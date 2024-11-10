package practice.springboot_microservices_notes_and_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import practice.springboot_microservices_notes_and_code.beanlifecycle.Car;
import practice.springboot_microservices_notes_and_code.entity.Book;
import practice.springboot_microservices_notes_and_code.entity.Employee;
import practice.springboot_microservices_notes_and_code.repository.BookRepository;
import practice.springboot_microservices_notes_and_code.repository.EmployeeRepository;
import practice.springboot_microservices_notes_and_code.service.EmployeeService;
import practice.springboot_microservices_notes_and_code.service.IUserService;
import practice.springboot_microservices_notes_and_code.service.UserService;

import java.util.List;

@SpringBootApplication
public class SpringbootMicroservicesNotesAndCodeApplication {

	/**
	 * Main entry point for the Spring Boot application.
	 * This method initializes the application context and runs various operations on the services and repositories.
	 * It demonstrates the functionality of several services like `UserService`, `EmployeeService`, and custom entities such as `Book` and `Car`.
	 */
	public static void main(String[] args) {
		// Start the Spring Boot application and get the application context.
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootMicroservicesNotesAndCodeApplication.class, args);

		// Demonstrating the use of UserService to fetch a username based on user ID.
		UserService service = context.getBean(UserService.class);
		service.getUsername(200);  // Example: Fetch user details by user ID (200).

		// Demonstrating the use of IUserService for registering a new user.
		IUserService iservice = context.getBean(IUserService.class);
		iservice.registerUser("John", "john@gmail.com", "abc@12");  // Registering a new user.

		// Demonstrating the use of a car bean that follows the lifecycle.
		Car bean = context.getBean(Car.class);
		bean.drive();  // Example: Call the drive method from the Car bean.

		// Working with Book repository (saving a new book to the database).
		BookRepository bookRepo = context.getBean(BookRepository.class);

		// Create and set values for a Book entity.
		Book b = new Book();
		b.setBookId(101);               // Setting book ID
		b.setBookName("SpringBoot");    // Setting book name
		b.setBookPrice(1502.59);        // Setting book price

		// Save the book entity to the database.
		bookRepo.save(b);

		// Working with EmployeeService to perform operations related to Employee entities.
		EmployeeService empser = context.getBean(EmployeeService.class);

		// Uncomment to save a single employee or multiple employees.
		// empser.saveEmployee();       // Saving a single employee.
//		 empser.saveMultipleEmployee();  // Saving multiple employees.

		// Fetch all employee records from the database.
		empser.getAllEmp();            // Fetching all employees.

		// Fetch employees by department.
		empser.getEmpsByDept("Sale");

		// Fetch employees by gender.
		empser.getEmpsByGender("M");

		// Fetch employees based on gender and department.
		empser.getEmpsByGenderandDept("M", "IT");

		// Fetch employees with a salary greater than or equal to 15000.
		empser.getByEmpsBySalary(15000.00);

		empser.getAllEmployeesBySalaryInDesc();

		// Fetch all employee records using a custom query.
		empser.getAllEmpRecord();

		// Fetch employee by ID.
		empser.getEmpById(2);

		// Fetch all employee records using the default method.
		empser.getAllEmp();

		// Delete an employee by ID.
		empser.deleteEmpById(2);

		empser.getEmpsWithPagination(6,1);

		// Close the application context at the end of the application run.
		context.close();
	}
}
