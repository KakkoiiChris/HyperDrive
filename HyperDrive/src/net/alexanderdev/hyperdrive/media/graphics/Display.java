/***************************************************************
 *   _   _                         ____        _               *
 *  | | | |                       |  _ \      |_|              *
 *  | |_| |_   _  ___   ___   ____| | | | ____ _ _   _  ___    *
 *  |  _  | | | |/ _ \ / _ \ / ___| | | |/ ___| | \ / |/ _ \   *
 *  | | | | |_| | |_| |  ___| |   | |_| | |   | |\ V /|  ___|  *
 *  |_| |_|\__  |  __/ \___||_|   |____/|_|   |_| \_/  \___|   *
 *   ___   ___| | |  _______________________________________   *
 *  |___| |____/|_| |___________JAVA_GAME_LIBRARY___________|  *
 *                                                             *
 *                                                             *
 *  COPYRIGHT © 2015, Christian Bryce Alexander                *
 ***************************************************************/
package net.alexanderdev.hyperdrive.media.graphics;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GLContext;

import net.alexanderdev.hyperdrive.input.Keyboard;

/**
 * @author Christian Bryce Alexander
 * @since Sep 15, 2015, 1:44:49 PM
 */
public class Display {
	public static final int DEFAULT_WIDTH = 640;
	public static final int DEFAULT_HEIGHT = 480;
	public static final String DEFAULT_TITLE = "HyperDrive";

	private int width, height;
	private String title;

	private long window;
	
	private Keyboard keyboard;

	private boolean useKeyboard = false;
	private boolean useMouse = false;

	public Display() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TITLE);
	}

	public Display(int width, int height) {
		this(width, height, DEFAULT_TITLE);
	}

	public Display(String title) {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, title);
	}

	public Display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	public void open() {
		if (glfwInit() != GL_TRUE)
			return;

		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

		window = glfwCreateWindow(width, height, title, NULL, NULL);

		if (window == NULL)
			return;

		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

		glfwSetWindowPos(window, (GLFWvidmode.width(vidmode) - width) / 2, (GLFWvidmode.height(vidmode) - height) / 2);

		glfwMakeContextCurrent(window);

		if (useKeyboard)
			glfwSetKeyCallback(window, keyboard = new Keyboard(this));

		glfwShowWindow(window);

		run();
	}

	public void close() {

	}

	public void enableKeyboard(boolean enable) {
		useKeyboard = enable;
	}
	
	public void enableMouse(boolean enable) {
		useMouse = enable;
	}

	public void run() {
		GLContext.createFromCurrent();

		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		while (glfwWindowShouldClose(window) == GL_FALSE) {
			update();
			render();
		}
	}

	private void update() {
		glfwPollEvents();
		
		if(keyboard.SPACE.held())
			System.out.println("YES!!!");
	}

	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		glfwSwapBuffers(window);
	}
}