package co.com.bancobogota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.bancobogota.model.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Integer> {

}
