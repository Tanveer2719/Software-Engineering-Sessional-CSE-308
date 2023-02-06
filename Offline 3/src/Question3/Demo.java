package Question3;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CompositeCompany company = new CompositeCompany("Manhattan Company");


        String projectName, managerName, developerName;
        boolean exitFlag = false;

        while(true){
            System.out.println("\nWhat do you want to do :");
            System.out.println("1. Create new Project");
            System.out.println("2. Create Developer");
            System.out.println("3. Delete Project");
            System.out.println("4. Company Details");
            System.out.println("5. Company Hierarchy");
            System.out.println("6. Manager Hierarchy");
            System.out.println("7. Manager Details");
            System.out.println("8. QUIT");

            int input = scanner.nextInt();
            while(input < 1 || input > 8){
                System.out.println("Please enter a valid response: ");
                input = scanner.nextInt();
            }
            scanner.nextLine();

            switch (input){
                case 1: {
                    System.out.println("Write the name of the new project: ");
                    projectName = scanner.nextLine();
                    System.out.println("Enter the project manager name: ");
                    managerName = scanner.nextLine();

                     ProjectManager man = new ProjectManager(managerName, projectName);
                     company.addNewProject(projectName, man);
                    break;
                }
                case 2:
                {
                    if(company.getTotalProjectNo() == 0){
                        System.out.println("There is no project available at this moment...please add new project");
                        break;
                    }
                    System.out.println("Write developer name: ");
                    developerName = scanner.nextLine();
                    company.add(new Developer(developerName));
                    break;
                }
                case 3:
                {
                    if(company.getTotalProjectNo() == 0){
                        System.out.println("There is no project available at this moment...please add new project");
                        break;
                    }

                    company.deleteProject();
                    break;

                }
                case 4:
                {
                    System.out.println("Company details: ");
                    company.details();
                    break;
                }
                case 5:
                {
                    System.out.println("Company hierarchy: ");
                    company.hierarchy();
                    break;
                }
                case 6:
                {
                    if(company.getTotalProjectNo() == 0){
                        System.out.println("There is no project available at this moment...please add new project");
                        break;
                    }
                    company.printManagerHierarchy();
                    break;
                }
                case 7:
                {
                    if(company.getTotalProjectNo() == 0){
                        System.out.println("There is no project available at this moment...please add new project");
                        break;
                    }
                    company.printManagerDetails();
                    break;
                }
                case 8:
                {
                    exitFlag = true;
                    break;
                }
            }
            if(exitFlag){
                break;
            }
        }

    }
}
