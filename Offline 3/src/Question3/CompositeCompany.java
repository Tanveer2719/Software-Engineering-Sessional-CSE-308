package Question3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CompositeCompany implements Component {

    private String name;
    private List<String> projects = new ArrayList<>();
    private HashMap<String, Component> projectDetails = new HashMap<>();
    private HashMap<String, List<Component>> developerDetails = new HashMap<>();

    private Scanner scanner = new Scanner(System.in);


    public CompositeCompany(String name){
        this.name = name;
    }

    @Override
    public void hierarchy() {
        System.out.println("- " + name);
        for(String project: projects){
            System.out.println("\t- "+ projectDetails.get(project).getName() + " ("+project + ")");
            for(Component x: developerDetails.get(project)){
                System.out.println("\t\t- " + x.getName());
            }
        }
    }

    @Override
    public void details() {
        System.out.println("Name: "+name);
        System.out.println("Role: Software Company");
        System.out.println("Current Running Projects: "+ projects.size());
        System.out.println("Current number of Developers: "+getDevelopersNO());
    }

    @Override
    // add a developer to the company
    public void add(Component component) {
        System.out.println("In which project do you want to add the developer "+ component.getName()+": ");
        int i = 1;
        for(String s: projects){
            System.out.println((i++) + ". " + s);

        }
        System.out.println("Enter your response: ");
        int input = takeInput(0, i);

        Component manager = projectDetails.get(projects.get(input-1));

        // add the developer to the managers list
        manager.add(component);
        // add the manager to the developer
        component.add(manager);

        // add the developer to the projects list
        component.execute(projects.get(input-1));
        developerDetails.get(projects.get(input -1)).add(component);
    }

    @Override
    // delete the developer with the name from the company
    public void execute(String name) {

        boolean flag = false;
        String projectName = "";
        Component c = null;

        // remove developers from the project
        for(String s: developerDetails.keySet()){
            List<Component> developers = developerDetails.get(s);
            for (Component component : developers) {
                if (name.equalsIgnoreCase(component.getName())) {
                    projectName = s;
                    c = component;
                    flag = true;
                }
            }
        }

        if(!flag){
            System.out.println("Developer with this name is not found...Sorry");
            return;
        }else {
            developerDetails.get(projectName).remove(c);
            projectDetails.get(projectName).execute(name);   // remove developer from the project list
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public int getTotalProjectNo(){
        return projects.size();
    }

    // create a new project for the company
    public void addNewProject(String name, Component manager){
        projects.add(name);
        projectDetails.put(name, manager);      // insert new <project,manager> pair
        developerDetails.put(name, new ArrayList<>());  // insert new <project, developer_list> pair
    }

    public void deleteProject(){
        System.out.println("Which project do you want to delete: ");
        for(int i = 0;i<projects.size();i++){
            System.out.println((i+1) + ". "+ projects.get(i));
        }
        int indx = takeInput(1, projects.size());
        String projectName = projects.get(indx-1);

        System.out.println("Removing Developers and Project manager of "+ projectName);
        projectDetails.remove(projectName);
        developerDetails.remove(projectName);
        projects.remove(projectName);
        System.out.println("Project Deleted");

    }

    public void printManagerHierarchy() {
        int index = selectManager();
        System.out.println("Manager Hierarchy: ");
        projectDetails.get(projects.get(index-1)).hierarchy();
    }

    public void printManagerDetails() {
        int index = selectManager();
        System.out.println("Manager Details: ");
        projectDetails.get(projects.get(index-1)).details();

    }

    private int selectManager() {
        System.out.println("Select one: ");
        int i = 1;
        for(String project : projects){
            System.out.println((i)+ ". " + projectDetails.get(project).getName());
            i++;
        }
        int index = takeInput(1, i-1);
        return index;
    }
    private int takeInput(int low, int high){
        int indx = scanner.nextInt();
        while(indx < low || indx >high){
            System.out.println("Please input a valid number: ");
            indx = scanner.nextInt();
        }
        return indx;
    }
    private int getDevelopersNO(){
        int x = 0;
        for(String s: developerDetails.keySet()){
            x+= developerDetails.get(s).size();
        }
        return x;
    }
}
