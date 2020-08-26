package co.com.bancobogota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.bancobogota.model.Location;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Integer> {

}
