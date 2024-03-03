package controller;

import java.util.List;

import model.userDAO;
import model.volunteerDAO;
import resource.user_detailsDTO;
import util.cookie;


public class volunteerControl {
    public List<user_detailsDTO> viewVolunteer(String city,String area) throws Exception
    {
        volunteerDAO volun=volunteerDAO.getInstance();
        List<user_detailsDTO> users=volun.getVolunteer(city,area);
        return users;
    }
     public boolean checkVolunteer(int id_volunteer) throws Exception
     {
        volunteerDAO volun=volunteerDAO.getInstance();
        int id=volun.check_volunteer(id_volunteer);
        if(id>0)
        {
            return true;
        }
        return false;
     }

     public boolean set_available(int b) throws Exception
     {
        volunteerDAO v=volunteerDAO.getInstance();
        int a=v.setAvailable(cookie.user_id,b);
        if(a<=0)
        throw new Exception("Failed ");
        else
        return true;
     }
     public boolean set_availableV(int id_vetnerian,int b) throws Exception
     {
        volunteerDAO v=volunteerDAO.getInstance();
        int a=v.setAvailable(id_vetnerian,b);
        if(a<=0)
        throw new Exception("Failed ");
        else
        return true;
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
