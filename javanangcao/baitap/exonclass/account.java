package exonclass;

public class account {
    private String id;
    private String name;
    private int balance;
    public account(String id, String name) {
        this.id = id;
        this.name = name;
        balance = 0;
    }
    public account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
    public int credit(int amount) {
        balance += amount;
        return balance;
    }
    public int debit(int amount) {
        if(amount > balance)
            balance -= amount;
        return balance;
    }
    public int transferTo(account a2, int amount) {
        balance += amount;
        return balance;

    }
    public String toString() {
        return "taikhoan["+id+","+name+","+balance+"]";
    }
    public static class TestMain {
        public static void main(String[] args) {
            // Test constructor and toString()
            account a1 = new account("A101", "Tan Ah Teck", 88);
            System.out.println(a1);  // toString();
            account a2 = new account("A102", "Kumar"); // default balance
            System.out.println(a2);

            // Test Getters
            System.out.println("ID: " + a1.getId());
            System.out.println("Name: " + a1.getName());
            System.out.println("Balance: " + a1.getBalance());

            // Test credit() and debit()
            a1.credit(100);
            System.out.println(a1);
            a1.debit(50);
            System.out.println(a1);
            a1.debit(500);  // debit() error
            System.out.println(a1);

            // Test transfer()
            a1.transferTo(a2, 100);  // toString()
            System.out.println(a1);
            System.out.println(a2);
        }
    }

}
