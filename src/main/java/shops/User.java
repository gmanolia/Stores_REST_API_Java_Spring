package shops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class User {
    @Id 
    @Column (name="UserID") 
    private Integer userID;

    private String username;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isDeleted;
    private String lastIPAddress;
    private Date creationDate;
    private Date lastSeenOnDate;
    private static final long serialVersionUID = -73098398398398L;
    
    @ManyToOne
    @JoinColumn(name = "roleID")
    private Role role;
    
    public User() {
    }
    
    public User(Integer userID, boolean isAdmin, String username, String email, String password, Role role) {
        this.userID = userID;
        this.isAdmin = isAdmin;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getLastIPAddress () {
        return this.lastIPAddress;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
      this.username = username;
    }
     
    public String getUsername() {
        return username;
    }

    public void setRole(Role role) { 
        this.role = role;
    }
    
    public Role getRole(){
        return role;
    }
}
