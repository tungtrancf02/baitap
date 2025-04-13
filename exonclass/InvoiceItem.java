package exonclass;

public class InvoiceItem {
    private String id;
    private String des;
    private int qty;
    private double price;
    public InvoiceItem(String id, String des, int qty, double price) {
        this.id = id;
        this.des = des;
        this.qty = qty;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDes() {
        return des;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getTotal() {
        return price * qty;
    }
    public String toString() {
        return "InvoiceItem [id=" + id + ", des=" + des + ", qty=" + qty + " price="+price+"]";
    }
    public static class TestMain {
        public static void main(String[] args) {
            // Test constructor and toString()
            InvoiceItem inv1 = new InvoiceItem("A101", "Pen Red", 888, 0.08);
            System.out.println(inv1);  // toString();

            // Test Setters and Getters
            inv1.setQty(999);
            inv1.setPrice(0.99);
            System.out.println(inv1);  // toString();
            System.out.println("id is: " + inv1.getId());
            System.out.println("desc is: " + inv1.getDes());
            System.out.println("qty is: " + inv1.getQty());
            System.out.println("unitPrice is: " + inv1.getPrice());

            // Test getTotal()
            System.out.println("The total is: " + inv1.getTotal());
        }
    }
}
