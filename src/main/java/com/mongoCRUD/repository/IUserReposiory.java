package com.mongoCRUD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongoCRUD.model.User;

@Repository
public interface IUserReposiory extends MongoRepository<User,Integer> {

}
