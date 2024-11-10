package com.ranim.superMarket.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ranim.superMarket.model.Supermarket;
import com.ranim.superMarket.model.Type;
import com.ranim.superMarket.repos.ImageRepository;
import com.ranim.superMarket.repos.SupermarketRepository;

@Service
public class SupermarketServiceImpl implements SupermarketService{

	@Autowired
	SupermarketRepository supermarketRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public Supermarket saveSupermarket(Supermarket s) {
		return supermarketRepository.save(s);
	}

	@Override
	public Supermarket updateSupermarket(Supermarket s) {
		
		//Long oldProdImageId =this.getSupermarket(s.getIdSuperMarket()).getImage().getIdImage();
		//Long newProdImageId = s.getImage().getIdImage();
		Supermarket supUpdated = supermarketRepository.save(s);
		//if (oldProdImageId != newProdImageId) 
				//imageRepository.deleteById(oldProdImageId);
				return supUpdated;
	}

	@Override
	public void deleteSupermarket(Supermarket s) {
		
		supermarketRepository.delete(s);
	}

	@Override
	public void deleteSupermarketById(Long id) {
		Supermarket s = getSupermarket(id);
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+s.getImagePath()));
			} catch (IOException e) {
			e.printStackTrace();
			}
		supermarketRepository.deleteById(id);
	}

	@Override
	public Supermarket getSupermarket(Long id) {
		return supermarketRepository.findById(id).get();
	}

	@Override
	public List<Supermarket> getAllSupermarkets() {
		return supermarketRepository.findAll();
	}

	@Override
	public List<Supermarket> findByNomSuperMarket(String nom) {
		return supermarketRepository.findByNomSuperMarket(nom);
	}

	@Override
	public List<Supermarket> findByNomSuperMarketContains(String nom) {
		return supermarketRepository.findByNomSuperMarketContains(nom);
	}

	@Override
	public List<Supermarket> findByNomLocalisation(String nom, String loc) {	
		return supermarketRepository.findByNomLocalisation(nom, loc);
	}

	@Override
	public List<Supermarket> findByType(Type type) {
		return supermarketRepository.findByType(type);
	}

	@Override
	public List<Supermarket> findByTypeIdtype(Long id) {
		return supermarketRepository.findByTypeIdtype(id);
	}

	@Override
	public List<Supermarket> findByOrderByNomSuperMarketAsc() {
		return supermarketRepository.findByOrderByNomSuperMarketAsc();
	}

	@Override
	public List<Supermarket> trierSupermarketsNomsLocalisations() {
		return supermarketRepository.trierSupermarketsNomsLocalisations();
	}

}
