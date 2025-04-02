package librarySystem;


public class MenuText {
    // Print the options for each menu

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

                1. Display all books
                2. Display borrowed books
                3. Display unborrowed books
                4. Add a new book
                5. Return

                - - - - - - - - - - - - - - -
                """);
    }

    public static void printMemberManagementMenu() {
        System.out.println("""

                - - - - - - - - - - - - - - -

                MEMBER MANAGEMENT MENU

                1. Display all members
                2. Add a new member
                3. Return

                - - - - - - - - - - - - - - -
                """);
    }

    public static void printLoanManagementMenu() {
        System.out.println("""

                - - - - - - - - - - - - - - -

                LOAN MANAGEMENT MENU

                1. Check out a book
                2. Check in a book
                3. Return

                - - - - - - - - - - - - - - -
                """);
    }

    public static void printSearchMenu() {
        System.out.println("""

                - - - - - - - - - - - - - - -

                SEARCH MENU

                1. Find a member
                2. Find a book
                3. Return

                - - - - - - - - - - - - - - -
                """);
    }

}
