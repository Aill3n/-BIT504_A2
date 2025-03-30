/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

import java.util.List;
import java.util.Scanner;

public class BookMenu {
    final static String DOTTED_DIVIDER = "------------------------------------------------------------------------------------------------------------------------------------------";

    public static void displayAllBooks(List<Book> bookList) {
        bookHeader();

        for (Book book : bookList) {

            String bookId = TableUtil.formatTwoDigitColumnString(book.getId(), 2);
            String bookIsbn = TableUtil.formatTable(book.getIsbn(), 20);
            String bookTitle = TableUtil.formatTable(book.getTitle(), 26);
            String bookAuthor = TableUtil.formatTable(book.getAuthor(), 20);
            String bookGenre = TableUtil.formatTable(book.getGenre(), 19);
            String bookDateOfPublication = TableUtil.formatTable(book.getDateOfPublication(), 19);
            String bookAgeFormat = TableUtil.formatTwoDigitColumn(book.getAgeRating(), 2);
            String bookAgeRating = TableUtil.formatTable(String.valueOf(bookAgeFormat), 10);

            System.out.println(String.format(
                    "| %s | %s | %s | %s | %s | %s | %s |",
                    bookId,
                    bookIsbn,
                    bookTitle,
                    bookAuthor,
                    bookDateOfPublication,
                    bookGenre,
                    bookAgeRating));
        }
        System.out.println(DOTTED_DIVIDER);
    }

    public static void displayBorrowedBooks(List<Book> bookList) {
        System.out.println("Displaying all the borrowed books in the system.");

        List<Book> borrowedBooks = bookList.stream().filter(Book::isBorrowed).toList();

        if (borrowedBooks.isEmpty()) {
            System.out.println("However, no books have been borrewed yet.");
        } else {
            displayAllBooks(borrowedBooks);
        }

    }

    public static void displayUnborrowedBooks(List<Book> bookList) {
        System.out.println("Displaying all the unborrowed books in the system.");

        List<Book> borrowedBooks = bookList.stream().filter(book -> !book.isBorrowed()).toList();

        if (borrowedBooks.isEmpty()) {
            System.out.println("However, all the books are borrewed.");
        } else {
            displayAllBooks(borrowedBooks);
        }
    }

    public static void addNewBook(List<Book> bookList, Scanner scanner) {
        //TODO: Aillen add validations
        
        System.out.println("ADD A NEW BOOK MENU. \n");

        System.out.println("Please enter the book ID, it has to be unique:");
        String id = scanner.nextLine();

        System.out.println("Please enter the book ISBN:");
        String isbn = scanner.nextLine();

        System.err.println("Please enter the book title:");
        String title = scanner.nextLine();

        System.out.println("Please enter the book author:");
        String author = scanner.nextLine();

        System.out.println("Please enter the book date of publication:");
        String dateOfPublication = scanner.nextLine();

        System.out.println("Please enter the book genre:");
        String genre = scanner.nextLine();

        System.out.println("Please enter the book age rating:");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer for age rating.");
            scanner.next(); // Consume invalid input
        }

        int ageRating = scanner.nextInt();
        scanner.nextLine(); // Consume newline after integer input

        Book book = new Book(id, isbn, title, author, dateOfPublication, genre, ageRating);

        bookList.add(book);
        if (bookList.stream().anyMatch(b -> b.getId().trim().equals(id.trim()))) {
            System.out.println("\nThe book has been added successfully!");
        } else {
            System.out.println("Failed to add the book. Please try again.");
        }
    }

    public static void bookHeader() {
        String id =TableUtil.formatTable(" ID", 4);
        String isbn =TableUtil.formatTable(" ISBN", 22);
        String title =TableUtil.formatTable(" Title", 28);
        String author =TableUtil.formatTable(" Author", 22);
        String dateOfPublication =TableUtil.formatTable(" Date of Publication", 21);
        String genre =TableUtil.formatTable(" Genre", 21);
        String ageRating =TableUtil.formatTable(" Age Rating", 12);

        List<String> headers = List.of(id, isbn, title, author, dateOfPublication, genre, ageRating);

        String headerDivider = "|";
        System.out.println(DOTTED_DIVIDER);
        for (String header : headers) {
            System.out.print(headerDivider + header);
        }
        System.out.println(headerDivider + "\n" + DOTTED_DIVIDER);
    }
}
