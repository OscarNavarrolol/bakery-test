package com.test.repository;

import com.test.entity.Flour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlourRepository extends JpaRepository<Flour, Long> {
}
