package com.solarwind.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * User: Zhongyang MA
 * Date: 2018/4/13
 * Time: 15:44
 */
@Document(collection = "user")  // specify mongodb's "collection", which is equivalent to "table"
public class User {
    @Id  // define the primary key
    private String id;
    private String name;
    private String gender;
    private String phone;

    public User() {}

    public User(String id, String name, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "{id:" + id + ", name:" + name + ", gender:" + gender + ", phone:" + phone + "}";
    }

}
