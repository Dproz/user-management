package com.ceitechs.dproz.usermanagement.domain;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -1353329736543106750L;

	public static final int PASSWORD_MIN_LENGTH = 8;
	public static final int PASSWORD_MAX_LENGTH = 100;
	
	@Id
	private String userReferenceId;
	
	
	private UserType userType;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;
	
	private String middleName;
	
	@Valid
	private Phone phone;
	
	@Valid
	private Address address;
	
	@Email
	@NotBlank
	private String emailAddress;
	
	/**
	 * Password has following validations:
	 * 1. Should have at least 1 capital letter
	 * 2. Should have at least 1 small letter
	 * 3. Should have at least 1 number
	 * 4. Only alphabets numbers and #@%*-_ are allowed
	 */
	@NotNull
    @Pattern(regexp  = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9_#@%\\*\\-]{8,24}$")
	private String password;
	
	private String profilePictureUrl;

}
