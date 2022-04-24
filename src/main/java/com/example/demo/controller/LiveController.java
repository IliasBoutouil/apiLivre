package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;

@RestController @RequestMapping("emsi_api/livres")
public class LiveController {
	@Autowired
	LivreService livreService;
@GetMapping
List<Livre> getLivres()
{
	return livreService.index();
}

@GetMapping("/{id}")
Livre showLivre(@PathVariable int id)
{
	return livreService.show(id);
}
@PostMapping
Livre newLivre(@RequestBody Livre data) {
 return livreService.store(data);
}
@PutMapping("/{id}")
Livre editLivre(@RequestBody Livre data, @PathVariable int id) {
 return livreService.edit(id,data);
}
@DeleteMapping("/{id}")
void deleteLivre(@PathVariable int id) {
 livreService.delete(id);
}
}
