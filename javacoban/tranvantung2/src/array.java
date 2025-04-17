

import java.util.ArrayList;
import java.util.Scanner;

class students_arrlist {
    private String ten;
    private String id;
    private int diem;

    public students_arrlist(String ten, String id, int tuoi) {
        this.ten = ten;
        this.id = id;
        this.diem = diem;
    }

    public String getTen() {
        return ten;
    }

    public String getTuoi() {
        return id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTuoi(int tuoi) {
        this.id = id;

    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }


    @Override
    public String toString() {
        return "thong tin:" + "ten=" + ten + ", id=" + id ;
    }

}

public class array {
    private static ArrayList<students_arrlist> thong_tin = new ArrayList<>();

    public static void main(String[] args) {


        int chose;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        do {
            System.out.println("menu");
            System.out.println("1.add student");
            System.out.println("2.update student ");
            System.out.println("3.delete student ");
            System.out.println("4.Display student ");
            System.out.println("5.Exit");
            System.out.println();
            chose = sc.nextInt();

            switch (chose) {

                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> displayStudents();
                case 5 -> sortStudentsByScore();
                case 6 -> System.out.println("exit");


            }
        } while (chose != 5);
    }


    private static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap id : ");
        String id = sc.nextLine();
        if (id == null) {
            System.out.println("lỗi nhap lai: ");
            return;
        }

        System.out.println(" ten : ");
        String ten = sc.nextLine();
        System.out.println("diem : ");
        int diem = sc.nextInt();
        array.thong_tin.add(new students_arrlist(ten, id, diem));
        System.out.println("thanh cong");
    }

    private static void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id can sua : ");
        String id = sc.nextLine();
        System.out.println("diem moi la: ");
        int diem = sc.nextInt();
    }

    private static void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("id can xoa : ");
        String id = sc.nextLine();
        for (students_arrlist student : thong_tin) {
            if (student.getTuoi().equals(id)) {
                thong_tin.remove(student);
                System.out.println("Xoa thanh cong!");
break;

            }
        }
    }
        private static void displayStudents () {
            if (thong_tin.isEmpty()) {
                System.out.println("khong co hoc sinh.");
            } else {
                for (students_arrlist students : thong_tin) {
                    System.out.println(students);
break;
                }

            }

        }
    private static void sortStudentsByScore() {
        if (thong_tin.isEmpty()) {
            System.out.println("Danh sách học sinh trống Không thể sắp xếp.");
            return;
        }




        System.out.println();
        displayStudents();
    }

}