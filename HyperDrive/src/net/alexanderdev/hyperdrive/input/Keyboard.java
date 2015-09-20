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
package net.alexanderdev.hyperdrive.input;

import static net.alexanderdev.hyperdrive.util.Time.*;
import static org.lwjgl.glfw.GLFW.*;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.glfw.GLFWKeyCallback;

import net.alexanderdev.hyperdrive.media.graphics.Display;

/**
 * @author Christian Bryce Alexander
 * @since Sep 20, 2015, 12:10:51 PM
 */
public class Keyboard extends GLFWKeyCallback {
	public final Key ESCAPE = new Key(GLFW_KEY_ESCAPE);
	public final Key DELETE = new Key(GLFW_KEY_DELETE);
	public final Key BACKSPACE = new Key(GLFW_KEY_BACKSPACE);
	public final Key TAB = new Key(GLFW_KEY_TAB);
	public final Key LEFT_SHIFT = new Key(GLFW_KEY_LEFT_SHIFT);
	public final Key RIGHT_SHIFT = new Key(GLFW_KEY_RIGHT_SHIFT);
	public final Key LEFT_CONTROL = new Key(GLFW_KEY_LEFT_CONTROL);
	public final Key RIGHT_CONTROL = new Key(GLFW_KEY_RIGHT_CONTROL);
	public final Key LEFT_ALT = new Key(GLFW_KEY_LEFT_ALT);
	public final Key RIGHT_ALT = new Key(GLFW_KEY_RIGHT_ALT);
	public final Key SPACE = new Key(GLFW_KEY_SPACE);
	public final Key ENTER = new Key(GLFW_KEY_ENTER);

	public final Key BACK_QUOTE = new Key(GLFW_KEY_GRAVE_ACCENT);

	public final Key F1 = new Key(GLFW_KEY_F1);
	public final Key F2 = new Key(GLFW_KEY_F2);
	public final Key F3 = new Key(GLFW_KEY_F3);
	public final Key F4 = new Key(GLFW_KEY_F4);
	public final Key F5 = new Key(GLFW_KEY_F5);
	public final Key F6 = new Key(GLFW_KEY_F6);
	public final Key F7 = new Key(GLFW_KEY_F7);
	public final Key F8 = new Key(GLFW_KEY_F8);
	public final Key F9 = new Key(GLFW_KEY_F9);
	public final Key F10 = new Key(GLFW_KEY_F10);
	public final Key F11 = new Key(GLFW_KEY_F11);
	public final Key F12 = new Key(GLFW_KEY_F12);

	public final Key ZERO = new Key(GLFW_KEY_0);
	public final Key ONE = new Key(GLFW_KEY_1);
	public final Key TWO = new Key(GLFW_KEY_2);
	public final Key THREE = new Key(GLFW_KEY_3);
	public final Key FOUR = new Key(GLFW_KEY_4);
	public final Key FIVE = new Key(GLFW_KEY_5);
	public final Key SIX = new Key(GLFW_KEY_6);
	public final Key SEVEN = new Key(GLFW_KEY_7);
	public final Key EIGHT = new Key(GLFW_KEY_8);
	public final Key NINE = new Key(GLFW_KEY_9);

	public final Key A = new Key(GLFW_KEY_A);
	public final Key B = new Key(GLFW_KEY_B);
	public final Key C = new Key(GLFW_KEY_C);
	public final Key D = new Key(GLFW_KEY_D);
	public final Key E = new Key(GLFW_KEY_E);
	public final Key F = new Key(GLFW_KEY_F);
	public final Key G = new Key(GLFW_KEY_G);
	public final Key H = new Key(GLFW_KEY_H);
	public final Key I = new Key(GLFW_KEY_I);
	public final Key J = new Key(GLFW_KEY_J);
	public final Key K = new Key(GLFW_KEY_K);
	public final Key L = new Key(GLFW_KEY_L);
	public final Key M = new Key(GLFW_KEY_M);
	public final Key N = new Key(GLFW_KEY_N);
	public final Key O = new Key(GLFW_KEY_O);
	public final Key P = new Key(GLFW_KEY_P);
	public final Key Q = new Key(GLFW_KEY_Q);
	public final Key R = new Key(GLFW_KEY_R);
	public final Key S = new Key(GLFW_KEY_S);
	public final Key T = new Key(GLFW_KEY_T);
	public final Key U = new Key(GLFW_KEY_U);
	public final Key V = new Key(GLFW_KEY_V);
	public final Key W = new Key(GLFW_KEY_W);
	public final Key X = new Key(GLFW_KEY_X);
	public final Key Y = new Key(GLFW_KEY_Y);
	public final Key Z = new Key(GLFW_KEY_Z);

