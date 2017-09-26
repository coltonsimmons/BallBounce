import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Class used to paint Balls.
 * @author Colton Simmons
 *
 */
public class Ball extends JPanel
{

  private int count = 0;
  public static int x = 0, y = 0;
  private Color color;
  private ArrayList<BallShape> balls;
  /**
   * Default Constructor.
   */
  public Ball(){
    balls = new ArrayList<BallShape>();
  }
  
  
  public void addBall(BallShape b){
    balls.add(b);
  }
  @Override
  protected void paintComponent(Graphics g) {
      //super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      count++;
      for(int i = 0; i < balls.size(); i++){
        g2.drawOval(balls.get(i).returnX(), balls.get(i).returnY(), 20, 20);
        g2.setColor(balls.get(i).returnColor());
        g2.fillOval(balls.get(i).returnX(), balls.get(i).returnY(), 20, 20);
      }
      String s = Integer.toString(count);
      g2.drawString(s, 150, 15);
      
      
  }
}
