/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import acm.util.*;

public class NameSurfer extends GraphicsProgram implements NameSurferConstants {

	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	
	private JTextField inputName;
	
	public void init() {
		JLabel nameLabel = new JLabel("Name: ");
		add(nameLabel, NORTH);
		inputName = new JTextField(TEXT_FIELD_WIDTH);
		add(inputName, NORTH);
		inputName.addActionListener(this);
		JButton graphButton = new JButton("Graph");
		add(graphButton, NORTH);
		JButton clearButton = new JButton("Clear");
		add(clearButton, NORTH);
		addActionListeners();
		
		
	}

	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Graph")) {
			String name = inputName.getText();
			println("Graph: " + name);
		} else if (e.getActionCommand().equals("Clear")) {
			println("Clear");
		}
		
	}
	
	/**
	 * This class is responsible for detecting when the the canvas
	 * is resized. This method is called on each resize!
	 */
	public void componentResized(ComponentEvent e) { 
		redraw();
	}
	
	/**
	 * A helper method that we *strongly* recommend. Redraw clears the
	 * entire display and repaints it. Consider calling it when you change
	 * anything about the display.
	 */
	private void redraw() {
		drawVerticalLines();
	}
	
	private void drawVerticalLines() {
		for (int i = 0; i < NDECADES; i++) {
			GLine line = new GLine(getWidth() * i, GRAPH_MARGIN_SIZE, getWidth() * i, getHeight());
			add(line);
		}
	}
}