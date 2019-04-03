package app.repositories;

import app.models.Project;
import app.models.Supervisor;
import app.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String > {
    Project findById(long id);
    Project findByName(String name);
    Project findBySupervisor(Supervisor supervisor);
    void deleteProjectById(long id);
}