package view;


import controller.UserControl;
import controller.petsControl;
import util.input;

public class userView extends input {
    public void add() throws Exception {
        System.out.println("1. Enter animal details");
        System.out.println("2. Login/Signup");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Enter name: ");
            String name = sc.next();
            System.out.print("Enter breed: ");
            String breed = sc.next();
            System.out.print("Enter city: ");
            String city = sc.next();
            System.out.print("Enter area: ");
            String area = sc.next();
            System.out.println("Enter the wound or rescue:  wounded,rescue,both");
            String w_or_r = sc.next();
            String status = "to_be_rescued";
            petsControl p = new petsControl();
            int id_b=p.add_pets(name, breed);
            int id_pets=p.add_pets_details(city,area,status,w_or_r,id_b);
            if(id_pets>0)
            {
            System.out.println("Sucessfully added");
            volunteerView v=new volunteerView();
            v.view_volunteers(city, area,id_pets);
            }
        } else {
             start();
        }
    }

    public void start() throws Exception {
        while(true)
        {
        System.out.println("1. Login in");
        System.out.println("2. Sign up");
        System.out.println("3.Exit");
        System.out.println("Enter your choice: ");
        int x = sc.nextInt();
        if (x == 1) {
            to_login();
        } else if (x == 2) {
            to_signup();
        }
        else 
        {
            break;
        }
    }
    }

    public void to_login() throws Exception {
        UserControl us = new UserControl();
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        int check = us.login(email, password);
        if (check == 1) 
        {
            volunteerView v=new volunteerView();
            v.start();
        } 
        else if (check == 2) 
        {
            vetnerianView vet=new vetnerianView();
            vet.start();
        } 
        else 
        {
            aduserView a=new aduserView();
            a.start();
        }
    }

    public void to_signup() throws Exception {
        UserControl us = new UserControl();
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.print("Enter city: ");
        String city = sc.next();
        System.out.print("Enter area: ");
        String area = sc.next();
        System.out.print("Enter phone number: ");
        String phone = sc.next();
        System.out.println("Enter role: volunteer/vetnerian/adoption_user");
        String role = sc.next();
        int user_id = us.add_user_details(name, city, area, phone, role);
        if (role.equals("volunteer")) 
        {
            System.out.println("Enter your are available or not:  0/1");
            int available = sc.nextInt();
            us.add_volunteer(available);
        } 
        else if (role.equals("vetnerian")) 
        {
            System.out.println("Enter speciality: ");
            String speciality = sc.next();
            us.add_vetnerian(speciality);
        }
        
        System.out.print("Enter email: ");
        String email = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();
        int a = us.add_login_details(user_id, email, password);
        if (a == 1) {
            System.out.println("Sign Up sucessfully");
        }
    }

    
}
