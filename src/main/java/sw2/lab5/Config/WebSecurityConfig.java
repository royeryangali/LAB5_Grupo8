package sw2.lab5.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception  {

        http.formLogin()
                .loginPage("/loginForm") //ruta del formulario de login.html
                .loginProcessingUrl("/processLogin") //el boton del proceso submit del login
                .defaultSuccessUrl("/redirectByRole", true);

        http.logout()
                .logoutSuccessUrl("/").deleteCookies("JSESSIONID").invalidateHttpSession(true);

        http.authorizeRequests()
                //Protege ruta /employee y una debajo de ella. Sólo pueden verlo admin y logistica
                .antMatchers("/user/list").hasAuthority("admin")
                .antMatchers("/user", "/user/edit").hasAuthority("admin")
                .antMatchers("/post/delete").hasAuthority("admin")
                .antMatchers("/post/create").hasAuthority("admin")
                .antMatchers("/post/**").authenticated()
                .antMatchers("/user/**").authenticated()
                .anyRequest().permitAll();
    }
    @Autowired
    DataSource datasource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .passwordEncoder(new BCryptPasswordEncoder())
                //Obligatorio: identificador de validacion , password , estado logico del usuario
                .usersByUsernameQuery("SELECT user.email, user.password, user.active FROM user where email =? ")
                //roles y email
                .authoritiesByUsernameQuery("SELECT user.email, role.role_name FROM user INNER JOIN role ON (user.id_role = role.id_role) WHERE user.email = ? and user.active = 1");
    }
}