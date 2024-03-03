package controller;

import java.util.List;

import model.adoptionDAO;
import model.appointmentDAO;
import model.petsDAO;
import resource.petsDTO;

public class aduserControl {
    public List<petsDTO> viewPets() throws Exception
    {
        petsDAO p=petsDAO.getInstance();
        List<petsDTO> pets=p.viewPetadopt("available");
        return pets;
    }
    
    public boolean check(int id_pets) throws Exception
    {
        petsDAO p=petsDAO.getInstance();
        int a=p.checkStatus(id_pets);
        if(a==1)
        {
        return true;
        }
        return false;
    }

    public int getApp(int id_pets) throws Exception
    {
        appointmentDAO a=appointmentDAO.getInstance();
        int id=a.getAppointmentId(id_pets);
        if(id<0)
        {
            throw new Exception("Failed ");
        }
        else
        return id;
    }

    public boolean set_adoption(int id_app) throws Exception
    {
        adoptionDAO a=adoptionDAO.getInstance();
        int b=a.set_adoption(id_app);
        if(b<=0)
        {
            throw new Exception("Failed ");
        }
        else
        return true;
    }

    public boolean updateStatus(int id_pets) throws Exception
    {
        petsDAO p=petsDAO.getInstance();
        int a=p.updateStatus("adopted", id_pets);
        if(a>0)
        return true;
        else
        return false;
    }
}
