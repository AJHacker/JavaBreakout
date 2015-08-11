/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	private static final int NUMBER_BRICKS = NBRICKS_PER_ROW*NBRICK_ROWS ;
	/** Width of a brick */
	private static final int BRICK_WIDTH =
		(APPLICATION_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	/** Initial Y velocity */
	private static final double Y_VELOCITY = 3.0;
	
	/** Delay between ball updates */
	private static final int ANIMATION_PAUSE = 10;
	
	//Declaration of all the instance variables 
	private GRect paddle;
	private GOval ball; 
	private GLabel messageLabel;
	private int numBricksLeft = NUMBER_BRICKS; 
	private RandomGenerator rgen = RandomGenerator.getInstance();
	AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");

	public static void main(String[] args) {
		new Breakout().start(args);
	}
	
	/* Method: run() */
	/** Runs the Breakout program. */

	public void run() {
		
	}
	
	/*Finds what the ball collided with and returns that GObject.  Checks for each corner vertex of the ball */

	private GObject getCollidingObject() {
		//Finds collider, if the ball collided on the top left corner 
		if (getElementAt(ball.getX(), ball.getY()) != null) {
			return getElementAt(ball.getX(), ball.getY()) ; 
		}
		//Finds collider, if the ball collided on the top right corner 
		else if (getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()) != null){
			return getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()) ;
		}
		//Finds collider, if the ball collided on the bottom left corner 
		else if (getElementAt(ball.getX(), ball.getY() + 2*BALL_RADIUS) != null) {
			return getElementAt(ball.getX(), ball.getY() + 2* BALL_RADIUS) ;
		}
		//Finds collider, if the ball collided on the bottom right corner 
		else if (getElementAt(ball.getX()+ 2*BALL_RADIUS, ball.getY() + 2*BALL_RADIUS) != null) {
			return getElementAt(ball.getX()+ 2*BALL_RADIUS, ball.getY() + 2*BALL_RADIUS);
		}
		return null; 
	}
	
}
