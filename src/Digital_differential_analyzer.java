import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Digital_differential_analyzer implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Digital_differential_analyzer l = new Digital_differential_analyzer();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
       	  try {
       		Scanner r=new Scanner(new File("Digital_differential_analyzer_INPUT"));
       		while(r.hasNext()){
       			double x0 = r.nextDouble();
                double y0 = r.nextDouble();
                double x1 = r.nextDouble();
                double y1 = r.nextDouble();
                System.out.println("output = "+x0+" "+y0+" "+x1+" "+y1);
                double dx = x1 - x0;
                double dy = y1 - y0;
                // initializing loop variables
                double x = x0;
                double y = y0;
                Double m=dy/dx;
                
                gl.glBegin (GL2.GL_POINTS);
                while (x < x1) {
                	if(m>=-1 && m<=1){
                		x += (1 * .001);
                		y += (m/1000);
                		gl.glVertex2d(x/10,y/10);
                    	
                    }else{
                    	x += (1/m);
                        y += (1 * .001);
                    	gl.glVertex2d(x/10,y/10);
                    	
                    }
                }
                gl.glEnd();
      		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
       	  
       	  
          
          gl.glEnd();
          
      
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;

//public class CSE423LAB01CLASS
