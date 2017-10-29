package com.ceitechs.dproz.usermanagement.adapter.datastore.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceitechs.dproz.usermanagement.domain.User;

@SuppressWarnings("unused")
@Repository
public interface UserRepostitory extends MongoRepository<User, String> {

}
