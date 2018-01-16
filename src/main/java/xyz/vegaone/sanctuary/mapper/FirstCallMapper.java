package xyz.vegaone.sanctuary.mapper;

import org.mapstruct.Mapper;
import xyz.vegaone.sanctuary.domain.FirstCallEntity;
import xyz.vegaone.sanctuary.dto.FirstCall;

@Mapper(componentModel = "Spring")
public interface FirstCallMapper {

    FirstCall domainToDto(FirstCallEntity firstCallEntity);

    FirstCallEntity dtoToDomain(FirstCall firstCall);

}
