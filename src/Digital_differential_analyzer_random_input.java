import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Digital_differential_analyzer_random_input implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
    static int lineNumber = 10;
    static double []x1=new double[lineNumber];
    static double []y1=new double[lineNumber];
    static double []x2=new double[lineNumber];
    static double []y2=new double[lineNumber];
	private static BufferedReader in;
	
   public static void main(String[] args) throws IOException {
	   try{
		   Random rng = new SecureRandom();
		    Set<Integer> numbers = new HashSet<>();
		    while (numbers.size() < 3) {
		        // number only added if not already present in Set, set values are unique
		        numbers.add(rng.nextInt());
		    }
		    List<Integer> numberList = new ArrayList<>(numbers);
		    Collections.sort(numberList);
		    // lower random at index 0, mid at index 1
		    // you can guess where the other one is hiding 
		    System.out.println(numberList);
		   /*nt minX = -9;
         	int maxX = 9;
         	int x0 = rand.nextInt() * (maxX - minX) + minX;
     		int y0 = rand.nextInt() * (maxX - minX) + minX;
     		int x1= rand.nextInt() * (maxX - minX) + minX;
     		int y1 = rand.nextInt() * (maxX - minX) + minX;*/
		   Random rand = new Random();
		   int Low = -2;
		   int High = 10;
		   int count=0;
		   int[]r=new int[40];
		   PrintWriter writer = new PrintWriter("abir", "UTF-8");
		   for (int i = 0; i <10; i++) {
			   int Result1 = rand.nextInt(High-Low) + Low;
			   int Result2 = rand.nextInt(High-Low) + Low;
			   int Result3 = rand.nextInt(High-Low) + Low;
			   int Result4 = rand.nextInt(High-Low) + Low;
			   int[] ints = {Result1,Result2,Result3,Result4};
			   Arrays.sort(ints);
			   for (int j = 0; j < ints.length; j++) {
				System.out.println("okay"+ints[j]);
			}
			   writer.println((double)ints[0]+" "+(double)ints[1]+" "+(double)ints[2]+" "+(double)ints[3]);
			   
			   
		}
		   writer.close();
		    
		} catch (Exception e) {
		   // do something
		}
	      in = new BufferedReader(new FileReader("abir"));
	      
	   	  for(int i=0; i<lineNumber;i++){
	   		  String line=in.readLine();	   		  
	   		  String[] t = line.split(" ");
	   
	   		  x1[i]=Double.parseDouble(t[0]);
	   		  y1[i]=Double.parseDouble(t[1]);
	   		  x2[i]=Double.parseDouble(t[2]);
	   		  y2[i]=Double.parseDouble(t[3]);
	  		System.out.println(x1[i]);
	   		System.out.println(y1[i]);
	   		System.out.println(x2[i]);
	   		System.out.println(y2[i]);
	   		
	   	  
	   		Digital_differential_analyzer_random_input l = new Digital_differential_analyzer_random_input();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	   	  }
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
      for(int i=0; i<lineNumber;i++){  	
      	 double m =   ( y2[i] - y1[i]) / ( x2[i] - x1[i])  ;
      	double x = x1[0];
  		double y = y1[0];
//  		m = 25;
      	 if( m < 1 ){
      		
      		 while(  Math.abs(x) <=  Math.abs(x2[i]) ){
      			 
      			gl.glBegin (GL2.GL_POINTS);//static field
      	       	gl.glVertex2d(x/10,y/10);
      	       	gl.glEnd();
      	       	
      		 x = x + 0.01;
      		 y += m*0.01;
      		 }      // end of while		 
      	 } // end of if	
      	 else if( m > 1 ){
      		 while( Math.abs(y) <= Math.abs(y2[i]) ){
      			 
       			gl.glBegin (GL2.GL_POINTS);//static field
       	       	gl.glVertex2d(x/10,y/10);
       	       	gl.glEnd();
       	       	
       		 y = y + .01;
       		 x += 0.01/m;
       		 }      // end of while	
      	 } // end of else
      			 
      } // end of for
       	
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