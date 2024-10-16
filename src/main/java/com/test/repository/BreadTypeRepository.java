package com.test.repository;

import com.test.entity.BreadType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadTypeRepository extends JpaRepository<BreadType, Long> {
}
