package controllers;
import java.awt.event.KeyEvent;

import models.Presentation;

import java.awt.event.KeyAdapter;

/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {
	PresentationController navigationController;
	
	public KeyController(PresentationController navigationController) {
		this.navigationController = navigationController;
	}

	public void keyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				navigationController.nextSlide();
				break;
			case KeyEvent.VK_LEFT:
				navigationController.previousSlide();
				break;
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				navigationController.forward();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				navigationController.backward();
				break;
			case 'q':
			case 'Q':
				System.exit(0);
				break; // wordt nooit bereikt als het goed is
			default:
				break;
		}
	}
}
