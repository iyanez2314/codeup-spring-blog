//package com.codeup.codeupspringblog.Services;
//
//import com.codeup.codeupspringblog.Controllers.UserRepository;
////import com.codeup.codeupspringblog.Controllers.UserWithRoles;
//import com.codeup.codeupspringblog.models.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

<<<<<<< Updated upstream
//@Service
//public class UserDetailsLoader implements UserDetailsService {
//    private final UserRepository users;
//
//    public UserDetailsLoader(UserRepository users){
//        this.users = users;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = users.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("No user found for " + username);
//        }
//        return new UserWithRoles(user);
//    }
//}
=======
import com.codeup.codeupspringblog.Controllers.UserRepository;
import com.codeup.codeupspringblog.Controllers.UserWithRoles;
import com.codeup.codeupspringblog.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
>>>>>>> Stashed changes
