
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {

    private int memberFee;
    private int totalIncome = 0;

    Scanner input = new Scanner(System.in);
    private ArrayList<Member> memberlist = new ArrayList<Member>();
    //Member member = new Member(0, "", 99, "", true, true, true);

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

        Member member = new Member(iD, name, age, mail, active, comp, memberFee);
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

    public void totalMembershipIncome() {
        System.out.println("The yearly total income is: " + totalIncome);
    }
}
