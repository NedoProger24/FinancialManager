package org.origami.fm.repository;

import org.origami.fm.entity.FMUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<FMUser, String> {
    FMUser findByUsername (String username);
}