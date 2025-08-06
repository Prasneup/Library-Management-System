import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.preloadBooks();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("📚 Welcome to the Library Management System");

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register new user");
            System.out.println("2. List all books");
            System.out.println("3. List all users");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String id = scanner.nextLine();
                    library.registerUser(new User(name, id));
                    System.out.println("✅ User registered.");
                    break;

                case "2":
                    System.out.println("📚 Book List:");
                    library.listAllBooks();
                    break;

                case "3":
                    System.out.println("👥 User List:");
                    library.listAllUsers();
                    break;

                case "4":
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    if (library.borrowBook(userId, isbn)) {
                        System.out.println("📖 Book borrowed successfully.");
                    } else {
                        System.out.println("⚠️ Could not borrow book.");
                    }
                    break;

                case "5":
                    System.out.print("Enter user ID: ");
                    String returnUserId = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    if (library.returnBook(returnUserId, returnIsbn)) {
                        System.out.println("✅ Book returned successfully.");
                    } else {
                        System.out.println("⚠️ Could not return book.");
                    }
                    break;

                case "6":
                    running = false;
                    System.out.println("👋 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

