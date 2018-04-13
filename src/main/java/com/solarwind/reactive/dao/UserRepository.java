package com.solarwind.reactive.dao;

import com.solarwind.reactive.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Zhongyang MA
 * Date: 2018/4/13
 * Time: 16:03
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
