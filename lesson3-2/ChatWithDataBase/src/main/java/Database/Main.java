//package Database;
//
//import Database.UsersDatabase;
//
//import java.sql.SQLException;
//
//public class Main {
//
//
//    public static void main (String[] args) throws SQLException {
//
////        startApp();
//}
//
//    public static void startApp () throws SQLException {
//
////        createTableInMySQL();
////        deleteTableInMySQL();
////        addUsersToDatabase();
////        getUserFromDatabase();
////        getAllUsersFromDatabase();
//    }
//
//    public static void createTableInMySQL () throws SQLException {
//
//        DBConn
//                .getInstance()
//                .connection()
//                .prepareStatement("create TABLE ChatUsers ( "+
//                        "   LOGIN VARCHAR(30) UNIQUE NOT NULL, " +
//                        "   PASSWORD VARCHAR(10) NOT NULL, " +
//                        "   NICKNAME VARCHAR(10) UNIQUE NOT NULL" +
//                        ");" )
//                .executeUpdate();
//
//    }
//
//    public static void deleteTableInMySQL () throws SQLException {
//
//        DBConn
//                .getInstance()
//                .connection()
//                .prepareStatement("DROP TABLE ChatUsers")
//                .execute();
//    }
//
//    public static void addUsersToDatabase () throws SQLException {
//
//        UsersDatabase user = new UsersDatabase();
//        user.createUser(new User("ats","123","Atos"));
//        user.createUser(new User("prts","456","Partos"));
//        user.createUser(new User("arms","789","Aramis"));
//        user.createUser(new User("drtn","000","Dartanian"));
//
//    }
//
//    public static void getUserFromDatabase() throws SQLException {
//
//        UsersDatabase user1 = new UsersDatabase();
//        System.out.println(user1.getUserByNick("Atos"));
//    }
//
//    public static void getAllUsersFromDatabase() throws SQLException {
//
//        UsersDatabase user1 = new UsersDatabase();
//        System.out.println(user1.getAllUsers());
//    }
//
//}
