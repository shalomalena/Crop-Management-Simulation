public class Resources {
    private String type;
    private int quantity;

    public Resources(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public void consume(int amount) {
        this.quantity -= amount;
    }

    public void add(int amount) {
        this.quantity += amount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getType() {
        return this.type;
    }
}
