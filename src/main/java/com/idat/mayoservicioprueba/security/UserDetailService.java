package com.idat.mayoservicioprueba.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if( "profesor".equals(username)) {
			return new User("profesor",new BCryptPasswordEncoder().encode("123456") , new ArrayList<>());
		}else
			throw new UsernameNotFoundException("Usuario no existe " + username);
	}

}
