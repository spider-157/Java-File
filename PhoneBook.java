import java.io.*;
import java.util.*;


public class PhoneBook{
  static Scanner sc;
  static HashMap<String, String> phoneBook;
  static File file;
  public static void main(String[] args){
    file = new File('./phone_book.txt');
    sc = new Scanner(file);
    phoneBook = new HashMap<String, String>();

    while(sc.hasNextLine()){
      String[] arr = sc.nextLine().split("\t");
      phoneBook.put(arr[0], arr[1]);
      phoneBook.put(arr[1], arr[0]);
    }
    sc.close();

    sc = new Scanner(System.in);
    System.out.print("Enter phone or name: ");
    String input = sc.next();

    System.out.println(phoneBook.get(input));
  }
}
