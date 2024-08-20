import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Functions functions = new Functions();

        Functions.clearConsole();

        while (true) {

            int choice = 0;

            while (true) {
                System.out.println("**********************************");
                System.out.println("1 - Add guests");
                System.out.println("2 - Remove guests");
                System.out.println("3 - View complete list");
                System.out.println("4 - View non-paying list");
                System.out.println("5 - Calculate surplus guests");
                System.out.println("'EXIT' to exit the program");
                System.out.println("**********************************");
                String entry = sc.nextLine();

                if (Objects.equals(entry, "EXIT")) {
                    System.out.println("Are you sure you want to exit the program? (y/n)");
                    String exit = sc.nextLine();
                    if (Objects.equals(exit, "y")) {
                        System.exit(0);
                    } else {
                        Functions.clearConsole();
                    }
                }
                try {
                    choice = Integer.parseInt(entry);
                } catch (NumberFormatException e) {
                    Functions.clearConsole();
                    System.out.println("You did not enter a number");
                }
                if (choice > 5 || choice < 1) {
                    Functions.clearConsole();
                    System.out.println("Enter a number between 1 and 5");
                } else {
                    break;
                }
            }

            switch (choice) {

                case 1:
                    Functions.clearConsole();
                    while (true) {
                        Functions.clearConsole();
                        System.out.println("Enter the names followed by enter (or 'exit'):");
                        String name = sc.nextLine();
                        if (!Objects.equals(name, "exit")) {
                            functions.addList(name);
                        } else {
                            break;
                        }
                    }
                    functions.noPayListAdd();
                    Functions.clearConsole();
                    break;

                case 2:
                    while (true) {
                        Functions.clearConsole();
                        int choiceInt = 0;
                        System.out.println("Enter the number of the guest to be removed (or 'exit')");
                        String escolha = sc.nextLine();
                        if (Objects.equals(escolha, "exit")) {
                            Functions.clearConsole();
                            break;
                        }
                        try {
                            choiceInt = Integer.parseInt(escolha);
                        } catch (NumberFormatException e) {
                            Functions.clearConsole();
                            System.out.println("You did not enter a number");
                        }
                        if (choiceInt > functions.getGuestsList().size() || choiceInt < 0) {
                            Functions.clearConsole();
                            System.out.println("You did not enter a valid number");
                        }
                        if (choiceInt > 0 && choiceInt <= functions.getGuestsList().size()) {
                            String guest = functions.getGuestsList((choiceInt - 1));
                            functions.removeList((choiceInt - 1));
                            Functions.clearConsole();
                            System.out.println(guest + " has been removed");
                            break;
                        }
                    }
                    break;

                case 3:
                    Functions.clearConsole();
                    if (functions.getGuestsList().isEmpty()) {
                        System.out.println("The list is empty.");
                        break;
                    }
                    System.out.println("Complete guest list:");
                    int count = 1;
                    for (String name : functions.getGuestsList()) {
                        System.out.println("-->  " + count + " - " + name);
                        count += 1;
                    }
                    break;

                case 4:
                    Functions.clearConsole();
                    if (functions.getNoPayList().isEmpty()) {
                        System.out.println("The list is empty.");
                        break;
                    }
                    System.out.println("Non-paying guest list:");
                    count = 1;
                    for (String name : functions.getNoPayList()) {
                        System.out.println("-->  " + count + " - " + name);
                        count += 1;
                    }

                    break;

                case 5:
                    Functions.clearConsole();
                    int guestPackage = 0;
                    String entry = "";
                    System.out.println("How many guests is the party package for? (or 'exit')");
                    entry = sc.nextLine();
                    if (entry.equalsIgnoreCase("exit")) {
                        Functions.clearConsole();
                        break;
                    }
                    while (true) {
                        try {
                            guestPackage = Integer.parseInt(entry);
                            break;
                        } catch (NumberFormatException e) {
                            Functions.clearConsole();
                            System.out.println("Enter a valid value");
                            entry = sc.nextLine();
                        }
                    }

                    while (true) {

                        if (functions.isSurplus(guestPackage)) {
                            Functions.clearConsole();
                            System.out.println("What is the cost for each excess guest? (or 'exit')");
                            entry = sc.nextLine();
                            if (entry.equalsIgnoreCase("exit")) {
                                Functions.clearConsole();
                                break;
                            }
                            try {
                                double surplusValue = Double.parseDouble(entry);
                                Functions.clearConsole();
                                System.out.println("Total cost for excess guests: $" + functions.surplusCalc(guestPackage, surplusValue));
                                break;
                            } catch (NumberFormatException e) {
                                Functions.clearConsole();
                                System.out.println("Enter a valid value");
                            }
                        } else {
                            Functions.clearConsole();
                            Functions.clearConsole();
                            System.out.println("There are no excess guests.");
                            break;
                        }
                    }
                    break;

            }

        }
    }
}