package practice.springboot_microservices_notes_and_code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import practice.springboot_microservices_notes_and_code.entity.Employee;
import practice.springboot_microservices_notes_and_code.repository.EmployeeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing employee-related operations.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository empRepo;

    /**
     * Constructor-based dependency injection for EmployeeRepository.
     *
     * @param empRepo EmployeeRepository instance
     */
    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    /**
     * Retrieves all employee records using a custom query.
     * Prints the employee details to the console.
     */
    public void getAllEmpRecord() {
        List<Employee> emps = empRepo.getAllRecord();
        emps.forEach(System.out::println);
    }

    /**
     * Fetches an employee by their ID.
     *
     * @param id Employee ID
     */
    public void getEmpById(Integer id) {
        Employee empId = empRepo.getEmpById(id);
        System.out.println(empId);
    }

    /**
     * Retrieves and prints all employee records from the database.
     */
    public void getAllEmployees() {
        List<Employee> allEmps = empRepo.getAllEmps();
        allEmps.forEach(System.out::println);
    }

    /**
     * Fetches all employee records with a different custom query.
     * Prints the employee details to the console.
     */
    public void getAllEmpRecords() {
        List<Employee> allrecords = empRepo.getAllEmpRecords();
        allrecords.forEach(System.out::println);
    }

    /**
     * Deletes an employee record by their ID.
     *
     * @param empId Employee ID to delete
     */
    public void deleteEmpById(Integer empId) {
        empRepo.deleteEmpById(empId);  // Calls custom @Query delete method
        System.out.println(empId + " deleted.");
    }

    /**
     * Counts the total number of employees in the table.
     *
     * @return the total count of employees
     */
    public long countEmployees() {
        return empRepo.count();
    }

    /**
     * Retrieves and prints all employees in a specific department.
     *
     * @param dept Department name
     */
    public void getEmpsByDept(String dept) {
        List<Employee> emps = empRepo.findByEmpDept(dept);
        emps.forEach(System.out::println);
    }

    /**
     * Retrieves and prints all employees of a specific gender.
     *
     * @param gen Gender (M/F)
     */
    public void getEmpsByGender(String gen) {
        List<Employee> emps = empRepo.findByEmpGender(gen);
        emps.forEach(System.out::println);
    }

    /**
     * Retrieves and prints employees that match both gender and department.
     *
     * @param gender Gender (M/F)
     * @param dept   Department name
     */
    public void getEmpsByGenderandDept(String gender, String dept) {
        List<Employee> emps = empRepo.findByEmpGenderAndEmpDept(gender, dept);
        emps.forEach(System.out::println);
    }

    /**
     * Retrieves and prints employees whose salary is greater than or equal to the provided value.
     *
     * @param salary Minimum salary
     */
    public void getByEmpsBySalary(Double salary) {
        List<Employee> emps = empRepo.findByEmpSalaryGreaterThanEqual(salary);
        emps.forEach(System.out::println);
    }

    /**
     * Retrieves and prints all employees sorted by salary in descending order.
     */
    public void getAllEmployeesBySalaryInDesc() {
        List<Employee> employees = empRepo.findAllByOrderByEmpSalaryDesc();
        employees.forEach(employee -> System.out.println("ID: " + employee.getEmpId() +
                ", Name: " + employee.getEmpName() +
                ", Department: " + employee.getEmpDept() +
                ", Salary: " + employee.getEmpSalary()));
    }


    /**
     * Retrieves and prints all employee records.
     */
    public void getAllEmp() {
        Iterable<Employee> findAll = empRepo.findAll();
        findAll.forEach(System.out::println);
    }

    /**
     * Fetches and prints an employee with a hardcoded ID (1).
     */
    public void getEmp() {
        Optional<Employee> findById = empRepo.findById(1);
        if (findById.isPresent()) {
            Employee employee = findById.get();
            System.out.println(employee);
        }
    }

    /**
     * Fetches and prints employees by a list of employee IDs.
     */
    public void getIdEmp() {
        List<Integer> empIds = Arrays.asList(1, 2, 3);
        Iterable<Employee> itr = empRepo.findAllById(empIds);
        itr.forEach(System.out::println);
    }

    /**
     * Saves a single employee to the database.
     * Creates an employee record with predefined details.
     */
    public void saveEmployee() {
        Employee emp = new Employee();
        emp.setEmpId(1);
        emp.setEmpName("Charles");
        emp.setEmpGender("M");
        emp.setEmpDept("IT");
        emp.setEmpSalary(15000.00);

        empRepo.save(emp);
    }

