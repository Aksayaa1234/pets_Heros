package view;

import java.util.List;

import controller.aduserControl;
import resource.petsDTO;
import util.input;

public class aduserView extends input{
    public void start() throws Exception
    {
        while(true)
        {
        System.out.println("1.view pets");
        System.out.println("2.To adopt");
        System.out.println("3.Exit");
        System.out.println("Enter your choice:");
        int choice=sc.nextInt();
        if(choice==1)
        {
           view();
        }
        else if(choice==2)
        {
           adopt();
        }
        else 
        {
            break;
        }
    }
    }

    public void view() throws Exception
    {
        aduserControl a=new aduserControl();
         List<petsDTO> pets= a.viewPets();;
            if(!pets.isEmpty())
           {
            System.out.println("pets details");
            System.out.println("----------------------------------");
            for(petsDTO pet:pets)
            {
                System.out.println("Id : "+pet.getId_pets());
                System.out.println("Name : "+pet.getName());
                System.out.println("breed : "+pet.getBreed());
                System.out.println("Vetnerian name : "+pet.getd_Name());
                System.out.println("Phone number : "+pet.getPhone_no());
                System.out.println("City : "+pet.getCity());
                System.out.println("Area : "+pet.getArea());
            }
            System.out.println("----------------------------------");
        }
        else
        {
            System.out.println("No pets");
        }
    }

    public void adopt() throws Exception
    {
        System.out.println("Enter pet id: ");
        int id=sc.nextInt();
        aduserControl a=new aduserControl();
        boolean b=a.check(id);
        if(b)
        {
            adoption(id);
        }
        else
        {
            System.out.println("pet not available");
        }
    }

    public void adoption(int id) throws Exception
    {
        aduserControl a=new aduserControl();
        int id_app=a.getApp(id);
        boolean b=a.set_adoption(id_app);
        if(b)
        {
        System.out.println("Adopted sucessfully");
        boolean c=a.updateStatus(id);
        if(c)
        System.out.println("sucessful");
        }
    }
    
}
