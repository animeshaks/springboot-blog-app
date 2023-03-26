package com.srijan.blog.sbblogapp.security;

import com.srijan.blog.sbblogapp.entities.User;
import com.srijan.blog.sbblogapp.exceptions.ResourceNotFoundException;
import com.srijan.blog.sbblogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Loading user from database by username
        User user = this.userRepository.findByEmail(username)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Username "+ username, 0)); // Create custom exception for string value

        return user;
    }
}
