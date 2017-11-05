package com.ceitechs.dproz.usermanagement.config.dbmigrations;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ceitechs.dproz.usermanagement.domain.Address;
import com.ceitechs.dproz.usermanagement.domain.ContactMethod;
import com.ceitechs.dproz.usermanagement.domain.Phone;
import com.ceitechs.dproz.usermanagement.domain.User;
import com.ceitechs.dproz.usermanagement.domain.UserType;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

@ChangeLog
public class AddTestDataChangeLog {
	
	
	@Profile("local")
	@ChangeSet(order = "01", author = "user-management", id = "01-addUsers")
    public void addUsers(MongoTemplate mongoTemplate) {
    
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
        systemUser.setPassword("Password@1");
        systemUser.setFirstName("Prabhakar");
        systemUser.setLastName("Digumarthi");
        systemUser.setMiddleName("VS");
        systemUser.setAddress(address1);
        systemUser.setPhone(phone1);
        systemUser.setUserType(UserType.PRO);

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
        systemUser1.setPassword("Password@1");
        systemUser1.setFirstName("Iddy");
        systemUser1.setLastName("Magohey");
        systemUser1.setAddress(address2);
        systemUser1.setPhone(phone2);
        systemUser1.setUserType(UserType.USER);
        mongoTemplate.save(systemUser1);
 
    }

}
