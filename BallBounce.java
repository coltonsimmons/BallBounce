import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallBounce implements Runnable, MouseMotionListener
{

  JFrame frame;
  JPanel pane;
  Ball ball;
  BallShape b1;
  BallShape b2;
  BallShape b3;
  BallShape b4;
  BallShape b5;
  BallShape b6;
  BallShape b7;
  Timer t;
  boolean directX = false;
  boolean directY = false;
  int x, y = Integer.MAX_VALUE;
  ArrayList<BallShape> balls;
  Random rand;
  
  @Override
  public void run()
  {
    balls = new ArrayList<BallShape>();

    ActionListener taskPerformer = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        if(intersects(x, y)){
          System.exit(0);
        }
        for(int i = 0; i < balls.size(); i++){
          for(int ii = i+1; ii < balls.size(); ii++){
            if(balls.get(i).intersects(balls.get(ii))){
              balls.get(ii).changeX();
              balls.get(ii).changeY();
              balls.get(i).changeX();
              balls.get(i).changeY();
            }
          }
        if(balls.get(i).returnX() >= 180 || balls.get(i).returnX() < 0){
          balls.get(i).changeX(); 
        }
        if(balls.get(i).returnY()>= 460 || balls.get(i).returnY() < 0){
          balls.get(i).changeY();
        }
        balls.get(i).update();
      }
        ball.repaint();

      }
     
      };
      
    
    frame = new JFrame("Ball Bounce");
    frame.setBounds(0, 0, 200, 500);
    
    pane = new JPanel(null);
    pane.setBounds(0, 0, 200, 500);
    
    ball = new Ball(); 
    ball.setBounds(0, 0, 200, 500);
    
    rand = new Random(System.currentTimeMillis());
    b1 = new BallShape(rand.nextInt(160), rand.nextInt(460), Color.BLACK);
    b2 = new BallShape(rand.nextInt(160), rand.nextInt(460), Color.RED);
    b3 = new BallShape(rand.nextInt(160), rand.nextInt(460), Color.PINK);
    b4 = new BallShape(rand.nextInt(160), rand.nextInt(460), Color.ORANGE);
    b5 = new BallShape(rand.nextInt(160), rand.nextInt(460), Color.GREEN);
    b6 = new BallShape(rand.nextInt(160), rand.nextInt(460), Color.YELLOW);
    b7 = new BallShape(rand.nextInt(160), rand.nextInt(460), Color.MAGENTA);
    

    ball.addBall(b1);
    ball.addBall(b2);
    ball.addBall(b3);
    ball.addBall(b4);
    ball.addBall(b5);
    ball.addBall(b6);
    ball.addBall(b7);
  
    balls.add(b1);
    balls.add(b2);
    balls.add(b3);
    balls.add(b4);
    balls.add(b5);
    balls.add(b6);
    balls.add(b7);

    
    
    frame.add(pane);
    pane.add(ball);
    ball.setBackground(Color.CYAN);
    pane.addMouseMotionListener(this);
    frame.setVisible(true);
    
    t = new Timer(10, taskPerformer);
    t.start();
    
  }
  @Override
  public void mouseDragged(MouseEvent e)
  {
    System.out.println(e.getX() + "\t" + e.getY());
    if(e.getX()>= ball.x && e.getX() <= ball.x+40){
      System.exit(0);
    }
    
    if(e.getY()>= ball.y && e.getY() <= ball.y+40){
      System.exit(0);
    }
    
  }
  @Override
  public void mouseMoved(MouseEvent e)
  {
    x = e.getX();
    y = e.getY();
  }
  
  private boolean intersects(int w, int h){
    for(int i = 0; i < balls.size(); i++){
     if(balls.get(i).intersects(x, y, 1, 1)){
       return true;
      }
    }
    return false;
  }
  
 

}
