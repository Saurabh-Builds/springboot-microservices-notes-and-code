package practice.springboot_microservices_notes_and_code.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import practice.springboot_microservices_notes_and_code.entity.Employee;

import java.util.List;

/**
 * Repository interface for interacting with `Employee` data in the database.
 * Extends `CrudRepository` for basic CRUD operations.
 */
//public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Retrieves all employee records using JPQL.
     *
     * @return a list of all employees
     */
    @Query("from Employee")
    public List<Employee> getAllRecord();

    /**
     * Retrieves an employee by their unique employee ID.
     *
     * @param Id The ID of the employee to retrieve.
     * @return the employee with the given ID, or null if not found
     */
    @Query("from Employee where empId = :Id")
    public Employee getEmpById(Integer Id);

    /**
     * Retrieves employees by their department name.
     *
     * @param dept The department name to filter by.
     * @return a list of employees in the specified department
     */
    public List<Employee> findByEmpDept(String dept);

    /**
     * Retrieves employees by their gender.
     *
     * @param gen The gender to filter by (e.g., "M" or "F").
     * @return a list of employees with the specified gender
     */
    public List<Employee> findByEmpGender(String gen);

    /**
     * Retrieves employees by both their gender and department.
     *
     * @param gender The gender to filter by.
     * @param dept The department name to filter by.
     * @return a list of employees with the specified gender and department
     */
    List<Employee> findByEmpGenderAndEmpDept(String gender, String dept);

    /**
     * Retrieves employees whose salary is greater than or equal to a specified value.
     *
     * @param salary The minimum salary threshold.
     * @return a list of employees with a salary greater than or equal to the specified value
     */
    List<Employee> findByEmpSalaryGreaterThanEqual(Double salary);


    /**
     * Retrieves all employees ordered by salary in descending order.
     *
     * @return List of employees sorted by salary in descending order
     */
    List<Employee> findAllByOrderByEmpSalaryDesc();

    // Start with another video

    /**
     * Retrieves all employee records using a different custom JPQL query.
     *
     * @return a list of all employees
     */
    @Query("from Employee")
    List<Employee> getAllEmps();

    /**
     * Retrieves all employee records using a native SQL query.
     *
     * @return a list of all employees
     */
    @Query(value = "select * from employee", nativeQuery = true)
    public List<Employee> getAllEmpRecords();

    /**
     * Deletes an employee by their ID using a custom `DELETE` query.
     * This operation is marked with `@Transactional` and `@Modifying` annotations to ensure the query modifies the database.
     *
     * @param empId The ID of the employee to delete.
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM Employee e WHERE e.empId = :empId")
    void deleteEmpById(Integer empId);
}
