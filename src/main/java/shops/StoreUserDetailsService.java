package shops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Service 
public class StoreUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User name "+username+" not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
    }
    
    private Collection<GrantedAuthority> getGrantedAuthorities(User user) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        System.out.println("Role is been checked");
        if (user.getRole().getRoleName().equals("admin")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_STOREOWNER"));
            System.out.println("Role is ROLE_ADMIN");
        
        }
        if (user.getRole().getRoleName().equals("storeowner")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_STOREOWNER"));
            System.out.println("Role is ROLE_STOREOWNER");
        }
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }
}
