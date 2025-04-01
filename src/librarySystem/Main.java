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

        loadMainMenu();
    }

    // TODO: Aillen search how to add design patterns
    public static void loadMainMenu() {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                clearConsole();
                MainMenu.printMainMenu();

                int choice = inputValidation(scanner);

                switch (choice) {
                    case 1 -> {
                        MainMenu.printBookManagementMenu();
                        loadBookManagementMenu(scanner);
                    }
                    case 2 -> {
                        MainMenu.printMemberManagementMenu();
                        loadMemberManagementMenu(scanner);
                    }
                    case 3 -> {
                        MainMenu.printLoanManagementMenu();
                        loadLoanManagementMenu(scanner);
                    }
                    case 4 -> {
                        MainMenu.printSearchMenu();
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

    private static void loadBookManagementMenu(Scanner scanner) {
        while (true) {

            int choice = inputValidation(scanner);


            switch (choice) {
                case 1 -> {
                    System.out.println("Displaying all the books in the system.");
                    BookMenu.displayAllBooks(BookList);
                    MainMenu.printBookManagementMenu();

                }
                case 2 -> {
                    System.out.println("Displaying all the borrowed books in the system.");
                    BookMenu.displayBorrowedBooks(BookList);
                    MainMenu.printBookManagementMenu();

                }

                case 3 -> {
                    System.out.println("Displaying all the unborrowed books in the system.");
                    BookMenu.displayUnborrowedBooks(BookList);
                    MainMenu.printBookManagementMenu();
                }

                case 4 -> {
                    System.out.println("Displaying 'Add a new Book' menu.");
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

    private static void loadMemberManagementMenu(Scanner scanner) {
        while (true) {

            int subMenuChoice = inputValidation(scanner);

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

            int subMenuChoice = inputValidation(scanner);

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

    private static void loadSearchMenu(Scanner scanner) {
        while (true) {

            int subMenuChoice = inputValidation(scanner);

            switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("\nDisplaying the 'Find a Member' menu. \n");
                    SearchMenu.searchMember(MemberList, BookList, scanner);
                    MainMenu.printSearchMenu();

                }
                case 2 -> {
                    System.out.println("\nDisplaying the menu 'Find a book menu'. \n");
                    SearchMenu.searchBook(BookList, MemberList, scanner);
                    MainMenu.printSearchMenu();
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

    public static int inputValidation(Scanner scanner){
        int validInput = -1;
        boolean valid = false;
        
        while (!valid){
            System.out.println("Please enter a menu number:");
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
