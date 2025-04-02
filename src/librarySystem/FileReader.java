/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    // Singleton Design Pattern applied
    private static FileReader instance;
    
    private FileReader() {}

    public static FileReader getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    final static String BOOK_FILE_PATH = "src/Books.txt";
    final static String MEMBER_FILE_PATH = "src/Members.txt";

    public List<Book> readBookFile() throws Exception {

        List<Book> bookList = new ArrayList<>();
        File file = new File(BOOK_FILE_PATH);

        try (Scanner sc = new Scanner(file)) {
            // Split items separated by a comma, add them to the bookList
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] bookData = line.split(",");
                String id = bookData[0].trim();
                String isbn = bookData[1].trim();
                String title = bookData[2].trim();
                String author = bookData[3].trim();
                String dateOfPublication = bookData[4].trim();
                String genre = bookData[5].trim();
                int ageRating = Integer.parseInt(bookData[6].trim());

                // Create book objects
                Book book = new Book(id, isbn, title, author, dateOfPublication, genre, ageRating);

                // Add the items to the List 
                bookList.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return bookList;
    }

    public List<Member> readMemberFile() throws FileNotFoundException {

        List<Member> memberList = new ArrayList<>();
        File file = new File(MEMBER_FILE_PATH);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] memberData = line.split(",");
                String id = memberData[0].trim();
                String firstName = memberData[1].trim();
                String lastName = memberData[2].trim();
                int age = Integer.parseInt(memberData[3].trim());

                // Create member objects
                Member member = new Member(id, firstName, lastName, age);

                // Add members to the list
                memberList.add(member);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return memberList;
    }
}
