/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

public class Book {
    
    private String id;
    private String isbn;
    private String title;
    private String author;
    private String dateOfPublication;
    private String genre;
    private int ageRating;
    private boolean isBorrowed;

    // Constructor
    public Book(String id, String isbn, String title, String author, String dateOfPublication, String genre,
            int ageRating) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
        this.genre = genre;
        this.ageRating = ageRating;
        this.isBorrowed = false;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDateOfPublication() {
        return dateOfPublication;
    }
    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getAgeRating() {
        return ageRating;
    }
    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }


    // Functions
      /*
    private void addNewBook(){
    User can add a new book successfully. 
    Validation is performed. 
    ID and ISBN must be unique.
    Warnings are correctly displayed.
    Good programming practices  and standards have been followed throughout the code.
    }
    */
    
}
