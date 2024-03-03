package resource;

public class loginDTO 
{
    private int user_id;
    private String email;
    private String password;
    private String role;
    public loginDTO() {
        
    }
    public loginDTO(int user_id, String email,String password,String role) {
       this.user_id=user_id;
       this.email = email;
       this.password = password;
       this.role=role;
   }
   public loginDTO(int user_id, String email,String password) {
    this.user_id=user_id;
    this.email = email;
    this.password = password;
}
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id=user_id;
   }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }
   public void setPassword(String password)
   {
       this.password=password;
   }
   public String getPassword()
   {
       return password;
   }   
   public void setRole(String role)
   {
       this.role=role;
   }
   public String getRole()
   {
       return role;
   }      
}
