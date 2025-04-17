
import java.util.ArrayList;

public class khoa {
    private  String ID;
    private String Ten;
    private String Bacsi;
    private ArrayList<String> danhSachBacSi;

    public khoa(String ID, String Ten) {
        this.ID = ID;
        this.Ten = Ten;
        this.danhSachBacSi = new ArrayList<>();
    }

    public khoa(String ID, String Ten, String Bacsi) {
    }

    public khoa() {
    }


    public String getID() {
        return ID;
    }

    public String getTen() {
        return Ten;
    }
    public ArrayList<String> getDanhSachBacSi() {
        return danhSachBacSi;
    }



    public void setID(String ID) {

        this.ID = ID;
    }

    public void setTen(String ten) {
        Ten = ten;
    }



        public void themBacSi (String tenBacSi){
            danhSachBacSi.add(tenBacSi);
        }



    @Override
    public String toString() {

        return "Ten khoa: " + this.Ten + "Id " + this.ID + " Danhsach: " + this.danhSachBacSi;


    }




}
