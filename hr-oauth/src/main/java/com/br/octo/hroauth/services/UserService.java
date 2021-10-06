package com.br.octo.hroauth.services;

import com.br.octo.hroauth.entities.User;
import com.br.octo.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.FindByEmail(email).getBody();

        if(user == null){
            logger.error("Email not found " + email);
            throw new IllegalArgumentException("Email not found");
        }

        logger.info("Email found " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userFeignClient.FindByEmail(s).getBody();

        if(user == null){
            logger.error("Email not found " + s);
            throw new UsernameNotFoundException("Email not found");
        }

        logger.info("Email found " + s);
        return user;
    }
}
