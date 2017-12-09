package com.ceitechs.dproz.usermanagement.config.dbmigrations;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ceitechs.dproz.shared.security.AuthoritiesConstants;
import com.ceitechs.dproz.usermanagement.domain.Address;
import com.ceitechs.dproz.usermanagement.domain.Authority;
import com.ceitechs.dproz.usermanagement.domain.ContactMethod;
import com.ceitechs.dproz.usermanagement.domain.Phone;
import com.ceitechs.dproz.usermanagement.domain.User;
import com.ceitechs.dproz.usermanagement.domain.UserType;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

@ChangeLog(order = "002")
public class AddTestDataChangeLog {

	@Profile("local")
	@ChangeSet(order = "02", author = "user-management", id = "01-addUsers")
	public void addUsers(MongoTemplate mongoTemplate) {

		Authority adminAuthority = new Authority();
		adminAuthority.setName(AuthoritiesConstants.ADMIN);
		Authority userAuthority = new Authority();
		userAuthority.setName(AuthoritiesConstants.USER);

		Address address1 = new Address();
		address1.setCountry("USA");
		address1.setDistrict("Godavari");
		address1.setRegion("Telangana");
		address1.setStreet("Kilbrun");
		Phone phone1 = new Phone();
		phone1.setContactMethod(ContactMethod.CALL);
		phone1.setPhoneNumber("8041000100");
		User systemUser = new User();
		systemUser.setUserReferenceId("1");
		systemUser.setEmailAddress("prabhakar.digumarthi@gmail.com");
		systemUser.setPassword("{bcrypt}$2a$10$OmMppGSRVjmOYFLm/MtX/.VHRgEbNJW06EiotJV37YbvOFxVwsxli");
		systemUser.setFirstName("Prabhakar");
		systemUser.setLastName("Digumarthi");
		systemUser.setMiddleName("VS");
		systemUser.setAddress(address1);
		systemUser.setPhone(phone1);
		systemUser.setActive(true);
		systemUser.setUserType(UserType.PRO);
		systemUser.getAuthorities().add(userAuthority);

		mongoTemplate.save(systemUser);

		Address address2 = new Address();
		address2.setCountry("Tanzania");
		address2.setDistrict("Ikungi");
		address2.setRegion("Singida");
		address2.setStreet("Kilbrun");
		Phone phone2 = new Phone();
		phone2.setContactMethod(ContactMethod.TEXTORCALL);
		phone2.setPhoneNumber("8041000101");
		User systemUser1 = new User();
		systemUser1.setUserReferenceId("2");
		systemUser1.setEmailAddress("iddy.magohey@gmail.com");
		systemUser1.setPassword("{bcrypt}$2a$10$OmMppGSRVjmOYFLm/MtX/.VHRgEbNJW06EiotJV37YbvOFxVwsxli");
		systemUser1.setFirstName("Iddy");
		systemUser1.setLastName("Magohey");
		systemUser1.setAddress(address2);
		systemUser1.setPhone(phone2);
		systemUser1.setUserType(UserType.USER);
		systemUser1.setActive(true);
		systemUser1.getAuthorities().add(userAuthority);
		mongoTemplate.save(systemUser1);
		
		Address address3 = new Address();
		address3.setCountry("Tanzania");
		address3.setDistrict("Ikungi");
		address3.setRegion("Singida");
		address3.setStreet("Kilbrun");
		Phone phone3 = new Phone();
		phone3.setContactMethod(ContactMethod.TEXTORCALL);
		phone3.setPhoneNumber("8041000101");
		User adminUser = new User();
		adminUser.setUserReferenceId("2");
		adminUser.setEmailAddress("ceitechs@gmail.com");
		adminUser.setPassword("{bcrypt}$2a$10$OmMppGSRVjmOYFLm/MtX/.VHRgEbNJW06EiotJV37YbvOFxVwsxli");
		adminUser.setFirstName("System");
		adminUser.setLastName("Admin");
		adminUser.setAddress(address2);
		adminUser.setPhone(phone2);
		adminUser.setUserType(UserType.USER);
		adminUser.setActive(true);
		adminUser.getAuthorities().add(adminAuthority);
		mongoTemplate.save(systemUser1);
	}

}
