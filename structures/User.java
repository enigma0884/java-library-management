package structures;

import java.util.ArrayList;
import core.Logger;

public class User {
  public final String username;
  public final String password;
  public final ArrayList<Book> books = new ArrayList<Book>();

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void addBook(Book book) {
    this.books.add(book);
    Logger.logSuccess(book.name + " added to your list of borrowed books");
  }

  public void removeBook(Book book) {
    this.books.remove(book);
    Logger.logSuccess(book.name + " removed from your list of borrowed books");
  }

  public void listBooks() {
    books.forEach(b -> {
      Logger.logSuccess(b.name);
    });
  }
}
