package resource;

public class adoptionDTO {
    private int id_adopt;
    private int user_id;
    private int id_app;
    
    public adoptionDTO() {
        
    }
    public adoptionDTO(int user_id,int id_adopt,int id_app) {
       this.user_id=user_id;
       this.id_adopt = id_adopt;
       this.id_app = id_app;
   }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id=user_id;
   }
    public int getId_adopt() {
        return id_adopt;
    }
    public void setId_adopt(int id_adopt) {
        this.id_adopt=id_adopt;
    }
    public int getId_app()
    {
        return id_app;
    }        
   public void setId_app(int id_app)
   {
       this.id_app=id_app;
   }
}
