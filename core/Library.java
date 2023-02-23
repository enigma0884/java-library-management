package core;

import java.util.ArrayList;
import java.util.Scanner;

import structures.Book;
import structures.Librarian;
import structures.User;

public class Library {

  private Scanner sc = new Scanner(System.in);
  private ArrayList<Book> books = new ArrayList<Book>();
  private ArrayList<User> users = new ArrayList<User>();
  private Librarian librarian = new Librarian();

  private User currentUser = null;

  public Library(String[] bookNames) {
    for (int i = 0; i < bookNames.length; i++) {
      books.add(new Book(bookNames[i]));
    }
  }

  public void init() {
    String choice;

    for (;;) {
      System.out.println();
      Logger.logMessage(
          "Select an option corresponding to the number",
          "1. Login",
          "2. Signup");

      choice = sc.nextLine();
      if (!choice.matches("[12]")) {
        Logger.logError("Invalid choice selected. Try again");
        continue;
      }

      Logger.logInfo("Enter the username");
      String username = sc.nextLine();

      Logger.logInfo("Enter the password");
      String pass = sc.nextLine();

      switch (choice) {
        case "1": {
          User user = this.login(username, pass);
          if (user == null) {
            Logger.logError("Invalid credentials provided. Try again");
            continue;
          }

          this.users.add(user);
          this.currentUser = user;
          break;
        }

        case "2": {
          User user = new User(username, pass);
          users.add(user);
          this.currentUser = user;
          break;
        }
      }

      Logger.logSuccess("Successfully logged in as " + currentUser.username);

      innerOne: for (;;) {
        System.out.println();
        Logger.logMessage(
            "1. Borrow a book",
            "2. Return a book",
            "3. List library books",
            "4. List borrowed books",
            "5. Logout");

        choice = sc.nextLine();
        if (!choice.matches("[1-5]")) {
          Logger.logError("Please enter a valid option");
          continue;
        }

        switch (choice) {
          case "1": {
            Logger.logInfo("Enter the name of the book you wish to borrow");
            choice = sc.nextLine();

            Book book = this.getBook(choice);
            if (book == null) {
              Logger.logError("That book does not exist in the library");
              continue;
            }

            librarian.issueBook(book, currentUser);
            break;
          }

          case "2": {
            Logger.logInfo("Enter the name of the book you wish to return");
            choice = sc.nextLine();

            Book book = this.getBook(choice);
            if (book == null) {
              Logger.logError("That book does not exist in the library");
              continue;
            }

            librarian.returnBook(book, currentUser);
            break;
          }

          case "3": {
            for (Book book : books) {
              if (book.getIssuedTo() != null) {
                Logger.logSuccess(book.name + " [Not Available]");
              }
              Logger.logSuccess(book.name);
            }
            break;
          }

          case "4": {
            currentUser.listBooks();
            break;
          }

          case "5": {
            break innerOne;
          }
        }
      }
    }
  }

  private User login(String username, String password) {
    return users.stream()
        .filter(u -> u.username.equals(username) && u.password.equals(password))
        .findFirst()
        .orElse(null);
  }

  private Book getBook(String name) {
    return this.books.stream()
        .filter(b -> b.name.equals(name))
        .findFirst()
        .orElse(null);
  }
}
