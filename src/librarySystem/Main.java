/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // What design patter to use for the menus?
    // Validation for errors

    private static List<Book> BookList = new ArrayList<>();
    private static List<Member> MemberList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            BookList = FileReader.getInstance().readBookFile();
            FileReader.getInstance().readBookFile();
        } catch (Exception e) {
            System.out.println("There was an issue reading the files.");
            e.printStackTrace();
        }

        try {
            MemberList = FileReader.getInstance().readMemberFile();
            FileReader.getInstance().readMemberFile();
        } catch (Exception e) {
            System.out.println("There was an issue reading the files.");
            e.printStackTrace();
        }

        loadMenu();
    }

    public static void loadMenu() {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                clearConsole();
                MainMenu.printMainMenu();
                System.out.println("Please enter an option (main menu):");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume invalid input
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        MainMenu.printBookManagementMenu();
                        loadBookManagementMenu(scanner);
                    }
                    case 2 -> {
                        MainMenu.printMemberManagementMenu();
                        loadMemberManagementMenu(scanner);
                    }
                    case 3 -> {MainMenu.printLoanManagementMenu();
                        loadLoanManagementMenu(scanner);}
                    case 4 -> MainMenu.searchMenu();
                    case 5 -> {
                        System.out.println("Exiting the program. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void loadBookManagementMenu(Scanner scanner) {
        while (true) {
            System.out.println("Please enter an option (Book management):");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            int subMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("Displaying all the books in the system.");
                    BookMenu.displayAllBooks(BookList);
                    MainMenu.printBookManagementMenu();
                }
                case 2 -> {
                    BookMenu.displayBorrowedBooks(BookList);
                    MainMenu.printBookManagementMenu();
                }

                case 3 -> {
                    BookMenu.displayUnborrowedBooks(BookList);
                    MainMenu.printBookManagementMenu();
                }

                case 4 -> {
                    BookMenu.addNewBook(BookList, scanner);
                    MainMenu.printBookManagementMenu();
                }

                case 5 -> {
                    System.out.println("Returning to the main menu.");
                    System.out.flush();
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void loadMemberManagementMenu(Scanner scanner) {
        while (true) {
            System.out.println("Please enter an option:");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            int subMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("Displaying all the members in the system.");
                    MemberMenu.displayAllMembers(MemberList);
                    MainMenu.printMemberManagementMenu();
                }
                case 2 -> {
                    System.out.println("Displaying add a member menu.");
                    MemberMenu.addNewMember(MemberList, scanner);
                    MainMenu.printMemberManagementMenu();
                }
                case 3 -> {
                    System.out.println("Returning to the main menu.");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void loadLoanManagementMenu(Scanner scanner) {
        while (true) {
            System.out.println("Please enter an option:");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int subMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("\n Displaying the menu 'Check out a book'. \n");
                    LoanManagementMenu.checkOutBook(BookList, MemberList, scanner);
                    MainMenu.printLoanManagementMenu();
                }
                case 2 -> {
                    System.out.println("\n Displaying the menu 'Check in a book'. \n");
                    LoanManagementMenu.checkInBook(BookList, MemberList, scanner);
                    MainMenu.printLoanManagementMenu();
                }
                case 3 -> {
                    System.out.println("Returning to the main menu.");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
