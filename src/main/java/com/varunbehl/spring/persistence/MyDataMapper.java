package com.varunbehl.spring.persistence;

import com.varunbehl.spring.model.Owner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MyDataMapper {

    @Select("SELECT * FROM owner")
    List<Owner> getAllData();

    @Insert("INSERT INTO owner (title, dateCreated) VALUES (#{title}, #{dateCreated})")
    void saveData(Owner myData);

    @Update("UPDATE owner SET title = #{title}, dateModified = #{dateModified} WHERE id = #{id}")
    int updateTodo(Owner myData);

    @Delete("DELETE FROM owner WHERE id = #{id}")
    int deleteData(Owner myData);

    @Select("SELECT * FROM owner where customerId = #{id}")
    Owner findById(String id);
}
