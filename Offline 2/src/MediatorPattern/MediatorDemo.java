package MediatorPattern;

import MediatorPattern.Employee.AuthorizedEmployee;
import MediatorPattern.Employee.Employee;
import MediatorPattern.Employee.UnAuthorized;
import MediatorPattern.Mediator.ConcreteMediator;

public class MediatorDemo {
    public static void main(String[] args) {
        System.out.println("**************Mediator Pattern Example *************");

        ConcreteMediator mediator = new ConcreteMediator();

        Employee X = new AuthorizedEmployee(mediator, "X", true);
        Employee Y = new AuthorizedEmployee(mediator, "Y", true);
        Employee Z = new AuthorizedEmployee(mediator, "Z", false);

        mediator.showList();

        Employee abc = new UnAuthorized(mediator, "abc");

        X.sendMessage(Y, "Hello Y, how are you ?");



    }
}
