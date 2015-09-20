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
package net.alexanderdev.hyperdrive.state;

import java.util.ArrayList;
import java.util.List;

import net.alexanderdev.hyperdrive.Internal;
import net.alexanderdev.hyperdrive.input.Keyboard;
import net.alexanderdev.hyperdrive.input.KeyboardListener;
import net.alexanderdev.hyperdrive.input.Mouse;
import net.alexanderdev.hyperdrive.input.MouseListener;
import net.alexanderdev.hyperdrive.media.graphics.Renderable;

/**
 * @author Christian Bryce Alexander
 * @since Sep 20, 2015, 1:19:13 PM
 */

/**
 * A class which holds the logic for representing a particular state in a game
 * 
 * @author Christian Bryce Alexander
 * @since March 6, 2015 | 3:03:42 AM
 */
public abstract class State implements Renderable {
	private StateManager manager;

	private List<KeyboardListener> keyboardListeners = new ArrayList<>();

	private List<MouseListener> mouseListeners = new ArrayList<>();

	public final StateManager getManager() {
		return manager;
	}

	@Internal
	public final void setManager(StateManager manager) {
		this.manager = manager;
	}

	/**
	 * Sets the interface that listens for keyboard input for this game state
	 *
	 * @param keyboardListener
	 *            Functional interface for handling the keyboard
	 */
	public final void addKeyboardListener(KeyboardListener kl) {
		keyboardListeners.add(kl);
	}

	public final void removeKeyboardListener(KeyboardListener kl) {
		keyboardListeners.remove(kl);
	}

	public final void clearKeyboardListeners() {
		keyboardListeners.clear();
	}

	/**
	 * Sets the interface that listens for mouse input for this game state
	 *
	 * @param mouseListener
	 *            Functional interface for handling the mouse
	 */
	public final void addMouseListener(MouseListener ml) {
		mouseListeners.add(ml);
	}

	public final void removeMouseListener(MouseListener ml) {
		mouseListeners.remove(ml);
	}

	public final void clearMouseListeners() {
		mouseListeners.clear();
	}

	@Internal
	public final void keyboardInput(Keyboard keyboard) {
		if (keyboardListeners != null)
			for (KeyboardListener kl : keyboardListeners)
				kl.keyboardInput(keyboard);
	}

	@Internal
	public final void mouseInput(Mouse mouse) {
		if (mouseListeners != null)
			for (MouseListener ml : mouseListeners)
				ml.mouseInput(mouse);
	}

	/**
	 * Handles actions to be taken when the state manager switches into this
	 * game state
	 */
	@Internal
	public abstract void switchIn();

	/**
	 * Handles actions to be taken when the state manager switches out of this
	 * game state
	 */
	@Internal
	public abstract void switchOut();
}