package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import resource.petsDTO;
import util.cookie;

public class petsDAO extends connection{
    private static petsDAO instance;
    PreparedStatement setPets;
    PreparedStatement getId;
    PreparedStatement setVolunteer;
    PreparedStatement view;
    PreparedStatement viewadopt;
    PreparedStatement update;
    PreparedStatement check;
    PreparedStatement checkStatus;
    private petsDAO() throws SQLException{
        setPets=con.prepareStatement("INSERT INTO pets (city,area,status,wound_or_rescue,id_b) VALUES( ?, ?, ?, ?, ?)");
        getId=con.prepareStatement("Select id_pets from pets where city=? and area=? and status=? and wound_or_rescue=? and id_b=?");
        setVolunteer=con.prepareStatement("update pets set id_volunteer=? where id_pets=?");
        view=con.prepareStatement("select * from pets join breeds using(id_b) where id_volunteer=? and status =?");
        update=con.prepareStatement("update pets set status=? where id_pets=?");
        check=con.prepareStatement("select count(*) from pets where id_pets=? and id_volunteer=?");
        //viewadopt=con.prepareStatement("select * from pets join breeds using(id_b) join user_details as u on u.user_id=? where status =?");
        checkStatus=con.prepareStatement("select count(*) from pets where id_pets=? and status=?");
        viewadopt=con.prepareStatement("SELECT p.id_pets,b.name,b.breed,u.name,u.city,u.area,u.phone_no FROM pets p JOIN breeds b ON p.id_b = b.id_b JOIN appoinment a ON p.id_pets = a.id_pets JOIN user_details u ON a.id_vetnerian = u.user_id WHERE p.status =?");
    }

    public static petsDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new petsDAO();
        }
        return instance;
    }
    public int set_pets(petsDTO pet) throws Exception
    {
        setPets.setString(1, pet.getCity());
        setPets.setString(2, pet.getArea());
        setPets.setString(3, pet.getStatus());
        setPets.setString(4, pet.getWound_or_rescue());
        setPets.setInt(5, pet.getId_b());
        int a=setPets.executeUpdate();
        if(a>0)
        {
        getId.setString(1, pet.getCity());
        getId.setString(2, pet.getArea());
        getId.setString(3, pet.getStatus());
        getId.setString(4, pet.getWound_or_rescue());
        getId.setInt(5, pet.getId_b());
        ResultSet resultSet=getId.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt("id_pets");
        }
    }
    return -1;
    }

    public int addVolunteer(int id_pets,int id_volunteer) throws Exception
    {
        setVolunteer.setInt(1,id_volunteer);
        setVolunteer.setInt(2,id_pets);
        int a=setVolunteer.executeUpdate();
        return a;
    }
     
    public petsDTO viewPet(String status) throws Exception
    {
        petsDTO pet=new petsDTO();
        view.setInt(1,cookie.user_id);
        view.setString(2,  status);
        ResultSet resultSet=view.executeQuery();
        if(resultSet.next())
        {
            pet.setId_pets(resultSet.getInt("id_pets"));
            pet.setName(resultSet.getString("name"));
            pet.setBreed(resultSet.getString("breed"));
            pet.setCity(resultSet.getString("city"));
            pet.setArea(resultSet.getString("area"));
            pet.setStatus(resultSet.getString("status"));
            pet.setWound_or_rescue(resultSet.getString("wound_or_rescue"));
        }
        return pet;
    }

    public int getId() throws Exception
    {
        view.setInt(1,cookie.user_id);
        view.setString(2,  "to_be_rescued");
        ResultSet resultSet=view.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt("id_pets");
        }
        return -1;
    }

    public int updateStatus(String status,int id) throws Exception
    {
        update.setString(1, status);
        update.setInt(2,id);
        int a=update.executeUpdate();
        return a;
    }

    public int check_pet(int id_pet) throws Exception
    {
        check.setInt(1,id_pet);
        check.setInt(2,cookie.user_id);
        ResultSet resultSet = check.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt(1);
        }
        return -1;
    }

    public List<petsDTO> viewPetadopt(String status) throws Exception
    {
        List<petsDTO> pets=new ArrayList<>();
        viewadopt.setString(1,  status);
        ResultSet resultSet=viewadopt.executeQuery();
        while(resultSet.next())
        {
            petsDTO pet=new petsDTO();
            pet.setId_pets(resultSet.getInt("id_pets"));
            pet.setName(resultSet.getString("name"));
            pet.setBreed(resultSet.getString("breed"));
            pet.setd_Name(resultSet.getString(4));
            pet.setCity(resultSet.getString("city"));
            pet.setArea(resultSet.getString("area"));
            pet.setPhone_no(resultSet.getString("phone_no"));
            pets.add(pet);
        }
        return pets;
    }

    public int checkStatus(int id_pets) throws Exception
    {
        checkStatus.setInt(1,id_pets);
        checkStatus.setString(2, "available");
        ResultSet resultSet = checkStatus.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt(1);
        }
        return -1;
    }
}
