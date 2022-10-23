/**
 * THIS CLASS HANDELS EVERYTHING WITH SQL
 */

package SQL;

//IMPORTS
import Server.IP;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//TODO function to connect to mysql with ip
public class DataBaseConnector {

    //URL where the server runs on
    private final String URL = "jdbc:mysql://localhost/";

    //not used
    //FIXME
    private String ip = "";
    //name of the database
    private final String DB_NAME = "db_financial_helper";

    //username
    private final String USER = "root";
    //password
    private final String PASSWORD = "";

    //statement and connection
    Statement statement;
    Connection conn = null;

    //ctor
    public DataBaseConnector() throws UnknownHostException {
        //set ip address
        setIP();
    }

    /**
     * Connect to Database
     */
    public void connectToDataBase(){
        try {
            //load the jdbc driver
            load_JDBC_Driver();

            //connect to database
            conn= DriverManager.getConnection(URL + DB_NAME,USER,PASSWORD);

            //Create a statement
            statement = conn.createStatement();
            System.out.print("Database is connected !");
        }
        catch (Exception e){
            System.out.print("Do not connect to DB - Error:"+e);
        }
        System.out.println("\n");
    }

    /**
     * Insert in the Users table
     * @param username, password
     */
    public void insertInUsers(String username, String password){
        //name of the database
        String db_Name = "users";

        try{
            //SQL Statement
            String insertquery = "INSERT INTO `" + db_Name + "`(`username`, `password`) VALUES ('" + username + "', '" + password + "')";

            //execute statement
            statement.executeUpdate(insertquery);
            System.out.print("Inserted");
        } catch(Exception e){
            System.out.print("Not Inserted" + e);
        }
    }

    /**
     * view data of table users
     */
    public void view(){
        String db_Name = "users";
        try {
            String insertquery = "select * from `" + db_Name + "`";
            ResultSet result = statement.executeQuery(insertquery);

            if(result.next()){
                System.out.println("Value " + result.getString(2));
                System.out.println("Value " + result.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Problem To Show Data" + e);
        }
    }

    /**
     * loads the jdbc driver
     * @throws ClassNotFoundException
     */
    private void load_JDBC_Driver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /**
     * set ip address
     * get it from ip class
     * @throws UnknownHostException
     */
    private void setIP() throws UnknownHostException {
        //Create instance of IP Class
        IP address = new IP();

        //call Method get_IP_Address()
        ip = address.get_IP_Address();
    }
}