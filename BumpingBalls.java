package lab4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;

public class BumpingBalls {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numBalls = ap.nextInt("Number of balls?");
		int numIts = ap.nextInt("Iterations?");


		// set the scale of the coordinate system
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);



		double[] posx = new double[numBalls];
		double[] posy = new double[numBalls];
		double[] velx = new double[numBalls];
		double[] vely = new double[numBalls];


		double radius = 0.04; 


		for (int i=0; i<numBalls; ++i) {
			boolean negative = (Math.random()<.5); 
			

			posx[i]=Math.random();
			posy[i] = Math.random();     // position
			velx[i] = Math.random()*0.03;
			vely[i] = Math.random()*0.03;

		}


		// main animation loop
		while (true)  { 


			for (int i=0; i<numBalls; ++i) {

				// bounce off wall according to law of elastic collision
				if (Math.abs(posx[i] + velx[i]) > 1.0 - radius) {
					velx[i] = -velx[i];
					StdAudio.play("sound/boing1.au");
				}

				if (Math.abs(posy[i]+vely[i])>1.0 - radius) {
					vely[i] = -vely[i];
					StdAudio.play("sound/boing1.au");
				}

				// update position
				posx[i] = posx[i] + velx[i]; 
				posy[i] = posy[i] + vely[i]; 




				// draw ball on the screen
				StdDraw.setPenColor(Color.pink);
					StdDraw.picture(posx[i], posy[i], "images/smileyface.gif");
			//	StdDraw.filledCircle(posx[i], posy[i], radius); 





				//		while (i<=(numBalls-1)) {


			}

			for (int j=0; j<numBalls; j ++) {
				for (int r=(j+1); r<numBalls; r++) {

					double xsqrd = Math.abs(posx[j]-posx[r]); 
					double ysqrd = Math.abs(posy[j]-posy[r]);
					double collide = Math.sqrt(((xsqrd*xsqrd)+(ysqrd*ysqrd))); 



					if (collide<=(2*radius)) {


						velx[j] = -velx[j];
						vely[j] = -vely[j];

						velx[r] = -velx[r];
						vely[r] = -vely[r];
						
				 	
					}


				}
			}


			// display and pause for 20 ms
			StdDraw.show(5);
			// clear the background
			StdDraw.clear();


		}


	}


}



