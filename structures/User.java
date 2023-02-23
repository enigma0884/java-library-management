package structures;

import java.util.ArrayList;

public class User {
  public final String username;
  public final String password;
  public final ArrayList<Book> books = new ArrayList<Book>();

  User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void addBook(Book book) {
    this.books.add(book);
    System.out.println(book.name + " added to your list of borrowed books");
  }

  public void removeBook(Book book) {
    this.books.remove(book);
    System.out.println(book.name + " removed from your list of borrowed books");
  }

  public void listBooks() {
    books.forEach(b -> {
      System.out.println("- " + b.name);
    });
  }
}
