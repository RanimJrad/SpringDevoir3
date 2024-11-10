package com.ranim.superMarket;


import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ranim.superMarket.model.Supermarket;
import com.ranim.superMarket.model.Type;
import com.ranim.superMarket.repos.SupermarketRepository;

@SpringBootTest
class SuperMarketApplicationTests {

	@Autowired
	private SupermarketRepository supermarketRepository;
	
	@Test
	public void testCreateProduit() {
	
	Supermarket sup = new Supermarket("Mg","Rue Ali Belhouane,Nabeul",new Date());
	supermarketRepository.save(sup);
	}
	
	@Test
	public void testFindSupermarket()
	{
	Supermarket s = supermarketRepository.findById(2L).get();
	System.out.println(s);
	}
	
	@Test
	public void testUpdateSupermarket()
	{
	Supermarket s = supermarketRepository.findById(1L).get();
	s.setLocalisationSuperMarket("Avenue Habib Bourguiba,Korba");
	supermarketRepository.save(s);
	System.out.println(s);
	}
	
	@Test
	public void testDeleteSupermarket()
	{
		supermarketRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousSupermarket()
	{
	List<Supermarket> sup = supermarketRepository.findAll();
	for (Supermarket s : sup)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testFindSupermarketByNom()
	{
	List<Supermarket> sup = supermarketRepository.findByNomSuperMarket("carrefour");
	for (Supermarket s : sup)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testFindSupermarketByNomContains()
	{
	List<Supermarket> sup = supermarketRepository.findByNomSuperMarketContains("o");
	for (Supermarket s : sup)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testfindByNomLocalisation()
	{
	List<Supermarket> sup = supermarketRepository.findByNomLocalisation("carrefour", "Avenue Habib Bourguiba,Nabeul");
	for (Supermarket s : sup)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByType()
	{
	Type t = new Type();
	t.setIdtype(1L);
	List<Supermarket> sup = supermarketRepository.findByType(t);
	for (Supermarket s : sup)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void findByTypeIdType()
	{
	List<Supermarket> sup = supermarketRepository.findByTypeIdtype(1L);
	for (Supermarket s : sup)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Supermarket> sup =supermarketRepository.findByOrderByNomSuperMarketAsc();
	for (Supermarket s : sup)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testTrierSupermarketsNomsLocalisations()
	{
	List<Supermarket> sup = supermarketRepository.trierSupermarketsNomsLocalisations();
	for (Supermarket s : sup)
	{
	System.out.println(s);
	}
	}

}
