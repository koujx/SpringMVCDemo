package com.kou.repository;

import com.kou.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lianjia on 2017-3-20.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Modifying
    @Transactional
    @Query("update UserEntity us set us.nickname=:qNickname,us.firstName=:qFirstname," +
            "us.lastName=:qLastname,us.passwd=:qPasswd where us.id=:qId")
    public void updateUser(@Param("qNickname") String nickName, @Param("qFirstname") String firstName,
                           @Param("qLastname") String lastName, @Param("qPasswd") String passwd,
                           @Param("qId") Integer id);
}
