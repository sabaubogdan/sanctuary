package xyz.vegaone.sanctuary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.sanctuary.domain.FirstCallEntity;

@Repository
public interface FirstCallRepo extends JpaRepository<FirstCallEntity, Long> {

}
