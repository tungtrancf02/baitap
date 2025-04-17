import java.util.ArrayList;
import java.util.Scanner;
public class Quanlysieuthi {
    private String Tenhang;
    private int soluongconlai;

    public Quanlysieuthi(String Tenhang, int soluongconlai) {
        this.Tenhang = Tenhang;
        this.soluongconlai = soluongconlai;
    }




    public String getTenhang() {
        return Tenhang;
    }

    public int getSoluongconlai() {
        return soluongconlai;
    }

    public void setTenhang(String tenhang) {
        Tenhang = tenhang;
    }

    public void setSoluongconlai(int soluongconlai) {
        this.soluongconlai = soluongconlai;
    }

    @Override
    public String toString() {
        return "Tên sản phẩm: " + Tenhang + ", Số lượng còn lại: " + soluongconlai;
    }


    public static void main(String[] args) {
        ArrayList<Quanlysieuthi> arrayList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("sieu thị:");
        System.out.println("nhap so luong san PHAM");
        int so = sc.nextInt();
        for (int i = 0; i < so; i++) {
            System.out.println("ten hang:" + (i + 1));
            String Tenhang = sc.next();
            System.out.println("so luong conlai cua" + (i + 1));
            int soluongconlai = sc.nextInt();

            Quanlysieuthi sp = new Quanlysieuthi(Tenhang, soluongconlai);
            arrayList.add(sp);
        }
        System.out.println("Danh sách sản phẩm:");
        for (Quanlysieuthi a : arrayList) {
            System.out.println(a);


        }
        System.out.println("tong so hàng con lai là");
        int tongSoLuong = 0;
        for (Quanlysieuthi a : arrayList) {
            if (a.getSoluongconlai()>10) {
                tongSoLuong +=a.getSoluongconlai();
            }


        }
        System.out.println( tongSoLuong );
    }
}
















