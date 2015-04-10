/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmib_4_4;

import org.opencv.core.Mat;

/**
 *
 * @author Prabhath
 */
public class NoiseRemove {
    
    public Mat removeNoisePixcels(Mat noiseGreyImage,Mat rbgImage){
         
        Mat image=noiseGreyImage;
        Mat image1=rbgImage;
        
        int size = (int) (image.total() * image.channels());
        byte[] get=new byte[size];
        byte[] temp1=new byte[size];
        int size1 = (int) (image1.total() * image1.channels());
        byte[] rgb1=new byte[size1];
        
        for (int i=0;i<image.rows();i++){
        
            for (int j=0;j<image.cols();j++){
            
                image.get(i, j,get);
                if(get[0]==-1){
                
                    image.put(i, j, 1);
                }
                image.get(i, j,get);
                //System.out.println(get[0]);
                
                if(get[0]==1){
                
                    if(i==0 & j==0){
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        image.get(i,j+1,a1);
                        image.get(i+1,j+1,a2);
                        image.get(i+1,j,a3);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)){
                        
                            //image1.put(j, i, 0.0);
                            //System.out.println("1");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    
                    else if(i==0 & j==image.cols()){
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        image.get(i,j-1,a1);
                        image.get(i+1,j-1,a2);
                        image.get(i+1,j,a3);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)){
                        
                            //image1.put(j, i, 1.0);
                            // System.out.println("2");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    else if(i==image.rows() & j==image.cols()){
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        image.get(i-1,j,a1);
                        image.get(i-1,j-1,a2);
                        image.get(i,j-1,a3);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)){
                        
                           // image1.put(j, i, 1.0);
                            // System.out.println("3");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    else if(j==0 & i==image.rows()){
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        image.get(i,j+1,a1);
                        image.get(i-1,j+1,a2);
                        image.get(i-1,j,a3);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)){
                        
                            //image1.put(j, i, 1.0);
                            // System.out.println("4");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    
                    else if(j==0){
                    
                        double[] a1=image.get(i-1,j);
                        double[] a2=image.get(i-1,j+1);
                        double[] a3=image.get(i,j+1);
                        double[] a4=image.get(i+1,j+1);
                        double[] a5=image.get(i+1,j);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)|(a2[0]==-1 & a3[0]==-1 & a4[0]==-1)|(a3[0]==-1 & a4[0]==-1 & a5[0]==-1)){
                        
                            //image1.put(j, i, 1.0);
                            // System.out.println("5");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    else if(i==0){
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        byte[] a4 = new byte[1];
                        byte[] a5 = new byte[1];
                     
                        image.get(i,j-1,a1);
                        image.get(i+1,j-1,a2);
                        image.get(i+1,j,a3);
                        image.get(i+1,j+1,a4);
                        image.get(i,j+1,a5);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)|(a2[0]==-1 & a3[0]==-1 & a4[0]==-1)|(a3[0]==-1 & a4[0]==-1 & a5[0]==-1)){
                        
                            //image1.put(j, i, 1.0);
                            // System.out.println("6");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    else if(j==image.cols()){
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        byte[] a4 = new byte[1];
                        byte[] a5 = new byte[1];
                       
                        image.get(i-1,j,a1);
                        image.get(i-1,j-1,a2);
                        image.get(i,j-1,a3);
                        image.get(i+1,j-1,a4);
                        image.get(i+1,j,a5);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)|(a2[0]==-1 & a3[0]==-1 & a4[0]==-1)|(a3[0]==-1 & a4[0]==-1 & a5[0]==-1)){
                        
                            //image1.put(j, i, 1.0);
                            // System.out.println("7");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    else if(i==image.rows()){
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        byte[] a4 = new byte[1];
                        byte[] a5 = new byte[1];
                        
                        image.get(i,j+1,a1);
                        image.get(i-1,j+1,a2);
                        image.get(i-1,j,a3);
                        image.get(i-1,j-1,a4);
                        image.get(i,j-1,a5);
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)|(a2[0]==-1 & a3[0]==-1 & a4[0]==-1)|(a3[0]==-1 & a4[0]==-1 & a5[0]==-1)){
                        
                            //image1.put(j, i, 1.0);
                            // System.out.println("8");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    
                    else {
                    
                        byte[] a1 = new byte[1];
                        byte[] a2 = new byte[1];
                        byte[] a3 = new byte[1];
                        byte[] a4 = new byte[1];
                        byte[] a5 = new byte[1];
                        byte[] a6 = new byte[1];
                        byte[] a7 = new byte[1];
                        byte[] a8 = new byte[1];
                        
                        image.get(i-1,j,a1);
                        image.get(i-1,j-1,a2);
                        image.get(i,j-1,a3);
                        image.get(i+1,j-1,a4);
                        image.get(i+1,j,a5);
                        image.get(i+1,j+1,a6);
                        image.get(i,j+1,a7);
                        image.get(i-1,j+1,a8);
                        
                        
                        
                        if((a1[0]==-1 & a2[0]==-1 & a3[0]==-1)|(a2[0]==-1 & a3[0]==-1 & a4[0]==-1)|(a3[0]==1 & a4[0]==-1 & a5[0]==-1)|(a4[0]==-1 & a5[0]==-1 & a6[0]==-1)|(a5[0]==-1 & a6[0]==1 & a7[0]==-1)|(a6[0]==-1 & a7[0]==-1 & a8[0]==-1)){
                        
                            //image1.put(j, i, 1.0);
                            // System.out.println("9");
                        }
                        else{
                        
                            image.put(i, j, 0);
                        }
                    }
                    
                }
                    
            
                
            }
        }
        ////////////////////// Obtain RGB final blood cell image /////////////////////////////
        for (int i=0;i<image.rows();i++){
        
            for (int j=0;j<image.cols();j++){
                
                image.get(i, j, temp1);
                image1.get(i, j, rgb1);
              
                if(temp1[0]==-1){
                
                    image.put(i, j, 1);
                }
                
                image.get(i, j, temp1);
                byte r=(byte) (rgb1[0]*temp1[0]);
                byte g=(byte) (rgb1[1]*temp1[0]);
                byte b=(byte) (rgb1[2]*temp1[0]);
                
                image1.put(i, j, new byte[]{r, g, b});

            }
            
    }
        return image1; 
    }
    
}
