package com.ranim.superMarket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtype;
	private String nomtype;
	private String desciptionType;
	
	@OneToMany(mappedBy = "type")
	@JsonIgnore
	private List<Supermarket> supermarkets;
	
	
	
	
	public Long getIdtype() {
		return idtype;
	}
	
	public void setIdtype(Long idtype) {
		this.idtype = idtype;
	}
	
	public String getNomtype() {
		return nomtype;
	}
	
	public void setNomtype(String nomtype) {
		this.nomtype = nomtype;
	}
	
	public String getDesciptionType() {
		return desciptionType;
	}
	
	public void setDesciptionType(String desciptionType) {
		this.desciptionType = desciptionType;
	}

	public List<Supermarket> getSupermarkets() {
		return supermarkets;
	}

	public void setSupermarkets(List<Supermarket> supermarkets) {
		this.supermarkets = supermarkets;
	}

	
	
	

}
