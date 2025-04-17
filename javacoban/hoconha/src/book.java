public class book {
    private String title;
    private String author;
    private int price;
    public String getTitle(String title) {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;

    }
    public String getAuthor(String author) {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void applyDiscount(double phamtram) {
        if (phamtram<0||phamtram>100) {
            return;
        }
        double giam;
        giam= (price * phamtram)/100;
        price-=giam;
    }


    public static void main(String[] args) {

        book book = new book();

        book.setAuthor("java programming");
        book.setTitle("djvkx");
        book.setPrice(100);
        System.out.println(book.title);


    }

}
