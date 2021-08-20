package com.preet.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User("foo", "foo",
                new ArrayList<>());
//        UserEntity user = userRepo.findByUserName(userName);
//        if (user == null) {
//            log.error("User not found in database");
//            throw new UsernameNotFoundException("User not found in database");
//        } else {
//            log.info("User found in database : {}", userName);
//            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
//            return new User(user.getUserName(), user.getPassword(), authorities);
//        }
    }
}