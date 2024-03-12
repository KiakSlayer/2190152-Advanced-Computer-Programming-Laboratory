import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public List<String> shopingList = new ArrayList<>(); 
    public ShoppingCart cart; 
    public DiscountByPercentDecorator discountByPercent;
    public DiscountByAmountDecorator discountByAmount;
    public FreeDeliveryDecorator freeDeliveryDecorator;
    public double deliveryFee = 0.0;
    public double totalPrice = 0.0;
    public double netPrice = 0.0;

    public void addItem(String newItem){
        shopingList.add(newItem);
    }

    public void addDeliveryFee(int Fee){
        deliveryFee += Fee;
    }

    public void isFeeApplied(){
        if(freeDeliveryDecorator != null) deliveryFee = 0;
    }

    public double calculateTotal(){
        double sum = 0;
        for (String item : shopingList) {
            String[] part = item.split(":");
            sum += Double.parseDouble(part[1]) * Double.parseDouble(part[2]);
        }
        totalPrice = sum;
        return sum;
    }
    
    public double getNetPrice(){
        SetNet();
        isFeeApplied();
        return netPrice + deliveryFee;
    }

    public void SetNet(){ 
        if(netPrice==0){
            calculateTotal();
            netPrice = totalPrice;
        }
    }

    public void SuperCart(){
        shopingList = cart.shopingList;
        discountByPercent = cart.discountByPercent;
        discountByAmount = cart.discountByAmount;
        freeDeliveryDecorator = cart.freeDeliveryDecorator;
        deliveryFee = cart.deliveryFee;
        totalPrice = cart.totalPrice;
        netPrice = cart.netPrice;
    }
}

class DiscountByPercentDecorator extends ShoppingCart {
    public double Percent;

    public DiscountByPercentDecorator(ShoppingCart cart, double Percent) {
        this.cart = cart;
        cart.SetNet();
        SuperCart();
        if (discountByPercent == null) {
            this.Percent = Percent;
            discountByPercent = this;
            netPrice = netPrice * (100 - Percent) / 100;
        }
    }

}

class DiscountByAmountDecorator extends ShoppingCart {// same as Percent Coupon just change to Amount coupon.
    public double Amount;

    public DiscountByAmountDecorator(ShoppingCart cart, double Amount) {
        this.cart = cart;
        cart.SetNet();
        SuperCart();
        if (discountByPercent == null) {
            this.Amount = Amount;
            discountByAmount = this;
            netPrice = netPrice - Amount;
        }
    }
}

class FreeDeliveryDecorator extends ShoppingCart {// use with isFeeApplie method in super class.
    public FreeDeliveryDecorator(ShoppingCart cart) {
        this.cart = cart;
        cart.freeDeliveryDecorator = this;
        cart.SetNet();
        SuperCart();

    }
}
