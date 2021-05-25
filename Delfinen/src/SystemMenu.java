import java.io.FileNotFoundException;

public class SystemMenu {
    Administrator administrator = new Administrator();

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
                    switch (choice) {
                        case 1:
                            administrator.breaststrokeComp();
                            break;
                        case 2:
                            administrator.butterflyComp();
                            break;
                        case 3:
                            administrator.backCrawlComp();
                            break;
                        case 4:
                            administrator.crawlComp();
                    }

                    break;
                case 2:
                    switch (choice) {
                        case 1:
                            administrator.breaststrokeTraining();
                            break;
                        case 2:
                            administrator.butterflyTraining();
                            break;
                        case 3:
                            administrator.backcrawlTraining();
                            break;
                        case 4:
                            administrator.crawlTraining();
                    }
                    break;
                case 3:
                    switch (choice) {
                        case 1:
                            System.out.println("Top 5 crawl training times:");
                            for (int i = 0; i < administrator.crawlCompetitiveTimes.size(); i++) {
                                System.out.println(administrator.crawlCompetitiveTimes.get(i));
                            }
                            break;
                        case 2:
                            System.out.println("Top 5 backcrawl training times:");
                            for (int i = 0; i < administrator.backcrawlTrainingTimes.size(); i++) {
                                System.out.println(administrator.backcrawlTrainingTimes.get(i));
                            }
                            break;
                        case 3:
                            System.out.println("Top 5 breaststroke training times:");
                            for (int i = 0; i < administrator.breaststrokeTrainingTimes.size(); i++) {
                                System.out.println(administrator.breaststrokeTrainingTimes.get(i));
                            }
                        case 4:
                            System.out.println("Top 5 butterfly training times:");
                            for (int i = 0; i < administrator.butterflyTrainingTimes.size(); i++) {
                                System.out.println(administrator.butterflyTrainingTimes.get(i));
                            }
                            break;
                    }
                    break;
                case 4:

                    switch (choice) {
                    case 1:
                        System.out.println("Top 5 crawl competitive times:");
                        for (int i = 0; i < administrator.crawlCompetitiveTimes.size(); i++) {
                            System.out.println(administrator.crawlCompetitiveTimes.get(i));
                        }
                        break;
                    case 2:
                        System.out.println("Top 5 backcrawl competitive times:");
                        for (int i = 0; i < administrator.backcrawlTrainingTimes.size(); i++) {
                            System.out.println(administrator.backcrawlTrainingTimes.get(i));
                        }
                        break;
                    case 3:
                        System.out.println("Top 5 breaststroke competitive times:");
                        for (int i = 0; i < administrator.breaststrokeTrainingTimes.size(); i++) {
                            System.out.println(administrator.breaststrokeTrainingTimes.get(i));
                        }
                    case 4:
                        System.out.println("Top 5 butterfly competitive times:");
                        for (int i = 0; i < administrator.butterflyTrainingTimes.size(); i++) {
                            System.out.println(administrator.butterflyTrainingTimes.get(i));
                        }
                        break;
                }
                    break;

                        default:
                            valid = false;
                            System.out.println("Your input is not valid, try again.");
                    }
            }while (!valid);

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
