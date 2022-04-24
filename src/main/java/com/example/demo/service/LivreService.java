package com.example.demo.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepository;

@Service
public class LivreService {
	@Autowired
	LivreRepository livreRepos;
	
	public List<Livre> index()
	{
		return livreRepos.findAllByOrderByTitreAsc();
	}
	public Livre show(int id)
	{
		return livreRepos.findById(id).get();
	}
	public Livre store(Livre livre)
	{
		try {
			return livreRepos.save(livre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public Livre edit(int id,Livre data)
	{
		try {
			Livre livre = livreRepos.findById(id).get();
			livre.setAuteur(data.getAuteur());
			livre.setDate_consultation(new Date());
			livre.setDate_sortie(data.getDate_sortie());
			livre.setDisponible(data.isDisponible());
			livre.setPages(data.getPages());
		    livre.setTitre(data.getTitre());
		    return livreRepos.save(livre);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	@Transactional
	public void delete(int id)
	{
		livreRepos.deleteById(id);   
	}

}
