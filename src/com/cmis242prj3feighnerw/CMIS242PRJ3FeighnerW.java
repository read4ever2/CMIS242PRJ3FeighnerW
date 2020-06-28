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

    /* // setColor method
    public void setColor(Graphics graphics){
      this.color = graphics.getColor();
    } // end setColor */

    // getSolid method

    public static int getNoOfShapes() {
      return count;
    } // end getNoOfShapes()

    public boolean getSolid() {
      return isSolid;
    } // end getSolid

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
      // draw the oval shape

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
      // draw the rectangular shape.
    }// end drawing

  } // end class Rectangular

  // Drawing class
  public static class Drawing extends JPanel {

    // declare attributes
    private Shape shape;

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
      // checking boundaries

      // repainting the shape
      repaint();
    } // end drawShape

  } // end class Drawing

  // OutsideBounds class
  public static class OutsideBounds extends Exception {
    // define checked exceptions through extension
  } // end OutsideBounds class

  // ProgramCore class
  static class ProgramCore extends JFrame {

    public ProgramCore() {
      initComponents();
    }

    private void initComponents() {

      JPanel displayPanel = new JPanel();
      JPanel upperPanel = new JPanel();
      JPanel optionPanel = new JPanel();
      JLabel shapeTypeLabel = new JLabel();
      JComboBox<String> shapeTypeComboBox = new JComboBox<>();
      JLabel fillTypeLabel = new JLabel();
      JComboBox<String> fillTypeComboBox = new JComboBox<>();
      JLabel colorLabel = new JLabel();
      JComboBox<String> colorComboBox = new JComboBox<>();
      JLabel widthLabel = new JLabel();
      JTextField widthInput = new JTextField();
      JLabel heightLabel = new JLabel();
      JTextField heightInput = new JTextField();
      JLabel xCoordLabel = new JLabel();
      JTextField xCoordInput = new JTextField();
      JLabel yCoordLabel = new JLabel();
      JTextField yCoordInput = new JTextField();
      Drawing drawPanel = new Drawing();
      JLabel shapeCountLabel = new JLabel();
      JPanel drawButtonPanel = new JPanel();
      JButton clearFieldsButton = new JButton();
      JButton drawButton = new JButton();
      JButton exitButton = new JButton();

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
      shapeTypeComboBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          shapeTypeComboBoxActionPerformed(evt);
        }
      });
      optionPanel.add(shapeTypeComboBox);

      fillTypeLabel.setText(" Fill Type");
      optionPanel.add(fillTypeLabel);

      fillTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Solid", "Hollow"}));
      fillTypeComboBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          fillTypeComboBoxActionPerformed(evt);
        }
      });
      optionPanel.add(fillTypeComboBox);

      colorLabel.setText(" Color");
      optionPanel.add(colorLabel);

      colorComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"}));
      colorComboBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          colorComboBoxActionPerformed(evt);
        }
      });
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
      drawPanel.setName("Shape Drawing"); // NOI18N
      drawPanel.setRequestFocusEnabled(false);
      drawPanel.setLayout(new BoxLayout(drawPanel, BoxLayout.PAGE_AXIS));

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

    private void shapeTypeComboBoxActionPerformed(ActionEvent evt) {
      // TODO add your handling code here:
    }

    private void fillTypeComboBoxActionPerformed(ActionEvent evt) {
      // TODO add your handling code here:
    }

    private void colorComboBoxActionPerformed(ActionEvent evt) {
      // TODO add your handling code here:
    }

    private void clearFieldsButtonActionPerformed(ActionEvent evt) {
      // TODO add your handling code here:
    }

    private void drawButtonActionPerformed(ActionEvent evt) {
      // TODO add your handling code here:
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
      System.exit(0);
    }
  } // End Program core

} // end class CMIS242PRJ3FeighnerW

