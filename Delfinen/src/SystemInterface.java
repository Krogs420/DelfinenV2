import java.io.FileNotFoundException;

public class SystemInterface {

    UserInterface userInterface = new UserInterface("Welcome to Delfinen!",
            "Press the appropriate number", new String[]{"1. Administrator","2. Coach", "3. Cashier", "4. Quit"});

    public void startMenu() throws FileNotFoundException {
     SystemMenu systemMenu = new SystemMenu();
        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;
            switch (choice) {
                case 1:
                    systemMenu.adminMenu();
                    break;
                case 2:
                    systemMenu.coachMenu();
                    break;
                case 3:
                    systemMenu.cashierMenu();
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid || !(choice == 4));
    }
}

// Creators - Kristian
