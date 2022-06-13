package com.dev.user.repositories;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.user.entities.User;

public interface userRepository extends JpaRepository<User, Long>{

	 /*User findByCpf(String cpf);
	 User findByEmail(String email);
	 User findByNome(String email);*/
	
}
