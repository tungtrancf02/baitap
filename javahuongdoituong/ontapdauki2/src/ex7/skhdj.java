package ex7;

import java.util.ArrayList;
import java.util.List;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class PolyLine {
    private List<Point> points = new ArrayList<>();

    public PolyLine() {}

    public PolyLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void appendPoint(Point point) {
        points.add(point);
    }

    public double getLength() {
        double length = 0.0;
        for (int i = 1; i < points.size(); i++) {
            int dx = points.get(i).getX() - points.get(i - 1).getX();
            int dy = points.get(i).getY() - points.get(i - 1).getY();
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point p : points) {
            sb.append(p.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}

 class Mains {
    public static void main(String[] args) {
        PolyLine polyline = new PolyLine();
        polyline.appendPoint(1, 1);
        polyline.appendPoint(4, 5);
        polyline.appendPoint(7, 9);

        System.out.println("Polyline: " + polyline);
        System.out.println("Length: " + polyline.getLength());
    }
}

