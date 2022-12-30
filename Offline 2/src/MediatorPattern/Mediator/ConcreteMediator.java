package MediatorPattern.Mediator;

import MediatorPattern.Employee.Employee;

import java.util.LinkedList;
import java.util.List;

public class ConcreteMediator implements Mediator{

    private List<Employee> employeeList = new LinkedList<>();


    @Override
    public void register(Employee x) {
        employeeList.add(x);
    }

    @Override
    public void sendMessage(Employee from, Employee to, String x) {
        if(from.employeeType() == "UnAuthorized"){
            System.out.println("[ALERT]  an unauthorized employee is trying to send a message");
            from.receiveMessage("You are not allowed to send message unless you are subscribed");
        }
        else if(employeeList.contains(from)){
            System.out.println(from.getName() + " is posting a message");
            if(employeeList.contains(to)){
                to.receiveMessage(from, x);
            }else{
                System.out.println(from.getName() + " your receiver is not subscribed !!! ");
            }
        }
        else{
            System.out.println("An unauthorized user is sending message to " + to.getName());
        }
    }

    public void showList(){
        for(Employee x : employeeList){
            System.out.println(x.getName());
        }
    }
}
