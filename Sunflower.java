import java.awt.Color;
import java.awt.Graphics;
/**
 * Write a description of class Sunflower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sunflower
{
    private Color COLOR_CENTER = new Color(97,54,23);
    private Color COLOR_PETALS = new Color(252,206,1);
    
    private int drawingSize;                         
    private int centerRadius;
    private int petalCount;

    /**
     * Constructor for objects of class Sunflower
     */
    public Sunflower(int drawingSize, int centerRadius, int petalCount) {
        // add preconditions  
        this.drawingSize = drawingSize;
        this.centerRadius = centerRadius;
        this.petalCount = petalCount;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void draw() {
       
        Color sky = new Color(143,170,220); // add to panel background color
        
        DrawingPanel panel = new DrawingPanel(400,400);
        Graphics graphics = panel.getGraphics();
        
        int xCenter = -centerRadius;//(drawingSize/2) - 1; // 200 -1 = 199
        int yCenter = centerRadius;//(drawingSize/2) - 1; 
        Circle sunflowerCenterCircle = new Circle(COLOR_CENTER,xCenter,yCenter,100);
        graphics.setColor(COLOR_CENTER);
        sunflowerCenterCircle.draw(graphics,400);
        sleepHalfSecond();
        graphics.setColor(COLOR_PETALS);
        //Circle[] petal = new Circle[petalCount];
        double radiansDividedbyPetalCount = (2*Math.PI)/petalCount;
        
        for (int numPetals = 0; numPetals < petalCount; numPetals ++) {
            double x = centerRadius*(Math.cos(radiansDividedbyPetalCount*numPetals)); // * centerRadius to scale it +centerRadius/2
            double y = centerRadius*(Math.sin(radiansDividedbyPetalCount*numPetals)); // * numPetals to keep rotating it around the unit circle
            Circle petal = new Circle(COLOR_PETALS,x,y,centerRadius/2);
            petal.draw(graphics,drawingSize);
            sleepHalfSecond();
            petal.toString();
            //petal[numPetals] = new Circle(COLOR_PETALS,x, y,centerRadius/2);
            //petal[numPetals].draw(graphics,drawingSize);
            //petal[numPetals].toString();      
        }
    }
    
    private void sleepHalfSecond() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }
        
        
    }
}
