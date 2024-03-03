package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import resource.breedsDTO;

public class breedsDAO extends connection{
    private static breedsDAO instance;
    PreparedStatement setBreeds;
    PreparedStatement getId;
    private breedsDAO() throws SQLException{
        setBreeds=con.prepareStatement("INSERT INTO breeds (name,breed) VALUES( ?, ?)");
        getId=con.prepareStatement("SELECT id_b FROM breeds WHERE name = ? and breed = ?");
    }

    public static breedsDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new breedsDAO();
        }
        return instance;
    }
    public int set_pets(breedsDTO breeds) throws Exception
    {
        setBreeds.setString(1, breeds.getName());
        setBreeds.setString(2, breeds.getBreed());
        int a=setBreeds.executeUpdate();
        return a;
    }
    public Integer check(breedsDTO breeds) throws Exception
    {
        getId.setString(1, breeds.getName());
        getId.setString(2, breeds.getBreed());
        ResultSet resultSet = getId.executeQuery();
        if(resultSet.next())
        {
            breeds.setId_b(resultSet.getInt("id_b") );
            return breeds.getId_b();
        }
        return null;
    }
}
