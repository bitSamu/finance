import SQL.DataBaseConnector;

import java.io.IOException;
import java.sql.SQLException;

public class Financial_Helper {

    public static void main(String[] args) throws SQLException, IOException {
        DataBaseConnector dbc = new DataBaseConnector();

        dbc.connectToDataBase();
        //dbc.insertInUsers("Tim", "123");
        dbc.view();
    }
}
