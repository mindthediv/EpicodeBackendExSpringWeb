package com.pack.appfiles.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.appfiles.security.enumerates.UserRole;
import com.pack.appfiles.security.models.Role;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRole(UserRole role);

	Boolean existsByRole(UserRole role);

}
