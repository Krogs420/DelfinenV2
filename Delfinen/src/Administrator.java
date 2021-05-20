
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Tænker at vi omdøber denne klasse til Metoder (Bedre ord), så vi kun har metoder herinde.
public class Administrator {

    private int memberFee;
    private int totalIncome = 0;
    private int totalArrears = 0;

    Scanner input = new Scanner(System.in);
    private ArrayList<Member> memberlist = new ArrayList<Member>();
    ArrayList<TrialTimer> trainingTimes = new ArrayList<TrialTimer>();
    ArrayList<Competitive> competitiveTimes = new ArrayList<>();
    ArrayList<Member> memberTrainingList = new ArrayList<Member>();

    public Administrator() throws FileNotFoundException {
    }

    public void setMemberlist(ArrayList memberlist) {
        this.memberlist = memberlist;
    }

    public ArrayList<Member> getMemberlist() {
        return memberlist;
    }

    File file = new File("src/membership.txt");

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
        System.out.println("Is the member active?");
        boolean active = input.nextBoolean();
        System.out.println("Is member a competitor?");
        boolean comp = input.nextBoolean();


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

        System.out.println("Has the member paid?");
        boolean memberFeePaid = input.nextBoolean();

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

    // Tænker at vi kan lave en menu klasse med alle menuerne til admin osv.
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
                    makeNewMember();
                    break;
                case 2:
                    removeMember();
                    break;
                case 3:
                    viewMemberList();
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);
    }

    public void trainingTimer() {

                System.out.println("Create a time trial from training.");
                String trialTime = input.nextLine();
                System.out.println("What discipline was it in?");
                String trainingDiscipline = input.nextLine();
                TrialTimer trialTimer = new TrialTimer(trialTime, trainingDiscipline);
                trainingTimes.add(trialTimer);
        System.out.println("Enter the ID of the member you want to add a time trial to.");
        int callID = input.nextInt();
        input.nextLine();
        boolean memberExist = false;
        int index;
        for (int i = 0; i < memberlist.size(); i++) {
            Member member = memberlist.get(i);
            if (member.getiD() == callID) {
                memberTrainingList.add(i,memberlist.get(i));
                if (!memberExist) {
                    System.out.println("There are no members with that ID");
                }
            }
        }
    }

    public void arrears() {
        System.out.println("Total arrears is: " + totalArrears);
    }

    public void totalMembershipIncome() {
        System.out.println("The yearly total income is: " + totalIncome);
    }

    public void arrearsMenu() {

        UserInterface userInterface = new UserInterface("Do you want to:",
            "1. Show total member fee income \n" +
                "2. Show total member fee arrears", new String[]{});

        int choice;
        boolean valid;
        do {
            userInterface.printMenu();
            choice = userInterface.readChoice();
            valid = true;

            switch (choice) {
                case 1:
                    totalMembershipIncome();
                    break;
                case 2:
                    arrears();
                    break;
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);
    }
}