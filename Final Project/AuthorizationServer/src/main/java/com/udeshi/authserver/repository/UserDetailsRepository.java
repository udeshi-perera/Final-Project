package com.udeshi.authserver.repository;

import com.udeshi.authserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String name);

    //optionalUser.orElseThrow(())

}
