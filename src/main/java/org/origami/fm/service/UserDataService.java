package org.origami.fm.service;

import org.origami.fm.entity.FMUser;
import org.origami.fm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {
    @Autowired
    private UserRepository userRepository;
    public FMUser getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
