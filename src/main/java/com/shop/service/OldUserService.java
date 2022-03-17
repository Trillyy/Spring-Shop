package com.shop.service;

import com.shop.dao.DAOUser;
import com.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OldUserService implements UserDetailsService {

    @Autowired
    DAOUser userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<User> user = userRepository.findByUsername(username);
    	System.out.print(user.map(MyUserDetails::new).get());
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }
}
