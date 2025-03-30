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
                MainMenu.printMainMenu();
                System.out.println("Please enter an option:");

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
                    case 2 -> {MainMenu.printMemberManagementMenu();
                    loadMemberManagementMenu(scanner);}
                    case 3 -> MainMenu.loanManagementMenu();
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
                    System.out.println("Displaying all the books in the system.");
                    BookMenu.displayAllBooks(BookList);
                    break;
                }
                case 2 -> {
                    BookMenu.displayBorrowedBooks(BookList);
                }

                case 3 -> {
                    BookMenu.displayUnborrowedBooks(BookList);
                }

                case 4 -> {
                    BookMenu.addNewBook(BookList, scanner);
                }

                case 5 -> {
                    System.out.println("Returning to the main menu.");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void loadMemberManagementMenu(Scanner scanner){
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
                }
                case 2 -> {
                    System.out.println("Displaying add a member menu.");
                    MemberMenu.addNewMember(MemberList);
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
}
