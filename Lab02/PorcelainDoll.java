public class PorcelainDoll extends Doll {

    public PorcelainDoll(String name, String material, float price) {
        super(name, material, price);
    }

    public PorcelainDoll(String name, float price) {
        super(name, "Porcelain", price);
    }

    @Override
    public void play() {
        System.out.println("Porcelain Doll is delicate, be gentle!");
    }
}