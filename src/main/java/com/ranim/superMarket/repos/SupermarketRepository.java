package com.ranim.superMarket.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.ranim.superMarket.model.Supermarket;
import com.ranim.superMarket.model.Type;

@RepositoryRestResource(path = "rest")
public interface SupermarketRepository extends JpaRepository<Supermarket,Long> {
	
	List<Supermarket> findByNomSuperMarket(String nom);
	List<Supermarket> findByNomSuperMarketContains(String nom);
	
	/*@Query("select s from Supermarket s where s.nomSuperMarket like %?1 and s.localisationSuperMarket like %?2")
	List<Supermarket> findByNomLocalisation (String nom, String loc);*/
	
	@Query("select s from Supermarket s where s.nomSuperMarket like %:nom and s.localisationSuperMarket like %:loc")
	List<Supermarket> findByNomLocalisation (@Param("nom") String nom,@Param("loc") String loc);
	
	@Query("select s from Supermarket s where s.type = ?1")
	List<Supermarket> findByType (Type type);
	
	List<Supermarket> findByTypeIdtype(Long id);
	
	List<Supermarket> findByOrderByNomSuperMarketAsc();
	
	@Query("select s from Supermarket s order by s.nomSuperMarket ASC, s.localisationSuperMarket DESC")
	List<Supermarket> trierSupermarketsNomsLocalisations ();


}
