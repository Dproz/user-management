package com.ceitechs.dproz.usermanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User implements Serializable, UserProjection {

  private static final long serialVersionUID = -1353329736543106750L;

  @Id
  private String userReferenceId;

  @NotNull
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


  private boolean active;

  /**
   * Password has following validations: 1. Should have at least 1 capital letter 2. Should have at
   * least 1 small letter 3. Should have at least 1 number 4. Only alphabets numbers and #@%*-_ are
   * allowed
   */
  @NotNull
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9_#@%\\*\\-]{8,24}$|^(\\{bcrypt\\})(.*)$")
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  private String profilePictureUrl;

  private Set<Authority> authorities = new HashSet<>();

}
