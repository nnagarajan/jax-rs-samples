package db;

import entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee,Long> {

    Employee findByFirstNameAndLastName(String firstName,String lastName);
}
