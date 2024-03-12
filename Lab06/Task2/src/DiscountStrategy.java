public interface DiscountStrategy {
    double applayDiscount(double initPrice);
}

class PercentageDiscountStrategy implements DiscountStrategy {
    double percen;
    public PercentageDiscountStrategy(double percentage) {
        percen = 1 - (percentage * 0.01);
    }

    @Override
    public double applayDiscount(double initPrice) {
        return initPrice * percen;
    }
}

class FixedDiscountStrategy implements DiscountStrategy{
    double fixdis;

    public FixedDiscountStrategy(double fixamount) {
        fixdis = fixamount;
    }

    @Override
    public double applayDiscount(double initPrice) {
        return initPrice - fixdis;
    }


}

class SampleDiscountStrategy implements DiscountStrategy{
    double initPrice;
    public SampleDiscountStrategy(double initPrice) {
        this.initPrice = initPrice;
    }
    @Override
    public double applayDiscount(double initPrice) {
        return initPrice;
    }    


}
