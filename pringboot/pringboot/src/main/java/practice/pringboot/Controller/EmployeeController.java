package practice.pringboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.pringboot.DTO.EmployeeDTO;
import practice.pringboot.Entity.Employee;
import practice.pringboot.Service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/test")
    public String test(){
        return employeeService.test();
    }

    @GetMapping("/AllEmployees") //to List All
    public List<Employee> AllEmployee(){
        return employeeService.AllEmployee();
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody EmployeeDTO dto) {
        return employeeService.addUser(dto);
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @GetMapping("/department/{dep}")
    public List<String> searchDep(@PathVariable String dep){
        return employeeService.searchDep(dep);
    }



    ///////////backed///////////

    @PutMapping("/salaryUpdate/{salary}/{id}") // salary update
    public String updateSalary(@PathVariable String salary , @PathVariable int id){
        return employeeService.updateSalary(salary,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return employeeService.deleteUser(id);
    }
}
