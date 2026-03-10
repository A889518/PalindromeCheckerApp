import java.util.*;

class FlashSaleInventoryManager {

    HashMap<String, Integer> inventory = new HashMap<>();
  
    LinkedHashMap<Integer, String> waitingList = new LinkedHashMap<>();

    public void addProduct(String productId, int stock) {
        inventory.put(productId, stock);
    }

    public void checkStock(String productId) {
        if (inventory.containsKey(productId)) {
            System.out.println("checkStock(\"" + productId + "\") → "
                    + inventory.get(productId) + " units available");
        } else {
            System.out.println("Product not found");
        }
    }

    public synchronized void purchaseItem(String productId, int userId) {

        if (!inventory.containsKey(productId)) {
            System.out.println("Product not available");
            return;
        }

        int stock = inventory.get(productId);

        if (stock > 0) {
            stock--;
            inventory.put(productId, stock);

            System.out.println("purchaseItem(\"" + productId + "\", userId=" + userId +
                    ") → Success, " + stock + " units remaining");
        } else {
            waitingList.put(userId, productId);
            System.out.println("purchaseItem(\"" + productId + "\", userId=" + userId +
                    ") → Out of stock, added to waiting list");
        }
    }

    // Display waiting list
    public void showWaitingList() {
        System.out.println("Waiting List: " + waitingList);
    }
}

public class FlashSaleInventoryManager {

    public static void main(String[] args) {

        FlashSaleInventoryManager manager = new FlashSaleInventoryManager();

        manager.addProduct("IPHONE15_256GB", 100);
      
        manager.checkStock("IPHONE15_256GB");

        manager.purchaseItem("IPHONE15_256GB", 12345);
        manager.purchaseItem("IPHONE15_256GB", 67890);

        // Reduce stock quickly
        for (int i = 0; i < 98; i++) {
            manager.purchaseItem("IPHONE15_256GB", 10000 + i);
        }
      
        manager.purchaseItem("IPHONE15_256GB", 99999);

        manager.showWaitingList();
    }
}
