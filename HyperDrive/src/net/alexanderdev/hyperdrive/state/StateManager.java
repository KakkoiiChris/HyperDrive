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

import java.util.HashMap;
import java.util.Map;

import net.alexanderdev.hyperdrive.Internal;
import net.alexanderdev.hyperdrive.input.Controllable;
import net.alexanderdev.hyperdrive.input.Keyboard;
import net.alexanderdev.hyperdrive.input.Mouse;
import net.alexanderdev.hyperdrive.media.graphics.Display;
import net.alexanderdev.hyperdrive.media.graphics.Renderable;

/**
 * @author Christian Bryce Alexander
 * @since Sep 20, 2015, 1:14:30 PM
 */
public class StateManager implements Renderable, Controllable {
	private final String DEFAULT = "@ld_default_state";

	private Map<String, State> states = new HashMap<>();

	private String currentState = DEFAULT;

	private Display display;

	public StateManager(Display display) {
		this.display = display;

		// addState(DEFAULT, new DefaultState());
	}

	private State getCurrentState() {
		try {
			return states.get(currentState);
		} catch (NullPointerException e) {
			System.err.println("Null State!!!");
		}
		return null;
	}

	/**
	 * Registers a {@code GameState} with this {@code StateManager} by mapping
	 * it to a given name.
	 * 
	 * @param name
	 *            The name to map the {@code GameState} to
	 * @param state
	 *            The {@code GameState} to register with this
	 *            {@code StateManager}
	 */
	public void addState(String name, State state) {
		if (states.containsKey(DEFAULT))
			states.remove(DEFAULT);

		state.setManager(this);

		states.put(name, state);
	}

	/**
	 * Sets the first {@code GameState} this {@code StateManager} will handle
	 * 
	 * @param name
	 *            The name of the {@code GameState} to set
	 */
	public void setInitialState(String name) {
		currentState = name;
	}

	/**
	 * Switches the {@code GameState} this {@code StateManager} handles
	 * 
	 * @param name
	 *            The name of the {@code GameState} to switch to
	 */
	public void switchState(String name) {
		if (currentState.equals(name))
			return;

		getCurrentState().switchOut();

		currentState = name;

		getCurrentState().switchIn();
	}

	public Display getDisplay() {
		return display;
	}

	@Internal
	public final void init() {
		getCurrentState().switchIn();
	}

	@Internal
	@Override
	public final void update(double delta) {
		getCurrentState().update(delta);
	}

	@Internal
	@Override
	public final void render() {
		getCurrentState().render();
	}

	@Internal
	@Override
	public final void keyboardInput(Keyboard keyboard) {
		getCurrentState().keyboardInput(keyboard);
	}

	@Internal
	@Override
	public final void mouseInput(Mouse mouse) {
		getCurrentState().mouseInput(mouse);
	}
}