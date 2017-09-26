import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class BallShape extends Rectangle
{

  private int x;
  private int y;
  private Color color;
  private boolean xchange, ychange = false;
  
  public BallShape(int xi, int yi, Color c){
    x = xi;
    y = yi;
    color = c;
    super.width = 20;
    super.height = 20;
  }
  
  public void update(){
    if(xchange){
      x--;
    }
    else{
      x++;
    }
    if(ychange){
      y--;
    }
    else{
      y++;
    }
    super.x = x;
    super.y = y;
  }
 
  public int returnX(){
    return x;
  }
  
  public int returnY(){
    return y;
  }
  
  public Color returnColor(){
    return color;
  }
  
  public void changeX(){
    if(xchange){
      xchange = false;
    }
    else{
      xchange = true;
    }
  }
  
  public void changeY(){
    if(ychange){
      ychange = false;
    }
    else{
      ychange = true;
    }
  }
}
