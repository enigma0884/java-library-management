package structures;

import core.Logger;

public class Librarian {

  public void issueBook(Book book, User user) {
    if (book.getIssuedTo() != null) {
      Logger.logError("Sorry, that book has already been borrowed");
      return;
    }

    if (user.books.size() >= 5) {
      Logger.logError("You cannot borrow any more books. Please return a book before borrowing a new one");
      return;
    }

    if (user.books.contains(book)) {
      Logger.logError("You have already borrowed that book");
      return;
    }

    user.addBook(book);
    book.setIssuedTo(user);
  }

  public void returnBook(Book book, User user) {
    if (book.getIssuedTo() != user) {
      Logger.logError("You haven't borrowed that book to return it back");
      return;
    }

    user.removeBook(book);
    book.setIssuedTo(null);
  }
}
