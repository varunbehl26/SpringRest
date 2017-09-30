package com.varunbehl.spring.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.varunbehl.spring.model.Owner;

public interface MyDataMapper {

	@Select("SELECT * FROM owner")
	public List<Owner> getAllData();

	@Insert("INSERT INTO owner (title, dateCreated) VALUES (#{title}, #{dateCreated})")
	public int saveData(Owner myData);

	@Update("UPDATE owner SET title = #{title}, dateModified = #{dateModified} WHERE id = #{id}")
	public int updateTodo(Owner myData);

	@Delete("DELETE FROM owner WHERE id = #{id}")
	public int deleteData(Owner myData);
	
	@Select("SELECT * FROM owner where customerId = #{id}")
	public Owner findById(String id);
}
