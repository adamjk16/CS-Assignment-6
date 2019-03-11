/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.Color;
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
	private NameSurferDataBase database;
	private GLabel nameLabel;
	private GLine plotLine;

	/*
	 * initializes program -- adds buttons, opens database
	 */
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
		database = new NameSurferDataBase(NAMES_DATA_FILE);
	}

	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Clear")) {
			redraw();
		} else {
			name = inputName.getText();							//gets name input by user into text field
			NameSurferEntry entry = database.findEntry(name);	//finds user input name in the database
			char firstLetter = name.charAt(0);
			if (Character.isLowerCase(firstLetter)) {
				firstLetter = Character.toUpperCase(firstLetter);
			}
			String nextLetters = name.substring(1);
			String nextLettersLowercase = nextLetters.toLowerCase();
			name = firstLetter + nextLettersLowercase;
			plotGraph(entry);							
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
	
	/*
	 * draws each vertical line on the graph (one for each decade)
	 */
	private void drawYAxis() {
		for (int i = 0; i < NDECADES; i++) {
			GLine line = new GLine((getWidth()/NDECADES) * i, 0, (getWidth()/NDECADES) * i, getHeight());
			add(line);
		}
	}
	
	/*
	 * draws two horizontal lines on graph -- upper and lower bounds
	 */
	private void drawXAxis() {
		GLine upperLine = new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE);
		add(upperLine);
		GLine lowerLine = new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE);
		add(lowerLine);
	}
	
	/*
	 * adds decade label to each vertical line, each of which represents
	 * a decade
	 */
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
	

	/*
	 * Plots the user input name's ranking for each decade by plotting a line
	 * between two points/decades for the duration of the graph. This method also
	 * adds a label of the name and ranking of the name at each decade/point.
	 */
	private void plotGraph (NameSurferEntry entry) {
		for (int i = 0; i < NDECADES; i++) {
			int rankOne = entry.getRank(i);
			int rankTwo = entry.getRank(i + 1);
			int xPointOne = (getWidth() / NDECADES) * i;
			int yPointOne;
			int xPointTwo = (getWidth() / NDECADES) * (i + 1);
			int yPointTwo;
			if (rankOne == 0) {
				yPointOne = getHeight() - GRAPH_MARGIN_SIZE;
				nameLabel = new GLabel (entry.getName() + "*", xPointOne, yPointOne);
			} else {
				yPointOne = ((rankOne * (getHeight() - (GRAPH_MARGIN_SIZE * 2)) / MAX_RANK) + GRAPH_MARGIN_SIZE);
				nameLabel = new GLabel (entry.getName() + " " + rankOne, xPointOne, yPointOne);
			}
			if (rankTwo == 0) {
				yPointTwo = getHeight() - GRAPH_MARGIN_SIZE;
				
			} else {
				yPointTwo = ((rankTwo * (getHeight() - (GRAPH_MARGIN_SIZE * 2)) / MAX_RANK) + GRAPH_MARGIN_SIZE);
				
			}
			plotLine = new GLine (xPointOne, yPointOne, xPointTwo, yPointTwo);
			/* could not figure out how to fully implement colors
			 * 	if (number % 4 == 1) {
					plotLine.color(Color.BLACK);
					nameLabel.color(Color.BLACK);
				} else if (number % 4 == 2) {
					plotLine.color(Color.RED);
					nameLabel.color(Color.BLACK);
				} else if (number % 4 == 3) {
					plotLine.setColor(Color.BLUE);
					nameLabel.color(Color.BLACK);
				} else if (color % 4 == 4) {
					plotLine.setColor(Color.MAGENTA);
					nameLabel.color(Color.BLACK);
				}
			 */
			add (plotLine);
			add (nameLabel);
		}
	}
}	
	
	


	
	