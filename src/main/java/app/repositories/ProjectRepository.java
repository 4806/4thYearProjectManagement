package app.repositories;

import app.models.Project;
import app.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String > {
    Project findById(long id);
    Project findByName(String name);
    List<Project> findBySupervisor(User supervisor);
    void deleteProjectById(long id);
}