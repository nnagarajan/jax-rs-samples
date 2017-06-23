package converters;

import entity.Employee;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOption;
import schema.EmployeeRequest;
import schema.EmployeeResponse;

public class EmployeeResponseConverter extends BeanMappingBuilder {


    @Override
    protected void configure() {
        mapping(Employee.class, EmployeeResponse.class).
                fields("firstName", "firstName").
                fields("lastName", "lastName").
                fields("employeeId", "employeeId").
                fields("email", "email").
                fields("phoneNumber", "phone").
                fields("hireDate", "DateOfJoining");

    }
}
