package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import resource.loginDTO;

public class loginDAO extends connection {

    private static loginDAO instance;
    PreparedStatement getLogin;
    PreparedStatement setLogin;
    private loginDAO() throws SQLException{
        getLogin=con.prepareStatement("SELECT L.email,L.password,L.user_id,U.role FROM login L JOIN user_details U USING(user_id) WHERE L.email=?");
        setLogin=con.prepareStatement("INSERT INTO login (user_id,email,password) VALUES( ?, ?, ?)");
    }

    public static loginDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new loginDAO();
        }
        return instance;
    }

    public loginDTO getLoginData(String email) throws SQLException{
        getLogin.setString(1, email);
        ResultSet res=getLogin.executeQuery();
        if(res.next())
        {
            return new loginDTO(res.getInt(3), res.getString(1), res.getString(2),res.getString(4));
        }
        return null;
    }

    public int setLoginData(loginDTO user) throws SQLException{
        setLogin.setInt(1,user.getUser_id() );
        setLogin.setString(2,user.getEmail() );
        setLogin.setString(3,user.getPassword() );
        int a=setLogin.executeUpdate();
        return a;
    }
}