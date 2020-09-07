package Messenger.Server.service;

import Messenger.Database.User;
import Messenger.Server.inter.AuthService;
import Messenger.Database.StartWorkWithDatabase;
import Messenger.Database.UsersDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AuthServiceImpl implements AuthService {

//    private List<UserEntity> usersList;
    private UsersDatabase userDAO;
    private String login;
    private String password;

    public AuthServiceImpl() throws SQLException {

//        UsersDatabase usr = new UsersDatabase();

       /* usersList= new LinkedList<>();
       this.usersList.add(new UserEntity("Evgen", "pass1", "Evgenii"));
       this.usersList.add(new UserEntity("Alex", "pass2", "Lesha"));
       this.usersList.add(new UserEntity("Nikita", "pass3", "Nik"));*/
//     this.usersList.add(new UserEntity(usr.getUserByLogin("ats")));
       userDAO = new UsersDatabase();

    }

    @Override
    public void start() {

        System.out.println("Сервис аутентификации запущен");
    }


    @Override
    public String getNick(String login, String password) {
       /* this.login = login;
        this.password = password;
        for (UserEntity u : usersList) {

            if (u.login.equals(login) && u.password.equals(password)) {
                return u.nick;
            }

        }
        return null;*/
        try {
            return userDAO.getUserByLoginAndPassword(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");

    }

//    private class UserEntity {
//        private String login;
//        private String password;
//        private String nick;
//
//        public UserEntity(String login, String password, String nick) {
//            this.login = login;
//            this.password = password;
//            this.nick = nick;
//        }


    }


