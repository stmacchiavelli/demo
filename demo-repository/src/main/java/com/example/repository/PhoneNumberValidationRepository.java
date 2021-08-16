package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.repository.entity.PhoneNumberValidationEntity;

@Repository
public interface PhoneNumberValidationRepository extends JpaRepository<PhoneNumberValidationEntity, Long> {
	List<PhoneNumberValidationEntity> findByStatus(Integer status);
}
