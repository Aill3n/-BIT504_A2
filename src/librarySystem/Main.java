/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Create a list for book objects
    private static List<Book> BookList = new ArrayList<>();

    // Create a list for Member objects
    private static List<Member> MemberList = new ArrayList<>();

    public static void main(String[] args) {
        // Read the book file
        try {
            BookList = FileReader.getInstance().readBookFile();
            FileReader.getInstance().readBookFile();
        } catch (Exception e) {
            System.out.println("There was an issue reading the files.");
        }

        // Read the member file
        try {
            MemberList = FileReader.getInstance().readMemberFile();
            FileReader.getInstance().readMemberFile();
        } catch (FileNotFoundException e) {
            System.out.println("There was an issue reading the files.");
        }

        loadMainMenu();
    }

    public static void loadMainMenu() {

        // Loads the main menu and links to its sub-menus
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                clearConsole();
                MenuText.printMainMenu();

                int choice = inputValidation(scanner);

                switch (choice) {
                    case 1 -> {
                        MenuText.printBookManagementMenu();
                        loadBookManagementMenu(scanner);
                    }
                    case 2 -> {
                        MenuText.printMemberManagementMenu();
                        loadMemberManagementMenu(scanner);
                    }
                    case 3 -> {
                        MenuText.printLoanManagementMenu();
                        loadLoanManagementMenu(scanner);
                    }
                    case 4 -> {
                        MenuText.printSearchMenu();
                        loadSearchMenu(scanner);
                    }
                    case 5 -> {
                        System.out.println("Exiting the program. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    // Present and controls the Book Management Menu
    private static void loadBookManagementMenu(Scanner scanner) {
        while (true) {

            int choice = inputValidation(scanner);


            switch (choice) {
                case 1 -> {
                    System.out.println("Displaying all the books in the system.\n");
                    BookMenu.displayAllBooks(BookList);
                    MenuText.printBookManagementMenu();

                }
                case 2 -> {
                    System.out.println("Displaying all the borrowed books in the system.\n");
                    BookMenu.displayBorrowedBooks(BookList);
                    MenuText.printBookManagementMenu();

                }

                case 3 -> {
                    System.out.println("Displaying all the unborrowed books in the system.\n");
                    BookMenu.displayUnborrowedBooks(BookList);
                    MenuText.printBookManagementMenu();
                }

                case 4 -> {
                    System.out.println("Displaying 'Add a new Book' menu.\n");
                    BookMenu.addNewBook(BookList, scanner);
                    MenuText.printBookManagementMenu();
                }

                case 5 -> {
                    System.out.println("Returning to the main menu.\n");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.\n");
                }
            }
        }
    }

    // Present and controls the Member Management Menu
    private static void loadMemberManagementMenu(Scanner scanner) {
        while (true) {

            int subMenuChoice = inputValidation(scanner);

            switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("Displaying all the members in the system.");
                    MemberMenu.displayAllMembers(MemberList);
                    MenuText.printMemberManagementMenu();
                }
                case 2 -> {
                    System.out.println("Displaying add a member menu.");
                    MemberMenu.addNewMember(MemberList, scanner);
                    MenuText.printMemberManagementMenu();
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

    // Present and controls the Loan Management Menu
    private static void loadLoanManagementMenu(Scanner scanner) {
        while (true) {

            int subMenuChoice = inputValidation(scanner);

            switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("\nDisplaying the menu 'Check out a book'. \n");
                    LoanManagementMenu.checkOutBook(BookList, MemberList, scanner);
                    MenuText.printLoanManagementMenu();
                }
                case 2 -> {
                    System.out.println("\nDisplaying the menu 'Check in a book'. \n");
                    LoanManagementMenu.checkInBook(BookList, MemberList, scanner);
                    MenuText.printLoanManagementMenu();
                }
                case 3 -> {
                    System.out.println("\nReturning to the main menu.\n");
                    return;
                }
                default -> {
                    System.out.println("\nInvalid choice. Please try again.\n");
                }
            }
        }
    }

    // Present and controls the Search Menu
    private static void loadSearchMenu(Scanner scanner) {
        while (true) {

            int subMenuChoice = inputValidation(scanner);

            switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("\nDisplaying the 'Find a Member' menu. \n");
                    SearchMenu.searchMember(MemberList, BookList, scanner);
                    MenuText.printSearchMenu();

                }
                case 2 -> {
                    System.out.println("\nDisplaying the menu 'Find a book menu'. \n");
                    SearchMenu.searchBook(BookList, MemberList, scanner);
                    MenuText.printSearchMenu();
                }
                case 3 -> {
                    System.out.println("\nReturning to the main menu.\n");
                    return;
                }
                default -> {
                    System.out.println("\nInvalid choice. Please try again.\n");
                }
            }
        }
    }

    // Clear the console - used for after returning to the main menu
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Validates the input of the user for the menus
    public static int inputValidation(Scanner scanner){
        int validInput = 0;
        boolean valid = false;
        
        while (!valid){
            System.out.println("\nPlease enter a menu number:");
            if (scanner.hasNextInt()) {
                validInput = scanner.nextInt();
                valid = true; 
            } else {
               System.out.println("Invalid input.");
            }
            // This will consume the enter key
            scanner.nextLine();
        }
        return validInput;
     }
    }
