
import java.util.Scanner;

public class UserInterface {
    private String menuHeader;
    private String leadtext;
    private String[] menuItems;

    public UserInterface(String menuHeader, String leadtext, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.leadtext = leadtext;
        this.menuItems = menuItems;
    }

    public void printMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuItems.length; i++)
            printString += menuItems[i] + "\n";
        System.out.println("\n" + printString);
    }

    public int readChoice() {
        Scanner input = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1;
        while (!validChoice) {
            System.out.println(leadtext);
            if (input.hasNextInt()) {
                choice = input.nextInt();
                validChoice = true;
            } else {
                input.nextLine();
            }
        }
        return choice;
    }
}

//Creators - Jeppe & Kristian
