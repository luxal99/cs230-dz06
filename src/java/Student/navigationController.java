package Student;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "navigationController")
@RequestScoped
public class navigationController {
    
     public navigationController() {
    }
    
    private String location;
 
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String navigate() {
    
        if (this.location.equals("Göteborg")) {
            return "confirmation";
        } 
        else if(this.location.equals("Stockholm")){
            return "confirmation2";
        }
            return "confirmation3";
    }
}
