import java.lang.Math;

abstract class Shape{
  public int[] arr;
  public Shape(int ...arr){
    this.arr = arr;
  }
  abstract public void Area();
}

class Rectangle extends Shape{
  public Rectangle(int l, int b){
    super(l, b);
  }

  @Override
  public void Area(){
    System.out.println(this.arr[0]*this.arr[1]);
  }
}

class Triangle extends Shape{
  public Triangle(int b, int h){
    super(b, h);
  }

  @Override
  public void Area(){
    System.out.println((1/3.0)*this.arr[0]*this.arr[1]);
  }
}



class Circle extends Shape{
  public Circle(int r){
    super(r);
  }

  @Override
  public void Area(){
    System.out.println(Math.PI*this.arr[0]*this.arr[0]);
  }
}


public class AbstractClass{
  public static void main(String[] args){
    Shape rect = new Rectangle(2,3);
    Shape tri = new Triangle(3,4);
    Shape cir = new Circle(5);

    rect.Area();
    tri.Area();
    cir.Area();
  }
}
