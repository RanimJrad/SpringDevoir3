package com.ranim.superMarket.service;

import java.util.List;
import org.springframework.data.repository.query.Param;
import com.ranim.superMarket.model.Supermarket;
import com.ranim.superMarket.model.Type;

public interface SupermarketService {
	Supermarket saveSupermarket(Supermarket s);
	Supermarket updateSupermarket(Supermarket s);
	void deleteSupermarket(Supermarket s);
	void deleteSupermarketById(Long id);
	Supermarket getSupermarket(Long id);
	List<Supermarket> getAllSupermarkets();
	List<Supermarket> findByNomSuperMarket(String nom);
	List<Supermarket> findByNomSuperMarketContains(String nom);
	List<Supermarket> findByNomLocalisation (@Param("nom") String nom,@Param("loc") String loc);
	List<Supermarket> findByType (Type type);
	List<Supermarket> findByTypeIdtype(Long id);
	List<Supermarket> findByOrderByNomSuperMarketAsc();
	List<Supermarket> trierSupermarketsNomsLocalisations ();
	}
