package com.ins.clinique.entities.mappers;

import com.ins.clinique.entities.Admin;
import com.ins.clinique.entities.dtos.AdminDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminMapper ADMIN_MAPPER = Mappers.getMapper(AdminMapper.class);

    Admin fromDto(AdminDto dto);

    AdminDto toDto(Admin admin);

}
