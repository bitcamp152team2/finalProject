package com.project.bit.admin.mapper;

import com.project.bit.admin.domain.TeamDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {

    public List<TeamDTO> selectTeam();
}
