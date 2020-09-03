
package Database;

import Database.DBConn;
import Database.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsersDatabase {

    private PreparedStatement ps = null;

    public void  createUser (User user) throws SQLException {

        ps = DBConn
                .getInstance()
                .connection()
                .prepareStatement(" INSERT INTO ChatUsers (LOGIN, PASSWORD, NICKNAME) VALUE (?, ?, ?) ");
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getNickname());
        ps.executeUpdate();


    }

    public User getUserByNick (String nickname) throws SQLException {

        ps = DBConn
                .getInstance()
                .connection()
                .prepareStatement("SELECT * FROM ChatUsers WHERE NICKNAME = ?");
        ps.setString(1,nickname);
        ResultSet set = ps.executeQuery();

        User user = new User();

        if (set.next()) {
            user.setLogin(set.getString( "LOGIN"));
            user.setPassword(set.getString("PASSWORD"));
            user.setNickname(set.getString("NICKNAME"));
        }

        return  user;

    }

    public List<User> getAllUsers () throws SQLException {

        List <User> usersList = new ArrayList<User>(10);
        ps = DBConn
                .getInstance()
                .connection()
                .prepareStatement("SELECT * FROM ChatUsers");

        ResultSet set = ps.executeQuery();

        while (set.next() == true) {
            User user = new User();
            user.setLogin(set.getString("LOGIN"));
            user.setPassword(set.getString("PASSWORD"));
            user.setNickname(set.getString("NICKNAME"));
            usersList.add(user);
        }

        return  usersList;
    }

}
