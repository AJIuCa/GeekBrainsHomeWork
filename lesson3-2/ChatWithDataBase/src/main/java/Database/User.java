package Database;

public class User {

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    private String nickname;
    private String login;
    private String password;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User(String login, String password, String nickname) {
        this.nickname = nickname;
        this.login = login;
        this.password = password;
    }
}
