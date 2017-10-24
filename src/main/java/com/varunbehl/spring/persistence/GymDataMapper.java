package com.varunbehl.spring.persistence;

import com.varunbehl.spring.model.Gym;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GymDataMapper {

    @Select("SELECT * FROM gym")
    List<Gym> listAllGyms();

    @Select("SELECT * FROM gym where gymId = #{id}")
    Gym findGymById(String id);

    @Insert("INSERT INTO gym ( gymId ,  gymPassword ,  gymName ,  gymEmail ,  gymMobile ,  gymPhone ,  gymId ,  dietId ,  gymLevel ,  gymImage ,  gymSex ,  gymDob ,  gymSlot ,  gymWeight ,  gymHeight ,  gymBmi ,  gymStatus ,  gymAttendence ,  gymType ,  gymSubscription ) VALUES (#{gymId}, #{gymPassword}, #{gymName}, #{gymEmail}, #{gymMobile}, #{gymPhone}, #{gymId},  #{dietId}, #{gymLevel}, #{gymImage}, #{gymSex}, #{gymDob},  #{gymSlot}, #{gymWeight}, #{gymHeight}, #{gymBmi}, #{gymStatus}, #{gymAttendence}, #{gymType}, #{gymSubscription})")
    void saveGymData(Gym myData);

    @Delete("DELETE FROM gym WHERE id = #{id}")
    int deletegymById(long id);

    @Update("UPDATE gym SET gymName = #{gymName} WHERE id = #{id}")
    void updateGym(Gym gym);
}
