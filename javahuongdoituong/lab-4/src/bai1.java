import java.sql.SQLOutput;

public class bai1 {
    // Biến thể hiện cho tên sinh viên
    private String name;
    // Biến thể hiện cho điểm Java
    private int javaScore;
    // Biến thể hiện cho điểm C
    private int cScore;

    // Constructor để khởi tạo các biến
    public bai1(String name, int javaScore, int cScore) {
        this.name = name;
        this.javaScore = javaScore;
        this.cScore = cScore;
    }

    // Phương thức để lấy tên sinh viên
    public String Name() {
        return name;
    }

    // Phương thức để lấy điểm Java
    public int JavaScore() {
        return javaScore;
    }

    // Phương thức để lấy điểm C
    public int CScore() {
        return cScore;
    }

    // Phương thức để hiển thị thông tin sinh viên

    public void diem() {
        System.out.println("Tên sinh viên: " + name + ", Điểm Java: " + javaScore + ", Điểm C: " + cScore);

    }

    public void  dtb(){
        System.out.println("diem trun binh : "+ (javaScore+cScore)/2);

    }

    public static void main(String[] args) {
        bai1 b = new bai1("tung",90,60);
        bai1 c = new bai1("an",90,60);
        b.diem();

        b.dtb();
      c.diem();

        c.dtb();
    }
}
