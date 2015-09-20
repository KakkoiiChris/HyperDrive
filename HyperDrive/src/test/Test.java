package test;

import net.alexanderdev.hyperdrive.media.graphics.Display;

public class Test {
	public static void main(String[] args) {
		new Display("Hello World") {
			{
				enableKeyboard(true);
			}
		}.open();
	}
}