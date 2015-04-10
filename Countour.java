/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmib_4_4;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Core;
import static org.opencv.core.CvType.CV_8U;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.THRESH_OTSU;

/**
 *
 * @author Prabhath
 */
public class Countour {
    
    public static void main(String args[]){

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Highgui.imread("input1.jpg",Highgui.CV_LOAD_IMAGE_GRAYSCALE);
        Mat image1 = Highgui.imread("input1.jpg",Highgui.CV_LOAD_IMAGE_GRAYSCALE);
        Mat image4 = Highgui.imread("input1.jpg");
        Imgproc.threshold(image1, image1, 0, 255,THRESH_OTSU);
        Imgproc.Canny(image1, image1,Imgproc.THRESH_BINARY_INV+Imgproc.THRESH_OTSU, Imgproc.THRESH_BINARY_INV+Imgproc.THRESH_OTSU);
        Mat image2 = Mat.zeros(image.rows()+2, image.cols()+2, CV_8U);
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();    
        Imgproc.findContours(image1, contours, new Mat(), Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);

        for(int i=0; i< contours.size();i++){

            if (Imgproc.contourArea(contours.get(i)) > 100 ){
                
                Rect rect = Imgproc.boundingRect(contours.get(i));
                Imgproc.floodFill(image1, image2, new Point(150,150), new Scalar(255));
                Rect rectCrop = new Rect(rect.x, rect.y, rect.width, rect.height);
                Mat image_roi_rgb = new Mat(image4,rectCrop);
                Highgui.imwrite("crop2.jpg",image_roi_rgb);
                if (rect.height > 28){

                    Core.rectangle(image, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
                }
            }
        }
        Highgui.imwrite("falciparum2.jpg",image);
   
}
    
}
