package dev.manolovn.htree;

public class HTree {

    /**
     * n is the depth
     * time : O(4^n)
     * space : O(n)
     */
    void drawHTree(double x, double y, double L, int depth) {
        if (depth == 0) {
            return;
        }

        drawLine(x - L / 2, y, x + L / 2, y); // horizontal line
        drawLine(x - L / 2, y - L / 2, x - L / 2, y + L / 2);
        drawLine(x + L / 2, y - L / 2, x + L / 2, y + L / 2);

        // 4 center
        L = L / Math.sqrt(2);
        drawHTree(x - L / 2, y - L / 2, L, depth - 1);
        drawHTree(x - L / 2, y + L / 2, L, depth - 1);
        drawHTree(x + L / 2, y - L / 2, L, depth - 1);
        drawHTree(x + L / 2, y + L / 2, L, depth - 1);
    }

    void drawLine(double v, double y, double v1, double y1) {
        // assume this function is already implemented an O(1) complexity
    }
}
