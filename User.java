import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private List<String> borrowedIsbns;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedIsbns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getBorrowedIsbns() {
        return borrowedIsbns;
    }

    public void borrowBook(String isbn) {
        borrowedIsbns.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedIsbns.remove(isbn);
    }

    @Override
    public String toString() {
        return "User: " + name + " (ID: " + userId + ")";
    }
}

