package day6_3;

class bai1_couter {
    int cout = 0;

    void tang() {
        cout++;
    }
}

    public class luong {


        public static void main(String[] args) throws InterruptedException {

            bai1_couter b1 = new bai1_couter();
            Thread coun1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    b1.tang();



                }

            });
            Thread coun2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    b1.tang();
                }
            });


            coun1.start();// bat dau luong 1
            coun2.start();// bat dau luong 2
            coun1.join();// doi luon 1 ket thuc
            coun2.join();// doi luong 2 ket thuc

            System.out.println(b1.cout);

        }

    }
