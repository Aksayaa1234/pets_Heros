package resource;

public class vetneriansDTO {
    private int id_vetnerians;
    private String specialist;
    
    public vetneriansDTO() {
            
    }
    public vetneriansDTO(int id_vetnerians, String specialist) {
    this.id_vetnerians=id_vetnerians;
    this.specialist = specialist;
    }
    public int getId_vetnerians() {
        return id_vetnerians;
    }
    public void setId_vetnerians(int id_vetnerians) {
        this.id_vetnerians=id_vetnerians;
    }
    public String getSpecialist() {
        return specialist;
    }
    public void setSpecialist(String specialist) {
        this.specialist=specialist;
    }
    
}
