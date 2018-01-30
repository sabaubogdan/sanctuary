package xyz.vegaone.sanctuary.mapper;

import org.mapstruct.Mapper;
import xyz.vegaone.sanctuary.domain.AmbulanceEntity;
import xyz.vegaone.sanctuary.dto.Ambulance;

@Mapper(componentModel = "Spring")
public interface AmbulanceMapper {
    
    Ambulance domainToDto(AmbulanceEntity ambulanceEntity);
    
    AmbulanceEntity dtoToDomain(Ambulance ambulance);
}
