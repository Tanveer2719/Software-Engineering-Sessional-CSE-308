package Question3;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager implements Component {

    private String name;
    private List<Component> developers = new ArrayList<>();
    private String projectName;

    public ProjectManager(String name, String projectName) {
        this.name = name;
        this.projectName = projectName;
    }

    @Override
    public void hierarchy() {
       // System.out.println("\nProjectManager.hierarchy():");
        System.out.println("- " + name + "(" + projectName +")");
        for(Component x: developers)
            System.out.println("\t- "+ x.getName());
    }

    @Override
    public void details() {
        System.out.println("Name: "+name);
        System.out.println("Role: Project Manager");
        System.out.println("Current Project: "+projectName);
        System.out.println("Number of Supervisees: "+developers.size());
    }

    @Override
    public void add(Component component) {
        developers.add(component);
        component.add(this);
    }

    @Override
    public void execute(String name) {
        // remove the developer from the project manager list
        developers.removeIf(component -> name.equalsIgnoreCase(component.getName()));
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
