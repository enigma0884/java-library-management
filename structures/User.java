package structures;

import java.util.ArrayList;

import core.AccessLevel;

public class User {
    public final String username;
    public final String password;
    public final ArrayList<Book> books = new ArrayList<Book>();
    public final AccessLevel level;

    User(String username, String password, AccessLevel level) {
        this.username = username;
        this.password = password;
        this.level = level;
    }

    public void addBook(Book book) {
        if (this.books.contains(book))
            return;
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (!this.books.contains(book))
            return;
        this.books.remove(book);
    }
}
