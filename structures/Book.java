package structures;

public class Book {
  public final String name;
  private User issuedTo = null;

  Book(String name) {
    this.name = name;
  }

  public User getIssuedTo() {
    return issuedTo;
  }

  public void setIssuedTo(User issuedTo) {
    this.issuedTo = issuedTo;
  }
}
