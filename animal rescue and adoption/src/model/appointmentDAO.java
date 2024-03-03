package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import resource.petsDTO;
import util.cookie;
import resource.appointmentDTO;

public class appointmentDAO extends connection{
    private static appointmentDAO instance;
    PreparedStatement setAppointment;
    PreparedStatement viewPets;
    PreparedStatement getId;
    private appointmentDAO() throws SQLException{
        setAppointment=con.prepareStatement("INSERT INTO appoinment (id_volunteer,id_pets,id_vetnerian) VALUES( ?, ?, ?)");
        viewPets=con.prepareStatement("select p.id_pets,b.name,b.breed from pets as p join breeds as b using(id_b) join appoinment as a using (id_pets) where a.id_vetnerian=? and status=?");
        getId=con.prepareStatement("Select * from appoinment where id_pets=?");
    }

    public static appointmentDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new appointmentDAO();
        }
        return instance;
    }
    public int setAppointment(appointmentDTO appoint) throws Exception
    {
        setAppointment.setInt(1, appoint.getId_volunteer());
        setAppointment.setInt(2, appoint.getId_pets());
        setAppointment.setInt(3, appoint.getId_vetnerians());
        int a=setAppointment.executeUpdate();
        return a;
    }

    public List<petsDTO> viewAppointment(String status) throws Exception
    {
        List<petsDTO> pets=new ArrayList<>();
        viewPets.setInt(1, cookie.user_id);
        viewPets.setString(2,status);
        ResultSet resultSet = viewPets.executeQuery();
        while(resultSet.next())
        {
                petsDTO pet=new petsDTO();
                pet.setId_pets(resultSet.getInt("id_pets"));
                pet.setName(resultSet.getString("name"));
                pet.setBreed(resultSet.getString("breed"));
                pets.add(pet);
                
        }
        return pets;
    }

    public int getAppointmentId(int id_pet) throws Exception
    {
        getId.setInt(1,id_pet);
        ResultSet resultSet = getId.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt("id_app");
        }
        return -1;
    }
}
