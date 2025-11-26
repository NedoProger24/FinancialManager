package org.origami.fm.repository;

import org.origami.fm.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User save(User user) {
        return user;
    }
}