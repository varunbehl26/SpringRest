package com.varunbehl.spring.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.varunbehl.spring.model.User;

public interface UserDataMapper {

	@Select("SELECT * FROM user")
	public List<User> getAllData();

	@Insert("INSERT INTO user ( userId ,  userPassword ,  userName ,  userEmail ,  userMobile ,  userPhone ,  gymId ,  dietId ,  userLevel ,  userImage ,  userSex ,  userDob ,  gymSlot ,  userWeight ,  userHeight ,  userBmi ,  userStatus ,  userAttendence ,  userType ,  userSubscription ) VALUES (#{userId}, #{userPassword}, #{userName}, #{userEmail}, #{userMobile}, #{userPhone}, #{gymId},  #{dietId}, #{userLevel}, #{userImage}, #{userSex}, #{userDob},  #{gymSlot}, #{userWeight}, #{userHeight}, #{userBmi}, #{userStatus}, #{userAttendence}, #{userType}, #{userSubscription})") 
	public int saveData(User myData);

	@Update("UPDATE user SET title = #{title}, dateModified = #{dateModified} WHERE id = #{id}")
	public int updateTodo(User myData);

	@Delete("DELETE FROM user WHERE id = #{id}")
	public int deleteData(User myData);
	
	@Select("SELECT * FROM user where gymId = #{id}")
	public User findById(String id);
}
