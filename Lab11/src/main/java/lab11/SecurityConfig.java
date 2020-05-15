package lab11;
import java.security.*;
import org.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requiresChannel()
                .anyRequest()
                .requiresSecure();
    }
}
