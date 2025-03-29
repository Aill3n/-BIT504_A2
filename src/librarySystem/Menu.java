package librarySystem;

import java.util.List;

public class Menu {
    public static void main(String[] args) {
        printMainMenu();
        printBookManagementMenu();
        printMemberManagementMenu();
        loanManagementMenu();
        searchMenu();
    }

    public static void printMainMenu() {
        System.out.println("""
                - - - - - - - - - - - - - - -

                MAIN MENU

                1. Book Management
                2. Member Management
                3. Loan Management
                4. Search
                5. Exit

                - - - - - - - - - - - - - - -
                """);
    }

    public static void printBookManagementMenu() {
        System.out.println("""
            
                - - - - - - - - - - - - - - -

                BOOK MANAGEMENT MENU

                a. Display all books
                b. Display borrowed books
                c. Display unborrowed books
                d. Add a new book
                e. Return

                - - - - - - - - - - - - - - -
                """);
    }

    public static void printMemberManagementMenu() {
        System.out.println("""
            
                - - - - - - - - - - - - - - -

                MEMBER MANAGEMENT MENU

                a. Display all members
                b. Add a new member
                c. Return
                
                - - - - - - - - - - - - - - -
                """);
    }

    public static void loanManagementMenu() {
        System.out.println("""
            
                - - - - - - - - - - - - - - -

                LOAN MANAGEMENT MENU

                a. Check out a book
                b. Check in a book
                c. Return
                
                - - - - - - - - - - - - - - -
                """);
    }

    public static void searchMenu() {
        System.out.println("""
            
                - - - - - - - - - - - - - - -

                SEARCH MENU

                a. Find a member
                b. Find a book
                c. Return
                
                - - - - - - - - - - - - - - -
                """);
    }
    
    public static void displayAllBooks(List<Book> bookList) {
        bookHeader();
        for (Book book : bookList) {
            String bookId = book.getId();
            String bookIsbn = book.getIsbn();
            String bookTitle = book.getTitle();
            String bookAuthor = book.getAuthor();
            String bookGenre = book.getGenre();

            // Format book ID
            if (bookId.length() < 2){
               bookId = 0 + book.getId();}
            else {
                bookId = book.getId();
            }
            // Format Book ISBN
            if (bookIsbn.length() < 18){
                bookIsbn = book.getIsbn() + " ";}
             else {
                bookIsbn = book.getIsbn();
             }
             // Format Book Title
             // Add blank spaces until the size of the field is 28 characters
             // What is the lenght?
             // Add spaces until the lenght is 30
             int length = bookTitle.length();
             if (length < 28){
                for (int i = 0; i < length; i++){
                    bookTitle = book.getTitle() + " ";}
             }
             else if (length > 28){
                bookTitle = book.getTitle();
             }

            
            System.out.println(String.format(
                "| %s | %s | %s \t\t | %s \t\t | %s | %s | %d |",
                bookId,
                bookIsbn,
                bookTitle,
                bookAuthor,
                book.getDateOfPublication(),
                bookGenre,
                book.getAgeRating()
            ));
        }
    }

    public static void displayAllMembers() {
        // This method will display all members in the system.
        // Implementation will be added later.
    }   
    public static void addNewBook() {
        // This method will allow the user to add a new book.
        // Implementation will be added later.
    }
    public static void addNewMember() {
        // This method will allow the user to add a new member.
        // Implementation will be added later.
    }
    public static void checkOutBook() {
        // This method will allow the user to check out a book.
        // Implementation will be added later.
    }
    public static void checkInBook() {
        // This method will allow the user to check in a book.
        // Implementation will be added later.
    }
    public static void findMember() {
        // This method will allow the user to find a member.
        // Implementation will be added later.
    }
    public static void findBook() {
        // This method will allow the user to find a book.
        // Implementation will be added later.
    }

    public static Object displayBorrowedBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayBorrowedBooks'");
    }

    public static Object displayUnborrowedBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayUnborrowedBooks'");
    }

    public static void bookHeader() {
        String divider = "--------------------------------------------------------------------------------------------------------------------------------------";
        String header = "| ID | ISBN               | Title                      | Author            | Date of Publication | Genre         | Age Rating |";

        System.out.println(divider + "\n" + header + "\n" + divider);
    }

    public static void memberHeader() {
        System.out.println("""
                | ID | First Name | Last Name | Age |
                """);
    }
}
