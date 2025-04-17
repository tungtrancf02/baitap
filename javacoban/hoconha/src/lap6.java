import java.util.HashSet;
import java.util.Scanner;

public class lap6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhắc người dùng nhập số lượng học sinh
        System.out.print("Nhập số lượng học sinh: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống sau khi nhập số

        String[][] students = new String[N][3]; // Tạo mảng 2D để lưu trữ thông tin
        HashSet<String> studentIDs = new HashSet<>(); // Để kiểm tra mã học sinh duy nhất

        // Nhập thông tin cho mỗi học sinh
        for (int i = 0; i < N; i++) {
            System.out.println("Nhập thông tin cho học sinh thứ " + (i + 1) + ":");

            // Nhập tên học sinh
            System.out.print("Tên học sinh: ");
            students[i][0] = scanner.nextLine();

            // Nhập mã học sinh với kiểm tra duy nhất
            String studentID;
            while (true) {
                System.out.print("Mã Học Sinh (duy nhất): ");
                studentID = scanner.nextLine();
                if (studentID.isEmpty() || studentIDs.contains(studentID)) {
                    System.out.println("Mã không hợp lệ. Vui lòng nhập lại.");
                } else {
                    studentIDs.add(studentID);
                    students[i][1] = studentID;
                    break;
                }
            }

            // Nhập điểm Java
            System.out.print("Điểm Java: ");
            students[i][2] = scanner.nextLine();
        }

        // Hiển thị thông tin chi tiết về sinh viên
        System.out.println("\nThông tin sinh viên:");
        System.out.printf("%-20s %-15s %-10s\n", "Tên", "Mã Học Sinh", "Điểm Java");
        for (int i = 0; i < N; i++) {
            System.out.printf("%-20s %-15s %-10s\n", students[i][0], students[i][1], students[i][2]);
        }

        // Tìm điểm Java cao nhất
        double highestScore = -1;
        String topStudent = "";
        for (int i = 0; i < N; i++) {
            double score = Double.parseDouble(students[i][2]);
            if (score > highestScore) {
                highestScore = score;
                topStudent = students[i][0];
            }
        }

        System.out.println("\nHọc sinh có điểm Java cao nhất là: " + topStudent + " với điểm: " + highestScore);

        scanner.close();
    }
}
