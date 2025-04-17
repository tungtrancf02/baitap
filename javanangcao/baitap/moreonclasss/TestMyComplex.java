package moreonclasss;

class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex1 another) {
        return this.real == another.getReal() && this.imag == another.getImag();
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public MyComplex addInto(MyComplex1 right) {
        this.real += right.getReal();
        this.imag += right.getImag();
        return this;
    }

    public MyComplex1 addNew(MyComplex1 right) {
        return new MyComplex1(this.real + right.getReal(), this.imag + right.getImag());
    }

    @Override
    public String toString() {
        return real + "+" + imag + "i";
    }
}

public class TestMyComplex {
    public static void main(String[] args) {
        MyComplex1 c1 = new MyComplex1(3.1, 4.05);
        MyComplex1 c2 = new MyComplex1(1.5, -2.3);

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);

        System.out.println("c1 is real? " + c1.isReal());
        System.out.println("c1 is imaginary? " + c1.isImaginary());
        System.out.println("c1 magnitude: " + c1.magnitude());

        MyComplex1 sum = c1.addNew(c2);
        System.out.println("Sum (new object): " + sum);

        c1.addInto(c2);
        System.out.println("c1 after adding c2: " + c1);

        System.out.println("c1 equals c2? " + c1.equals(c2));
    }
}
