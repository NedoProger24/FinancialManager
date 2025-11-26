package org.origami.fm.page.login.service;

import org.origami.fm.entity.FMUser;
import org.origami.fm.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.origami.fm.util.CheckValidationUtils.checkUsername;
import static org.origami.fm.util.CheckValidationUtils.notNull;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    UserDataService userDataService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final FMUser user = userDataService.getUser(username);
        if (notNull(user) || checkUsername(username))
            throw new UsernameNotFoundException("User not found");
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