//    /**
//     * Saves multiple employees to the database.
//     * Creates two employee records with predefined details and saves them.
//     */
//    public void saveMultipleEmployee() {
//        Employee emp1 = new Employee();
//        emp1.setEmpId(2);
//        emp1.setEmpName("Angle");
//        emp1.setEmpGender("F");
//        emp1.setEmpDept("Sale");
//        emp1.setEmpSalary(13445.00);
//
//        Employee emp2 = new Employee();
//        emp2.setEmpId(3);
//        emp2.setEmpName("Jhone");
//        emp2.setEmpGender("M");
//        emp2.setEmpDept("Software");
//        emp2.setEmpSalary(200000.00);
//
//        List<Employee> empsList = Arrays.asList(emp1, emp2);
//        empRepo.saveAll(empsList);
//    }

    /**
     * Saves multiple employees to the database.
     * Creates 20 employee records with predefined details and saves them.
     */
//    public void saveMultipleEmployee() {
//        Employee emp1 = new Employee(1, "Alice", 15000.00, "F", "HR");
//        Employee emp2 = new Employee(2, "Bob", 18000.00, "M", "Marketing");
//        Employee emp3 = new Employee(3, "Carol", 17000.00, "F", "Finance");
//        Employee emp4 = new Employee(4, "Dave", 16000.00, "M", "Operations");
//        Employee emp5 = new Employee(5, "Emma", 21000.00, "F", "Research");
//        Employee emp6 = new Employee(6, "Frank", 14000.00, "M", "Sales");
//        Employee emp7 = new Employee(7, "Grace", 14500.00, "F", "IT");
//        Employee emp8 = new Employee(8, "Harry", 13000.00, "M", "Support");
//        Employee emp9 = new Employee(9, "Ivy", 17500.00, "F", "Finance");
//        Employee emp10 = new Employee(10, "Jack", 19500.00, "M", "Engineering");
//        Employee emp11 = new Employee(11, "Karen", 15500.00, "F", "Product");
//        Employee emp12 = new Employee(12, "Leo", 14450.00, "M", "Sales");
//        Employee emp13 = new Employee(13, "Mona", 18200.00, "F", "Marketing");
//        Employee emp14 = new Employee(14, "Nate", 17800.00, "M", "Finance");
//        Employee emp15 = new Employee(15, "Olivia", 15100.00, "F", "HR");
//        Employee emp16 = new Employee(16, "Peter", 16200.00, "M", "Operations");
//        Employee emp17 = new Employee(17, "Quinn", 21300.00, "F", "Research");
//        Employee emp18 = new Employee(18, "Ruth", 14900.00, "F", "IT");
//        Employee emp19 = new Employee(19, "Sam", 13445.00, "M", "Sales");
//        Employee emp20 = new Employee(20, "Tina", 22000.00, "F", "Development");
//
//        List<Employee> empsList = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10,
//                emp11, emp12, emp13, emp14, emp15, emp16, emp17, emp18, emp19, emp20);
//        empRepo.saveAll(empsList);
//    }

    // pagenation Topic

    /**
     * Retrieves employees with pagination.
     *
     * @param pageSize Number of records per page
     * @param pageNo   Page number
     */
    public void getEmpsWithPagination(int pageSize, int pageNo) {
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<Employee> findAll = empRepo.findAll(pageable);
        findAll.getContent().forEach(System.out::println);
    }

}
