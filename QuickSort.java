import java.util.*;

public class QuickSort{
  public static void main(String[] args){
      String[] arr = {"1", "2", "3", "4", "5", "6", "7"};
      sort(0, arr.length-1, arr);
      System.out.println(Arrays.toString(arr));
  }

  public static void sort(int left, int right, String ...arr){
    if(left >= right)
      return;

    String pivot = arr[right];
    int partation = partition(left, right, pivot, arr);

    sort(0, partation-1, arr);
    sort(partation+1, right, arr);
  }

  public static int partition(int left, int right, String pivot, String ...a){
    int leftCursor = left-1;
    int rightCursor = right;

    while(leftCursor < rightCursor){
      while(a[++leftCursor].compareTo(pivot) < 0);
      while(rightCursor > 0 && a[--rightCursor].compareTo(pivot) > 0);

      if(leftCursor >= rightCursor){
        break;
      }else{
        swap(leftCursor, rightCursor);
      }
    }
    swap(leftCursor, rightCursor, a);
    return leftCursor;
  }

  public static void swap(int leftCursor, int rightCursor, String ...a){
    String temp = a[leftCursor];
    a[leftCursor] = a[rightCursor];
    a[rightCursor] = temp;
  }
}
