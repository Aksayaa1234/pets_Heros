package resource;

public class user_detailsDTO 
{
    private int user_id;
    private String name;
    private String city;
    private String area;
    private String phone_no;
    private String role;
    private int id;
    private String specialist;

    public user_detailsDTO() {
        
    }
    public user_detailsDTO(int user_id, String name,String city,String area,String phone_no,String role,int id) {
       this.user_id=user_id;
       this.name = name;
       this.city= city;
       this.area= area;
       this.phone_no=phone_no;
       this.role= role;
       this.id= id;
   }
   public user_detailsDTO( String name,String city,String area,String phone_no,String role) {
    this.name = name;
    this.city= city;
    this.area= area;
    this.phone_no=phone_no;
    this.role= role;
}
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id=user_id;
   }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
   public void setCity(String city)
   {
       this.city=city;
   }
   public String getCity()
   {
       return city;
   }    
   public void setArea(String area)
   {
       this.area=area;
   }
   public String getArea()
   {
       return area;
   }    
   public void setPhone_no(String phone_no)
   {
       this.phone_no=phone_no;
   }
   public String getPhone_no()
   {
       return phone_no;
   }    
   public void setRole(String role)
   {
       this.role=role;
   }
   public String getRole()
   {
       return role;
   } 
   public int getId() {
    return id;
}
public void setId(int id) {
    this.id=id;
}      
public String getSpecialist() {
    return specialist;
}
public void setSpecialist(String specialist) {
    this.specialist=specialist;
}     
}