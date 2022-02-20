public class Food extends Product{
    String date;

    public Food(String name, int price, String date) {
        super(name, price);
        this.date = date;
    }
}
