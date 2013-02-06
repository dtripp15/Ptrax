package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.ebean.*;
 
@Entity
public class User extends Model {
 
    public Long user_id;
 	public String email;
    public String password;
    public String first_name;
    public String last_name;
    public boolean active;    
    public boolean isAdmin;
    
    public User(String email, String password, String first_name, String last_name, boolean active, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.active = active;
        this.isAdmin = isAdmin;
    }
 
}