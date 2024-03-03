package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import resource.user_detailsDTO;
import util.cookie;

public class userDAO extends connection {
    private static userDAO instance;
    PreparedStatement setUser;
    PreparedStatement getId;
    PreparedStatement changeCity;
    PreparedStatement changeArea;
    private userDAO() throws SQLException{
        setUser=con.prepareStatement("INSERT INTO user_details (name,city,area,phone_no,role) VALUES( ?, ?, ?, ?, ?)");
        getId=con.prepareStatement("SELECT user_id FROM user_details WHERE name= ? and phone_no= ? and role= ?");
        changeCity=con.prepareStatement("update user_details set city=? where user_id=?");
        changeArea=con.prepareStatement("update user_details set area=? where user_id=?");
    }

    public static userDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new userDAO();
        }
        return instance;
    }

    public int setUserData( user_detailsDTO user) throws SQLException{
        setUser.setString(1, user.getName());
        setUser.setString(2, user.getCity());
        setUser.setString(3, user.getArea());
        setUser.setString(4, user.getPhone_no());
        setUser.setString(5, user.getRole());
        setUser.executeUpdate();
        getId.setString(1, user.getName());
        getId.setString(2, user.getPhone_no());
        getId.setString(3, user.getRole());
        ResultSet res=getId.executeQuery();
        if(res.next())
        {
            return res.getInt("user_id");
        }
        return -1;
    }

    public int changeCity(String area) throws Exception
    {
        changeCity.setString(1, area);
        changeCity.setInt(2, cookie.user_id);
        int a=changeCity.executeUpdate();
        return a;
    }

    public int changeArea(String area) throws Exception
    {
        changeArea.setString(1, area);
        changeArea.setInt(2,cookie.user_id);
        int a=changeArea.executeUpdate();
        return a;
    }
}
