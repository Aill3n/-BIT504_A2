/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

import java.util.List;
import java.util.Scanner;

public class LoanManagementMenu {

    public static void checkOutBook(List<Book> bookList, List<Member> memberList, Scanner scanner) {
        // Book ID
        System.out.println("\nBook ID to check out:\n");
        String bookIdInput = scanner.nextLine();

        // Memebr ID
        System.out.println("\nMember ID to check out:\n");
        String memberIdInput = scanner.nextLine();

        int memberAge = 0;

        // Validates if the ID of the member exists
        Member foundMember = null;
        for (Member member : memberList) {
            if (memberIdInput.equals(member.getId())) {
                foundMember = member;
                System.out.printf("Member found. Name: %s. \n",
                        member.getFirstName() + " " + member.getLastName() + " Age: " + member.getAge());
                memberAge = member.getAge();
                break;
            }
        }

        if (foundMember == null) {
            System.out.println("No member found with this id.");
            return;
        }

        // Match the book with the ID entered
        Book foundBook = findBookById(bookList, bookIdInput);
       
        isBookFound(foundBook);

        // Validate if the book has been borrowed
        if (foundBook.isBorrowed()) {
            System.out.println("This book has been borrowed. Please chose another book.");
            return;
        }

        // Validate age criteria
        if (foundBook.getAgeRating() > memberAge) {
            System.out.println("The member doesn't fit the age rating criteria.");
            return;
        }

        System.out.println("The following book has been found: " + foundBook.getTitle() + "\n");

        System.out.println("Would you like to proceed? Enter 'yes' or 'no'.");
        String confirmation = scanner.nextLine().toLowerCase().trim();

        // Check out book upon confirmation
        if (confirmation.equals("yes")) {
            foundBook.setBorrowed(true);
            foundBook.setBorrowedByMemberId(memberIdInput);
            System.out.println("The book has been successfully checked out.");

        } else {
            System.out.println("Canceling operation.");
        }
    }

    public static void checkInBook(List<Book> bookList, List<Member> memberList, Scanner scanner) {
        System.out.println("\nBook ID to check in:\n");
        String bookIdInput = scanner.nextLine().trim();
        
        // Match a book with the provided ID
        Book foundBook = findBookById(bookList, bookIdInput);
       
        isBookFound(foundBook);

        // Validate if the book has been borrowed
        if (!foundBook.isBorrowed()) {
            System.out.println("This book has already been checked in. Please chose another book.");
            return;
        }

        System.out.println("Would you like to proceed? Enter 'yes' or 'no'.");
        String confirmation = scanner.nextLine().toLowerCase();

        // Check in the book upon confirmation
        if (confirmation.equals("yes")) {
            foundBook.setBorrowed(false);
            foundBook.setBorrowedByMemberId(null);
            System.out.println("The book has been successfully checked in.");

        } else {
            System.out.println("Canceling operation.");
        }
    }

    // Validate if book has been found
    public static void isBookFound(Book foundBook)
    {
        if (foundBook == null) {
            System.out.println("The book entered wasn't found. \n");
        }
    }

    // Match the user input with a book Id
    public static Book findBookById(List<Book> bookList, String bookIdInput) {
        Book foundBook = null;
        for (Book book : bookList) {
            if (bookIdInput.equals(book.getId())) {
                foundBook = book;
                break;
            }
        }
        return foundBook;
    }

}
