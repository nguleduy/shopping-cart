package com.example.productservice.repository;

import com.example.productservice.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {
}
