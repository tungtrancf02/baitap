package ExercisesonComposition;

class MyPoint {
    private int x, y;

    public MyPoint(int x, int y) {
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
        return Math.sqrt(Math.pow(this.x - another.getX(), 2) + Math.pow(this.y - another.getY(), 2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class MyLine {
    private MyPoints begin, end;

    public MyLine(int x1, int y1, int x2, int y2) {
        this.begin = new MyPoints(x1, y1);
        this.end = new MyPoints(x2, y2);
    }

    public MyLine(MyPoints begin, MyPoints end) {
        this.begin = begin;
        this.end = end;
    }

    public MyPoints getBegin() { return begin; }
    public void setBegin(MyPoints begin) { this.begin = begin; }
    public MyPoints getEnd() { return end; }
    public void setEnd(MyPoints end) { this.end = end; }
    public int getBeginX() { return begin.getX(); }
    public void setBeginX(int x) { begin.setX(x); }
    public int getBeginY() { return begin.getY(); }
    public void setBeginY(int y) { begin.setY(y); }
    public int getEndX() { return end.getX(); }
    public void setEndX(int x) { end.setX(x); }
    public int getEndY() { return end.getY(); }
    public void setEndY(int y) { end.setY(y); }
    public int[] getBeginXY() { return begin.getXY(); }
    public void setBeginXY(int x, int y) { begin.setXY(x, y); }
    public int[] getEndXY() { return end.getXY(); }
    public void setEndXY(int x, int y) { end.setXY(x, y); }

    public double getLength() {
        return begin.distance(end);
    }

    public double getGradient() {
        return Math.atan2(end.getY() - begin.getY(), end.getX() - begin.getX());
    }

    @Override
    public String toString() {
        return "MyLine[begin=" + begin + ", end=" + end + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        MyPoints p1 = new MyPoints(1, 2);
        MyPoints p2 = new MyPoints(4, 6);
        MyLine line = new MyLine(p1, p2);

        System.out.println("Original Line: " + line);
        System.out.println("Begin Point: " + line.getBegin());
        System.out.println("End Point: " + line.getEnd());
        System.out.println("Length: " + line.getLength());
        System.out.println("Gradient: " + Math.toDegrees(line.getGradient()));

        line.setBeginXY(2, 3);
        line.setEndXY(5, 7);
        System.out.println("Updated Line: " + line);
        System.out.println("Updated Length: " + line.getLength());
    }
}
