package com.example.demo.entities;


import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Livre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 @Column(length = 50,nullable = false)
	 private String titre ;
	 @Column(nullable = false,updatable = false)
	 private String maison_édition;
	 @Column(nullable = false)
	 @Temporal(TemporalType.DATE) 
	 private Date date_sortie;
	 @Column(nullable = false)
	 private String auteur;
	 @Column(nullable = false)
	 private int pages;
	 @Column(unique = true,nullable = false,updatable = false)
	 private String  ISBN;
	 @Temporal(TemporalType.DATE)
	 @Column(nullable = false)
	 private Date date_consultation;
	 @Column(nullable = false)
	 private boolean disponible; 
}
