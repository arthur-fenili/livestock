package com.checkpoint.livestock.repository;

import com.checkpoint.livestock.model.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmazemRepository extends JpaRepository<Armazem, Long> {
}
