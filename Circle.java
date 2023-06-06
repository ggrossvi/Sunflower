import java.awt.Color;
import java.awt.Graphics;
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle{
    // instance variables - replace the example below with your own
    private Color color;
    private double centerX;
    private double centerY;
    private double radius;
    

    /**
     * Constructor for objects of class Circle
     */
    public Circle(Color color, double centerX,double centerY, double radius) {
        // initialise instance variables
        if (color == null) {
            throw new IllegalArgumentException("Color must not be null.");
        }
        setColor(color); //this.color = color ask Barry
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Color getColor() {
        return color;
    }
    
    public double getCenterX() {
        return centerX;
    }
    
    public double getCenterY() {
        return centerY;
    }
    
    public double getRadius() {
        return radius;
    }
    
    
    public void setColor(Color color) {
        color = color;
    }
    
    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }
    
    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public void draw(Graphics graphics, int drawSize) {
        double x = cartesianXToGraphics(drawSize,getCenterX());
        double y = cartesianYToGraphics(drawSize,getCenterY());
        int width = 2*(int)(this.getRadius());
        int height = 2*(int)(this.getRadius());
        graphics.fillOval((int)x,(int)y,width,height); // round instead of int
    }
    
    public String toString() {
        //System.out.printf("Circle centered at %s", getCenterX());
        return "Circle centered at (" + getCenterX() + "," + getCenterY() + ") with radius " + getRadius() + "\n" +
        "color java.awt.Color [" + getColor();
    }
    
    static double cartesianXToGraphics(int drawWidth, double x) {
        double xGraphics = (drawWidth/2) + x; 
        return xGraphics;
    }
    
    static double cartesianYToGraphics(int drawWidth, double y) {
        double yGraphics = (drawWidth/2) -y;
        return yGraphics;
    }

    public static void main(String[] args) {
        // drawing size,radius,petal count
        Sunflower sunflower = new Sunflower(400,100,9);
        sunflower.draw();
        
        
    }
}
