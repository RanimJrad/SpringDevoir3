package com.ranim.superMarket.restconrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ranim.superMarket.model.Type;
import com.ranim.superMarket.repos.TypeRepository;

@RestController
@RequestMapping("/api/Type")
@CrossOrigin(origins = "http://localhost:4200/")
public class TypeRESTController {
	
	@Autowired
	TypeRepository typeRepository;
	
	@RequestMapping( method=RequestMethod.GET)
	public List<Type> getAllTypes()
	{
		return typeRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Type getTypeById(@PathVariable("id") Long id) {
	return typeRepository.findById(id).get();
	}
	
	@RequestMapping(path="/addtype" ,method = RequestMethod.POST)
	//@PostMapping("/addtype")
	public Type createType(@RequestBody Type type) {
	return typeRepository.save(type);
	}

}
