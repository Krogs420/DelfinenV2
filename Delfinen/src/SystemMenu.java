import java.io.FileNotFoundException;
import java.util.Collections;

public class SystemMenu {
    Administrator administrator = new Administrator();
    Coach coach = new Coach(administrator);

    public SystemMenu() throws FileNotFoundException {
    }


    public void adminMenu() {
        UserInterface userInterface = new UserInterface("Do you want to:", "1. Add a member \n" +
                "2. Remove a member" + "\n3. View Memberlist", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    administrator.makeNewMember();
                    break;
                case 2:
                    administrator.removeMember();
                    break;
                case 3:
                    administrator.viewMemberList();
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);
    }

    public void coachMenu() {
        TimeComparator timeComparator = new TimeComparator();
        UserInterface userInterface = new UserInterface("Do you want to:",
                "1. Add competition times \n" +
                        "2. Add training times\n" + "3. Show competition times\n" +
                        "4. Show training times", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    coach.addSeniorOrJuniorComp();
                    break;
                case 2:
                    coach.addSeniorOrJuniorTraining();
                    break;
                case 3:
                    coach.showSeniorOrJuniorComp();
                    break;
                case 4:

                    coach.showSeniorOrJuniorTraining();
                    break;


                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);

    }

    public void cashierMenu() {

        UserInterface userInterface = new UserInterface("Do you want to:",
                "1. Show total member fee incomes \n" +
                        "2. Show total member fee arrears", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    administrator.totalMembershipIncome();
                    break;
                case 2:
                    administrator.arrears();
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);
    }
}

//Creators - Jeppe og Kristian
