package CG.washer.GreenCarWash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="washers")
public class WasherProfile {
    @Id
    private  String email;
    private String password1;
    private String fullName;
    private String status;
    private String phoneNunmber;
    public WasherProfile()
    {

 

    }
    public WasherProfile(String email, String password, String fullName, String status, String phoneNunmber) {
        super();
        this.email = email;
        password1 = password;
        this.fullName = fullName;
        this.status = status;
        this.phoneNunmber = phoneNunmber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password1;
    }
    public void setPassword(String password) {
    	password1 = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPhoneNunmber() {
        return phoneNunmber;
    }
    public void setPhoneNunmber(String phoneNunmber) {
        this.phoneNunmber = phoneNunmber;
    }
    @Override
    public String toString() {
        return "WasherProfile [email=" + email + ", Password=" + password1 + ", fullName=" + fullName + ", status="
                + status + ", phoneNunmber=" + phoneNunmber + "]";
    }
}
