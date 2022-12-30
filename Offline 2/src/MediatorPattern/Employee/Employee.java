package MediatorPattern.Employee;

import MediatorPattern.Mediator.Mediator;

public abstract class Employee {
    protected String name;
    protected Mediator mediator;
    protected boolean authorizedUser;

    Employee(Mediator mediator, String name, boolean auth){
        this.mediator = mediator;
        this.name = name;
        this.authorizedUser = auth;
        if(authorizedUser){
            this.mediator.register(this);
        }
    }


    public void sendMessage(Employee to, String x){
        mediator.sendMessage(this, to, x);
    }
    public void receiveMessage(Employee x, String k){

        System.out.println(this.name + " Got a mesage from " + x.getName() + " : " + k);

    }
    public  void receiveMessage(String s){

    }

    public Mediator getMediator(){
        return mediator;
    }
    public String getName(){
        return name;
    }
    public abstract String employeeType();


}
