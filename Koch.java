/** Draws the Koch curve and the the Koch snowflake fractal. */
	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public class Koch {

    public static void main(String[] args) {
		
		curve(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		
       // snowFlake(n);
    }

    /**
     * Draws a Koch curve of depth n from (x1, y1) to (x2, y2).
     * The algorithm recursively divides a line into 4 segments and 
     * builds an equilateral triangle in the middle.
     */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        // Base case: If depth is 0, draw a single straight line
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        //Calculate the points that divide the segment into 3 equal parts.
        // Point A is 1/3 of the way from (x1,y1) to (x2,y2)
        double xA = x1 + (x2 - x1) / 3.0;
        double yA = y1 + (y2 - y1) / 3.0;
        
        //Point B is 2/3 of the way from (x1,y1) to (x2,y2)
        double xB = x1 + 2.0 * (x2 - x1) / 3.0;
        double yB = y1 + 2.0 * (y2 - y1) / 3.0;

        //Calculate the vertex (xC, yC) of the equilateral triangle.
        // This point is "p3" from the provided formula.
        double xC = (Math.sqrt(3) / 6.0) * (y1 - y2) + 0.5 * (x1 + x2);
        double yC = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);

        //Replace the original line with 4 smaller Koch curves.
        //Each recursive call reduces the depth (n) by 1.
        curve(n - 1, x1, y1, xA, yA); // First third
        curve(n - 1, xA, yA, xC, yC); // Left side of the triangle "peak"
        curve(n - 1, xC, yC, xB, yB); // Right side of the triangle "peak"
        curve(n - 1, xB, yB, x2, y2); // Final third
    }

    /**
     * Draws a Koch snowflake by joining three Koch curves into a triangle.
     * Coordinates are adjusted to fit within the standard [0, 1] canvas.
     */
    public static void snowFlake(int n) {
        // Base triangle vertices designed to stay within bounds
        // (0.5, 0.9) - Top vertex
        // (0.1, 0.2) - Bottom left
        // (0.9, 0.2) - Bottom right
        
        curve(n, 0.1, 0.3, 0.5, 0.9); // Left side
        curve(n, 0.5, 0.9, 0.9, 0.3); // Right side
        curve(n, 0.9, 0.3, 0.1, 0.3); // Bottom side
    }
}