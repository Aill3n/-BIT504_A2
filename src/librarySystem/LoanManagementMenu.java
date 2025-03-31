package librarySystem;

import java.util.List;
import java.util.Scanner;

public class LoanManagementMenu {

    public static void checkOutBook(List<Book> bookList, List<Member> memberList, Scanner scanner) {
        System.out.println("\nBook ID to check out:\n");
        String bookIdInput = scanner.nextLine().trim();
        System.out.println("\nMember ID to check out:\n");
        String memberIdInput = scanner.nextLine();

        int memberAge = 0;

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

        Book foundBook = null;
        for (Book book : bookList) {
            if (bookIdInput.equals(book.getId())) {
                foundBook = book;
                break;
            }
        }

        if (foundBook == null) {
            System.out.printf("The book with id %s wasn't found. \n", bookIdInput);
            return;
        }

        if (foundBook.isBorrowed()) {
            System.out.println("This book has been borrowed. Please chose another book.");
            return;
        }

        if (foundBook.getAgeRating() > memberAge) {
            System.out.println("The member doesn't fit the age rating criteria.");
            return;
        }

        System.out.println("The following book has been found: " + foundBook.getTitle() + "\n");

        System.out.println("Would you like to proceed? Enter 'yes' or 'no'.");
        String confirmation = scanner.nextLine().toLowerCase();

        if (confirmation.equals("yes")) {
            foundBook.setBorrowed(true);
            foundBook.setBorrowedByMemberId(memberIdInput);
            System.out.println("The book has been successfully checked out.");

        } else {
            System.out.println("Canceling operation.");
        }
    }

    public static void checkInBook(List<Book> bookList, List<Member> memberList, Scanner scanner) {

    }

}
