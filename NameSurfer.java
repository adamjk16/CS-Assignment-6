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
	private GLabel decadeLabel;
	private String name;
	private NameSurferDataBase database = new NameSurferDataBase(NAMES_DATA_FILE);
	private NameSurferEntry dataString;

	
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
			name = inputName.getText();
			NameSurferEntry entry = database.findEntry(name);
			plotGraph(entry);
			println(entry);
		} else if (e.getActionCommand().equals("Clear")) {
			
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
		removeAll();
		drawYAxis();
		drawXAxis();
		addLabels();
	}
	
	private void drawYAxis() {
		for (int i = 0; i < NDECADES; i++) {
			GLine line = new GLine((getWidth()/NDECADES) * i, 0, (getWidth()/NDECADES) * i, getHeight());
			add(line);
		}
	}
	
	private void drawXAxis() {
		GLine upperLine = new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE);
		add(upperLine);
		GLine lowerLine = new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE);
		add(lowerLine);
	}
	
	private void addLabels() { 
		for (int i = 0; i < NDECADES; i++) {
			if (i < NDECADES - 1) {
				decadeLabel = new GLabel("19" + i + "0");
			} else if (i == NDECADES - 1) {
				decadeLabel = new GLabel ("2000");
			}
			add(decadeLabel, (getWidth()/NDECADES) * i, getHeight() - DECADE_LABEL_MARGIN_SIZE);
		}
	}
	
	private void plotGraph (NameSurferEntry entry) {
		for (int i = 0; i < NDECADES - 1; i++) {
			int a = entry.getRank(i);
			int b = entry.getRank(i + 1);
			int xPointOne = (getWidth() / NDECADES) * i;
			int yPointOne = 0;
			int xPointTwo = (getWidth() / NDECADES) * (i + 1);
			int yPointTwo = 0;
			if (a == 0) {
				yPointOne = getHeight() - GRAPH_MARGIN_SIZE;
			} else {
				yPointOne = getHeight() - GRAPH_MARGIN_SIZE - (a / MAX_RANK);
			} 
			if (b == 0) {
				yPointTwo = getHeight() - GRAPH_MARGIN_SIZE;
			} else {
				yPointTwo = getHeight() - GRAPH_MARGIN_SIZE - (b / MAX_RANK);
			}
			GLine plotLine = new GLine (xPointOne, yPointOne, xPointTwo, yPointTwo);
			add (plotLine);
			
		}
	}
}	
	
	