	public final Key UP = new Key(GLFW_KEY_UP);
	public final Key DOWN = new Key(GLFW_KEY_DOWN);
	public final Key LEFT = new Key(GLFW_KEY_LEFT);
	public final Key RIGHT = new Key(GLFW_KEY_RIGHT);

	private final Map<Integer, Key> ALL_KEYS = new HashMap<>();

	private Display display;

	{
		addKey(ESCAPE);
		addKey(DELETE);
		addKey(BACKSPACE);
		addKey(TAB);
		addKey(LEFT_SHIFT);
		addKey(RIGHT_SHIFT);
		addKey(LEFT_CONTROL);
		addKey(RIGHT_CONTROL);
		addKey(LEFT_ALT);
		addKey(RIGHT_ALT);
		addKey(SPACE);
		addKey(ENTER);

		addKey(BACK_QUOTE);

		addKey(F1);
		addKey(F2);
		addKey(F3);
		addKey(F4);
		addKey(F5);
		addKey(F6);
		addKey(F7);
		addKey(F8);
		addKey(F9);
		addKey(F10);
		addKey(F11);
		addKey(F12);

		addKey(ZERO);
		addKey(ONE);
		addKey(TWO);
		addKey(THREE);
		addKey(FOUR);
		addKey(FIVE);
		addKey(SIX);
		addKey(SEVEN);
		addKey(EIGHT);
		addKey(NINE);

		addKey(A);
		addKey(B);
		addKey(C);
		addKey(D);
		addKey(E);
		addKey(F);
		addKey(G);
		addKey(H);
		addKey(I);
		addKey(J);
		addKey(K);
		addKey(L);
		addKey(M);
		addKey(N);
		addKey(O);
		addKey(P);
		addKey(Q);
		addKey(R);
		addKey(S);
		addKey(T);
		addKey(U);
		addKey(V);
		addKey(W);
		addKey(X);
		addKey(Y);
		addKey(Z);

		addKey(UP);
		addKey(DOWN);
		addKey(LEFT);
		addKey(RIGHT);
	}

	public Keyboard(Display display) {
		this.display = display;
	}

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		ALL_KEYS.get(key).invoke(action);
	}

	private void addKey(Key key) {
		ALL_KEYS.put(key.getKeycode(), key);
	}

	public class Key {
		private final long TIMEOUT = 50;

		private int keycode;

		private boolean pressed;
		private boolean held;
		private boolean released;
		
		private long actionTimer;

		public Key(int keycode) {
			this.keycode = keycode;
		}

		public int getKeycode() {
			return keycode;
		}

		public void invoke(int action) {
			if (action == GLFW_PRESS) {
				pressed = true;
				held = true;
			} else if (action == GLFW_REPEAT) {
				held = true;
			} else if (action == GLFW_RELEASE) {
				released = true;
				held = false;
			}
			
			actionTimer = msTime();
		}
		
		public boolean pressed() {
			if (pressed) {
				pressed = false;
				return msTime() - actionTimer < TIMEOUT;
			}
			return false;
		}

		public boolean released() {
			if (released) {
				released = false;
				return msTime() - actionTimer < TIMEOUT;
			}
			return false;
		}

		public boolean held() {
			return held;
		}
	}
}