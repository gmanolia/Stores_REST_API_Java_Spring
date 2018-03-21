package shops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StoreUserDetailsService storeUserDetailsService;

    @Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(storeUserDetailsService);
    
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("passing from here");     
        http
                .authorizeRequests()
                .antMatchers("/getStoresList/**").permitAll()
                //.antMatchers("/createStore/**").permitAll()
                .antMatchers("/createStore/**").hasRole("ADMIN")
                .antMatchers("/changeStore/**").hasRole("STOREOWNER")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
