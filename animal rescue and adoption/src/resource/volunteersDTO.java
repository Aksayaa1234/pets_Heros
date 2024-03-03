package resource;

public class volunteersDTO 
{
    private int id_volunteer;
    private int available;
    
    public volunteersDTO() {
            
    }
    public volunteersDTO(int id_volunteer, int available) {
    this.id_volunteer=id_volunteer;
    this.available = available;
    }
    public int getId_volunteer() {
        return id_volunteer;
    }
    public void setId_volunteer(int id_volunteer) {
        this.id_volunteer=id_volunteer;
    }
    public int getAvailable() {
        return available;
    }
    public void setAvailable(int available) {
        this.available=available;
    }
}