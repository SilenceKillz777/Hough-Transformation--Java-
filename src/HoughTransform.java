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
	
	double computeDistance(Point point, double angleInRadians, int offset){
		double distance = 0;
		double a = angleInRadians;
		double x = point.col;
		double y = point.row;
		double atan = Math.atan(y/x);
		double halfpi = Math.PI/2;
		double t = a-atan-halfpi;
		double radiant = Math.cos(t);
		distance = (Math.sqrt(Math.pow(x,2)+Math.pow(y,2)))*radiant + offset;
		return distance;
	}
	
	void prettyPrint(int[][] HoughAry, PrintWriter outFile1){
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
	
	void determineMinMax(int[][] HoughAry){
		HoughMinVal = HoughAry[0][0];
		HoughMaxVal = HoughAry[0][0];
		for(int row=0; row<Hough_dist; row++){
			for(int col=0; col<Hough_angle; col++){
				if(HoughAry[row][col]>HoughMaxVal)
					HoughMaxVal = HoughAry[row][col];
				else if(HoughAry[row][col]<HoughMinVal)
					HoughMinVal = HoughAry[row][col];
			}
		}
	}
}
