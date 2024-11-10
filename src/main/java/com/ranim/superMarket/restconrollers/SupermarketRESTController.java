package com.ranim.superMarket.restconrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ranim.superMarket.model.Supermarket;
import com.ranim.superMarket.service.SupermarketService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SupermarketRESTController {
	
	@Autowired
	SupermarketService supermarketSevice;
	
	@RequestMapping(path= "/all", method=RequestMethod.GET)
	public List<Supermarket> getAllSupermarkets(){
		return supermarketSevice.getAllSupermarkets();
	}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	//@GetMapping("getbyid/{id}")
	public Supermarket getProduitById(@PathVariable("id") Long id) {
	return supermarketSevice.getSupermarket(id);
	}
	
	@RequestMapping(path="/addsupermarket" ,method = RequestMethod.POST)
	//@PostMapping("/addsupermarket")
	public Supermarket createSupermarket(@RequestBody Supermarket supermarket) {
	return supermarketSevice.saveSupermarket(supermarket);
	}
	
	@RequestMapping(path="/updatesupermarket" ,method = RequestMethod.PUT)
	//@PutMapping("/updatesupermarket")
	public Supermarket updateSupermarket(@RequestBody Supermarket supermarket) {
	return supermarketSevice.updateSupermarket(supermarket);
	}
	
	@RequestMapping(value="/deletesupermarket/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("/deletesupermarket/{id}")
	public void deleteSupermarket(@PathVariable("id") Long id)
	{
		supermarketSevice.deleteSupermarketById(id);
	}
	
	@RequestMapping(value="/suptype/{idtype}",method = RequestMethod.GET)
	public List<Supermarket> getSupermarketByTypeId(@PathVariable("idtype") Long idtype) {
	return supermarketSevice.findByTypeIdtype(idtype);
	}
	
	@RequestMapping(value="/supersByName/{nom}",method = RequestMethod.GET)
	public List<Supermarket> findByNomProduitContains(@PathVariable("nom") String nom) {
	return supermarketSevice.findByNomSuperMarketContains(nom);
	}

}
