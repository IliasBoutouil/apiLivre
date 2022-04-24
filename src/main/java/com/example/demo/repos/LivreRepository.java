package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
	//searches all books and returns them sorted in ascending way using title 
 List<Livre> findAllByOrderByTitreAsc();
}
