package xyz.vegaone.sanctuary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.sanctuary.domain.AmbulanceEntity;
import xyz.vegaone.sanctuary.dto.Ambulance;
import xyz.vegaone.sanctuary.dto.FirstCall;
import xyz.vegaone.sanctuary.mapper.AmbulanceMapper;
import xyz.vegaone.sanctuary.repo.AmbulanceRepo;

import java.util.Optional;

@Service
public class AmbulanceService {

    private AmbulanceMapper ambulanceMapper;
    private AmbulanceRepo ambulanceRepo;
    private FirstCallService firstCallService;

    @Autowired
    public AmbulanceService(AmbulanceMapper ambulanceMapper, AmbulanceRepo ambulanceRepo, FirstCallService firstCallService) {
        this.ambulanceMapper = ambulanceMapper;
        this.ambulanceRepo = ambulanceRepo;
        this.firstCallService = firstCallService;
    }

    public Ambulance createAmbulance(Ambulance ambulance){
        AmbulanceEntity ambulanceEntity = ambulanceMapper.dtoToDomain(ambulance);
        AmbulanceEntity savedAmbulanceEntity = ambulanceRepo.save(ambulanceEntity);
        Ambulance savedAmbulance = ambulanceMapper.domainToDto(savedAmbulanceEntity);
//        savedAmbulance.setFirstCallId(firstCallService.getFirstCall(ambulance.getId()));

        return savedAmbulance;
    }

    public Ambulance getAmbulance(Long id){
        AmbulanceEntity foundAmbulanceEntity = ambulanceRepo.findOne(id );
        Ambulance ambulance = ambulanceMapper.domainToDto(foundAmbulanceEntity);

        return ambulance;
    }

    public void deleteAmbulance(Long id){
        ambulanceRepo.delete(id);
    }

    public Ambulance updateAmbulance(Ambulance ambulance){
        AmbulanceEntity ambulanceEntity = ambulanceMapper.dtoToDomain(ambulance);
        AmbulanceEntity savedAmbulanceEntity = ambulanceRepo.save(ambulanceEntity);

        Ambulance updatedAmbulance = ambulanceMapper.domainToDto(savedAmbulanceEntity);

        return updatedAmbulance;
    }

}
