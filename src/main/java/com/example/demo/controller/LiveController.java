package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;
//Rest Controller for Books
@RestController @RequestMapping("emsi_api/livres") //main route for this controller 
public class LiveController {
//Dependency injection of LivreService instance
@Autowired
LivreService livreService;

//Get all books
@GetMapping
List<Livre> getLivres()
{
	return livreService.index();
}
//Get one book using its ID
@GetMapping("/{id}")
Livre showLivre(@PathVariable int id)
{
	return livreService.show(id);
}
//Add new book 
@PostMapping
Livre newLivre(@RequestBody Livre data) {
 return livreService.store(data);
}
//Edit one book using its ID
@PutMapping("/{id}")
Livre editLivre(@RequestBody Livre data, @PathVariable int id) {
 return livreService.edit(id,data);
}
//Edit one book using its ID
@DeleteMapping("/{id}")
void deleteLivre(@PathVariable int id) {
 livreService.delete(id);
}
}
