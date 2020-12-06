import java.util.*;

public class DoubleLinkedList{
  public static LinkedList<String> ll;
  public static void main(String[] args){
    ll = new LinkedList<String>();
    Scanner sc = new Scanner(System.in);
    String el;

    while(true){
      System.out.println("1.add element");
      System.out.println("2.remove element");
      System.out.println("3.display");
      System.out.println("\nEnter you'r choice");

      int choice = sc.nextInt();
      switch(choice){
        case 1:
          System.out.print("\nElement: ");
          el = sc.next();
          addElement(el);
          break;
        case 2:
          System.out.print("\nElement: ");
          el = sc.next();
          removeElement(el);
          break;
        case 3:
          displayList();
          break;
        default:
          System.exit(0);
      }
    }

  }

  public static void addElement(String a){
    ll.add(a);
  }

  public static void removeElement(String a){
    try{
      ll.remove(a);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  public static void displayList(){
    for(Object s : ll.toArray()){
      System.out.print(s.toString()+" ");
    }
    System.out.print("\n");
  }
}
