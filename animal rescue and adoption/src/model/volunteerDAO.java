package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import resource.user_detailsDTO;
import resource.volunteersDTO;

public class volunteerDAO extends connection {
    private static volunteerDAO instance;
    PreparedStatement setVolunteer;
    PreparedStatement getVolunteer;
    PreparedStatement checkVolunteer;
    PreparedStatement avail;
    private volunteerDAO() throws SQLException{
        setVolunteer=con.prepareStatement("INSERT INTO volunteers (id_volunteer,available) VALUES( ?, ?)");
        getVolunteer = con.prepareStatement("SELECT ud.user_id,ud.name, ud.phone_no FROM user_details ud JOIN volunteers v ON ud.user_id = v.id_volunteer WHERE ud.city = ? AND ud.area = ? and available=1");
        checkVolunteer= con.prepareStatement("select count(*) from volunteers where id_volunteer=?");
        avail=con.prepareStatement("update volunteers set available=? where id_volunteer=?");
    }

    public static volunteerDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new volunteerDAO();
        }
        return instance;
    }

    public int  setVolunteer_details(volunteersDTO volun ) throws SQLException{
        setVolunteer.setInt(1, volun.getId_volunteer());
        setVolunteer.setInt(2, volun.getAvailable());
        int a=setVolunteer.executeUpdate();
        return a;
    }

    public List<user_detailsDTO> getVolunteer(String city,String area) throws Exception
    {
        List<user_detailsDTO> users = new ArrayList<>();
        getVolunteer.setString(1, city);
        getVolunteer.setString(2, area);
        ResultSet resultSet = getVolunteer.executeQuery();
        while(resultSet.next())
        {
                user_detailsDTO user = new user_detailsDTO();
                user.setUser_id(resultSet.getInt("ud.user_id"));
                user.setName(resultSet.getString("ud.name"));
                user.setPhone_no(resultSet.getString("ud.phone_no"));
                users.add(user);
        }
        return users;
    }
    
    public int check_volunteer(int id_volunteer) throws Exception
    {
        checkVolunteer.setInt(1, id_volunteer);
        ResultSet resultSet = checkVolunteer.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt(1);
        }
        return -1;
    }

    public int setAvailable(int id_volunteer,int b ) throws Exception
    {
        avail.setInt(1,b);
        avail.setInt(2,id_volunteer);
        int a=avail.executeUpdate();
        return a;
    }
}
