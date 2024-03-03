package view;

import java.sql.SQLException;
import model.connection;
import util.input;

public class App extends input {
    public static void main(String[] args) throws Exception {
        try{
            connection.getConnection();
            System.out.println("connected");
        }
        catch(SQLException err){
            System.out.println("Database Connection error");
            System.out.println(err);
            return;
        }
        userView a=new userView();
        a.add();
    }
}
