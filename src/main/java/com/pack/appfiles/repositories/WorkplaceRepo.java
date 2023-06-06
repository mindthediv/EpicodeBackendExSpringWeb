package com.pack.appfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pack.appfiles.models.Workplace;

public interface WorkplaceRepo extends JpaRepository<Workplace, Long> {
    
}
