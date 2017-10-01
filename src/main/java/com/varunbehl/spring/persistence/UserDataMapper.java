package com.varunbehl.spring.persistence;

import com.varunbehl.spring.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDataMapper {

    @Select("SELECT * FROM user")
    List<User> getAllData();

    @Insert("INSERT INTO user ( userId ,  userPassword ,  userName ,  userEmail ,  userMobile ,  userPhone ,  gymId ,  dietId ,  userLevel ,  userImage ,  userSex ,  userDob ,  gymSlot ,  userWeight ,  userHeight ,  userBmi ,  userStatus ,  userAttendence ,  userType ,  userSubscription ) VALUES (#{userId}, #{userPassword}, #{userName}, #{userEmail}, #{userMobile}, #{userPhone}, #{gymId},  #{dietId}, #{userLevel}, #{userImage}, #{userSex}, #{userDob},  #{gymSlot}, #{userWeight}, #{userHeight}, #{userBmi}, #{userStatus}, #{userAttendence}, #{userType}, #{userSubscription})")
    void saveData(User myData);

    @Update("UPDATE user SET title = #{title}, dateModified = #{dateModified} WHERE id = #{id}")
    int updateTodo(User myData);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteData(User myData);

    @Select("SELECT * FROM user where gymId = #{id}")
    User findById(String id);
}
