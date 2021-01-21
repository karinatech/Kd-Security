package com.cybertek.implementations;

import com.cybertek.entity.User;
import com.cybertek.entity.common.UserProncipaal;
import com.cybertek.repo.UserRepo;
import com.cybertek.service.SecurityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    private UserRepo userRepo;

    public SecurityServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepo.findByUserName(s);
        if(user==null){
            throw new UsernameNotFoundException("This user doesn't exist");

        }
        return new UserProncipaal(user);
    }
}
