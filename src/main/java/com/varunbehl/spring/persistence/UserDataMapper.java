package com.varunbehl.spring.persistence;

import com.varunbehl.spring.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDataMapper {

    @Select("SELECT * FROM user")
    List<User> getAllData();


    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "userId")
    @Insert("INSERT INTO user (  userPassword ,  userName ,  userEmail ,  userMobile ,  userPhone ,  gymId ,  dietId ,  userLevel ,  userImage ,  userSex ,  userDob ,  gymSlot ,  userWeight ,  userHeight ,  userBmi ,  userStatus ,  userAttendence ,  userType ,  userSubscription ) VALUES ( #{userPassword}, #{userName}, #{userEmail}, #{userMobile}, #{userPhone}, #{gymId},  #{dietId}, #{userLevel}, #{userImage}, #{userSex}, #{userDob},  #{gymSlot}, #{userWeight}, #{userHeight}, #{userBmi}, #{userStatus}, #{userAttendence}, #{userType}, #{userSubscription})")
    int saveData(User myData);

    @Update("UPDATE user SET title = #{title}, dateModified = #{dateModified} WHERE id = #{id}")
    int updateTodo(User myData);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteData(User myData);

    @Select("SELECT * FROM user where gymId = #{id}")
    List<User> findById(String id);

    @Select("SELECT * FROM user where userEmail = #{email}")
    User findByEmail(String email);
}
