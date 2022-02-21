import java.util.ArrayList;

public class History {
    private final ArrayList<Product> payment = new ArrayList<>();

    public ArrayList<Product> getPayment() { return payment; }

    public void setPayment(Product payment) { this.payment.add(payment); }
}
