import java.util.Scanner;

public class Coach {

    private Administrator administrator;
    Scanner input = new Scanner(System.in);

    public Coach(Administrator administrator) {
        this.administrator = administrator;
    }

    public TrialTimer trainingTimer() {

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
        return trialTimer;

    }


    public void crawlTraining() {
        administrator.crawlTrainingTimes.add(trainingTimer());
    }

    public void backcrawlTraining() {
        administrator.backcrawlTrainingTimes.add(trainingTimer());
    }

    public void butterflyTraining() {
        administrator.butterflyTrainingTimes.add(trainingTimer());
    }

    public void breaststrokeTraining() {
        administrator.breaststrokeTrainingTimes.add(trainingTimer());
    }

    public void crawlComp() {

        administrator.crawlCompetitiveTimes.add(compTimer());
    }

    public void backCrawlComp() {
        administrator.backcrawlCompetitiveTimes.add(compTimer());
    }

    public void butterflyComp() {
        administrator.butterflyCompetitiveTimes.add(compTimer());
    }

    public void breaststrokeComp() {
        administrator.breaststrokeCompetitiveTimes.add(compTimer());
    }


    public Competitive compTimer() {
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
        return competitive;
    }
}

//Creators - Kristian
