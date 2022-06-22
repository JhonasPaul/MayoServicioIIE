package com.idat.mayoservicioprueba.security;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*5*/
@Service
public class UserDetailService implements UserDetailsService {/*implementar metodo UserDetails*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("profesor".equals(username)){
            /*importar de import org.springframework.security.core.userdetails.User;*/
            return new User("profesor", "123", new ArrayList<>());
        }else{
            throw   new  UsernameNotFoundException("Usuario no existe" + username);
        }
    }
}
