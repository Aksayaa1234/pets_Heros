package resource;

public class breedsDTO {
    private int id_b;
    private String name;
    private String breed;

    public breedsDTO() {
        
    }
    
    public breedsDTO(int id_b,String name,String breed) {
       this.name = name;
       this.breed= breed;
       this.id_b= id_b;
    }
    public breedsDTO(String name,String breed) {
        this.name = name;
        this.breed= breed;
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
}
