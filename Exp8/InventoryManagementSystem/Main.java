import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // Get Singleton instance
        InventoryManager manager = InventoryManager.getInstance();

        // Add New Products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Smartphone"));

        // Add Legacy Products using Adapter
        LegacyItem old1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem old2 = new LegacyItem(102, "Old Monitor");

        manager.addProduct(new ProductAdapter(old1));
        manager.addProduct(new ProductAdapter(old2));

        // Iterate using Iterator
        Iterator<Product> iterator = manager.returnInventory();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            p.displayDetails();
        }
    }
}