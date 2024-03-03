package controller;

import model.breedsDAO;
import model.petsDAO;
import resource.breedsDTO;
import resource.petsDTO;

public class petsControl {
     public int add_pets(String name,String breed) throws Exception
    {
        breedsDAO b=breedsDAO.getInstance();
        breedsDTO breeds=new breedsDTO(name,breed);
        Integer id_b=b.check(breeds);
        if(id_b==null)
        {
           int a=b.set_pets(breeds);
           return a;
        }
        else{
        return id_b;
        }
    }
    public int add_pets_details(String city,String area,String status,String w_or_r,int id_b) throws Exception
    {
        petsDAO p=petsDAO.getInstance();
        petsDTO pet=new petsDTO(city,area,status,w_or_r,id_b);
        int a= p.set_pets(pet);
        if(a==-1)
        {
            throw new Exception("Failed to add pet");
        }
        return a;
    }

    public int add_volunteer(int id_pets,int id_volunteer) throws Exception
    {
        petsDAO p=petsDAO.getInstance();
        int a=p.addVolunteer(id_pets,id_volunteer);
        if(a<=0)
        {
            throw new Exception("Failed to add");
        }
        return a;
    }

    public petsDTO view_pet() throws Exception
    {
        petsDAO p=petsDAO.getInstance();
        petsDTO pet =p.viewPet("to_be_rescued");
        return pet;
    }

    public boolean update() throws Exception
    {
        petsDAO pet=petsDAO.getInstance();
        int id=pet.getId();
        if(id>0)
        {
        int a= pet.updateStatus("rescued",id);
        if(a>0)
        return true;
        else
        return false;
        }
        else
        throw new Exception("Failed to update");
    }
}
