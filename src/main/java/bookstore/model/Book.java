package bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private int isbn;
    private String author;
    private String title;
    private BookType type;


    public Book() {
    }

    public Book(int isbn, String author, String title, BookType type) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.type = type;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return isbn + "," + author + "," + title + "," + type;
    }
}
