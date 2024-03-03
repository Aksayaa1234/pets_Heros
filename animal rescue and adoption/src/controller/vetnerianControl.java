package controller;

import java.util.List;

import model.petsDAO;
import model.userDAO;
import model.vetnerianDAO;
import resource.user_detailsDTO;


public class vetnerianControl {
    public List<user_detailsDTO> view_vetnerian(String city,String area) throws Exception
    {
        vetnerianDAO vet=vetnerianDAO.getInstance();
        List<user_detailsDTO> vets=vet.viewVetnerians(city,area);
        return vets;
    }

    public boolean updateStatus(int id_pet,String status) throws Exception
    {
        petsDAO p=petsDAO.getInstance();
        int a=p.updateStatus(status, id_pet);
        if(a>0)
        return true;
        else 
        return false;
    }

    public boolean change_city(String city) throws Exception
     {
        userDAO u=userDAO.getInstance();
        int a=u.changeCity(city);
        if(a==1)
        return true;
        else
        throw new Exception("Failed ");
     }

     public boolean change_area(String area) throws Exception
     {
        userDAO u=userDAO.getInstance();
        int a=u.changeArea(area);
        if(a==1)
        return true;
        else
        throw new Exception("Failed ");
     }
}
