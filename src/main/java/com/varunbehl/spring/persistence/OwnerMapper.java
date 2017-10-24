package com.varunbehl.spring.persistence;

import com.varunbehl.spring.model.Owner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OwnerMapper {

    @Select("SELECT * FROM owner")
    List<Owner> listAllGymOwners();

    @Select("SELECT * FROM owner where customerId = #{id}")
    Owner findOwnerById(long id);

    @Insert("INSERT INTO  Owner  ( gymId ,  customerId ,  customerName ,  customerEmail ,  customerMobile ,  customerPhone ,  customerAddress ,  customerImage ,  customerSex ,  customerDob ,  customerPassword ,  customerStatus )VALUES(#{gymId}, #{customerId}, #{customerName}, #{customerEmail}, #{customerMobile}, #{customerPhone}, #{customerAddress}, #{customerImage}, #{customerSex}, #{customerDob}, #{customerPassword}, #{customerStatus})")
    void saveOwner(Owner myData);

    @Update("UPDATE owner SET title = #{title}, dateModified = #{dateModified} WHERE id = #{id}")
    int updateTodo(Owner myData);

    @Delete("DELETE FROM owner WHERE id = #{id}")
    int deleteOwnwer(long id);


}
