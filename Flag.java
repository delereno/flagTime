/* Based on the VUW ecs100 template
 *
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import java.util.ArrayList;


/** 
 * Allows user to create a custom flag, 
 * or use a function to create a preset country flag
 * 
 *
 * @author Del Huang
 * @version 12/4/21
 */
public class Flag {
    
    
    /**
     * Constructor for objects of class Flag 
     */
    public Flag() {
        UI.initialise();
        
        //Buttons allow for methods to be called, or to quit window
        // UI.addButton("Custom Flag", this::customFlag);
        // UI.addButton("Japan", this::drawJapan);
        // UI.addButton("Switzerland", this::drawSwitzerland);
        // UI.addButton("Vietnam", this::drawVietnam);
        // UI.addButton("Korea", this::drawKorea); //not finished
        // UI.addButton("Quit", UI::quit);
    }

    // fields
    /**While the program is running */
    public static final boolean RUNNING = true;
    /**default x coordinate*/
    public static final double DEFAULTX = 20.0; 
    /**default y coordinate*/
    public static final double DEFAULTY = 20.0; 
    /**index constant for color 1*/
    public static final int COLOUR1 = 0;
    /**index constant for color 2*/
    public static final int COLOUR2 = 1;
    /**index constant for color 3*/
    public static final int COLOUR3 = 2;
    /**
     * Main routine
     * @param args all command line arguments given by the user
     */
    public static void main(String[] args) {
        Flag obj = new Flag(); //creates new Flag object
       
    }
    /**
     * Allows the user to make a custom flag
     * Decides position, color and orientation
     */
    public void customFlag() {
        UI.clearGraphics(); //clears graphics onscreen
        double x = 0.0; // flag coordinate distance from left side
        double y = 0.0; //flag coodinate distance from top
        double width = 0.0; //flag width
        double height = 0.0; //flag height
        
        // uses method to create map of colours
        Map<String, Color> customColours = this.createColours();
        
        UI.println("Creating your very own custom flag!");
        
        //asks user for valid flag x coordinate
        while (RUNNING) {
            x = UI.askDouble("Please set the x-coordinate.");
            if (x >= 0) {
                break;
            }
            else {
                UI.println("Please give a valid input  (>=0)");
            }
        }
        //asks user for valid flag y coordinate
        while (RUNNING) {
            y = UI.askDouble("Please set the y-coordinate.");            
            if (y >= 0) {
                break;
            }
            else {
                UI.println("please give a valid input  (>=0)");
            }
        }
        //asks user for valid flag width
        while (RUNNING) {
            width = UI.askDouble("Set your flag width.");         
            if (width >= 10) {
                break;
            }
            else {
                UI.println("please give a valid input  (>=10)");
            }
        } 
        //asks user for a valid flag height
        while (RUNNING) {
            height = UI.askDouble("Set your flag height.");      
            if (height >= 10) {
                break;
            }
            else {
                UI.println("please give a valid input  (>=10)");
            }
        }  
            
        // prints all possible color options
        UI.println("Colour options:");
        for (String key : customColours.keySet()) {
            UI.println(key);
        }
        
        //asks user for 3 valid colors, checks if valid using map
        ArrayList<Color> colorPalette = new ArrayList<Color>();
        for (int i = 0; i < 3; i++) {
            while (RUNNING) {
                String colorSelect = (UI.askString("What will colour " +
                    (i + 1) + "  of your flag be?"));
                colorSelect = colorSelect.toLowerCase();
                //if valid, color is added to ArrayList
                if (customColours.containsKey(colorSelect)) {
                    colorPalette.add(customColours.get(colorSelect));
                    break;
                }
                else {
                    UI.println("Please select a valid colour.");
                }
            }
        }
        
        //asks user to choose between a vertical or horizontal flag orientation
        while (RUNNING) {
            String orientation = 
                UI.askString("Would you like horizontal or vertical stripes?");
            orientation = orientation.toLowerCase();
            //calls relevant methods if valid input given
            if (orientation.equals("vertical")) {
                this.drawVertFlag(x, y, width, height, colorPalette);
                break;
            }
            else if (orientation.equals("horizontal")) {
                this.drawHorizonFlag(x, y, width, height, colorPalette);
                break;
            }
            else {
                UI.println("Please enter a valid input");
            }
        }
    } 
    
    /**
     * Draws a vertical flag
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param width Flag width
     * @param height Flag height
     * @param colors Flag colours 
     */
    public void drawVertFlag(double x, double y, double width,
        double height, ArrayList<Color> colors) {
        //sets color, then fills each rectangle third
        UI.setColor(colors.get(COLOUR3));
        UI.fillRect(x, y, width, height);
        UI.setColor(colors.get(COLOUR2));
        UI.fillRect(x, y, width * 2.0 / 3.0, height);
        UI.setColor(colors.get(COLOUR1));
        UI.fillRect(x, y, width / 3.0, height);
    }
    
