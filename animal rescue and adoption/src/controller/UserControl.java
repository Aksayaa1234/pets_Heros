package controller;
import model.loginDAO;
import model.userDAO;
import model.vetnerianDAO;
import model.volunteerDAO;
import util.cookie;
import resource.loginDTO;
import resource.user_detailsDTO;
import resource.vetneriansDTO;
import resource.volunteersDTO;

public class UserControl {
    public int login(String email,String password)throws Exception{
        loginDAO login=loginDAO.getInstance();
        loginDTO user=login.getLoginData(email);
        if(user==null){
            throw new Exception("Invalid user");
        }
        if(!user.getPassword().equals(password)){
            throw new Exception("Invalid password");
        }
        cookie.user_id=user.getUser_id();
        if(user.getRole().equals("volunteer")){
            return 1;
        }
        else if(user.getRole().equals("vetnerian"))
        {
            return 2;
        }
        return 3;
    }
    
    public int add_user_details(String name,String city,String area,String phone,String role) throws Exception
    {
        userDAO signup=userDAO.getInstance();
        user_detailsDTO user=new user_detailsDTO(name,city,area,phone,role);
        int id=signup.setUserData(user);
        if(id<0)
        {
            throw new Exception("Failed ");
        }
        else{
            cookie.user_id=id;
            return id;
        }
    }

    public int add_login_details(int user_id,String email,String password) throws Exception
    {
        loginDAO login=loginDAO.getInstance();
        loginDTO user=new loginDTO(user_id,email,password);
        int a=login.setLoginData(user);
        if(a<=0)
        {
            throw new Exception("Failed ");
        }
        else{
            return 1;
        }
    }
    public void add_volunteer(int available) throws Exception
    {
        volunteerDAO v =volunteerDAO.getInstance();
        volunteersDTO volun = new volunteersDTO(cookie.user_id,available);
        int a=v.setVolunteer_details(volun);
        if(a<=0)
        {
            throw new Exception("Failed to add volunteers");
        }
    }
    public void add_vetnerian(String speciality) throws Exception
    {
        vetnerianDAO v =vetnerianDAO.getInstance();
        vetneriansDTO vet = new vetneriansDTO(cookie.user_id,speciality);
        int a=v.setVetnerian_details(vet);
        if(a<=0)
        {
            throw new Exception("Failed to add volunteers");
        }
    }

   
    
}