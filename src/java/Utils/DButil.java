/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Meal;
import model.User;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class DButil {
   static String dbURL = "jdbc:mysql://localhost:3306/hw4";
static String username = "root";
static String password = "izbad1";

public static List<Meal> updateRow(String id, String meal, String cals) throws SQLException {
      List<Meal> mealList = new ArrayList<>();
      Meal tempMeal;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "UPDATE meal SET " +
               "name = '" + meal + "', " +
               "calories = '" + cals +"' " +
               "WHERE idmeal = '" + id + "'";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet mealResult = statement.executeQuery(
"SELECT * FROM meal ");

while (mealResult.next()) {
    tempMeal = new Meal(mealResult.getString(2),
            mealResult.getInt(3), mealResult.getInt(1));
    mealList.add(tempMeal);
}
      
      return mealList;    
}
public static List<User> makeAdmin(String id) throws SQLException {
      List<User> userList = new ArrayList<>();
      User tempUser;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "UPDATE user SET " +
               "clearance = 2 WHERE iduser = '" + id + "'";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user ");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
    userList.add(tempUser);
}
      
      return userList;       
}
public static User changeFName(String id, String newFN) throws SQLException {
      User tempUser = new User();
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "UPDATE user SET " +
               "fname = '" + newFN + "' WHERE iduser = '" + id + "'";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user where iduser = '" + id + "'");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
  
}
      
      return tempUser;       
}
public static User changeLName(String id, String newLN) throws SQLException {
      User tempUser = new User();
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "UPDATE user SET " +
               "lname = '" + newLN + "' WHERE iduser = '" + id + "'";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user where iduser = '" + id + "'");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
  
}
      
      return tempUser;       
}
public static User changePW(String id, String newPW) throws SQLException {
      User tempUser = new User();
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "UPDATE user SET " +
               "password = '" + newPW + "' WHERE iduser = '" + id + "'";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user where iduser = '" + id + "'");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
  
}
      
      return tempUser;       
}
public static User changeGoal(String id, String newGoal) throws SQLException {
      User tempUser = new User();
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "UPDATE user SET " +
               "goal = " + newGoal + " WHERE iduser = '" + id + "'";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user where iduser = '" + id + "'");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
  
}
      
      return tempUser;       
}
public static List<Meal> removeRow(String id) throws SQLException {
      List<Meal> mealList = new ArrayList<>();
      Meal tempMeal;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "DELETE FROM meal " +
               "WHERE idmeal = '" + id + "'";
Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet mealResult = statement.executeQuery(
"SELECT * FROM meal ");

while (mealResult.next()) {
    tempMeal = new Meal(mealResult.getString(2),
            mealResult.getInt(3), mealResult.getInt(1));
    mealList.add(tempMeal);
}
      
      return mealList;    
}
public static List<User> removeUser(String id) throws SQLException {
      List<User> userList = new ArrayList<>();
     User tempUser;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

String query = "DELETE FROM user " +
               "WHERE iduser = '" + id + "'";
Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);

statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user ");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
    userList.add(tempUser);
}
      
      return userList;      
}

