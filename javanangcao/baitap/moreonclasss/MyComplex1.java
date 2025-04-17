package moreonclasss;

public class MyComplex1 {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex1() {}

    public MyComplex1(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() { return real; }
    public void setReal(double real) { this.real = real; }
    public double getImag() { return imag; }
    public void setImag(double imag) { this.imag = imag; }
    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {
        return "(" + real + "+" + imag + "i)";
    }

    public boolean isReal() { return imag == 0; }
    public boolean isImaginary() { return real == 0; }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex1 another) {
        return this.real == another.real && this.imag == another.imag;
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        return Math.atan2(imag, real);
    }

    public MyComplex1 add(MyComplex1 right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex1 addNew(MyComplex1 right) {
        return new MyComplex1(this.real + right.real, this.imag + right.imag);
    }

    public MyComplex1 subtract(MyComplex1 right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex1 subtractNew(MyComplex1 right) {
        return new MyComplex1(this.real - right.real, this.imag - right.imag);
    }

    public MyComplex1 multiply(MyComplex1 right) {
        double newReal = this.real * right.real - this.imag * right.imag;
        double newImag = this.real * right.imag + this.imag * right.real;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex1 divide(MyComplex1 right) {
        double denominator = right.real * right.real + right.imag * right.imag;
        double newReal = (this.real * right.real + this.imag * right.imag) / denominator;
        double newImag = (this.imag * right.real - this.real * right.imag) / denominator;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex1 conjugate() {
        return new MyComplex1(this.real, -this.imag);
    }


}
