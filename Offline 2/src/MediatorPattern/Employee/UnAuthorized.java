package MediatorPattern.Employee;

import MediatorPattern.Mediator.Mediator;

public class UnAuthorized extends Employee{
    public UnAuthorized(Mediator mediator, String name){
        super(mediator, name, false);
    }


    @Override
    public String employeeType() {
        return "UnAuthorized";
    }
}
