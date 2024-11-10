package com.ranim.superMarket.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomSupers", types = { Supermarket.class })
public interface SupermarketProjection {
	public String getNomSupermarket();

}
