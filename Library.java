import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Register a new user
    public void registerUser(User user) {
        users.add(user);
    }

    // Find book by ISBN
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Find user by ID
    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equalsIgnoreCase(userId)) {
                return user;
            }
        }
        return null;
    }

    // Borrow a book
    public boolean borrowBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user != null && book != null && !book.isBorrowed()) {
            book.borrow();
            user.borrowBook(isbn);
            return true;
        }
        return false;
    }

    // Return a book
    public boolean returnBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user != null && book != null && book.isBorrowed()) {
            book.returnBook();
            user.returnBook(isbn);
            return true;
        }
        return false;
    }

    // Show all books
    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Show all users
    public void listAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    // Preload books from your list
    public void preloadBooks() {
        addBook(new Book("Pride and Prejudice", "Jane Austen, Anna Quindlen", "9780679783268"));
        addBook(new Book("1984", "George Orwell", "1443434973"));
        addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", "0486415872"));
        addBook(new Book("The Housemaid", "Freida McFadden", "1538742578"));
        addBook(new Book("The Nightingale", "St. Martin's Griffin", "1250080401"));
        addBook(new Book("Every Summer After", "Berkley", "0593438531"));
        addBook(new Book("The Teacher", "Freida McFadden", "1728296218"));
        addBook(new Book("The Midnight Library", "Penguin Books", "0525559493"));
        addBook(new Book("We Were the Lucky Ones", "Georgia Hunter", "0399563091"));
        addBook(new Book("Amara: The Rise of the Shadow", "Gary Fikes, Eric Fikes", "9798985565188"));
        addBook(new Book("Son of Anger", "Donovan Cook", "9781838300807"));
        addBook(new Book("Woden's Spear", "Donovan Cook", "9781836563297"));
        addBook(new Book("Men of Iron", "MJ Porter", "9781836174981"));
        addBook(new Book("The Viking", "Peter Gibbons", "B0DZZ2PK6D"));
        addBook(new Book("Dragon Rock", "Griff Hosker", "B0DZXV3RT9"));
        addBook(new Book("Raid of the Wolves", "Donovan Cook", "9781838300838"));
        addBook(new Book("The Rose and the Crane", "Clint Dohmen", "9780692930649"));
        addBook(new Book("The Threads Remain", "Glenn Shapiro", "9798998501524"));
        addBook(new Book("Revolutionary", "Eric Craft", "B0FGVXHPPC"));
        addBook(new Book("EpiEthic: The dilemma of freedom", "Nicola Maggi", "B0FFZSKVJ8"));
    }
}

