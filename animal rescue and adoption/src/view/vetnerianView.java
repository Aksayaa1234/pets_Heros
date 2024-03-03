package view;
import resource.petsDTO;
import controller.apointmentControl;
import controller.vetnerianControl;
import util.input;
import java.util.List;

public class vetnerianView extends input{
    public void start() throws Exception
    {
    while(true)
    {
        System.out.println("1.View pets ");
        System.out.println("2.Update status");
        System.out.println("3.Change city: ");
        System.out.println("4.Change area: ");
        System.out.println("5.Exit");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        if(choice==1)
        {
            viewPets();
        }
        else if(choice==2)
        {
             update();
        }
        else if(choice==3)
        {
            vetnerianControl v=new vetnerianControl();
            System.out.println("Enter city:");
            String a=sc.next();
            boolean b=v.change_city(a);
            if(b)
            System.out.println("sucessful");
        }
        else if(choice==4)
        {
            vetnerianControl v=new vetnerianControl();
            System.out.println("Enter area:");
            String a=sc.next();
            boolean b=v.change_area(a);
            if(b)
            System.out.println("sucessful");
        }
        else 
        {
            break;
        }
    }
    }
    public void viewPets() throws Exception
    {
            System.out.println("Enter the status of animal:  rescued/treatment");
            String status =sc.next();
            apointmentControl app=new apointmentControl();
            List<petsDTO> pets= app.view_appointment(status);
            if(!pets.isEmpty())
           {
            System.out.println("pets details");
            System.out.println("----------------------------------");
            for(petsDTO pet:pets)
            {
                System.out.println("Id : "+pet.getId_pets());
                System.out.println("Name : "+pet.getName());
                System.out.println("breed : "+pet.getBreed());
            }
            System.out.println("----------------------------------");
        }
        else
        {
            System.out.println("No pets");
        }
    }

    public void update() throws Exception
   {
        System.out.println("Enter pet id: ");
        int id_pet=sc.nextInt();
        System.out.println("Enter status:  treatment/available");
        String status=sc.next();
        vetnerianControl v=new vetnerianControl();
        boolean a=v.updateStatus(id_pet,status);
        if(a)
        System.out.println("updated sucessfull");
        else
        System.out.println("failed");
   }
}
