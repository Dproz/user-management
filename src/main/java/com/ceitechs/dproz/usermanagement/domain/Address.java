package com.ceitechs.dproz.usermanagement.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * Address
 * @author pdigumarthi
 *
 */
@Data
public class Address implements Serializable {
	
	private static final long serialVersionUID = -6947225767527076692L;

	private double longitude;
	
	private double latitude;
	
	private String street;
	
	private String district;
	
	private String region;
	
	private String country;
}
