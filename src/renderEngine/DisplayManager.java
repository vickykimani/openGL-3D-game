package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 60;
	private static final String TITLE = "our first display";
	
	/*
	 * creates a display window on which we can render our game. the 
	 * dimensions of the window are determined by setting the display mode. by using
	 * glViewport we tell opengl which part of the window we want
	 * to render our game onto. we indicated that we want to use the entire window.*/
	
	public static void createDisplay() {
		
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat (), attribs);
			Display.setTitle(TITLE);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	/*
	 * this method is used to update the display at the end of 
	 * every frame. when we have set up a rendering process this method will display whatever we've been
	 * rendering onto the screen. the "sync" method is used here to cap the frame rate. without this the computer
	 * would just try to run the game as fast as it possibly can, doing more work than it needs to.*/
	
	public static void updateDisplay() {
		
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	/*
	 * this closes the window when the game is closed*/
	public static void closeDisplay() {
		
		Display.destroy();
	}

}
