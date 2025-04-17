import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.tgem khoa");
            System.out.println("2.them phòng");
            System.out.println("3.them bac si");
            System.out.println("4.them benh nhan");
            System.out.println("5.hien thi ds khoa");
            System.out.println("6.hien thi ds phong");
            System.out.println("0.exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    QuanLy.themkhoa();
                    break;
                case 2:
                    QuanLy.themphong();
                    break;
                case 3:
                    QuanLy.thembacSi();
                    break;
                case 4:
                    QuanLy.thembenhbhan();
                    break;
                case 5:
                    QuanLy.hienthikhoa();
                    break;
                case 6:
                    QuanLy.hienthiphong();
                    break;
                case 0:
                    System.out.println("thoat");
                    break;
                default:
                    System.out.println("ko dc!");
            }
        } while (choice != 0);
    }
}