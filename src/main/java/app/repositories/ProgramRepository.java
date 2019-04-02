package app.repositories;

import app.models.Program;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProgramRepository extends CrudRepository<Program, String> {
    Program findByName(String name);
    Program findById(long id);
}