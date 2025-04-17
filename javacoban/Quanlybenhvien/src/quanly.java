import java.util.ArrayList;
import java.util.Scanner;

class QuanLy {
    private static ArrayList<khoa> danhSachKhoa = new ArrayList<>();
    private static ArrayList<Phong> danhSachPhong = new ArrayList<>();


    public static void themkhoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap id khoa: ");
        String id = sc.nextLine();
        System.out.print("ten khoa: ");
        String ten = sc.nextLine();
        System.out.println("bac si");
        String tenbacsi = sc.nextLine();

        khoa khoa = new khoa(id,ten, tenbacsi);
        danhSachKhoa.add(khoa);

    }


    public static void thembacSi() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap id phogn: ");
        String idKhoa = sc.nextLine();
        for (khoa k : danhSachKhoa) {
            if (k.getID().equals(idKhoa)) {
                System.out.print("tenbac si: ");
                String tenBacSi = sc.nextLine();
                k.themBacSi(tenBacSi);
            }}
    }


    public static void themphong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhapid phong: ");
        int idPhong = sc.nextInt();
        System.out.print("nhap ten phong: ");
        String tenPhong = sc.nextLine();
        System.out.print("nhap so giuong: ");
        int soGiuong = sc.nextInt();
        System.out.print("nhap so benh nhan: ");
        int soBenhNhan = sc.nextInt();
        Phong phong = new Phong(idPhong, tenPhong, soGiuong, soBenhNhan);
        danhSachPhong.add(phong);

    }


    public static void thembenhbhan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap id phong: ");
        int idPhong = sc.nextInt();
        for (Phong phong : danhSachPhong) {
            if (phong.getIdphong() == idPhong) {
                phong.thembenhnhan();
            }
        }

    }



    public static void hienthikhoa() {
        System.out.println("ds khoa");

        for (khoa k : danhSachKhoa) {
            System.out.println(k);
        }
    }
    public static void hienthiphong() {
        System.out.println("ds phogn");
        for (Phong p : danhSachPhong) {
            System.out.println(p);
        }
    }
}