import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Coach {

    private Administrator administrator;
    Scanner input = new Scanner(System.in);
    ArrayList<TrialTimer> juniorCrawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> seniorCrawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> juniorBackcrawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> seniorBackcrawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> juniorButterflyTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> seniorButterflyTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> juniorBreaststrokeTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> seniorBreaststrokeTrainingTimes = new ArrayList<TrialTimer>();

    ArrayList<Competitive> juniorCrawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> juniorbackcrawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> juniorbutterflyCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> juniorbreaststrokeCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> seniorCrawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> seniorbackcrawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> seniorbutterflyCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> seniorbreaststrokeCompetitiveTimes = new ArrayList<>();

    public Coach(Administrator administrator) {
        this.administrator = administrator;
    }

    public void addSeniorOrJuniorTraining() {
        UserInterface userInterface = new UserInterface("Is it a senior or junior member?:",
                "1. Junior \n" +
                        "2. Senior", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    trainingTimerJunior();
                    break;
                case 2:
                    trainingTimerSenior();
                    break;
            }
        } while (!valid);
    }

    public void trainingTimerJunior() {

        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = true;
        String name = "";

        for (int i = 0; i < administrator.memberlist.size(); i++) {
            Member member = administrator.memberlist.get(i);
            if (member.getiD() == callID) {
                name = administrator.memberlist.get(i).getName();
            }
            if (!memberExist) {
                System.out.println("There are no members with that ID");
            }
        }

        System.out.println("What was the date?");
        String date = input.nextLine();
        System.out.println("Create a time trial from training.");
        double trialTime = input.nextDouble();
        TrialTimer trialTimer = new TrialTimer(callID, name, date, trialTime);
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
                    juniorBreaststrokeTrainingTimes.add(trialTimer);
                    break;
                case 2:
                    juniorButterflyTrainingTimes.add(trialTimer);
                    break;
                case 3:
                    juniorBackcrawlTrainingTimes.add(trialTimer);
                    break;
                case 4:
                    juniorCrawlTrainingTimes.add(trialTimer);
                    break;


                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }

        } while (!valid);
    }

    public void trainingTimerSenior() {

        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();

        boolean memberExist = true;
        String name = "";

        for (int i = 0; i < administrator.memberlist.size(); i++) {
            Member member = administrator.memberlist.get(i);
            if (member.getiD() == callID) {
                name = administrator.memberlist.get(i).getName();
            }
            if (!memberExist) {
                System.out.println("There are no members with that ID");
            }
        }

        System.out.println("What was the date?");
        String date = input.nextLine();
        System.out.println("Create a time trial from training.");
        double trialTime = input.nextDouble();
        TrialTimer trialTimer = new TrialTimer(callID, name, date, trialTime);
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
                    seniorBreaststrokeTrainingTimes.add(trialTimer);
                    break;
                case 2:
                    seniorButterflyTrainingTimes.add(trialTimer);
                    break;
                case 3:
                    seniorBackcrawlTrainingTimes.add(trialTimer);
                    break;
                case 4:
                    seniorCrawlTrainingTimes.add(trialTimer);
                    break;


                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }

        } while (!valid);
    }

    public void addSeniorOrJuniorComp() {
        UserInterface userInterface = new UserInterface("Is it a senior or junior member?:",
                "1. Junior \n" +
                        "2. Senior", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    juniorCompTimer();
                    break;
                case 2:
                    seniorCompTimer();
                    break;
            }
        } while (!valid);
    }

    public void juniorCompTimer() {
        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = true;
        String name = "";
        for (int i = 0; i < administrator.memberlist.size(); i++) {
            Member member = administrator.memberlist.get(i);
            if (member.getiD() == callID) {
                name = administrator.memberlist.get(i).getName();

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
        Competitive competitive = new Competitive(callID, name, date, compTime, rank, placeOfComp);
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
                    juniorbreaststrokeCompetitiveTimes.add(competitive);
                    break;
                case 2:
                    juniorbutterflyCompetitiveTimes.add(competitive);
                    break;
                case 3:
                    juniorbackcrawlCompetitiveTimes.add(competitive);
                    break;
                case 4:
                    juniorCrawlCompetitiveTimes.add(competitive);
                    break;


                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);

    }

    public void seniorCompTimer() {
        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = true;
        String name = "";
        for (int i = 0; i < administrator.memberlist.size(); i++) {
            Member member = administrator.memberlist.get(i);
            if (member.getiD() == callID) {
                name = administrator.memberlist.get(i).getName();

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
        Competitive competitive = new Competitive(callID, name, date, compTime, rank, placeOfComp);
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
                    seniorbreaststrokeCompetitiveTimes.add(competitive);
                    break;
                case 2:
                    seniorbutterflyCompetitiveTimes.add(competitive);
                    break;
                case 3:
                    seniorbackcrawlCompetitiveTimes.add(competitive);
                    break;
                case 4:
                    seniorCrawlCompetitiveTimes.add(competitive);
                    break;


                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);

    }

    public void showSeniorOrJuniorTraining() {
        UserInterface userInterface = new UserInterface("Top 5 Training:",
                "1. Junior \n" +
                        "2. Senior", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    top5TrainingJunior();
                    break;
                case 2:
                    top5TrainingSenior();
                    break;
            }
        } while (!valid);
    }

    public void top5TrainingJunior() {
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


                    if (juniorBreaststrokeTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorBreaststrokeTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorBreaststrokeTrainingTimes, timeComparator);
                        for (int i = 0; i < juniorBreaststrokeTrainingTimes.size(); i++) {
                            System.out.println(juniorBreaststrokeTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorBreaststrokeTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorBreaststrokeTrainingTimes.get(0) + '\n' + "2nd.:"
                                + juniorBreaststrokeTrainingTimes.get(1) + '\n' + "3rd.:" +
                                juniorBreaststrokeTrainingTimes.get(2) + "4th.:" +
                                juniorBreaststrokeTrainingTimes.get(3)
                                + '\n' + "5th:" + juniorBreaststrokeTrainingTimes.get(4));

                    }

                    break;
                case 2:

                    if (juniorButterflyTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorButterflyTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorButterflyTrainingTimes, timeComparator);
                        for (int i = 0; i < juniorButterflyTrainingTimes.size(); i++) {
                            System.out.println(juniorButterflyTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorButterflyTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorButterflyTrainingTimes.get(0) + '\n' + "2nd.:"
                                + juniorButterflyTrainingTimes.get(1) + '\n' + "3rd.:" +
                                juniorButterflyTrainingTimes.get(2) + "4th.:" +
                                juniorButterflyTrainingTimes.get(3)
                                + '\n' + "5th:" + juniorButterflyTrainingTimes.get(4));

                    }
                    break;

                case 3:
                    if (juniorBackcrawlTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorBackcrawlTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorBackcrawlTrainingTimes, timeComparator);
                        for (int i = 0; i < juniorBackcrawlTrainingTimes.size(); i++) {
                            System.out.println(juniorBackcrawlTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorBackcrawlTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorBackcrawlTrainingTimes.get(0) + '\n' + "2nd.:"
                                + juniorBackcrawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                                juniorBackcrawlTrainingTimes.get(2) + "4th.:" +
                                juniorBackcrawlTrainingTimes.get(3)
                                + '\n' + "5th:" + juniorBackcrawlTrainingTimes.get(4));

                    }
                    break;
                case 4:
                    if (juniorCrawlTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorCrawlTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorCrawlTrainingTimes, timeComparator);
                        for (int i = 0; i < juniorCrawlTrainingTimes.size(); i++) {
                            System.out.println(juniorCrawlTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorCrawlTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorCrawlTrainingTimes.get(0) + '\n' + "2nd.:"
                                + juniorCrawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                                juniorCrawlTrainingTimes.get(2) + "4th.:" +
                                juniorCrawlTrainingTimes.get(3)
                                + '\n' + "5th:" + juniorCrawlTrainingTimes.get(4));

                    }
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }
        } while (!valid);
    }

    public void showSeniorOrJuniorComp() {
        UserInterface userInterface = new UserInterface("Top 5 Competition:",
                "1. Junior \n" +
                        "2. Senior", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    top5CompJunior();
                    break;
                case 2:
                    top5CompSenior();
                    break;
            }
        } while (!valid);
    }

    public void top5CompJunior() {
        TimeComparator2 timeComparator = new TimeComparator2();
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


                    if (juniorbreaststrokeCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorbreaststrokeCompetitiveTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorbreaststrokeCompetitiveTimes, timeComparator);
                        for (int i = 0; i < juniorbreaststrokeCompetitiveTimes.size(); i++) {
                            System.out.println(juniorbreaststrokeCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorbreaststrokeCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorbreaststrokeCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + juniorbreaststrokeCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                juniorbreaststrokeCompetitiveTimes.get(2) + "4th.:" +
                                juniorbreaststrokeCompetitiveTimes.get(3)
                                + '\n' + "5th:" + juniorbreaststrokeCompetitiveTimes.get(4));

                    }

                    break;
                case 2:

                    if (juniorbutterflyCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorbutterflyCompetitiveTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorbutterflyCompetitiveTimes, timeComparator);
                        for (int i = 0; i < juniorbutterflyCompetitiveTimes.size(); i++) {
                            System.out.println(juniorbutterflyCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorbutterflyCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorbutterflyCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + juniorbutterflyCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                juniorbutterflyCompetitiveTimes.get(2) + "4th.:" +
                                juniorbutterflyCompetitiveTimes.get(3)
                                + '\n' + "5th:" + juniorbutterflyCompetitiveTimes.get(4));

                    }
                    break;

                case 3:
                    if (juniorbackcrawlCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorbackcrawlCompetitiveTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorbackcrawlCompetitiveTimes, timeComparator);
                        for (int i = 0; i < juniorbackcrawlCompetitiveTimes.size(); i++) {
                            System.out.println(juniorbackcrawlCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorbackcrawlCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorbackcrawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + juniorbackcrawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                juniorbackcrawlCompetitiveTimes.get(2) + "4th.:" +
                                juniorbackcrawlCompetitiveTimes.get(3)
                                + '\n' + "5th:" + juniorbackcrawlCompetitiveTimes.get(4));

                    }
                    break;
                case 4:
                    if (juniorCrawlCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (juniorCrawlTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(juniorCrawlCompetitiveTimes, timeComparator);
                        for (int i = 0; i < juniorCrawlCompetitiveTimes.size(); i++) {
                            System.out.println(juniorCrawlCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(juniorCrawlCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + juniorCrawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + juniorCrawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                juniorCrawlCompetitiveTimes.get(2) + "4th.:" +
                                juniorCrawlCompetitiveTimes.get(3)
                                + '\n' + "5th:" + juniorCrawlCompetitiveTimes.get(4));

                    }
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }
        } while (!valid);
    }

    public void top5TrainingSenior() {
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


                    if (seniorBreaststrokeTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorBreaststrokeTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorBreaststrokeTrainingTimes, timeComparator);
                        for (int i = 0; i < seniorBreaststrokeTrainingTimes.size(); i++) {
                            System.out.println(seniorBreaststrokeTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorBreaststrokeTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorBreaststrokeTrainingTimes.get(0) + '\n' + "2nd.:"
                                + seniorBreaststrokeTrainingTimes.get(1) + '\n' + "3rd.:" +
                                seniorBreaststrokeTrainingTimes.get(2) + "4th.:" +
                                seniorBreaststrokeTrainingTimes.get(3)
                                + '\n' + "5th:" + seniorBreaststrokeTrainingTimes.get(4));

                    }

                    break;
                case 2:

                    if (seniorButterflyTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorButterflyTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorButterflyTrainingTimes, timeComparator);
                        for (int i = 0; i < seniorButterflyTrainingTimes.size(); i++) {
                            System.out.println(seniorButterflyTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorButterflyTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorButterflyTrainingTimes.get(0) + '\n' + "2nd.:"
                                + seniorButterflyTrainingTimes.get(1) + '\n' + "3rd.:" +
                                seniorButterflyTrainingTimes.get(2) + "4th.:" +
                                seniorButterflyTrainingTimes.get(3)
                                + '\n' + "5th:" + seniorButterflyTrainingTimes.get(4));

                    }
                    break;

                case 3:
                    if (seniorBackcrawlTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorBackcrawlTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorBackcrawlTrainingTimes, timeComparator);
                        for (int i = 0; i < seniorBackcrawlTrainingTimes.size(); i++) {
                            System.out.println(seniorBackcrawlTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorBackcrawlTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorBackcrawlTrainingTimes.get(0) + '\n' + "2nd.:"
                                + juniorBackcrawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                                seniorBackcrawlTrainingTimes.get(2) + "4th.:" +
                                seniorBackcrawlTrainingTimes.get(3)
                                + '\n' + "5th:" + seniorBackcrawlTrainingTimes.get(4));

                    }
                    break;
                case 4:
                    if (seniorCrawlTrainingTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorCrawlTrainingTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorCrawlTrainingTimes, timeComparator);
                        for (int i = 0; i < seniorCrawlTrainingTimes.size(); i++) {
                            System.out.println(seniorCrawlTrainingTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorCrawlTrainingTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorCrawlTrainingTimes.get(0) + '\n' + "2nd.:"
                                + seniorCrawlTrainingTimes.get(1) + '\n' + "3rd.:" +
                                seniorCrawlTrainingTimes.get(2) + "4th.:" +
                                seniorCrawlTrainingTimes.get(3)
                                + '\n' + "5th:" + seniorCrawlTrainingTimes.get(4));

                    }
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }
        } while (!valid);
    }

    public void top5CompSenior() {
        TimeComparator2 timeComparator = new TimeComparator2();
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


                    if (seniorbreaststrokeCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorbreaststrokeCompetitiveTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorbreaststrokeCompetitiveTimes, timeComparator);
                        for (int i = 0; i < seniorbreaststrokeCompetitiveTimes.size(); i++) {
                            System.out.println(seniorbreaststrokeCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorbreaststrokeCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorbreaststrokeCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + seniorbreaststrokeCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                seniorbreaststrokeCompetitiveTimes.get(2) + "4th.:" +
                                seniorbreaststrokeCompetitiveTimes.get(3)
                                + '\n' + "5th:" + seniorbreaststrokeCompetitiveTimes.get(4));

                    }

                    break;
                case 2:

                    if (seniorbutterflyCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorbutterflyCompetitiveTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorbutterflyCompetitiveTimes, timeComparator);
                        for (int i = 0; i < seniorbutterflyCompetitiveTimes.size(); i++) {
                            System.out.println(seniorbutterflyCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorbutterflyCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorbutterflyCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + seniorbutterflyCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                seniorbutterflyCompetitiveTimes.get(2) + "4th.:" +
                                seniorbutterflyCompetitiveTimes.get(3)
                                + '\n' + "5th:" + seniorbutterflyCompetitiveTimes.get(4));

                    }
                    break;

                case 3:
                    if (seniorbackcrawlCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorbackcrawlCompetitiveTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorbackcrawlCompetitiveTimes, timeComparator);
                        for (int i = 0; i < seniorbackcrawlCompetitiveTimes.size(); i++) {
                            System.out.println(seniorbackcrawlCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorbackcrawlCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorbackcrawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + seniorbackcrawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                seniorbackcrawlCompetitiveTimes.get(2) + "4th.:" +
                                seniorbackcrawlCompetitiveTimes.get(3)
                                + '\n' + "5th:" + seniorbackcrawlCompetitiveTimes.get(4));

                    }
                    break;
                case 4:
                    if (seniorCrawlCompetitiveTimes.isEmpty()) {
                        System.out.println("List is empty");
                    } else if (seniorCrawlCompetitiveTimes.size() < 5) {
                        System.out.println("junior:" + '\n' + "Top breaststroke training times:");
                        Collections.sort(seniorCrawlCompetitiveTimes, timeComparator);
                        for (int i = 0; i < seniorCrawlCompetitiveTimes.size(); i++) {
                            System.out.println(seniorCrawlCompetitiveTimes.get(i));
                        }
                    } else {
                        Collections.sort(seniorCrawlCompetitiveTimes, timeComparator);
                        System.out.println("Senior:");
                        System.out.println("1st.:" + seniorCrawlCompetitiveTimes.get(0) + '\n' + "2nd.:"
                                + seniorCrawlCompetitiveTimes.get(1) + '\n' + "3rd.:" +
                                seniorCrawlCompetitiveTimes.get(2) + "4th.:" +
                                seniorCrawlCompetitiveTimes.get(3)
                                + '\n' + "5th:" + seniorCrawlCompetitiveTimes.get(4));

                    }
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");

            }
        } while (!valid);
    }

}

//Creators -  Christopher, Kristian & Jeppe
