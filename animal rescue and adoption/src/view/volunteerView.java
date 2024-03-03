package view;

import java.util.List;

import controller.apointmentControl;
import controller.petsControl;
import controller.vetnerianControl;
import controller.volunteerControl;
import resource.petsDTO;
import resource.user_detailsDTO;
import util.input;

public class volunteerView extends input{
    public void start() throws Exception
    {
        while(true)
        {
        System.out.println("1.View pet");
        System.out.println("2.View doctor");
        System.out.println("3.Update pet status");
        System.out.println("4.Book appointment");
        System.out.println("5.Set availablity");
        System.out.println("6.Change city: ");
        System.out.println("7.Change area: ");
        System.out.println("8.Exit");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        if(choice==1)
        {
            viewPet();
        }
        else if(choice==2)
        {
            viewVetnerians();
        }
        else if(choice==3)
        {
            petsControl pet=new petsControl();
            boolean b=pet.update();
            if(b)
            System.out.println("updated sucessfully");
            else
            System.out.println("failed");
        }
        else if(choice==4)
        {
            volunteer();
        }
        else if(choice==5)
        {
            volunteerControl v=new volunteerControl();
            System.out.println("Enter availablity :   0/1");
            int a=sc.nextInt();
            boolean b=v.set_available(a);
            if(b)
            System.out.println("updated sucessfully");
        }
        else if(choice==6)
        {
            volunteerControl v=new volunteerControl();
            System.out.println("Enter city:");
            String a=sc.next();
            boolean b=v.change_city(a);
            if(b)
            System.out.println("sucessful");
        }
        else if(choice==7)
        {
            volunteerControl v=new volunteerControl();
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

public void volunteer() throws Exception
{
    System.out.println("Enter the id_pet:");
    int id_pets=sc.nextInt();
    System.out.println("Enter the doctor id:");
    int id_vetnerian=sc.nextInt();
    apointmentControl ap=new apointmentControl();
    ap.check_vetnerian(id_vetnerian);
    ap.check_pet(id_pets);
    int a=ap.addAppointment(id_pets,id_vetnerian);
    if(a==1);
    System.out.println("appointment added sucessfully");
}

public void view_volunteers(String city,String area,int id_pets) throws Exception
{
    volunteerControl v=new volunteerControl();
    List<user_detailsDTO> users=v.viewVolunteer(city,area);
    if(!users.isEmpty())
    {
        System.out.println("volunteers details");
        System.out.println("----------------------------------");
            for(user_detailsDTO user:users)
            {
                System.out.println("User Id : "+user.getUser_id());
                System.out.println("Name : "+user.getName());
                System.out.println("Phone Number : "+user.getPhone_no());
            }
            System.out.println("----------------------------------");
            match_volunteer(id_pets);
        }
        else
        {
            System.out.println("No volunteer nearby found");
        }
    }

    public void viewPet() throws Exception
    {
        petsControl p=new petsControl();
        petsDTO pet=p.view_pet();
        System.out.println("pet details");
        System.out.println("----------------------------------");
        System.out.println("Id : "+pet.getId_pets());
        System.out.println("Name : "+pet.getName());
        System.out.println("Breed : "+pet.getBreed());
        System.out.println("City : "+pet.getCity());
        System.out.println("Area : "+pet.getArea());
        System.out.println("Status : "+pet.getStatus());
        System.out.println("Wounded/Rescue : "+pet.getWound_or_rescue());
        System.out.println("----------------------------------");
    }
    
    public void viewVetnerians() throws Exception
    {
        System.out.println("Enter city: ");
        String city=sc.next();
        System.out.println("Enter area: ");
        String area=sc.next();
        vetnerianControl v=new vetnerianControl();
        List<user_detailsDTO> vets= v.view_vetnerian(city,area);
        if(!vets.isEmpty())
        {
            System.out.println("volunteers details");
            System.out.println("----------------------------------");
            for(user_detailsDTO vet:vets)
            {
                System.out.println("User Id : "+vet.getUser_id());
                System.out.println("Name : "+vet.getName());
                System.out.println("Specialist : "+vet.getSpecialist());
                System.out.println("Phone Number : "+vet.getPhone_no());
            }
            System.out.println("----------------------------------");
        }
        else
        {
            System.out.println("No vetnerian nearby found");
        }
    }
    
    public void match_volunteer(int id_pets) throws Exception
    {
        System.out.println("Enter the volunteer id:");
        int id_volunteer=sc.nextInt();
        volunteerControl v=new volunteerControl();
        boolean a=v.checkVolunteer( id_volunteer);
        if(!a)
        {
            System.out.println("The volunteer id is not valid");
        }
        else
        {
            petsControl p=new petsControl();
            int b=p.add_volunteer(id_pets,id_volunteer);
            if(b>0)
            System.out.println("Added Sucessful");
            int d=0;
            boolean c=v.set_availableV(id_volunteer,d);
            if(c) 
            System.out.println("done");
        }
    }
}
