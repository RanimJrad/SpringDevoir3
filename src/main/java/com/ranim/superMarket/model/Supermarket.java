package com.ranim.superMarket.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supermarket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSuperMarket;
	private String nomSuperMarket;
	private String localisationSuperMarket;
	private Date dateCreation;
	
	@ManyToOne
	private Type type;
	


	public void setIdSuperMarket(Long idSuperMarket) {
		this.idSuperMarket = idSuperMarket;
	}

	/*@OneToOne
	private Image image;*/
	
	@OneToMany (mappedBy = "supermarket")
	private List<Image> images;
	
	private String imagePath;

	
	public Supermarket(String nomSuperMarket, String localisationSuperMarket, Date dateCreation) {
		super();
		this.nomSuperMarket = nomSuperMarket;
		this.localisationSuperMarket = localisationSuperMarket;
		this.dateCreation = dateCreation;
	}

	public String toString() {
		return "Supermarket [idSuperMarket=" + idSuperMarket + ", nomSuperMarket=" + nomSuperMarket
				+ ", localisationSuperMarket=" + localisationSuperMarket + ", dateCreation=" + dateCreation + "]";
	}

	/*public long getIdSuperMarket() {
		return idSuperMarket;
	}
	public void setIdSuperMarket(long idSuperMarket) {
		this.idSuperMarket = idSuperMarket;
	}
	public String getNomSuperMarket() {
		return nomSuperMarket;
	}
	public void setNomSuperMarket(String nomSuperMarket) {
		this.nomSuperMarket = nomSuperMarket;
	}
	public String getLocalisationSuperMarket() {
		return localisationSuperMarket;
	}
	public void setLocalisationSuperMarket(String localisationSuperMarket) {
		this.localisationSuperMarket = localisationSuperMarket;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}*/

	
	
	

}
