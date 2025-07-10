import java.util.*;

class Book {
    int id;
    String title;
    boolean isAvailable;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }
}

public class LibraryManagementSystem {
    static List<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample books
        books.add(new Book(1, "Java Basics"));
        books.add(new Book(2, "Data Structures"));
        books.add(new Book(3, "Operating Systems"));

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Exiting system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    static void viewBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.id + ", Title: " + book.title + ", Available: " + book.isAvailable);
        }
    }

    static void borrowBook() {
        System.out.print("Enter Book ID to borrow: ");
        int id = sc.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Sorry, the book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (!book.isAvailable) {
                    book.isAvailable = true;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("This book wasn't borrowed.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }
}
