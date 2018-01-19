package xyz.vegaone.sanctuary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.sanctuary.domain.FirstCallEntity;
import xyz.vegaone.sanctuary.dto.FirstCall;
import xyz.vegaone.sanctuary.mapper.FirstCallMapper;
import xyz.vegaone.sanctuary.repo.FirstCallRepo;

@Service
public class FirstCallService {

    private FirstCallRepo firstCallRepo;
    private FirstCallMapper firstCallMapper;

    @Autowired
    public FirstCallService(FirstCallRepo firstCallRepo, FirstCallMapper firstCallMapper) {
        this.firstCallRepo = firstCallRepo;
        this.firstCallMapper = firstCallMapper;
    }

    public FirstCall createFirstCall(FirstCall firstCall) {
        FirstCallEntity firstCallEntity = firstCallMapper.dtoToDomain(firstCall);
        FirstCallEntity savedFirstCallEntity = firstCallRepo.save(firstCallEntity);
        FirstCall savedFirstCall = firstCallMapper.domainToDto((savedFirstCallEntity));

        return savedFirstCall;
    }

    public FirstCall getFirstCall(Long id) {
        FirstCallEntity foundFirstCallEntity = firstCallRepo.findOne(id);
        FirstCall firstCall = firstCallMapper.domainToDto(foundFirstCallEntity);

        return firstCall;

    }

    public void deleteFirstCall(Long id) {
        firstCallRepo.delete(id);

    }

    public FirstCall updateFirstCall(FirstCall firstCall) {
        FirstCallEntity firstCallEntity = firstCallMapper.dtoToDomain(firstCall);
        FirstCallEntity savedFirstCallEntity = firstCallRepo.save(firstCallEntity);

        FirstCall updatedFirstCall = firstCallMapper.domainToDto(savedFirstCallEntity);

        return updatedFirstCall;
    }
}
