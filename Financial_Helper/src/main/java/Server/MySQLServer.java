/**
 * THIS CLASS STARTS THE MYSQL SERVER AND THE APACHE SERVER
 */

package Server;

import java.io.IOException;

public class MySQLServer {
    public MySQLServer(){}

    //FIXME look, that the function starts the server without any trouble
    public void start() throws IOException {
        //Maybe for later to start the server
        ProcessBuilder P1 =new ProcessBuilder("C:\\Users\\Samuel\\Desktop\\xampp\\mysql_start.bat");
        P1.start();
        ProcessBuilder P2 =new ProcessBuilder("C:\\Users\\Samuel\\Desktop\\xampp\\APACHE_start.bat");
        P2.start();
    }
}
