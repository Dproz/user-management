package com.ceitechs.dproz.shared.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class DprozUserDetail extends User {

  private String userReferenceId;

  public DprozUserDetail(String username, String password, String userReferenceId,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
    this.userReferenceId = userReferenceId;
  }

  public DprozUserDetail(String username, String password, String userReferenceId, boolean enabled,
      boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
        authorities);
    this.userReferenceId = userReferenceId;
  }

  public String getUserReferenceId() {
    return userReferenceId;
  }

  public void setUserReferenceId(String userReferenceId) {
    this.userReferenceId = userReferenceId;
  }
}
