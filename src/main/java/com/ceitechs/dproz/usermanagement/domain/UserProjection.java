package com.ceitechs.dproz.usermanagement.domain;

import java.util.Set;

public interface UserProjection {
  String getUserReferenceId();
  UserType getUserType();
  String getFirstName();
  String getLastName();
  String getMiddleName();
  Phone getPhone();
  Address getAddress();
  String getEmailAddress();
  boolean isActive();
  String getProfilePictureUrl();
  Set<Authority> getAuthorities();
}
