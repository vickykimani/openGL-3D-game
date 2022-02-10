package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop {

	public static void main(String[] args) {
		
		
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		//opengl expects vertices to be defined counter clockwise by default
		float[] vertices = {
				-0.5f, 0.5f, 0,    //v0
				-0.5f, -0.5f, 0,   //v1
				0.5f, -0.5f, 0,     //v2
				0.5f, 0.5f, 0      //v3
		};
		
		int[] indices = {
				0,1,3,             //top left triangle (v0,v1,v3)
				3,1,2              //bottom right triangle (v3,v1,v2)
		};
		
		RawModel model = loader.loadToVAO(vertices,indices);
		
		while(!Display.isCloseRequested()) {
			//game logic
			renderer.prepare();
			shader.start();
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
