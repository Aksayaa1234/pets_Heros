package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import util.env;

public class connection
{
    protected static Connection con;
    protected static Statement st;
    public static void getConnection() throws Exception
    {
        con=DriverManager.getConnection(env.DB_URL, env.DB_USER, env.DB_PASSWORD);
        st=con.createStatement();
    }
}