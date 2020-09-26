   import javax.swing.*;
import java.awt.*;

class Solution {
   public static int[] SearchRange(int nums[], int target)
   {
      //first try below but then I realized it was O(n) efficiency not O(log n)
      int[] array = {-1,-1};
      /*
      for(int i = 0; i < nums.length; i++) {
         if(nums[i] == target) {          
            if(array[0] == -1)
               array[0] = i;
            else array[1] = i;  
         }     
      }
      return array;
      */
      
      //storing the max and min indexes of the array
      int min = 0;
      int max = nums.length - 1;
      int first = -1;
      //searching for first pos of target, iterate until search contains at least one index
      while (min <= max)
      {
         //determine the middle index of the array
         int mid = (min + max) / 2;
         
         //if the target equals middle index update first and search towards right
         if(target == nums[mid]) {
            first = mid;
            max = mid - 1;
         }
         //if target is less than middle value, search left    
         if(target < nums[mid])
            max = mid - 1;
         //if target is greater than middle value, search right
         if(target > nums[mid])
            min = mid + 1;  
      }
      //update array so that the first value of it is equal to first index 
      array[0] = first;
      
      //restoring max and min pos of array and storing default last index val to -1
      int last = -1;
      min = 0;
      max = nums.length - 1;
      //searching for last pos of target, iterate until search contains at least one index
      while (min <= max)
      {
         //determine the middle index of the array
         int mid = (min + max) / 2;
         
         //if the target equals middle index update last and search towards left
         if(target == nums[mid]) {
            last = mid;
            min = mid + 1;
         }
         //if target is less than middle value, search left    
         if(target < nums[mid])
            max = mid - 1;
         //if target is greater than middle value, search right
         if(target > nums[mid])
            min = mid + 1;  
      }
      //update array so that the second value of it is equal to last 
      array[1] = last;
      
      return array;
   }
   
   public static void main(String[] args)
   {
      //declaring arrays to run tests with
      int[] nums = {5,7,7,8,8,10};
      int[] nums2 = {5,7,7,8,8,10};
      
      //storing returned arrays fromo SearchRange
      int[] res1 = SearchRange(nums, 8);
      int[] res2 = SearchRange(nums2, 6);
      
      //printing out results from the returned arrays
      for(int y : res1) {
         System.out.println(y);
      }
      for(int x : res2) {
         System.out.println(x);
      }
   }   
}   
