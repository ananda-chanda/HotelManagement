package HotelManagementSystem;

public class Administration implements IAdministration {
  private String Username,Password;
  public Administration(){
    
  }
  public void  administration(String Username,String Password){
    this.Username=Username;
    this.Password=Password;
  }
  public String getUsername(){
    return Username;
  }
  public String getPassword(){
    return Password;
  }
}