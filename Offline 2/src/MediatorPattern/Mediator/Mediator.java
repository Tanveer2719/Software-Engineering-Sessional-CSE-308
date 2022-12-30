package MediatorPattern.Mediator;

import MediatorPattern.Employee.Employee;

public interface Mediator {
    void register(Employee x);
    void sendMessage(Employee from,Employee to,  String x);
}
