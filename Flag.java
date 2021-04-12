/* Based on the VUW ecs100 template
 *
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import java.util.ArrayList;

/** 
 * Write a description of class Flag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flag{
    
    //String arr[] = {"Black",blue,cyan,darkGray,gray,green,magenta,orange,pink,red,white, yellow};
    //String colorInput = "a";
    //boolean test = Arrays.asList(arr).contains(colorInput);
    /**
     * Constructor for objects of class Flag 
     */
    public Flag(){
    UI.initialise();
    UI.addButton("Quit", UI::quit);    // Comment out to checkstyle
    }


    /**
     * Main routine
     *
     */
    public static void main(String[] args){
        Map<String, Color> customColours = createColours();
        
        UI.println("Creating your very own custom flag!");
        double x = UI.askDouble("How far away would you like your flag to be from the left? (x coordinate)");
        double y = UI.askDouble("How far away would you like your flag to be from the topt? (y coordinate)");
        double width = UI.askDouble("What will the width of your flag be?");
        double height = UI.askDouble("What will the height of your flag be?");
        
        // prints all possible color options
        UI.println("Colour options:");
        for (String key: customColours.keySet()) {
            UI.println(key);
        }
        
        
        ArrayList<Color> colorPalette = new ArrayList<Color>();
        for (int i = 0; i < 3; i++) {
            //NOTE FOR LATER, MAKE THIS LOOP TILL VALID COLOUR GIVEN
            while(true) {
                String colorSelect = (UI.askString("What will colour " + (i+1) +"  of your flag be?"));
                colorSelect = colorSelect.toLowerCase();
                if(customColours.containsKey(colorSelect)){
                    UI.println("sucess!");
                    colorPalette.add(customColours.get(colorSelect));
                    break;
                }
                else{
                    UI.println("Please select a valid colour.");
                }
            }
        }
        
        // for (Color color: colorPalette) {
            // UI.println(color);
        // }
        //Flag obj = new Flag();
        
        while(true) {
            String orientation = UI.askString("Would you like horizontal or vertical stripes?");
            orientation = orientation.toLowerCase();
            if(orientation.equals("vertical")) {
                UI.println("verty!");
                DrawVertFlag(x,y,width,height,colorPalette);
                break;
            }
            else if(orientation.equals("horizontal")) {
                UI.println("hori!");
                DrawHorizonFlag(x,y,width,height,colorPalette);
                break;
            }
            else {
                UI.println("Please enter a valid input");
            }
        }
    }
    
    public static void DrawVertFlag(double x, double y, double width, double height, ArrayList<Color> colors) {
        UI.setColor(colors.get(2));
        UI.fillRect(x,y,width,height);
        UI.setColor(colors.get(1)); //MAKE THIS ALL CONSTANT
        UI.fillRect(x,y,width,height*2/3);
        UI.setColor(colors.get(0));
        UI.fillRect(x,y,width,height/3);
    }
    
    public static void DrawHorizonFlag(double x, double y, double width, double height, ArrayList<Color> colors) {
        UI.setColor(colors.get(2));
        UI.fillRect(x,y,width,height);
        UI.setColor(colors.get(1));
        UI.fillRect(x,y,width*2/3,height);
        UI.setColor(colors.get(0));
        UI.fillRect(x,y,width/3,height);
        
        
    }
    public static Map createColours(){
    Map<String, Color> customColours = new HashMap<String, Color>();
    //Black,blue,cyan,darkGray,gray,green,lightGray,magenta,orange,pink,red,white, yellow
    customColours.put("black",Color.black);
    customColours.put("blue",Color.blue);
    customColours.put("cyan",Color.cyan);
    customColours.put("gray",Color.gray);
    customColours.put("green",Color.green);
    customColours.put("magenta",Color.magenta);
    customColours.put("orange",Color.orange);
    customColours.put("pink",Color.pink);
    customColours.put("red",Color.red);
    customColours.put("white",Color.white);
    customColours.put("yellow",Color.yellow);
    return customColours;
    }
}

