package src.day13_3;
import java.util.concurrent.Semaphore;
public class fivetrietgia extends Thread {
    private int id;
    private Semaphore duatrai, duaphai;// semaphore dung de dam bao moi nguoi dung dua mot thoi diem nhat dinh

    public fivetrietgia(int id, Semaphore leftchiostick, Semaphore rightchiostick) {
        this.id = id;
        this.duatrai = duatrai;
        this.duaphai = duaphai;
    }

    private void nghi() {
        System.out.println("triet gia " + id + "dang nghi");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
