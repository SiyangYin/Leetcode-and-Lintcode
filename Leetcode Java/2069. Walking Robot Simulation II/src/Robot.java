class Robot {
    private int[] pos;
    private String[] dir = new String[]{"East", "North", "West", "South"};
    private int d;
    private int w;
    private int h;
    public Robot(int width, int height) {
        w = width;
        h = height;
        d = 0;
        pos = new int[]{0, 0};
    }

    public void step(int num) {
        while (num > 0) {
            if ((pos[0] == 0 || pos[0] == w - 1 || pos[1] == 0 || pos[1] == h - 1) && num >= (w + h - 2) * 2) {
                num %= (w + h - 2) * 2;
                if (pos[0] == 0 && pos[1] == 0 && d == 0) {
                    d += 3;
                }
            }
            switch (d) {
                case 0:
                    if (pos[0] + num < w) {
                        pos[0] += num;
                        num = 0;
                    }
                    else {
                        num -= w - 1 - pos[0];
                        pos[0] = w - 1;
                        d = (d + 1) % 4;
                    }
                    break;
                case 1:
                    if (pos[1] + num < h) {
                        pos[1] += num;
                        num = 0;
                    }
                    else {
                        num -= h - 1 - pos[1];
                        pos[1] = h - 1;
                        d = (d + 1) % 4;
                    }
                    break;
                case 2:
                    if (pos[0] - num >= 0) {
                        pos[0] -= num;
                        num = 0;
                    }
                    else {
                        num -= pos[0];
                        pos[0] = 0;
                        d = (d + 1) % 4;
                    }
                    break;
                case 3:
                    if (pos[1] - num >= 0) {
                        pos[1] -= num;
                        num = 0;
                    }
                    else {
                        num -= pos[1];
                        pos[1] = 0;
                        d = (d + 1) % 4;
                    }
                    break;
            }
        }
    }

    public int[] getPos() {
        return pos;
    }

    public String getDir() {
        return dir[d];
    }

    public static void main(String[] args) {
        Robot robot = new Robot(6, 3);
        robot.step(2);
        robot.step(2);
        System.out.println(robot.getPos()[0] + "," + robot.getPos()[1]);
        System.out.println(robot.getDir());
        robot.step(2);
        robot.step(1);
        robot.step(4);
        System.out.println(robot.getPos()[0] + "," + robot.getPos()[1]);
        System.out.println(robot.getDir());
    }
}
