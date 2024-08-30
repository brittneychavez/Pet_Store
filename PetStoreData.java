package pet.store.controller.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor

public class PetStoreData {
private Long petStoreId;
private String petStoreName;
private String petStoreLocation;
private List<PetStoreCustomer> customers;
private List<PetStoreEmployee> employees;

public PetStoreData(PetStore petStore) {
	petStoreId = petStore.getPetStoreId();
	petStoreName = petStore.getPetStoreName();
	petStoreLocation = petStore.getPetStoreLocation();
//	customers = petStore.getCustomers().stream().map(PetStoreCustomer::new)
//	                .toList();
//	employees = petStore.getEmployees().stream().map(PetStoreEmployee::new)
//	                .toList();
	for(Customer customer: petStore.getCustomers()) {
		customers.add(new PetStoreCustomer (customer));
	}
	for(Employee employee: petStore.getEmployees()) {
		employees.add(new PetStoreEmployee (employee));
	}
	    }

@Data
@NoArgsConstructor
public static class PetStoreCustomer {
private Long customerId;
private String customerFirstName;
private String customerLastName;
private String customerEmail;

public PetStoreCustomer(Customer customer) {
	customerId = customer.getCustomerId();
	customerFirstName = customer.getCustomerFirstName();
	customerLastName = customer.getCustomerLastName();
	customerEmail = customer.getCustomerEmail();
	        }
	    }

@Data
@NoArgsConstructor
public static class PetStoreEmployee {
private Long employeeId;
private String employeeFirstName;
private String employeeLastName;
private String employeeEmail;

public PetStoreEmployee(Employee employee) {
	employeeId = employee.getEmployeeId();
	employeeFirstName = employee.getEmployeeFirstName();
	employeeLastName = employee.getEmployeeLastName();
	employeeEmail =  employee.getEmployeeEmail();
	        }
	    }
	}


