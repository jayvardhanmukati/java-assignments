public class Book {
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private double price;

    // Full constructor
    public Book(String title, String author, String genre, String ISBN, double price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative");
        }

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.price = price;
    }

    // Limited constructor
    public Book(String title, String author, double price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative");
        }

        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = "Unknown";
        this.ISBN = "Not Available";
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }
}
