package shops;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Role {
    
    private static final long serialVersionUID = -829888892992929929L;
   
    @Id
    @GeneratedValue
    private long roleID;

    private String roleName;

    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;

    public Role(){
    }

    public Role(long roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public String getRoleName(){
        return roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
}


