import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Tænker at vi omdøber denne klasse til Metoder (Bedre ord), så vi kun har metoder herinde.
public class Administrator {

    private int memberFee;
    private int totalIncome = 0;
    private int totalArrears = 0;

    Scanner input = new Scanner(System.in);
    ArrayList<Member> memberlist = new ArrayList<Member>();
    ArrayList<TrialTimer> crawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> backcrawlTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> butterflyTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<TrialTimer> breaststrokeTrainingTimes = new ArrayList<TrialTimer>();
    ArrayList<Competitive> crawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> backcrawlCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> butterflyCompetitiveTimes = new ArrayList<>();
    ArrayList<Competitive> breaststrokeCompetitiveTimes = new ArrayList<>();
    public Administrator() throws FileNotFoundException {
    }

    public void setMemberlist(ArrayList memberlist) {
        this.memberlist = memberlist;
    }

    public ArrayList<Member> getMemberlist() {
        return memberlist;
    }

    File file = new File("Delfinen/src/membership.txt");

    PrintStream writeToFile = new PrintStream(new FileOutputStream(file, true));

    public void viewMemberList() {
        System.out.println("\nMemberlist: ");
        for (int i = 0; i < memberlist.size(); i++) {
            System.out.println(memberlist.get(i));
        }
    }

    public int makeNewMember() {

        System.out.println("Create an id");
        int iD = input.nextInt();
        input.nextLine();
        System.out.println("What is the members name?");
        String name = input.nextLine();
        System.out.println("What is the members age?");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("What is the members mail?");
        String mail = input.nextLine();

        System.out.println("Is the member active? Type yes or no? ");
        String chooseActive = input.nextLine();
        boolean active;
        if(chooseActive.equalsIgnoreCase("yes")){
           active = true;
        } else {
            active = false;
        }

        if (active == true) {
            if (age < 18) {
                memberFee = 1000;

            } else if (age >= 18 && age <= 60) {
                memberFee = 1600;

            } else {
                memberFee = 1150;
            }
        } else {
            memberFee = 500;
        }

        totalIncome += memberFee;

        System.out.println("Is member a competitor? Type yes or no? ");
        String chooseComp = input.nextLine();
        boolean comp;
        if(chooseComp.equalsIgnoreCase("yes")){
            comp = true;
        } else {
            comp = false;
        }

        System.out.println("Has the member paid? Type yes or no? ");
        String chooseMemberFeePaid = input.nextLine();
        boolean memberFeePaid;
        if(chooseMemberFeePaid.equalsIgnoreCase("yes")){
            memberFeePaid = true;
        } else {
            memberFeePaid = false;
        }

        if(memberFeePaid == false) {
            totalArrears += memberFee;
        }

        Member member = new Member(iD, name, age, mail, active, comp, memberFee, memberFeePaid);
        memberlist.add(member);
        for (int i = 0; i < memberlist.size(); i++) {
            System.out.println(memberlist.get(i));
            writeToFile.println(memberlist.get(i));
        }
        return memberFee;
    }
    //-------------------------------------------------
    public void removeMember() {

        System.out.println("Enter the ID of the member you want to remove");
        int remove = input.nextInt();
        input.nextLine();
        boolean memberExist = false;

        for (int i = 0; i < memberlist.size(); i++) {
            Member member = memberlist.get(i);
            if (member.getiD() == remove) {
                memberlist.remove(i);
                memberExist = true;
                System.out.println("Member removed" + remove);
            }
            if (!memberExist) {
                System.out.println("There are no members");
            }
        }
    }

    public TrialTimer trainingTimer() {
        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = true;
        String name = "";
        for (int i = 0; i < memberlist.size(); i++) {
            Member member = memberlist.get(i);
            if (member.getiD() == callID) {
                name = memberlist.get(i).getName();
            }
            if (!memberExist) {
                System.out.println("There are no members with that ID");
            }
        }
        System.out.println("What was the date?");
        String date = input.nextLine();
        System.out.println("Create a time trial from training.");
        double trialTime = input.nextDouble();

        TrialTimer trialTimer = new TrialTimer(callID, name,date,trialTime);
        return trialTimer;

    }
    public void crawlTraining(){
        crawlTrainingTimes.add(trainingTimer());
    }
    public void backcrawlTraining () {
        backcrawlTrainingTimes.add(trainingTimer());
    }
    public void butterflyTraining () {
        butterflyTrainingTimes.add(trainingTimer());
    }
    public void breaststrokeTraining () {
        breaststrokeTrainingTimes.add(trainingTimer());
    }
public void crawlComp (){

        crawlCompetitiveTimes.add(compTimer());
}
public void backCrawlComp () {
        backcrawlCompetitiveTimes.add(compTimer());
}
public void butterflyComp () {
        butterflyCompetitiveTimes.add(compTimer());
}
public void breaststrokeComp () {
        breaststrokeCompetitiveTimes.add(compTimer());
}


    public Competitive compTimer() {
        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = true;
        String name = "";
        for (int i = 0; i < memberlist.size(); i++) {
            Member member = memberlist.get(i);
            if (member.getiD() == callID) {
                name = memberlist.get(i).getName();
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
        Competitive competitive = new Competitive(callID,name,date,compTime,rank, placeOfComp);
        return competitive;
    }


    public void arrears() {
        System.out.println("Total arrears is: " + totalArrears);
    }

    public void totalMembershipIncome() {
        System.out.println("The yearly total income is: " + totalIncome);
    }




}