package com.example.websiteminuman.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websiteminuman.entities.Minuman;

@Repository
public interface MinumanRepository extends JpaRepository<Minuman, Long> {
	Minuman findByNama(String nama);

	boolean existsByNama(String nama);

	Optional<Minuman> findByNamaContainingIgnoreCase(String keyword);
}
 