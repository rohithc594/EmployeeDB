package practice.pringboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.pringboot.DTO.EmployeeDTO;
import practice.pringboot.Repo.EmployeeRepo;
import practice.pringboot.Entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public String test() {
        return "test successfully";
    }

    public List<Employee> AllEmployee() {
        return employeeRepo.findAll();
    }

    public String addUser(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());

        employee.setDepartment(dto.getDepartment());
        employeeRepo.save(employee);
        return "Employee added "+ employee.getName();
    }

    public Employee getById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public List<String> searchDep(String dep) {
        List<Employee> employees = employeeRepo.findByDepartment(dep);

        List<String> names = new ArrayList<>();
        for(Employee employee : employees){
            names.add(employee.getName());
        }
        return names;
    }

    ////////////backend//////////

    public String updateSalary(String salary , int id){
        Employee employee = employeeRepo.findById(id).orElse(null);
        employee.setSalary(salary);
        employeeRepo.save(employee);
        return "salary Updated to " + salary;
    }


    public String deleteUser(int id) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        String name = employee.getName();
        employeeRepo.deleteById(id);
        return name + " deleted successfully";

    }


}
