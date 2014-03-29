import java.util.*;

public class monthlyreport
{
   public static int getMin(int[] data)
   {
      int min = data[0];
      for (int i = 0; i < data.length; i++)
      {
         if (data[i] < min)
            min = data[i];
      }
      return min;
   }
   
    public static int getMax(int[] data)
   {
      int max = data[0];
      for (int i = 0; i < data.length; i++)
      {
         if (data[i] > max)
            max = data[i];
      }
      return max;
   }
   
    public static double getAverage(int[] data)
   {
      double sum = 0;
      double average = 0;
      double counter = 0;
      for (int i = 0; i < data.length; i++)
      {
         sum = sum + data[i];
         counter++;     
      }
      average = (sum/counter);
      return average;
   }
}