package structures;

public class Librarian extends User {

  Librarian(String username, String password) {
    super(username, password);
  }

  public void issueBook(Book book, User user) {
    if (book.getIssuedTo() != null) {
      System.out.println("Sorry, that book has already been borrowed");
      return;
    }

    if (user.books.size() >= 5) {
      System.out.println("You cannot borrow any more books. Please return a book before borrowing a new one");
      return;
    }

    if (user.books.contains(book)) {
      System.out.println("You have already borrowed that book");
      return;
    }

    user.addBook(book);
  }

  public void returnBook(Book book, User user) {
    if (book.getIssuedTo() != user) {
      System.out.println("You haven't borrowed that book to return it back");
      return;
    }

    user.removeBook(book);
  }

  public void listAllBooks(Book[] books) {
    for (Book book : books) {
      System.out.println("- " + book.name);
    }
  }

  public void listBorrowedBooks(Book[] books) {
    for (Book book : books) {
      if (book.getIssuedTo() != null)
        System.out.println("Book: " + book.name + "\n" + "Issued To: " + book.getIssuedTo().username);
    }
  }
}
