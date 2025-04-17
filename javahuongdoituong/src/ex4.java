
import  java.io.*;
public class ex4 {
    public static void main(String[] args) {
        String chuoi = "Write a program in Java easily";

        char ch = 'a';
        int count = 0;

        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) == ch) {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự '" + ch + "': " + count);

        boolean containsJava = chuoi.contains("Java");
        System.out.println("Chuỗi có chứa từ 'Java': " + containsJava);

        boolean startsWithWrite = chuoi.startsWith("Write");
        System.out.println("Chuỗi có bắt đầu bằng 'Write': " + startsWithWrite);

        boolean endsWithEasily = chuoi.endsWith("easily");
        System.out.println("Chuỗi có kết thúc bằng 'easily': " + endsWithEasily);

    }
}