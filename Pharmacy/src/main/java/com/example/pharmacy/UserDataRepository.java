package com.example.pharmacy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
		Optional<UserData> findByemail(String email);
}
