package com.example.demo.dbapi.MyuserRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dbapi.MyUser.Myuser;

@Repository
public interface MyUserRepo extends  JpaRepository <Myuser,Integer> {

}
