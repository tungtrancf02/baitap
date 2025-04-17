package ExercisesonComposition;

class MyPoints {
    private int x, y;

    public MyPoints() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoints(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int[] getXY() { return new int[]{x, y}; }
    public void setXY(int x, int y) { this.x = x; this.y = y; }

    public double distance(MyPoints another) {
        return Math.sqrt(Math.pow(this.x - another.x, 2) + Math.pow(this.y - another.y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class MyCircle {
    private MyPoints center;
    private int radius;

    public MyCircle() {
        this.center = new MyPoints(0, 0);
        this.radius = 1;
    }

    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoints(x, y);
        this.radius = radius;
    }

    public MyCircle(MyPoints center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
    public MyPoints getCenter() { return center; }
    public void setCenter(MyPoints center) { this.center = center; }
    public int getCenterX() { return center.getX(); }
    public void setCenterX(int x) { center.setX(x); }
    public int getCenterY() { return center.getY(); }
    public void setCenterY(int y) { center.setY(y); }
    public int[] getCenterXY() { return center.getXY(); }
    public void setCenterXY(int x, int y) { center.setXY(x, y); }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double distance(MyCircle another) {
        return center.distance(another.getCenter());
    }

    @Override
    public String toString() {
        return "MyCircle[radius=" + radius + ",center=" + center.toString() + "]";
    }
}

class main {

    public static void main(String[] args) {
        MyPoints p1 = new MyPoints(3, 4);
        MyPoints p2 = new MyPoints(6, 8);

        MyCircle c1 = new MyCircle(p1, 5);
        MyCircle c2 = new MyCircle(p2, 10);

        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Circumference: " + c1.getCircumference());
        System.out.println("Distance to c2: " + c1.distance(c2));

        c1.setRadius(7);
        c1.setCenter(new MyPoints(10, 10));
        System.out.println("Updated c1: " + c1);
    }
}