    /**
     * Draws a horizontal flag
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param width Flag width
     * @param height Flag height
     * @param colors Flag colours 
     */
    public void drawHorizonFlag(double x, double y, double width,
        double height, ArrayList<Color> colors) {
        //sets color, then fills each rectangle third
        UI.setColor(colors.get(COLOUR3));
        UI.fillRect(x, y, width, height);
        UI.setColor(colors.get(COLOUR2)); 
        UI.fillRect(x, y, width, height * 2.0 / 3.0);
        UI.setColor(colors.get(COLOUR1));
        UI.fillRect(x, y, width, height / 3.0);
    }
    /**
     * Creates a map for colour values
     * @return Returns map
     */
    public Map createColours() {
        //Creates a map for colour values, with String Keys assigned to each
        Map<String, Color> customColours = new HashMap<String, Color>();
        
        //adds colours
        customColours.put("black", Color.black);
        customColours.put("blue", Color.blue);
        customColours.put("cyan", Color.cyan);
        customColours.put("gray", Color.gray);
        customColours.put("green", Color.green);
        customColours.put("magenta", Color.magenta);
        customColours.put("orange", Color.orange);
        customColours.put("pink", Color.pink);
        customColours.put("red", Color.red);
        customColours.put("white", Color.white);
        customColours.put("yellow", Color.yellow);
        
        return customColours; 
    }
    /**
     * Draws the Japanese flag
     */
    public void drawJapan() {
        UI.clearGraphics(); //clears onscreen graphics
        
        //asks for flag width, calculates other measurements
        double width = UI.askDouble("What will the flag's width be?");
        double height = width * 2.0 / 3.0;
        double ovalPosX = DEFAULTX + width * 3.0 / 10.0;
        double ovalPosY = DEFAULTY + height / 5;
        double ovalDiam = height * 3 / 5;
        
        //draws flag
        UI.setColor(Color.black); //flag outline
        UI.drawRect(DEFAULTX, DEFAULTY, width, height);
        UI.setColor(Color.red);
        UI.fillOval(ovalPosX, ovalPosY, ovalDiam, ovalDiam);
    }
    /**
     * Draws the Switzerland flag
     */
    public void drawSwitzerland() {
        UI.clearGraphics(); //clears onscreen graphics
        
        //asks for flag size, calculates other measurements
        double size = UI.askDouble("What will the flag's width be?");
        double crossWidth = size * 6.0 / 32.0;
        double crossLength = size - 2 * crossWidth;
        double crossPos = size * 13.0 / 32.0;
        
        //draws flag
        UI.setColor(Color.red); //flag outline
        UI.fillRect(DEFAULTX, DEFAULTY, size, size);
        UI.setColor(Color.white);
        UI.fillRect(DEFAULTX + crossPos, 
            DEFAULTY + crossWidth, crossWidth, crossLength);
        UI.fillRect(DEFAULTX + crossWidth, 
            DEFAULTY + crossPos, crossLength, crossWidth);
    }
    
    /**
     * Draws the Vietnam flag
     */
    public void drawVietnam() {
        /*
         * Notes for drawing star
         * x & y array coords start at top, move clockwise
         * 10 points
         * star radius of 50
         * rectangle measurements are temporary, need adjusting
         * flag ratio should be 2:3, not 3:4
         * implement use of constants
         */
        UI.clearGraphics(); //clears onscreen graphics
        
        //pain
        double[] posX = {100, 111, 148, 118, 130, 100, 70, 82, 52, 89};
        double[] posY = {25, 59, 59, 81, 116, 93, 116, 81, 59, 59};
        UI.setColor(Color.red);
        UI.fillRect(0, 0, 200, 150);
        UI.setColor(Color.yellow);
        UI.fillPolygon(posX, posY, 10);

    }
    
    /**
     * Draws the Korean flag
     */
    public void drawKorea() {
        
        //PAIN (incomplete, please ignore button and code)
        UI.clearGraphics();
        double width = 300;
        double height = 200;
        double radius = 50;
        
        UI.setColor(Color.white);
        UI.fillRect(0, 0, width, height);
        UI.setColor(Color.black);
        UI.drawRect(0, 0, width, height);
        /*
         * arc notes
         * arc(x,y,width,height, start of angle, angle length
         * anngle is measured anti clockwise
         * circle is weirdly rotated right now
         * figure out how to rotate things please 
         */
        UI.setColor(Color.red);
        UI.fillArc(width / 2 - radius, height / 2 - radius,
            2 * radius, 2 * radius, 0.0, 180.0);
        UI.setColor(Color.blue);
        UI.fillArc(width / 2 - radius, height / 2 - radius,
            2 * radius, 2 * radius, 180.0, 180.0);
        
        //creating the yin yang effect with smaller circles
        UI.setColor(Color.red);
        UI.fillArc(width / 2 - radius, height / 2 - radius / 2,
            radius, radius, 180.0, 180.0);
        UI.setColor(Color.blue);
        UI.fillArc(width / 2, height / 2 - radius / 2, 
            radius, radius, 0.0, 180.0);
        
        //creating the trigrams with boxes
    }
    
}

