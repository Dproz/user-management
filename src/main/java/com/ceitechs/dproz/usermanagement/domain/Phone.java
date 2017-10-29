package com.ceitechs.dproz.usermanagement.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Phone implements Serializable {
	
	private static final long serialVersionUID = -4320647163356541917L;

	@NotNull
	private String phoneNumber;
	
	@NotNull
	private boolean primary;
	
	@NotNull
	private ContactMethod contactMethod;

}
