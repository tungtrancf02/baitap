package moreonclasss;

class Ball {
    private float x, y, z;

    public Ball(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public float getZ() { return z; }

    public void setXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

class Player {
    private int number;
    private float x, y, z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.z += zDisp;
    }

    public boolean near(Ball ball) {
        float dx = this.x - ball.getX();
        float dy = this.y - ball.getY();
        float dz = this.z - ball.getZ();
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return distance < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 5, ball.getY() + 5, ball.getZ());
            System.out.println("Ball kicked! New position: " + ball);
        } else {
            System.out.println("Ball is too far to kick!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(0, 0, 0);
        Player player = new Player(10, 2, 3);

        System.out.println("Initial Ball Position: " + ball);
        System.out.println("Player kicks the ball:");
        player.kick(ball);

        System.out.println("Moving player closer...");
        player.move(2, 2);

        System.out.println("Player tries to kick the ball again:");
        player.kick(ball);
    }
}
