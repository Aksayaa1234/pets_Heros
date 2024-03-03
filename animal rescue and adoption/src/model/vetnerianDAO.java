package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import resource.user_detailsDTO;
import resource.vetneriansDTO;

public class vetnerianDAO extends connection {
    private static vetnerianDAO instance;
    PreparedStatement setVetnerian;
    PreparedStatement getVetnerians;
    PreparedStatement checkVetnerian;
    private vetnerianDAO() throws SQLException{
        setVetnerian=con.prepareStatement("INSERT INTO vetnerians (id_vetnerian,specialist) VALUES(?, ?)");
        getVetnerians=con.prepareStatement("SELECT * FROM user_details JOIN vetnerians ON user_id = id_vetnerian WHERE city = ? AND area = ? ");
        checkVetnerian=con.prepareStatement("Select count(*) from vetnerians where id_vetnerian=?");
    }

    public static vetnerianDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new vetnerianDAO();
        }
        return instance;
    }
    
    public int  setVetnerian_details(vetneriansDTO vet ) throws SQLException{
        setVetnerian.setInt(1, vet.getId_vetnerians());
        setVetnerian.setString(2, vet.getSpecialist());
        int a=setVetnerian.executeUpdate();
        return a;
    }

    public List<user_detailsDTO> viewVetnerians(String city,String area) throws Exception
    {
        List<user_detailsDTO> vets=new ArrayList<>();
        getVetnerians.setString(1, city);
        getVetnerians.setString(2, area);
        ResultSet resultSet =getVetnerians.executeQuery();
        while(resultSet.next())
        {
            user_detailsDTO vet = new user_detailsDTO();
            vet.setUser_id(resultSet.getInt("user_id"));
            vet.setName(resultSet.getString("name"));
            vet.setPhone_no(resultSet.getString("phone_no"));
            vet.setSpecialist(resultSet.getString("specialist"));
            vets.add(vet);
        }
        return vets;
    }

    public int check_vetnerian(int id_vetnerian) throws Exception
    {
        checkVetnerian.setInt(1, id_vetnerian);
        ResultSet resultSet = checkVetnerian.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getInt(1);
        }
        return -1;
    }
}
