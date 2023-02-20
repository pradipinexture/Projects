package com.javainuse.service;

import com.javainuse.model.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("javainuse".equals(username)) {
			CustomUserDetails customUserDetails = new CustomUserDetails();
			customUserDetails.setEmail("javainuse");
			customUserDetails.setEnabled(true);
			customUserDetails.setMobile("1234567890");
			customUserDetails.setPassword("$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6");
			return customUserDetails;
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}