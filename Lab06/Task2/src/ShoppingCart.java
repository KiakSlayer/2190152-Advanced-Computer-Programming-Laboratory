public class ShoppingCart {
    private Item[] items;
    DiscountStrategy discountStrategy;
    public ShoppingCart() {
        items = new Item[0];
        discountStrategy = new SampleDiscountStrategy(); // Default strategy
    }

    public void addItem(Item item) {
        // Extend the array to accommodate the new item
        Item[] newItems = new Item[items.length + 1];
        for(int i=0; i < items.length; i++)
            newItems[i] = items[i];
        newItems[items.length] = item;
        items = newItems;
    }

    public void SetStrategy(DiscountStrategy dis) {
        discountStrategy = dis;
    }

    public void calculateTotal() {
        double totalPrice = 0;
        for(int i = 0; i < items.length; i++) {
            totalPrice += items[i].getQuantity() * items[i].getPrice(); 
        }
        double discountPrice = discountStrategy.applayDiscount(totalPrice);
        System.out.println(discountPrice);
    }
}

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}