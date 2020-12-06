import java.lang.*;
import java.util.Random;

class ThreadRandom extends Thread{
  public int x;
  public void run(){
    Random random = new Random();
    this.x = random.nextInt(10);
  }

  public int getX(){
    return this.x;
  }
}

class ThreadSquare extends Thread{
  private int x;
  public void setX(Integer x){
    this.x = x;
  }

  public void run(){
    int x = this.x;
    if(x%2 == 0){
      System.out.println(x*x);
    }
  }
}

class ThreadCube extends Thread{
  private int x;
  public void setX(Integer x){
    this.x = x;
  }

  public void run(){
    int x = this.x;
    if(x%2 != 0){
      System.out.println(x*x*x);
    }
  }
}


public class MultiThreading{
  public static void main(String[] args){
    ThreadRandom tr = new ThreadRandom();
    ThreadSquare ts = new ThreadSquare();
    ThreadCube tc = new ThreadCube();

    Integer x;

    while(true){
      tr.run();
      x = tr.getX();
      ts.setX(x);
      tc.setX(x);
      ts.run();tc.run();
      try{
        tr.sleep(1000);
        // ts.sleep(1000);
        // tc.sleep(1000);
      }catch(Exception e){
        continue;
      }
    }
  }
}
