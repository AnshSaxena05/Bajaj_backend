package com.anshSaxena._BAI10190.repository;

import com.anshSaxena._BAI10190.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long> {
}
