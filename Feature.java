/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmib_4_4;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Prabhath
 */
public class Feature {
    
    public int[] featureVector(Mat image1){
        
        Mat image = new Mat();
        Size sz = new Size(30,30);
        Imgproc.resize( image1, image, sz );
        int size = (int) (image1.total() * image1.channels());
        int size2=(image.width()*image.height());
        double[][] spec1=new double[size2][3];
        
        FeatureVector A=new FeatureVector();
        int k=0;
        for (int i=0;i<image.rows();i++){
        
            for (int j=0;j<image.cols();j++){
                
                //image.get(i, j, rgb);
                double[] rgb=image.get(i,j);
                double[] a=A.cartToSpec(rgb[0], rgb[1], rgb[2]);
                double x=Math.toRadians(90);
                spec1[k][0]=a[0]/x;
                spec1[k][1]=a[1]/x;
                spec1[k][2]=a[2]/x;
                //System.out.println(rgb[0]);
                //System.out.println(spec1[k][2]);
                k++;
            }
        }
        
        int[][] b=new int[11][11];
        for (int i=0;i<11;i++){
        
            for (int j=0;j<11;j++){
            
                b[i][j]=0;
            }
        }
        
        for (int i=0;i<900;i++){
        
            int x1=(int)(Math.round(spec1[i][1]*10));
            int y1=(int)(Math.round(spec1[i][2]*10));
            
            b[x1][y1]=b[x1][y1]+1;
            //System.out.println(x1+"and"+y1);
        }
        int l=0;
        int[] c=new int[121];
        for (int i=0;i<11;i++){
        
            for (int j=0;j<11;j++){
            
                c[l]=b[i][j];
                l++;
                //System.out.println(c[l-1]);
            }
        }
        return c;
       
    }
    
}
