
import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {
    Scanner input = new Scanner(System.in);
    private ArrayList<Member> memberlist = new ArrayList<Member>();
    Member member = new Member(0, "", 99, "", true, true, true);

    public void setMemberlist(ArrayList memberlist) {
        this.memberlist = memberlist;
    }

    public ArrayList getMemberlist() {
        return memberlist;
    }

    public void makeNewMember() {

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
        System.out.println("Is the member junior or senior?");
        boolean senior = input.nextBoolean();
        System.out.println("Is member a competitor?");
        boolean comp = input.nextBoolean();
        Member member = new Member(iD, name, age, mail, active,
                senior, comp);
        memberlist.add(member);
        for (int i = 0; i < memberlist.size(); i++) {
            System.out.println(memberlist.get(i));
        }
    }

    public void removeMember() {

        System.out.println("Enter the ID of the member you want to remove");
        int remove = input.nextInt();
        input.nextLine();
        boolean memberExist = false;

        for (int i = 0; i < memberlist.size(); i++) {
            memberlist.get(i);
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
                "2. Remove a member", new String[]{});

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
                default:
                    valid = false;
                    System.out.println("Your input is not valid, try again.");
            }
        } while (!valid);
    }
}
