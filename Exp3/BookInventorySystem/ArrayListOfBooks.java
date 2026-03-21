import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        ArrayList<Book> alb = new ArrayList<>();

        try {
            alb.add(new Book("Psychology of Money", "Morgan Housel", "Personal finance", "978-9390166268", 400));
            alb.add(new Book("Atomic Habits", "James Clear", "Personal development", "978-1847941831", 500));

            // This will throw exception
            alb.add(new Book("Rich Dad Poor Dad", "Robert T. Kiyosaki", -510));

            alb.add(new Book("War and Peace", "Leo Tolstoy", 810));
            alb.add(new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", 710));

        } catch (InvalidPriceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nBook details from the ArrayList:\n");

        for (Book b : alb) {
            System.out.println("Title  : " + b.getTitle());
            System.out.println("Author : " + b.getAuthor());
            System.out.println("Price  : " + b.getPrice());
            System.out.println("ISBN   : " + b.getISBN());
            System.out.println("Genre  : " + b.getGenre());
            System.out.println("---------------------------");
        }

        // Filter books by genre
        String searchGenre = "Personal finance";

        System.out.println("\nBooks in Genre: " + searchGenre + "\n");

        for (Book b : alb) {
            if (b.getGenre().equalsIgnoreCase(searchGenre)) {
                System.out.println("Title  : " + b.getTitle());
                System.out.println("Author : " + b.getAuthor());
                System.out.println("Price  : " + b.getPrice());
                System.out.println("---------------------------");
            }
        }

        // Calculate average price
        double totalPrice = 0;

        for (Book b : alb) {
            totalPrice += b.getPrice();
        }

        if (!alb.isEmpty()) {
            double averagePrice = totalPrice / alb.size();
            System.out.println("\nAverage price of books: " + averagePrice);
        }
    }
}