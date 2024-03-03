package controller;

import java.util.List;

import model.appointmentDAO;
import model.petsDAO;
import model.vetnerianDAO;
import resource.appointmentDTO;
import resource.petsDTO;
import util.cookie;

public class apointmentControl {
    public int addAppointment(int id_pets,int id_vetnerian) throws Exception
    {
        appointmentDAO app=appointmentDAO.getInstance();
        appointmentDTO appoint=new appointmentDTO(id_pets,cookie.user_id,id_vetnerian);
        int a=app.setAppointment(appoint);
        if(a<=0)
        {
            throw new Exception("Failed to add appointment");
        }
        else{
            return a;
        }
    }

    public List<petsDTO> view_appointment(String status) throws Exception
    {
        appointmentDAO a=appointmentDAO.getInstance();
        List<petsDTO> pets=a.viewAppointment(status);
        return pets;
    }

    public boolean check_vetnerian(int id_vetnerian) throws Exception
    {
        vetnerianDAO v=vetnerianDAO.getInstance();
        int a=v.check_vetnerian(id_vetnerian);
        if(a>0)
        return true;
        else
        throw new Exception("no such vetnerian ");
        
    }

    public boolean check_pet(int id_pet) throws Exception
    {
        petsDAO pet=petsDAO.getInstance();
        int a=pet.check_pet(id_pet);
        if(a>0)
        return true;
        else 
        throw new Exception("no such pets");
    }
}
