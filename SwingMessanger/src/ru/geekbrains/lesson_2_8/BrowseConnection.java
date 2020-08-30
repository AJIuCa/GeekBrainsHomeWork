package ru.geekbrains.lesson_2_8;

public interface BrowseConnection {

    void connectionSuccessfull (Client client);
    void incomingMessage(Client client, String value);
    void connectionLost (Client client);



}
