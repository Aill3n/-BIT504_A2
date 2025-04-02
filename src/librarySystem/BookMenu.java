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
        // Print all the books
        for (Book book : bookList) {

            // Set a length for the column
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

        // Filters for only books that have been borrowed
        List<Book> borrowedBooks = bookList.stream().filter(Book::isBorrowed).toList();

        if (borrowedBooks.isEmpty()) {
            System.out.println("However, no books have been borrewed yet.");
        } else {
            displayAllBooks(borrowedBooks);
        }

    }

    public static void displayUnborrowedBooks(List<Book> bookList) {

        // Filters for books that have not been borrowed
        List<Book> borrowedBooks = bookList.stream().filter(book -> !book.isBorrowed()).toList();

        if (borrowedBooks.isEmpty()) {
            System.out.println("However, all the books are borrewed.");
        } else {
            displayAllBooks(borrowedBooks);
        }
    }

    public static void addNewBook(List<Book> bookList, Scanner scanner) {
            // Book ID
            System.out.println("Please enter the book ID, it has to be unique:");
            String id = scanner.nextLine();
            validateId(id, scanner, bookList);

            // ISBN
            System.out.println("Please enter the book ISBN:");
            String isbn = scanner.nextLine().trim();
            isbnValidation(isbn, scanner, bookList);

            // Title
            System.out.println("Please enter the book title:");
            String title = scanner.nextLine().trim();
            MemberMenu.validateBlankField(title, scanner);

            // Author
            System.out.println("Please enter the book author:");
            String author = scanner.nextLine().trim();
            MemberMenu.validateBlankField(author, scanner);

            // Date of Publication
            System.out.println("Please enter the book date of publication:");
            String dateOfPublication = scanner.nextLine().trim();
            MemberMenu.validateBlankField(dateOfPublication, scanner);

            // Genre
            System.out.println("Please enter the book genre:");
            String genre = scanner.nextLine().trim();
            MemberMenu.validateBlankField(genre, scanner);

            // Age rating
            System.out.println("Please enter the book age rating:");
            String age = scanner.nextLine().trim();
            int treatedAge = MemberMenu.ageRangeValidation(age, scanner);

            // Create book object with given input
            Book book = new Book(id, isbn, title, author, dateOfPublication, genre, treatedAge);

            // Add book to the end of the list
            bookList.add(book);

            // Confirm book has been added
            if (bookList.get(bookList.size() - 1).getId().trim().equals(id.trim())) {
                System.out.println("\nThe book has been added successfully!");
            } else {
                System.out.println("Failed to add the book. Please try again.");
            }
    }

    public static void bookHeader() {
        // Print the header for the book table with set sizes
        String id = TableUtil.formatTable(" ID", 4);
        String isbn = TableUtil.formatTable(" ISBN", 22);
        String title = TableUtil.formatTable(" Title", 28);
        String author = TableUtil.formatTable(" Author", 22);
        String dateOfPublication = TableUtil.formatTable(" Date of Publication", 21);
        String genre = TableUtil.formatTable(" Genre", 21);
        String ageRating = TableUtil.formatTable(" Age Rating", 12);

        List<String> headers = List.of(id, isbn, title, author, dateOfPublication, genre, ageRating);

        String headerDivider = "|";
        System.out.println(DOTTED_DIVIDER);

        // Print the header with the dividers
        for (String header : headers) {
            System.out.print(headerDivider + header);
        }
        System.out.println(headerDivider + "\n" + DOTTED_DIVIDER);
    }

    public static void validateId(String id, Scanner scanner, List<Book> bookList) {
        while (true) {
            if (id.isBlank()) {
                System.out.println("ID cannot be blank. Please enter a valid ID:");
                id = scanner.nextLine();
                continue;
            }

            boolean isUnique = true;
            for (Book book : bookList) {
                if (id.equals(book.getId())) {
                    System.out.println("ID must be unique. Please enter a different ID:");
                    id = scanner.nextLine();
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                break;
            }
        }
    }

    public static void isbnValidation(String isbn, Scanner scanner, List<Book> bookList) {
        while (true) {
            boolean isUnique = true;

            for (Book book : bookList) {
                if (isbn.equals(book.getIsbn())) {
                    System.out.println("ISBN has to be unique.");
                    isbn = scanner.nextLine();
                    isUnique = false;
                    break;
                }
            }

            if (isbn.length() != 10) {
                System.out.println("ISBN should contain exactly 10 characters. Please enter a valid ISBN:");
                isbn = scanner.nextLine();
                continue;
            }

            if (isUnique) {
                break;
            }
        }
    }
}
