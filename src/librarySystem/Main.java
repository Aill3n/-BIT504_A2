/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    // What design patter to use for the menus?
	// Validation for errors

    private static List<Book> BookList;

    public static void main(String[] args) {
        
            try {
                BookList = FileReader.getInstance().readBookFile();
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
                    Menu.printMainMenu();
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            Menu.printBookManagementMenu();
                            loadBookManagementMenu(scanner);
                        }
                        case 2 -> Menu.printMemberManagementMenu();
                        case 3 -> Menu.loanManagementMenu();
                        case 4 -> Menu.searchMenu();
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
                String subMenuChoice = scanner.next();

                switch (subMenuChoice) {
                    case "a" -> Menu.displayAllBooks(BookList);
                    case "b" -> Menu.displayBorrowedBooks();
                    case "c" -> Menu.displayUnborrowedBooks();
                    case "d" -> Menu.addNewBook();
                    case "e" -> {
                        System.out.println("Returning to the main menu.");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }/* 
            Menu.printMainMenu();
            try (Scanner scanner = new Scanner(System.in)) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> Menu.printBookManagementMenu();
                    case 2 -> Menu.printMemberManagementMenu();
                    case 3 -> Menu.loanManagementMenu();
                    case 4 -> Menu.searchMenu();
                    case 5 -> System.out.println("Exiting the program. Goodbye!");
                    default -> {
                        System.out.printf("Option %s selected. Loading the menu.", choice);
                }
                }
            
            if (choice == 1) {
                String subMenuChoice = scanner.nextLine();
                
                switch (subMenuChoice) {
                    case "a" -> Menu.displayAllBooks(BookList);
                    case "b" -> Menu.displayBorrowedBooks();
                    case "c" -> Menu.displayUnborrowedBooks();
                    case "d" -> Menu.addNewBook();
                    case "e" -> loadMenu();
                }
            }
            else{
                Exception e = new Exception("Invalid choice. Please try again.");
                System.out.println(e.getMessage());
            }
        }*/
}

