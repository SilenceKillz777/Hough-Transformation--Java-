import java.io.PrintWriter;

public class HoughTransform {

	public class xyCoord{
		int x;
		int y;
	}
	
	xyCoord point;
	int angleInDegree, Hough_dist, Hough_angle, HoughMinVal, HoughMaxVal;
	double angleInRadians;
	int[][] HoughAry;
	
	//constructor
	public HoughTransform(int Hough_dist, int Hough_angle){
		this.Hough_dist = Hough_dist;
		this.Hough_angle = Hough_angle;
	}
	
	double computeDistance(Point point, double angleInRadians){
		double distance = 0;
		double a = angleInRadians;
		double x = point.col;
		double y = point.row;
<<<<<<< HEAD
		double atan = Math.toRadians(Math.atan(y/x));
		double halfpi = Math.PI/2;
		double t = a-atan-halfpi;
		double radiant = Math.cos(t);
		//System.out.println("This is t: " + t);
		//System.out.println("This is cos(t): " + radiant);
		//System.out.println("toDegrees: " + Math.toDegrees(radiant));
		//System.out.println("X: " + x + "\nY: " + y);
		System.out.println("Test Negative: "+ a + " " + atan + " "+ halfpi);
		distance = (Math.sqrt(Math.pow(x,2)+Math.pow(y,2)))*radiant;
=======
		double atan = Math.atan(y/x);
		double halfpi = Math.PI/2;
		double t = a-atan-halfpi;
		System.out.println("X: " + x + "\nY: " + y);
		System.out.println("Test Negative: "+ a + " " + atan + " "+ halfpi);
		System.out.println("This is t: " + t);
		System.out.println("This is x squared: "+ Math.pow(x, 2));
		System.out.println("This is y squared: "+ Math.pow(y, 2));
		
		distance = (Math.sqrt(Math.pow(x,2)+Math.pow(y,2)))*(Math.cos(t));
		//System.out.println("This is distance: " + distance);
>>>>>>> d51c9be0d7aeb1e51abd50dbc9a7665c55462281
		return distance;
	}
	
	void prettyPrint(int[][] HoughAry, PrintWriter outFile1){
		//System.out.println("Hough_dist: " + Hough_dist);
		//System.out.println("Hough_angle: " + Hough_angle);
		//System.out.println("HoughMinVal: " + HoughMinVal);
		//System.out.println("HoughMaxVal: " + HoughMaxVal);
		for(int row=0; row<Hough_dist; row++){
			for(int col=0; col<Hough_angle; col++){
				if(HoughAry[row][col]>0)
					outFile1.print(".");
				else outFile1.print(" ");
			}
			outFile1.println();
		}
	}
	
	void write(int[][] HoughAry, PrintWriter outFile2){
		outFile2.println(Hough_dist+" "+Hough_angle+" "+HoughMinVal+" "+HoughMaxVal);
		for(int row=0; row<Hough_dist; row++){
			for(int col=0; col<Hough_angle; col++){
				outFile2.print(HoughAry[row][col]);
			}
			outFile2.println();
		}
	}
	
}
