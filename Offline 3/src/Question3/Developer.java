package Question3;

public class Developer implements Component {
    private String name;
    private String projectName;
    private String projectManager;

    public Developer(String name, String projectName, String projectManager) {
        this.name = name;
        this.projectName = projectName;
        this.projectManager = projectManager;
    }
    public Developer(Component component, String projectName, String projectManager){
        this.name = component.getName();
        this.projectName = projectName;
        this.projectManager = projectManager;
    }

    public Developer(String name){
        this.name = name;
    }

    @Override
    public void hierarchy() {
        System.out.println("- " + name + "(" + projectName +")");
    }

    @Override
    public void details() {
        System.out.println("Name: "+name);
        System.out.println("Role: Question3.Developer");
        System.out.println("Current Project: "+projectName);
        System.out.println("Name of Supervisor: "+projectManager);
    }

    @Override
    public void add(Component component) {
        // use this method to add project manager to the developer
        projectManager = component.getName();
    }

    @Override
    public void execute(String name) {
        // add the project name to the  Developer
        projectName = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
