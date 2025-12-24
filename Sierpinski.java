/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	public static void sierpinski(int n) {
    if (n == 0) return;

    // Define coordinates for an equilateral triangle sitting on a horizontal base
    double x1 = 0.0, y1 = 0.0;                  // Bottom-left corner
    double x2 = 1.0, y2 = 0.0;                  // Bottom-right corner
    double x3 = 0.5, y3 = Math.sqrt(3) / 2.0;   // Top vertex

    sierpinski(n, x1, x2, x3, y1, y2, y3);
}

private static void sierpinski(int n, double x1, double x2, double x3,
                                      double y1, double y2, double y3) {
    // Base case: Draw the triangle when the lowest depth is reached
    if (n == 1) {
        double[] x = {x1, x2, x3};
        double[] y = {y1, y2, y3};
        StdDraw.filledPolygon(x, y);
        return;
    }

    // Calculate midpoints of the three sides
    double x12 = (x1 + x2) / 2.0;
    double y12 = (y1 + y2) / 2.0;

    double x23 = (x2 + x3) / 2.0;
    double y23 = (y2 + y3) / 2.0;

    double x13 = (x1 + x3) / 2.0;
    double y13 = (y1 + y3) / 2.0;

    // Recursive calls: Create three smaller triangles at the corners
    // 1. Bottom-left triangle
    sierpinski(n - 1, x1, x12, x13, y1, y12, y13);
    
    // 2. Bottom-right triangle
    sierpinski(n - 1, x12, x2, x23, y12, y2, y23);
    
    // 3. Top triangle
    sierpinski(n - 1, x13, x23, x3, y13, y23, y3);
   }
}
