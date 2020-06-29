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

    // get no of shapes method
    public static int getNoOfShapes() {
      return count;
    } // end getNoOfShapes()

    // setColor method
    public void setColor(Graphics graphic) {
      graphic.setColor(this.color);
    } // end setColor

    // getSolid method
    public boolean getSolid(Shape shape) {
      return shape.isSolid;
    } // end get solid


    // abstract draw method for parameters of graphic object
    public abstract void draw(Graphics graphics);

  } // end Shape class

  // Oval class, subclass of Shape
  public static class Oval extends Shape {

    // constructor
    public Oval(Rectangle rectangle, Color color, boolean isSolid) {
      super(rectangle, color, isSolid);
    } // end constructor

    // override draw oval on graphics object
    @Override
    public void draw(Graphics graphics) {
      this.setColor(graphics);
      if (this.getSolid(this)) {
        graphics.fillOval(this.x, this.y, this.width, this.height);
      } else {
        graphics.drawOval(this.x, this.y, this.width, this.height);
      } // end if/else
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
      this.setColor(graphics);
      if (this.getSolid(this)) {
        graphics.fillRect(this.x, this.y, this.width, this.height);
      } else {
        graphics.drawRect(this.x, this.y, this.width, this.height);
      } // end if/else block
    } // end draw method

  } // end class Rectangular

  // Drawing class
  public static class Drawing extends JPanel {

    // declare attributes
    private Shape shape;

    // overridden paintComponent method
    @Override
    public void paintComponent(Graphics graphics) {

      // draw everything else
      super.paintComponent(graphics);

      // checking of the shape is null
      if (shape != null) {

        // draw shape
        shape.draw(graphics);

      } // end null test
    } // end paintComponent method

    // overridden getPreferredSize method
    @Override
    public Dimension getPreferredSize() {
      // make the dimensions 200 by 200
      return new Dimension(200, 200);
    } // end getPreferredSize()

    // drawShape method
    public void drawShape(Shape shape) throws OutsideBounds {
      this.shape = shape;
      if ((shape.width > 200) || (shape.height > 200)) {
        Shape.count--;
        throw new OutsideBounds(null, "Please enter an integer less than or equal to 200");
      }

      // repainting the shape
      repaint();

    } // end drawShape

  } // end class Drawing

  // OutsideBounds class
  public static class OutsideBounds extends Exception {

    // constructor
    public OutsideBounds(JFrame frame, String error) {
      JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.ERROR_MESSAGE);
    } // end constructor

  } // end OutsideBounds class

  // ProgramCore class
  static class ProgramCore extends JFrame {

    // Declare fields
    private JButton clearFieldsButton;
    private JComboBox<String> colorComboBox;
    private JLabel colorLabel;
    private JPanel displayPanel;
    private JButton drawButton;
    private JPanel drawButtonPanel;
    private Drawing drawPanel;
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
    private JPanel centeringPanel;

    // Constructor
    public ProgramCore() {
      initComponents();
    } // end constructor

    // create and organize components
    private void initComponents() {

      displayPanel = new JPanel();
      centeringPanel = new JPanel();
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
      drawPanel = new Drawing();
      shapeCountLabel = new JLabel();
      drawButtonPanel = new JPanel();
      clearFieldsButton = new JButton();
      drawButton = new JButton();
      exitButton = new JButton();

      // frame parameters
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      getContentPane().setLayout(new GridLayout());

      // panels parameters
      displayPanel.setMinimumSize(new Dimension(200, 200));
      displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

      upperPanel.setMinimumSize(new Dimension(450, 210));
      upperPanel.setPreferredSize(new Dimension(450, 210));
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

      shapeCountLabel.setText("   Shapes: " + Shape.getNoOfShapes());
      drawPanel.add(shapeCountLabel);


      upperPanel.add(drawPanel);

      displayPanel.add(upperPanel);

      FlowLayout flowLayout1 = new FlowLayout();
      flowLayout1.setAlignOnBaseline(true);
      drawButtonPanel.setLayout(flowLayout1);

      clearFieldsButton.setText("Clear Fields");

      // clear fields action listeners
      clearFieldsButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          clearFieldsButtonActionPerformed(evt);
        }
      });
      drawButtonPanel.add(clearFieldsButton);

      drawButton.setText("Draw");

      // draw button action listeners
      drawButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          drawButtonActionPerformed(evt);
        }
      });
      drawButtonPanel.add(drawButton);

      exitButton.setText("Exit");

      // exit button actin listener
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

// clear fields method
    private void clearFieldsButtonActionPerformed(ActionEvent evt) {
      yCoordInput.setText("0");
      xCoordInput.setText("0");
      widthInput.setText("0");
      heightInput.setText("0");
      widthInput.requestFocus();
    }

    // draw button method
    private void drawButtonActionPerformed(ActionEvent evt) {

      // check inputs, then create rectangle object
      int xCoord = -1;
      int yCoord = -1;
      int width = -1;
      int height = -1;
      Color color = Color.black;
      boolean isSolid;
      Rectangle rectangle;

      // validate integer inputs
      try {
        xCoord = Integer.parseInt(xCoordInput.getText());
        yCoord = Integer.parseInt(yCoordInput.getText());
        width = Integer.parseInt(widthInput.getText());
        height = Integer.parseInt(heightInput.getText());
      } catch (NumberFormatException numberFormatException) {
        JOptionPane.showMessageDialog(displayPanel, "Please enter an integer in the input field", "Error", JOptionPane.ERROR_MESSAGE);
        xCoordInput.setText("0");
        xCoordInput.requestFocus();
        yCoordInput.setText("0");
        widthInput.setText("0");
        heightInput.setText("0");
      } // end validate


      // get shape parameters
      switch (colorComboBox.getItemAt(colorComboBox.getSelectedIndex())) {
        case "Black":
          color = Color.black;
          break;
        case "Red":
          color = Color.red;
          break;
        case "Orange":
          color = Color.orange;
          break;
        case "Yellow":
          color = Color.yellow;
          break;
        case "Green":
          color = Color.green;
          break;
        case "Blue":
          color = Color.blue;
          break;
        case "Magenta":
          color = Color.magenta;
      } // end color switch

      isSolid = fillTypeComboBox.getItemAt(fillTypeComboBox.getSelectedIndex()).equals("Solid");

      // create rectangle
      rectangle = new Rectangle(xCoord, yCoord, width, height);

      // create new shape if valid rectangle dimensions were entered
      if (!((xCoord == -1) || (yCoord == -1) || (height == -1) || (width == -1))) {
        if (shapeTypeComboBox.getItemAt(shapeTypeComboBox.getSelectedIndex()).equals("Oval")) {
          Oval oval = new Oval(rectangle, color, isSolid);
          try {
            drawPanel.drawShape(oval);
          } catch (OutsideBounds outsideBounds) {
          } // end oval try-catch
        } else {
          Rectangular rectangular = new Rectangular(rectangle, color, isSolid);
          try {
            drawPanel.drawShape(rectangular);
          } catch (OutsideBounds outsideBounds) {
          } // end rectangle try-catch
        } // end shape selection if-else block
      } // end shape creation block

      // update valid shapes label
      shapeCountLabel.setText("   Shapes: " + Shape.getNoOfShapes());
    }//end draw button action

    // exit button method
    private void exitButtonActionPerformed(ActionEvent evt) {
      System.exit(0);
    }
  } // End Program core

} // end class CMIS242PRJ3FeighnerW

