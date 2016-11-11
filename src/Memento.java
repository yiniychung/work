import Portfolio.Security;

/**
 * Created by nanasemaru on 3/11/2016.
 */
public class Memento {
    private Security security;
    private int quantity;

    public Memento(Security security) {
        this.security = security;
        this.quantity = security.getQuantity();
    }
//    public int getQuantity() {
//        return quantity;
//    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public void restore() {
        security.setQuantity(quantity);
    }
}