/*
    public static void addMeal(Meal meal) throws SQLException {        
        String name = meal.getMeal();     
        int cals = meal.getCalories();
        
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

       
String query = 
        "INSERT INTO meal (name, calories) " +
        "VALUES ('" + meal.getMeal() + "', " +
        "'" + meal.getCalories() + "')";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);
System.out.println(rowCount);
    }
    */
    
     public static int checkExist(String email, String passWord) throws SQLException { 
         // 0 = doesn't exist
         // 1 = exists and correct email/password combo
         // 2 = email exists, password wrong
         
          String tempEmail = "";
          String tempPW = "";
          int exists = 1;
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

       
Statement statement = conn.createStatement();
ResultSet existResult = statement.executeQuery(
"SELECT * FROM user WHERE email = '" + email + "'");

while (existResult.next()) {
    tempEmail = existResult.getString(4);
    tempPW = existResult.getString(5);
  
}
if (tempPW.equals(passWord) && tempEmail.equals(email)) {
 //correct email/PW combo
 exists = 1;
} else if (tempEmail.equals(email)){
    //email exists, Wrong PW
    exists = 2;
} else {
    //Email and PW not on file
    exists = 0;
}
    return exists;    
     }
     
      public static void addUser(User user) throws SQLException {        
         String firstName, lastName,email,pw, goal;
  int idUser;  
  
  
  int clearance = 1; //User (non-Admin) by default    
    firstName = user.getFirstName();
    lastName = user.getLastName();
    email = user.getEmail();
    pw = user.getPassword();
    //idUser = user.getIdUser();
    
    goal = user.getGoal() + "";
       
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

       
String query = 
        "INSERT INTO user (fname, lname, email, password, goal) " +
        "VALUES ('" + user.getFirstName() + "', " +
        "'" + user.getLastName() + "', " +
        "'" + user.getEmail() + "', " +
         "'" + user.getPassword() + "', " +
        "'" + goal + "')";

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);
System.out.println(rowCount);
    }
           
      public static void addMeal(String name, String calories, String user, String d, int YYYY, int MM, int DD) throws SQLException {        
                
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

       
String query = 
        "INSERT INTO meal (name, calories, user, date, YYYY, MM, DD) " +
        "VALUES ('" + name + "', " +
        calories + ", " + user + ", " +
         "str_to_date('" + d + "', '%d-%m-%Y'),"
        + YYYY + ", " + MM + ", " + DD + ")"; 

Statement statement = conn.createStatement();
int rowCount = statement.executeUpdate(query);
System.out.println(rowCount);
    }
      
      public static List<User> getAllUsers() throws SQLException {
      List<User> userList = new ArrayList<>();
      User tempUser;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user ");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
    userList.add(tempUser);
}
      
      return userList;    
}
       public static List<Meal> getMealOrder(String userID) throws SQLException {
      List<Meal> mealList = new ArrayList<>();
      Meal tempMeal;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet mealResult = statement.executeQuery(
"SELECT * FROM meal where user = " + userID + " ORDER BY date ASC");

while (mealResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    
    // public Meal(String meal, int calories, int mealid, int user, int YYYY, int MM, int DD) {
    tempMeal = new Meal(
            mealResult.getString(2), // meal
            mealResult.getInt(3), // cals
            mealResult.getInt(1), //meal id
           mealResult.getInt(4), // user
           mealResult.getInt(6), //YYYY
            mealResult.getInt(7), //MM
           mealResult.getInt(8)); //DD
    mealList.add(tempMeal);
}
      
      return mealList;    
}
     
        public static List<Meal> getMealOrderByDay(String userID) throws SQLException {
      List<Meal> mealList = new ArrayList<>();
      Meal tempMeal;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();

ResultSet mealResult = statement.executeQuery(
        "SELECT YYYY, MM, DD, SUM(calories) FROM meal where user = " + userID +         
                " GROUP BY date ORDER BY date ASC");

while (mealResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    
    // public Meal(String meal, int calories, int mealid, int user, int YYYY, int MM, int DD) {
    //public Meal(int calories, int YYYY, int MM, int DD)
    
    tempMeal = new Meal(            
            mealResult.getInt(4), // cals
            mealResult.getInt(1), //YYYY
           mealResult.getInt(2), // MM
           mealResult.getInt(3)); //DD          
    mealList.add(tempMeal);
}
      
      return mealList;    
}
   
         public static List<Meal> getMealOrderByDayLast7(String userID) throws SQLException {
      List<Meal> mealList = new ArrayList<>();
      Meal tempMeal;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet mealResult = statement.executeQuery(
"SELECT YYYY, MM, DD, SUM(calories) FROM meal where user = " + userID + 
        " GROUP BY date ORDER BY date DESC LIMIT 7");

while (mealResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    
    // public Meal(String meal, int calories, int mealid, int user, int YYYY, int MM, int DD) {
    //public Meal(int calories, int YYYY, int MM, int DD)
    
    tempMeal = new Meal(            
            mealResult.getInt(4), // cals
            mealResult.getInt(1), //YYYY
           mealResult.getInt(2), // MM
           mealResult.getInt(3)); //DD          
    mealList.add(tempMeal);
}
      
      return mealList;    
}
         
           public static List<Meal> getMealOrderByDayLast30(String userID) throws SQLException {
      List<Meal> mealList = new ArrayList<>();
      Meal tempMeal;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet mealResult = statement.executeQuery(
"SELECT YYYY, MM, DD, SUM(calories) FROM meal where user = " + userID + 
        " GROUP BY date ORDER BY date DESC LIMIT 30");

while (mealResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    
    // public Meal(String meal, int calories, int mealid, int user, int YYYY, int MM, int DD) {
    //public Meal(int calories, int YYYY, int MM, int DD)
    
    tempMeal = new Meal(            
            mealResult.getInt(4), // cals
            mealResult.getInt(1), //YYYY
           mealResult.getInt(2), // MM
           mealResult.getInt(3)); //DD          
    mealList.add(tempMeal);
}
      
      return mealList;    
}
        
    public static Meal getNewestMeal(String userID) throws SQLException {   
      Meal tempMeal = new Meal();
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet mealResult = statement.executeQuery(
"SELECT * FROM meal where user = " + userID + " GROUP BY date ORDER BY date DESC LIMIT 1");

while (mealResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    
    // public Meal(String meal, int calories, int mealid, int user, int YYYY, int MM, int DD) {
    tempMeal = new Meal(
            mealResult.getString(2), // meal
            mealResult.getInt(3), // cals
            mealResult.getInt(1), //meal id
           mealResult.getInt(4), // user
           mealResult.getInt(6), //YYYY
            mealResult.getInt(7), //MM
           mealResult.getInt(8)); //DD
    
}
      
      return tempMeal;    
}      
       public static List<Meal> getMealsByDate(String userID, String YYYY, String MM, String DD) throws SQLException {
      List<Meal> mealList = new ArrayList<>();
      Meal tempMeal;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();

ResultSet mealResult = statement.executeQuery(
        "SELECT * FROM meal where user = " + userID        
                + " AND YYYY = " +YYYY+ " AND MM = " + MM + " AND DD = " + DD);

while (mealResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    
    // public Meal(String meal, int calories, int mealid, int user, int YYYY, int MM, int DD) {
    tempMeal = new Meal(
            mealResult.getString(2), // meal
            mealResult.getInt(3), // cals
            mealResult.getInt(1), //meal id
           mealResult.getInt(4), // user
           mealResult.getInt(6), //YYYY
            mealResult.getInt(7), //MM
           mealResult.getInt(8)); //DD
    mealList.add(tempMeal);
}
      
      return mealList;    
}
     public static int totalCalsByDate(String userID, String YYYY, String MM, String DD) throws SQLException {
     
      Meal tempMeal = new Meal();
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet mealResult = statement.executeQuery(
"SELECT SUM(calories) FROM meal where user = " + userID
        + " AND YYYY = " +YYYY+ " AND MM = " + MM + " AND DD = " + DD);

while (mealResult.next()) {   
    tempMeal = new Meal(mealResult.getInt(1));// cals    
}
      
      return tempMeal.getCalories();    
}     
       public static int getIDfromEmail(String email) throws SQLException {
    String ID = "";
      User tempUser = new User();
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user WHERE email = '" + email + "'");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance
    
}
      
      return tempUser.getIdUser();    
}
       
      public static User getCurrentUser(String email) throws SQLException {
      //List<User> userList = new ArrayList<>();
      User tempUser = new User();
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user WHERE email = '" + email + "'");

while (userResult.next()) {
    // public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)
    tempUser = new User(
            userResult.getString(2), // Fname
            userResult.getString(3), //Lname
            userResult.getString(4), //email
            userResult.getString(5), //pw
            userResult.getInt(1), //userID
            userResult.getInt(6), //goal
            userResult.getInt(7)); //clearance    
}
      
      return tempUser;    
}
       public static int getClearance(String email) throws SQLException {
     int clearance = 1;
      User tempUser;
      
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;

try {
    conn =
       DriverManager.getConnection(dbURL, username, password);

    // Do something with the Connection

 
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

Statement statement = conn.createStatement();
ResultSet userResult = statement.executeQuery(
"SELECT * FROM user WHERE email = '" + email + "'");

while (userResult.next()) {
clearance = userResult.getInt(7);
// public User(String firstName, String lastName, String email, String password, 
    //int idUser, int goal, int clearance)   
}
      
      return clearance;    
}  
}



/*
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
public class DButil {
    
String dbURL = "jdbc:mysql://localhost:3306/hw4";
String username = "root";
String password = "izbad1";
       

    public static void AddMeal() throws ClassNotFoundException{

        try {
            Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            for (Throwable t: e)
                t.printStackTrace();
        }
}
    
}
*/