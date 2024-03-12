public class TeddyDoll extends Doll {
    
    public TeddyDoll(String name, String material, float price) {
        super(name, material, price);
    }

    public TeddyDoll(String name, float price) {
        super(name, "Fabric", price);
    }

    @Override
    public void play() {
        System.out.println("Teddy Doll says: Hug me!");
    }

}
