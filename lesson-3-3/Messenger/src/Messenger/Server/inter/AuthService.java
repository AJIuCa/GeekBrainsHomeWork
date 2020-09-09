package Messenger.Server.inter;

public interface AuthService {
    void start();
        String getNick(String login, String password);
//    Object getNick(String login, String password);

    void stop();
}
