package HotelManagementSystem;

public class Admin implements IAdmin{
  private String Username,Password;
  public Admin(){
    
  }
  public void admin(String Username,String Password){
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