package resource;

public class petsDTO {

    private int id_pets;
    private String city;
    private String area;
    private String status;
    private String wound_or_rescue ;
    private int id_b;
    private String name;
    private String breed;
    private int id_volunteer;
    private String d_name;
    private String phone_no;

    public petsDTO() {
        
    }
    public petsDTO(int id_pets,String city,String area,String status,String wound_or_rescue,int id_b) {
       this.id_pets=id_pets;
       this.city= city;
       this.area= area;
       this.status=status;
       this.wound_or_rescue= wound_or_rescue;
       this.id_b= id_b;
   }
   public petsDTO(String city,String area,String status,String wound_or_rescue,int id_b) {
    
    this.city= city;
    this.area= area;
    this.status=status;
    this.wound_or_rescue= wound_or_rescue;
    this.id_b= id_b;
}
    public int getId_pets() {
        return id_pets;
    }
    public void setId_pets(int id_pets) {
        this.id_pets=id_pets;
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
   public void setStatus(String status)
   {
       this.status=status;
   }
   public String getStatus()
   {
       return status;
   }    
   public void setWound_or_rescue(String wound_or_rescue)
   {
       this.wound_or_rescue=wound_or_rescue;
   }
   public String getWound_or_rescue()
   {
       return wound_or_rescue;
   } 
   public int getId_b() {
    return id_b;
}
public void setId_b(int id_b) {
    this.id_b=id_b;
}   
public String getName() {
    return name;
}
public void setName(String name) {
    this.name=name;
}
public void setBreed(String breed)
{
   this.breed=breed;
}
public String getBreed()
{
   return breed;
}    
public int getId_volunteer() {
    return id_volunteer;
}
public void setId_volunteer(int id_volunteer) {
    this.id_volunteer=id_volunteer;
}      
public void setPhone_no(String phone_no)
{
    this.phone_no=phone_no;
}
public String getPhone_no()
{
    return phone_no;
}   
public String getd_Name() {
    return d_name;
}
public void setd_Name(String d_name) {
    this.d_name=d_name;
}   
}