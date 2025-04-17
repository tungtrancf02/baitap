
import java.util.Scanner;
import java.util.HashSet;
public class lab6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so hoc sinh");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] students = new String[n][3]; // Tạo mảng 2D để lưu trữ thông tin
        HashSet<String> sbdset = new HashSet<>();//tạo kiểm tra sbd khong trùng
        int i;
        for (i = 0; i < n; i++) {


            System.out.println(" nhap thong tin hocj sinh " + (i + 1) + ": ");
            System.out.println("nhap ten hocj sinh : ");
            students[i][0] = sc.nextLine();

            String sbd;
            while (true) {
                sbd = sc.nextLine();
                System.out.print("nhap so bao danh: ");
                if (sbd.isEmpty() || sbdset.contains(sbd)) {
                    System.out.println("vui long nhap lai");
                } else {
                    sbdset.add(sbd);
                    students[i][1] = sbd;
                    break;
                }
            }
            System.out.println("nhap diem java cua hoc sinh: ");

            students[i][2] =sc.nextLine();


        }
        System.out.println("thong tin sinh viên:");
        System.out.println(" ------------------------------------------------------------");
        System.out.println(" số báo danh" + "        " + " tên          " + " điểm java");
        System.out.println("----------------------------------------------------------------");
        for (i = 0; i < n; i++) {

            System.out.println(students[i][1] + "                 " + students[i][0] + "               " + students[i][2]);

        }
        String max=students[0][2];
        for (i = 0; i < n; i++) {
             if(students[i][2].compareTo(max)>0) {
                 max = students[i][2];
             }

        }
        System.out.println("diem cao nhat la "+max);
    }


    }







