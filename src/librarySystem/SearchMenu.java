package librarySystem;

import java.util.List;
import java.util.Scanner;

public class SearchMenu {

    public static void searchMember(List<Member> memberList, List<Book> bookList, Scanner scanner) {
        System.out.println("Enter a member's last name: \n");
        String lastName = scanner.nextLine();
        boolean memberFound = false;

        if (lastName.isEmpty()) {
            System.out.println("Please enter a valid last name.");
            return;
        }

        for (Member member : memberList) {
            if (member.getLastName().toLowerCase().contains(lastName.trim().toLowerCase())) {
                memberFound = true;
                System.out.println("Member Details:");
                System.out.println("\n- First name: " + member.getFirstName());
                System.out.println("- Last name: " + member.getLastName());
                System.out.println("- Age: " + member.getAge());

                boolean bookFound = false; // Reset bookFound for each member
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

    public static void searchBook(List<Book> bookList, List<Member> memberList, Scanner scanner) {

        System.out.println("Enter the title of a book: \n");
        String bookTitle = scanner.nextLine();
        boolean bookFound = false;

        if (bookTitle.isEmpty()) {
            System.out.println("Please enter a valid title.");
            return;
        }

        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(bookTitle.trim().toLowerCase())) {
                bookFound = true;
                printBookInformation(book);
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
