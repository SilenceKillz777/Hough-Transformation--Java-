import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] argv){
		
		try {
			int numRows=0, numCols=0, minVal=0, maxVal=0;
			Scanner inFile = new Scanner(new File(argv[0]));
			PrintWriter outFile1 = new PrintWriter(new FileWriter(argv[1]));
			PrintWriter outFile2 = new PrintWriter(new FileWriter(argv[2]));
			
			//retrieve header information
			numRows = Integer.parseInt(inFile.next());
			numCols = Integer.parseInt(inFile.next());
			minVal = Integer.parseInt(inFile.next());
			maxVal = Integer.parseInt(inFile.next());
			
			int[][] imgAry = new int[numRows][numCols];
			int distInt, angleInDegree, Hough_angle=180, Hough_dist, maxDistance, offset;
			double angleInRadians, dist;
			Hough_dist = (int)Math.sqrt(Math.pow(numRows, 2)+Math.pow(numCols, 2));
			offset = Hough_dist;
			int[][] HoughAry = new int[Hough_dist + offset][Hough_angle];
			Point point = new Point();
			ImageProcessing process = new ImageProcessing(numRows, numCols, minVal, maxVal, inFile);
			process.loadImage(imgAry);
			HoughTransform hough = new HoughTransform(Hough_dist + offset, Hough_angle);
			
			for(int row=0; row<numRows; row++){
				for(int col=0; col<numCols; col++){
					if(imgAry[row][col] > 0){
						point.row = row;
						point.col = col;
						angleInDegree = 0;
						while(angleInDegree < 180){
							angleInRadians = Math.toRadians(angleInDegree);
							dist = hough.computeDistance(point, angleInRadians, offset);
							distInt = (int)dist;
							HoughAry[distInt][angleInDegree]++;
							angleInDegree++;
						}
					}
				}
			}			
			hough.determineMinMax(HoughAry);
			hough.prettyPrint(HoughAry, outFile1);
			hough.write(HoughAry, outFile2);
			
			inFile.close();
			outFile1.close();
			outFile2.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
