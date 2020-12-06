import java.util.*;

public class BubbleSort{
  static Scanner sc;
  public static void main(String[] args){
    sc = new Scanner(System.in);
    int n;
    System.out.print("Enter the n: ");
    n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    System.out.println("Before sorting: "+Arrays.toString(arr));
    int interchanges = sort(arr);
    System.out.println("Interchanges: "+interchanges);
    System.out.println("After sorting: "+Arrays.toString(arr));
  }

  public static int sort(int ...arr){
    int interchanges = 0;
    for(int i=0; i < arr.length-1; i++){
      for(int j=i; j < arr.length-1; j++){
        if(arr[j] < arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          interchanges++;
        }
      }
    }

    return interchanges;
  }
}
