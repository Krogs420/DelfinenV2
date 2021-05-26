import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Tænker at vi omdøber denne klasse til Metoder (Bedre ord), så vi kun har metoder herinde.
public class Administrator {

    private Member member;

    public Administrator (Member member) throws FileNotFoundException {
        this.member = member;
    }

    private int memberFee;
    private int totalIncome = 0;
    private int totalArrears = 0;


    Scanner input = new Scanner(System.in);
    ArrayList<Member> memberlist = new ArrayList<Member>();

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

    public void arrears() {
        System.out.println("Total arrears is: " + totalArrears);
    }

    public void totalMembershipIncome() {
        System.out.println("The yearly total income is: " + totalIncome);
    }



    public int totalMemberShipIncomeForTest(int memberFee){
        totalIncome += memberFee;
        return totalIncome;
    }
}

//Creators - Jeppe, Christopher & Kristian