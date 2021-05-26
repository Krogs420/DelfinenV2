import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Coach {

    private Administrator administrator;
    Scanner input = new Scanner(System.in);
    ArrayList<TrialTimer> crawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> backcrawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> butterflyTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> breaststrokeTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<Competitive> crawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> backcrawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> butterflyCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> breaststrokeCompetitiveTimes = new ArrayList<>();
    public Coach(Administrator administrator) {
        this.administrator = administrator;
    }

    public void trainingTimer() {

        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = true;
        String name = "";
        boolean juniorSenior = false;
        for (int i = 0; i < administrator.memberlist.size(); i++) {
            Member member = administrator.memberlist.get(i);
            if (member.getiD() == callID) {
                name = administrator.memberlist.get(i).getName();
                juniorSenior = administrator.memberlist.get(i).isActiveMember();
            }
            if (!memberExist) {
                System.out.println("There are no members with that ID");
            }
        }

        System.out.println("What was the date?");
        String date = input.nextLine();
        System.out.println("Create a time trial from training.");
        double trialTime = input.nextDouble();
        TrialTimer trialTimer = new TrialTimer(callID, name, date, trialTime, juniorSenior);
        UserInterface userInterface = new UserInterface("Which competion was it in?:",
                "1. Breaststokes \n" +
                        "2. Butterfly\n" + "3. Backcrawl\n" +
                        "4. Crawl", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    breaststrokeTrainingTimes.add(trialTimer);
                    break;
                case 2:
                    butterflyTrainingTimes.add(trialTimer);
                    break;
                case 3:
                    backcrawlTrainingTimes.add(trialTimer);
                    break;
                case 4:
                    crawlTrainingTimes.add(trialTimer);
                    break;



                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        }while (!valid);



    }





    public void compTimer() {
        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = true;
        String name = "";
        boolean juniorSenior = false;
        for (int i = 0; i < administrator.memberlist.size(); i++) {
            Member member = administrator.memberlist.get(i);
            if (member.getiD() == callID) {
                name = administrator.memberlist.get(i).getName();
                juniorSenior = administrator.memberlist.get(i).isActiveMember();
            }
            if (!memberExist) {
                System.out.println("There are no members with that ID");
            }
        }
        System.out.println("Create a time from competition.");
        double compTime = input.nextDouble();
        System.out.println("Which competition was it?");
        String placeOfComp = input.nextLine();
        System.out.println("What were their placement?");
        int rank = input.nextInt();
        input.nextLine();
        System.out.println("What was the date?");
        String date = input.nextLine();
        Competitive competitive = new Competitive(callID, name, date, compTime, juniorSenior, rank, placeOfComp);
        UserInterface userInterface = new UserInterface("Which competion was it in?:",
                "1. Breaststokes \n" +
                        "2. Butterfly\n" + "3. Backcrawl\n" +
                        "4. Crawl", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    breaststrokeCompetitiveTimes.add(competitive);
                    break;
                case 2:
                    butterflyCompetitiveTimes.add(competitive);
                    break;
                case 3:
                    backcrawlCompetitiveTimes.add(competitive);
                    break;
                case 4:
                    crawlCompetitiveTimes.add(competitive);
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
                    for (int i = 0; i < breaststrokeTrainingTimes.size(); i++) {
                        TrialTimer trialTimer = breaststrokeTrainingTimes.get(i);
                        if (trialTimer.isJuniorSenior() == true) {
                            Collections.sort(breaststrokeTrainingTimes, timeComparator);
                            System.out.println("Senior:");
                            System.out.println("1st.:" + breaststrokeTrainingTimes.get(0) + '\n' + "2nd.:"
                                    + breaststrokeTrainingTimes.get(1) + '\n' + "3rd.:" +
                                  breaststrokeTrainingTimes.get(2) + "4th.:" + breaststrokeTrainingTimes.get(3)
                                    + '\n' + "5th:" + breaststrokeTrainingTimes.get(4)); }
                        else if (trialTimer.isJuniorSenior() == false){
                            Collections.sort(breaststrokeTrainingTimes, timeComparator);
                            System.out.println("Junior:");
                            System.out.println("1st.:" + breaststrokeTrainingTimes.get(0) + '\n' + "2nd.:"
                                    + breaststrokeTrainingTimes.get(1) + '\n' + "3rd.:" +
                                    breaststrokeTrainingTimes.get(2) + "4th.:" +
                                    breaststrokeTrainingTimes.get(3)
                                    + '\n' + "5th:" + breaststrokeTrainingTimes.get(4));
                        }

                    }
                    break;
                case 2:
                    System.out.println("Top 5 butterfly training times:");
                    Collections.sort(butterflyTrainingTimes, timeComparator);

                    System.out.println("1st.:" + butterflyTrainingTimes.get(0) +'\n'+"2nd.:"
                            + butterflyTrainingTimes.get(1) + '\n'+ "3rd.:" +
                            butterflyTrainingTimes.get(2) + "4th.:" + butterflyTrainingTimes.get(3)
                            +'\n'+ "5th:" + butterflyTrainingTimes.get(4) );
                    break;

                case 3:
                    System.out.println("Top 5 backcrawl training times:");
                    Collections.sort(backcrawlTrainingTimes, timeComparator);

                    System.out.println("1st.:" + backcrawlTrainingTimes.get(0) + '\n' + "2nd.:"
                            + backcrawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                            backcrawlTrainingTimes.get(2) + "4th.:" + backcrawlTrainingTimes.get(3)
                            + '\n' + "5th:" + backcrawlTrainingTimes.get(4));
                    break;
                case 4:
                    System.out.println("Top 5 crawl training times:");
                    Collections.sort(crawlTrainingTimes, timeComparator);

                    System.out.println("1st.:" + crawlTrainingTimes.get(0) + '\n' + "2nd.:"
                            + crawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                            crawlTrainingTimes.get(2) + "4th.:" + crawlTrainingTimes.get(3)
                            + '\n' + "5th:" + crawlTrainingTimes.get(4));
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
                    Collections.sort(breaststrokeCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + breaststrokeCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + breaststrokeCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            breaststrokeCompetitiveTimes.get(2) + "4th.:" + breaststrokeCompetitiveTimes.get(3)
                            + '\n' + "5th:" + breaststrokeCompetitiveTimes.get(4));
                    break;
                case 2:
                    System.out.println("Top 5 butterfly competition times:");
                    Collections.sort(butterflyCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + butterflyCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + butterflyCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            butterflyCompetitiveTimes.get(2) + "4th.:" + butterflyTrainingTimes.get(3)
                            + '\n' + "5th:" + butterflyTrainingTimes.get(4));
                    break;

                case 3:
                    System.out.println("Top 5 backcrawl training times:");
                    Collections.sort(backcrawlCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + backcrawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + backcrawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            backcrawlCompetitiveTimes.get(2) + "4th.:" + backcrawlCompetitiveTimes.get(3)
                            + '\n' + "5th:" + backcrawlCompetitiveTimes.get(4));
                    break;
                case 4:
                    System.out.println("Top 5 crawl training times:");
                    Collections.sort(crawlCompetitiveTimes, compComparator);

                    System.out.println("1st.:" + crawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                            + crawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                            crawlCompetitiveTimes.get(2) + "4th.:" + crawlCompetitiveTimes.get(3)
                            + '\n' + "5th:" + crawlCompetitiveTimes.get(4));
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }
        } while (!valid);
    }
}

//Creators - Kristian
