package MediatorPattern.Employee;

import MediatorPattern.Mediator.Mediator;

public class AuthorizedEmployee extends Employee{

    public AuthorizedEmployee(Mediator mediator, String name, boolean x){
        super(mediator, name, x);
    }
    @Override
    public String employeeType() {
        return "AuthorizedEmployee";
    }

}
