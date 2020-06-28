package com.cmis242prj3feighnerw;

/*
 * Filename:  CMIS242PRJ3FeighnerW.java
 * Author:    Will Feighner
 * Date:      2020 06 27
 * Purpose:   Create a program to draw specified shapes
 */

// import statements

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CMIS242PRJ3FeighnerW {
  public static void main(String[] args) {
    // instantiate new object from ProgramCore
    ProgramCore frame = new ProgramCore();
    frame.setLocationRelativeTo(null);
    // make GUI appear
    frame.setVisible(true);

  } // end main method

  // Shape class
  public static abstract class Shape extends Rectangle {

    // declare static attributes
    private static int count = 0;

    // declare instance attributes
    private final Color color;
    private final boolean isSolid;

    // constructor
    public Shape(Rectangle rectangle, Color color, boolean isSolid) {
      super(rectangle);
      this.color = color;
      this.isSolid = isSolid;
      Shape.count++;
    } // end constructor

    public static int getNoOfShapes() {
      return count;
    } // end getNoOfShapes()

   /* // setColor method
    public void setColor(Graphics graphic) {

      this.color = graphics.getColor();
    } // end setColor*/

    // getSolid method
    public boolean getSolid(Shape shape) {
      return this.isSolid;
    } // end get solid


    // draw method for parameters of graphic object
    public abstract void draw(Graphics graphics);

  } // end Shape class

  // Oval class, subclass of Shape
  public static class Oval extends Shape {

    // constructor
    public Oval(Rectangle rectangle, Color color, boolean isSolid) {
      super(rectangle, color, isSolid);
    } // end constructor


    @Override
    public void draw(Graphics graphics) {
      graphics.drawOval(this.x, this.y, this.width, this.height);
    } // end draw method

  } // end oval class

  // Rectangular class, subclass of Shape
  public static class Rectangular extends Shape {

    // constructor
    public Rectangular(Rectangle rectangle, Color color, boolean isSolid) {
      super(rectangle, color, isSolid);
    } // end constructor

    // override for drawing rectangle
    @Override
    public void draw(Graphics graphics) {
      graphics.drawRect(this.x, this.y, this.width, this.height);
    }// end drawing

  } // end class Rectangular

  // Drawing class
  public static class Drawing extends JPanel {

    // declare attributes
    private Shape shape;

    public Drawing(Shape shape) {
      this.shape = shape;
    }

    // TODO draw the number of shapes that have been created
    //  thus far in the upper left corner

    // overriden paintComponent method
    @Override
    public void paintComponent(Graphics graphics) {

      // draw shape of graphics
      super.paintComponent(graphics);

      // checking of the shape is null
    } // end paintComponent method

    // overridden getPreferredSize method
    @Override
    public Dimension getPreferredSize() {
      // make the dimensions 200 by 200
      return new Dimension(200, 200);
    } // end getPreferredSize()

    // drawShape method
    public void drawShape(Shape shape) throws OutsideBounds {
if ()
      // repainting the shape
      repaint();
    } // end drawShape

  } // end class Drawing

  // OutsideBounds class
  public static class OutsideBounds extends Exception {
    public OutsideBounds(JFrame frame, String error) {
      JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);
    } // end constructor

  } // end OutsideBounds class

  // ProgramCore class
  static class ProgramCore extends JFrame {

    private JButton clearFieldsButton;
    private JComboBox<String> colorComboBox;
    private JLabel colorLabel;
    private JPanel displayPanel;
    private JButton drawButton;
    private JPanel drawButtonPanel;
    private JPanel drawPanel;
    private JButton exitButton;
    private JComboBox<String> fillTypeComboBox;
    private JLabel fillTypeLabel;
    private JTextField heightInput;
    private JLabel heightLabel;
    private JPanel optionPanel;
    private JLabel shapeCountLabel;
    private JComboBox<String> shapeTypeComboBox;
    private JLabel shapeTypeLabel;
    private JPanel upperPanel;
    private JTextField widthInput;
    private JLabel widthLabel;
    private JTextField xCoordInput;
    private JLabel xCoordLabel;
    private JTextField yCoordInput;
    private JLabel yCoordLabel;

    public ProgramCore() {
      initComponents();
    }

    private void initComponents() {

      displayPanel = new JPanel();
      upperPanel = new JPanel();
      optionPanel = new JPanel();
      shapeTypeLabel = new JLabel();
      shapeTypeComboBox = new JComboBox<>();
      fillTypeLabel = new JLabel();
      fillTypeComboBox = new JComboBox<>();
      colorLabel = new JLabel();
      colorComboBox = new JComboBox<>();
      widthLabel = new JLabel();
      widthInput = new JTextField();
      heightLabel = new JLabel();
      heightInput = new JTextField();
      xCoordLabel = new JLabel();
      xCoordInput = new JTextField();
      yCoordLabel = new JLabel();
      yCoordInput = new JTextField();
      drawPanel = new JPanel();
      shapeCountLabel = new JLabel();
      drawButtonPanel = new JPanel();
      clearFieldsButton = new JButton();
      drawButton = new JButton();
      exitButton = new JButton();

      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      getContentPane().setLayout(new GridLayout());

      displayPanel.setMinimumSize(new Dimension(200, 200));
      displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

      upperPanel.setMinimumSize(new Dimension(600, 300));
      upperPanel.setPreferredSize(new Dimension(600, 300));
      upperPanel.setLayout(new GridLayout(1, 2));

      optionPanel.setLayout(new GridLayout(7, 2, 5, 5));

      shapeTypeLabel.setText(" Shape Type");
      optionPanel.add(shapeTypeLabel);

      shapeTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Oval", "Rectangle"}));

      optionPanel.add(shapeTypeComboBox);

      fillTypeLabel.setText(" Fill Type");
      optionPanel.add(fillTypeLabel);

      fillTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Solid", "Hollow"}));

      optionPanel.add(fillTypeComboBox);

      colorLabel.setText(" Color");
      optionPanel.add(colorLabel);

      colorComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"}));

      optionPanel.add(colorComboBox);

      widthLabel.setText(" Width");
      optionPanel.add(widthLabel);

      widthInput.setText("0");
      optionPanel.add(widthInput);

      heightLabel.setText(" Height");
      optionPanel.add(heightLabel);

      heightInput.setText("0");

      optionPanel.add(heightInput);

      xCoordLabel.setText(" X Coordinate");
      optionPanel.add(xCoordLabel);

      xCoordInput.setText("0");
      optionPanel.add(xCoordInput);

      yCoordLabel.setText(" Y Coordinate");
      optionPanel.add(yCoordLabel);

      yCoordInput.setText("0");
      optionPanel.add(yCoordInput);

      upperPanel.add(optionPanel);

      drawPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape Drawing"));
      drawPanel.setMinimumSize(new Dimension(200, 200));
      drawPanel.setRequestFocusEnabled(false);
      drawPanel.setLayout(new BoxLayout(drawPanel, BoxLayout.PAGE_AXIS));
      drawPanel.setPreferredSize(drawPanel.getPreferredSize());

      shapeCountLabel.setText("   Shapes: 0");
      drawPanel.add(shapeCountLabel);

      upperPanel.add(drawPanel);

      displayPanel.add(upperPanel);

      FlowLayout flowLayout1 = new FlowLayout();
      flowLayout1.setAlignOnBaseline(true);
      drawButtonPanel.setLayout(flowLayout1);

      clearFieldsButton.setText("Clear Fields");
      clearFieldsButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          clearFieldsButtonActionPerformed(evt);
        }
      });
      drawButtonPanel.add(clearFieldsButton);

      drawButton.setText("Draw");
      drawButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          drawButtonActionPerformed(evt);
        }
      });
      drawButtonPanel.add(drawButton);

      exitButton.setText("Exit");
      exitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          exitButtonActionPerformed(evt);
        }
      });
      drawButtonPanel.add(exitButton);

      displayPanel.add(drawButtonPanel);

      getContentPane().add(displayPanel);

      pack();
    }


    private void clearFieldsButtonActionPerformed(ActionEvent evt) {
      yCoordInput.setText("0");
      xCoordInput.setText("0");
      widthInput.setText("0");
      heightInput.setText("0");
      widthInput.requestFocus();
    }

    private void drawButtonActionPerformed(ActionEvent evt) {
      // TODO add your handling code here:

      // check inputs, then create rectangle object
      int xCoord = 0;
      int yCoord = 0;
      int width = 0;
      int height = 0;
      Color color = Color.black;
      boolean isSolid;

      try {
        xCoord = Integer.parseInt(xCoordInput.getText());
      } catch (NumberFormatException numberFormatException) {
        JOptionPane.showMessageDialog(displayPanel, "Please enter an integer", "Error", JOptionPane.ERROR_MESSAGE);
        xCoordInput.setText("0");
        xCoordInput.requestFocus();
      } // end xcoord validate

      try {
        yCoord = Integer.parseInt(yCoordInput.getText());
      } catch (NumberFormatException numberFormatException) {
        JOptionPane.showMessageDialog(displayPanel, "Please enter an integer", "Error", JOptionPane.ERROR_MESSAGE);
        yCoordInput.setText("0");
        yCoordInput.requestFocus();
      } // end ycoord validate

      try {
        width = Integer.parseInt(widthInput.getText());
      } catch (NumberFormatException numberFormatException) {
        JOptionPane.showMessageDialog(displayPanel, "Please enter an integer", "Error", JOptionPane.ERROR_MESSAGE);
        widthInput.setText("0");
        widthInput.requestFocus();
      } // end width validate

      try {
        height = Integer.parseInt(heightInput.getText());
      } catch (NumberFormatException numberFormatException) {
        JOptionPane.showMessageDialog(displayPanel, "Please enter an integer", "Error", JOptionPane.ERROR_MESSAGE);
        heightInput.setText("0");
        heightInput.requestFocus();
      } // end height validate

      // get shape parameters
      switch (colorComboBox.getItemAt(colorComboBox.getSelectedIndex())) {
        case "Black":
          color = Color.black;
        case "Red":
          color = Color.red;
        case "Orange":
          color = Color.orange;
        case "Yellow":
          color = Color.yellow;
        case "Green":
          color = Color.green;
        case "Blue":
          color = Color.blue;
        case "Magenta":
          color = Color.magenta;
      } // end color switch

      if (fillTypeComboBox.getItemAt(fillTypeComboBox.getSelectedIndex()).equals("Solid")) {
        isSolid = true;
      } else {
        isSolid = false;
      }
      Rectangle rectangle = new Rectangle(xCoord, yCoord, width, height);

      if (shapeTypeComboBox.getItemAt(shapeTypeComboBox.getSelectedIndex()).equals("Oval")) {
        Oval oval = new Oval(rectangle, color, isSolid);
        oval.draw();
      } else {
        Rectangular rectangular = new Rectangular(rectangle, color, isSolid);
      }

    }

    private void exitButtonActionPerformed(ActionEvent evt) {
      System.exit(0);
    }
  } // End Program core

} // end class CMIS242PRJ3FeighnerW

