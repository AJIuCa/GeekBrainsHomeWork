package Server.Handlers.Processes;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class WorkWithFiles  {

    // Список состояний. В зависимости от того чем занят клиент
    public enum State {
        AWAIT, TITLE_Length, TITLE, FILE_Length, FILE
    }

    private String path;

    public WorkWithFiles(String path) {
        this.path = path;
    }

    private State currentState = State.AWAIT;   // по умолчанию клиент ожидает события
    private int titleLength;  // длина имени файла
    private long fileLength;  // сколько мы должны дождатся байтов (длина входящего файла)
    private long receivedFileLength; // сколько мы уже получили байтов при скачивании
    private BufferedOutputStream outputStream; // буфер нужный для записи байтов в файл

    private final char symbolToSend = '!';
    private final char symbolToDownload = '*';


    public void prepare() {
        currentState = State.TITLE_Length;  // меняем статус
        receivedFileLength = 0L; // счётчик размера файла выставляем равный
    }

    public void run(ChannelHandlerContext ctx, ByteBuf buf) throws Exception {

        if (currentState == State.TITLE_Length) {
            if (buf.readableBytes() > 3) { // Размер имени файла зашит в int. Если имя больше 3 (а int (в чём измеряется длина файла) > 3 байт) значит файл не пустой
                System.out.println("Get fileName length");
                titleLength = buf.readInt(); // прочитываем из входящего буфера один int (то есть узнаём длину имени файла (к примеру 10 символов))
                currentState = State.TITLE; // меняем статус
            }
        }

        if (currentState == State.TITLE) {
            if (buf.readableBytes() >= titleLength) {  // проверяем наличие места в буфере байтов столько сколько в длине имени. Страхуемся от частичной считки имени файла
                byte[] fileTitle = new byte[titleLength]; // если пришло нужное количество байтов то мы формируем массив байтов с длиной массива равной длине имени файла
                buf.readBytes(fileTitle); // делаем запись байтов из буффера в байтовый массив
                String fileName = new String(fileTitle, "UTF-8"); //собираем строчку с именем файла
                System.out.println("Downloading file: " + fileName);  // выводим имя файла
                outputStream = new BufferedOutputStream(new FileOutputStream(path + "/" + new String(fileTitle))); // открываем стрим буфер на запись входящего стрима байтов  для записи байтов в файл
                currentState = State.FILE_Length; // меняем статус
            }
        }
        if (currentState == State.FILE_Length) {
            if (buf.readableBytes() > 7) { // Размер файла зашит в лонг. Если размер файла больше 7 (а long > 7 байт) значит файл не пустой
                fileLength = buf.readLong(); // вычитываем лонг из входящего. Теперь мы знаем размер входящего файла
                System.out.println("Downloading file length: " + fileLength);
                currentState = State.FILE;
            }
        }

        if (currentState == State.FILE) {
            while (buf.readableBytes() > 0) { // пока есть в буфере файлы которые мы ещё не прочитали
                outputStream.write(buf.readByte()); // по одному байту из буфера достаём и записываем в outputStream
                receivedFileLength++; // после каждого переданного байта счётчик полученных байтов увелич на 1
                if (fileLength == receivedFileLength) { // Если счётчик стал равен размеры файла то успешно файл скачан переходим в режим ожидания

                    // Если в буфере остаются ещё байты (могла быть выбрана скачка 2-х, 3-х файлов и тд) То цикл запускается занового и дообрабатываем буфер
                    currentState = State.AWAIT;
                    System.out.println("File downloaded");
                    outputStream.close(); // закрываем файл в который записывали входящий поток байтов
                    return;
                }
            }
        }
                if (buf.readableBytes() == 0) {
                    buf.release();
        }
    }

}
