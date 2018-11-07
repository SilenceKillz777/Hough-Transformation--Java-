import java.util.Scanner;

public class ImageProcessing {
	int numRows, numCols, minVal, maxVal, Hough_dist, Hough_angle;
	Scanner inFile;
	
	//constructor
	public ImageProcessing(int numRows, int numCols, int minVal, int maxVal, Scanner inFile){
		this.numRows = numRows;
		this.numCols = numCols;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.inFile = inFile;
	}
	
	void loadImage(int[][] imgAry){
		for(int rows=0; rows<numRows; rows++){
			for(int cols=0; cols<numCols; cols++){
				imgAry[rows][cols] = Integer.parseInt(inFile.next());
			}
		}
	}	
}
