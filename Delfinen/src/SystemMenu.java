import java.io.FileNotFoundException;
import java.util.Collections;

public class SystemMenu {
    Administrator administrator = new Administrator();
    Coach coach = new Coach(administrator);

    public SystemMenu() throws FileNotFoundException {
    }
public SystemMenu(Coach coach) throws FileNotFoundException {
        this.coach = coach;
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
                    coach.compTimer();
                    break;
                case 2:
                    coach.trainingTimer();
                    break;
                case 3:
                    top5Training();
                    break;
                case 4:
                    top5Comp();
                    break;



                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        }while (!valid);

    }
    public void top5Training () {
        TimeComparator timeComparator = new TimeComparator();
        UserInterface userInterface = new UserInterface("Do you want to:",
                "1. Show top 5 breaststroke time trial \n" +
                        "2. Show top 5 butterfly time trial\n" + "3. Show top 5 backcrawl time trial\n" +
                        "4. Show top 5 crawl time trial", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    System.out.println("Top 5 breaststroke training times:");
                    Collections.sort(administrator.breaststrokeTrainingTimes, timeComparator);

                    System.out.println("1st.:" + administrator.breaststrokeTrainingTimes.get(0) + '\n' + "2nd.:"
                            + administrator.breaststrokeTrainingTimes.get(1) + '\n' + "3rd.:" +
                            administrator.breaststrokeTrainingTimes.get(2) + "4th.:" + administrator.breaststrokeTrainingTimes.get(3)
                            + '\n' + "5th:" + administrator.breaststrokeTrainingTimes.get(4));
                    break;
                case 2:
                    System.out.println("Top 5 butterfly training times:");
                    Collections.sort(administrator.butterflyTrainingTimes, timeComparator);

                    System.out.println("1st.:" + administrator.butterflyTrainingTimes.get(0) +'\n'+"2nd.:"
                            +administrator.butterflyTrainingTimes.get(1) + '\n'+ "3rd.:" +
                            administrator.butterflyTrainingTimes.get(2) + "4th.:" + administrator.butterflyTrainingTimes.get(3)
                            +'\n'+ "5th:" + administrator.butterflyTrainingTimes.get(4) );
                    break;

                case 3:
                    System.out.println("Top 5 backcrawl training times:");
                    Collections.sort(administrator.backcrawlTrainingTimes, timeComparator);

                    System.out.println("1st.:" + administrator.backcrawlTrainingTimes.get(0) + '\n' + "2nd.:"
                            + administrator.backcrawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                            administrator.backcrawlTrainingTimes.get(2) + "4th.:" + administrator.backcrawlTrainingTimes.get(3)
                            + '\n' + "5th:" + administrator.backcrawlTrainingTimes.get(4));
                    break;
                case 4:
                    System.out.println("Top 5 crawl training times:");
                    Collections.sort(administrator.crawlTrainingTimes, timeComparator);

                    System.out.println("1st.:" + administrator.crawlTrainingTimes.get(0) + '\n' + "2nd.:"
                            + administrator.crawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                            administrator.crawlTrainingTimes.get(2) + "4th.:" + administrator.crawlTrainingTimes.get(3)
                            + '\n' + "5th:" + administrator.crawlTrainingTimes.get(4));
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }
        }while (!valid);
    }
    public void top5Comp () {
        CompComparator compComparator = new CompComparator();
        UserInterface userInterface = new UserInterface("Do you want to:",
                "1. Show top 5 breaststroke competition time \n" +
                        "2. Show top 5 competition time \n" + "3. Show top 5 backcrawl competition time\n" +
                        "4. Show top 5 crawl competition time trial", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    System.out.println("Top 5 breaststroke competition times:");
                    Collections.sort(administrator.breaststrokeCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + administrator.breaststrokeCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + administrator.breaststrokeCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            administrator.breaststrokeCompetitiveTimes.get(2) + "4th.:" + administrator.breaststrokeCompetitiveTimes.get(3)
                            + '\n' + "5th:" + administrator.breaststrokeCompetitiveTimes.get(4));
                    break;
                case 2:
                    System.out.println("Top 5 butterfly competition times:");
                    Collections.sort(administrator.butterflyCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + administrator.butterflyCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + administrator.butterflyCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            administrator.butterflyCompetitiveTimes.get(2) + "4th.:" + administrator.butterflyTrainingTimes.get(3)
                            + '\n' + "5th:" + administrator.butterflyTrainingTimes.get(4));
                    break;

                case 3:
                    System.out.println("Top 5 backcrawl training times:");
                    Collections.sort(administrator.backcrawlCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + administrator.backcrawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + administrator.backcrawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            administrator.backcrawlCompetitiveTimes.get(2) + "4th.:" + administrator.backcrawlCompetitiveTimes.get(3)
                            + '\n' + "5th:" + administrator.backcrawlCompetitiveTimes.get(4));
                    break;
                case 4:
                    System.out.println("Top 5 crawl training times:");
                    Collections.sort(administrator.crawlCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + administrator.crawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + administrator.crawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            administrator.crawlCompetitiveTimes.get(2) + "4th.:" + administrator.crawlCompetitiveTimes.get(3)
                            + '\n' + "5th:" + administrator.crawlCompetitiveTimes.get(4));
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
