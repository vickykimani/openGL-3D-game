package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		//opengl expects vertices to be defined counter clockwise by default
		float[] vertices = {
				//first triangle
				-0.5f, 0.5f, 0,    //v0
				-0.5f, -0.5f, 0,   //v1
				0.5f, 0.5f, 0,     //v3 
				
				
				//second triangle
				0.5f, 0.5f, 0,     //v3
				-0.5f, -0.5f, 0,   //v1
				0.5f, -0.5f, 0     //v2
		};
		
		RawModel model = loader.loadToVAO(vertices);
		
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			//game logic
			renderer.render(model);
			
			DisplayManager.updateDisplay();
		}
		
		
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
