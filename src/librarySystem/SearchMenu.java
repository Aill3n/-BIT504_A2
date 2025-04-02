/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

import java.util.List;
import java.util.Scanner;

public class SearchMenu {

    // Search for a member
    public static void searchMember(List<Member> memberList, List<Book> bookList, Scanner scanner) {
        System.out.println("Enter a member's last name: \n");
        String lastName = scanner.nextLine();
        boolean memberFound = false;

        // Validates that name is not empty
        if (lastName.isEmpty()) {
            System.out.println("Please enter a valid last name.");
            return;
        }

        // Match the content entered with the members, comparing lower case and trimming spaces
        for (Member member : memberList) {
            if (member.getLastName().toLowerCase().contains(lastName.trim().toLowerCase())) {
                memberFound = true;
                // Print the details of the member found
                System.out.println("Member Details:");
                System.out.println("\n- First name: " + member.getFirstName());
                System.out.println("- Last name: " + member.getLastName());
                System.out.println("- Age: " + member.getAge());

                // Search if the member has borrowed a book
                boolean bookFound = false;
                for (Book book : bookList) {
                    if (book.getBorrowedByMemberId() != null && book.getBorrowedByMemberId().equals(member.getId())) {
                        bookFound = true;
                        System.out.println("- Book borrowed: " + book.getTitle() + "\n");
                    }
                }
                if (!bookFound) {
                    System.out.println("- Book: none \n");
                }
            }
        }

        if (!memberFound) {
            System.out.println("Member not found. \n");
        }
    }

    // Responsible for the Search Book logic
    public static void searchBook(List<Book> bookList, List<Member> memberList, Scanner scanner) {

        System.out.println("Enter the title of a book: \n");
        String bookTitle = scanner.nextLine();
        boolean bookFound = false;

        // Validate title is not empty
        if (bookTitle.isEmpty()) {
            System.out.println("Please enter a valid title.");
            return;
        }

        // Loop through the books that are in the bookList
        for (Book book : bookList) {
            // Filter for titles that match
            if (book.getTitle().toLowerCase().contains(bookTitle.trim().toLowerCase())) {
                bookFound = true;
                // Print the book information
                printBookInformation(book);

                // Search if a member has borrowed the book
                boolean memberFound = false;
                for (Member member : memberList) {
                    if (book.getBorrowedByMemberId() != null && book.getBorrowedByMemberId().equals(member.getId())) {
                        memberFound = true;
                        System.out.println(
                                "- Borrowed by member: " + member.getFirstName() + " " + member.getLastName() + "\n");
                    }
                }
                if (!memberFound) {
                    System.out.println("- Borrowed by member: none \n\n");
                }
            }
        }

        if (!bookFound) {
            System.out.println("Book not found. \n");
        }
    }

    public static void printBookInformation(Book book){
        System.out.println("Book Details:");
        System.out.println("\n- Id: " + book.getId());
        System.out.println("- ISBN: " + book.getIsbn());
        System.out.println("- Title: " + book.getTitle());
        System.out.println("- Author: " + book.getAuthor());
        System.out.println("- Publish date: " + book.getDateOfPublication());
        System.out.println("- Genre: " + book.getGenre());
        System.out.println("- Age rating: " + book.getAgeRating());
    }
}
