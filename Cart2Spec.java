/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmib_4_4;

/**
 *
 * @author Prabhath
 */
public class Cart2Spec {
    
        
    public double[] cartToSpec(double x,double y,double z){
    
        double r=StrictMath.sqrt((x*x+y*y+z*z));
        double teta=StrictMath.atan2(y, x);
        double pi=StrictMath.atan2(z,StrictMath.sqrt((x*x+y*y)));
        
        double[] spec = new double[]{r,teta,pi};
        return spec;
    }
    
    
}
