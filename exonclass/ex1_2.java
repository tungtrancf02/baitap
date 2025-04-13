package exonclass;

public class ex1_2 {
    private  double radius;


   public ex1_2() {
       radius =1.0;

   }
   public ex1_2(double newradius) {
       radius =newradius;
   }
   public double getradius(){
       return radius;
   }
   public void setradius(double  newradius){
       radius =newradius;

   }
   public double getArea(){
       return radius * radius * Math.PI;
   }
   public double getCircumference(){
       return 2*Math.PI*radius;
   }
    public String toString() {
        return "Circle[radius=" + radius + " ]";
    }


}
