package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.cookie;

public class adoptionDAO extends connection
{
    private static adoptionDAO instance;
    PreparedStatement setAdoption;
    private adoptionDAO() throws SQLException{
        setAdoption=con.prepareStatement("INSERT INTO adoption (user_id,id_app) VALUES( ?, ?)");
    }

    public static adoptionDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new adoptionDAO();
        }
        return instance;
    }

    public int set_adoption(int id_app) throws Exception
    {
        setAdoption.setInt(1, cookie.user_id);
        setAdoption.setInt(2, id_app);
        int a=setAdoption.executeUpdate();
        return a;
    }
    
}
