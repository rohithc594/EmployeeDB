package practice.pringboot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.pringboot.Entity.Employee;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    List<Employee> findByDepartment(String department);

}
