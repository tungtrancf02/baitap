import java.util.Scanner;

public class Phong extends khoa {

    private int idphong;
    private String ten;
    private  int sogiuong;
    private  int sobennhnhan;
    public Phong(int idphong, String ten, int sogiuong, int sobennhnhan) {

        this.idphong = idphong;
        this.ten = ten;
        this.sogiuong = sogiuong;
        this.sobennhnhan = sobennhnhan;

    }

    public int getIdphong() {
        return idphong;
    }

    public String getTen() {
        return ten;
    }

    public int getSogiuong() {
        return sogiuong;
    }

    public int getSobennhnhan() {
        return sobennhnhan;
    }

    public void setIdphong(int idphong) {
        this.idphong = idphong;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSogiuong(int sogiuong) {
        this.sogiuong = sogiuong;
    }

    public void setSobennhnhan(int sobennhnhan) {
        this.sobennhnhan = sobennhnhan;
    }


    public void thembenhnhan(){
        if (sobennhnhan < sogiuong){
            sobennhnhan++;
            System.out.println("them ok");
        }
        else System.out.println("phong da day");
    }
    public void xoabenhnhan(){
        if (sobennhnhan > 0){

            sobennhnhan--;
            System.out.println("xoaben ok");
        }
        else System.out.println("ko co benh nhan");
    }

    @Override
    public String toString() {
        return "id phong "+idphong+"ten "+ ten+"sogiuong "+sogiuong+"sobennhnhan ";
    }



}
