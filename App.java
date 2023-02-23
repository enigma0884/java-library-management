import core.Library;

public class App {
  public static void main(String[] args) {
    String[] bookNames = {
        "Hardy Boys",
        "The Hunger Games",
        "Feluda",
        "The Diary of a Wimpy Kid",
        "Matched",
        "Long Way Down",
        "The Giver",
        "Thirteen Reasons Why",
        "Five Feet Apart",
        "Half Girlfriend",
        "Twilight",
        "Eleanor & Park",
        "Every Body Looking",
        "Little Women",
        "Before I Fall",
        "Uglies",
        "The Truth About Forever",
        "Looking for Alaska",
        "The Book Thief",
        "Lord of the Flies"
    };

    new Library(bookNames).init();
  }
}
