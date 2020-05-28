package com.project.bit.projects.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DutyMapper {
	
	@Insert("insert into dutys(DUTY_CODE, DUTY_NAME) values(#{DUTY_CODE}, #{DUTY_NAME})")
	void insertDuty(String DUTY_CODE, String DUTY_NAME);

}
