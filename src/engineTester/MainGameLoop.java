package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
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
		
		float[] textureCoords = {
				0,0,             //v0
				0,1,             //v1
				1,1,             //v2
				1,0              //v3
		};
		
		RawModel model = loader.loadToVAO(vertices,textureCoords,indices);
		
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("image")));
		
		Entity entity = new Entity(staticModel, new Vector3f(0,0,-5),0,0,0,1);
		
		Camera camera = new Camera();
		
		while(!Display.isCloseRequested()) {
			//entity.increasePosition(0, 0, -0.1f);
			entity.increaseRotation(1, 1, 0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadViewMatrix(camera);
			renderer.render(entity,shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
