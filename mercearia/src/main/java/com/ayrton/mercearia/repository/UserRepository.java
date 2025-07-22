package com.ayrton.mercearia.repository;

import com.ayrton.mercearia.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    UserDetails findByLogin(String login);
}
