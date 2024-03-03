package resource;

public class appointmentDTO {
    private int id_pets;
    private int id_app;
    private int id_volunteer;
    private int id_vetnerians;
    
    public appointmentDTO() {
        
    }
    public appointmentDTO(int id_pets,int id_volunteer,int id_app,int id_vetnerians) {
        this.id_pets=id_pets;
        this.id_volunteer=id_volunteer;
       this.id_app = id_app;
       this.id_vetnerians=id_vetnerians;
   }
   public appointmentDTO(int id_pets,int id_volunteer,int id_vetnerians) {
    this.id_pets=id_pets;
    this.id_volunteer=id_volunteer;
   this.id_vetnerians=id_vetnerians;
    }
    public int getId_pets() {
    return id_pets;
    }
    public void setId_pets(int id_pets) {
        this.id_pets=id_pets;
    }
    public int getId_volunteer() {
        return id_volunteer;
    }
    public void setId_volunteer(int id_volunteer) {
        this.id_volunteer=id_volunteer;
    }
    public int getId_app()
    {
        return id_app;
    }        
   public void setId_app(int id_app)
   {
       this.id_app=id_app;
   }
   public int getId_vetnerians() {
    return id_vetnerians;
    }
    public void setId_vetnerians(int id_vetnerians) {
        this.id_vetnerians=id_vetnerians;
    }
}
