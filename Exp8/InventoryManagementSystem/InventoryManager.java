import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryManager {

    private static InventoryManager instance; // Singleton instance
    private List<Product> products;

    // Private constructor
    private InventoryManager() {
        products = new ArrayList<>();
    }

    // Singleton method
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Add product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Return iterator
    public Iterator<Product> returnInventory() {
        return products.iterator();
    }
}