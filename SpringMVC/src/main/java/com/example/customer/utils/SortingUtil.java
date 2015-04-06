package com.example.customer.utils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class SortingUtil {

	//static int [] unsortedArray={9,2,8,6,4,3,5,1,0,5,7,6,0};
	
	//for heap sort
    private static int[] unsortedArray;
    private static int total;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildheap(int []a){
        total=a.length-1;
        for(int i=total/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= total && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= total && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
        	swap(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void swap(int i, int j){
        int t=unsortedArray[i];
        unsortedArray[i]=unsortedArray[j];
        unsortedArray[j]=t; 
    }
    
    public static long sortUsingHeapSort(int []a0){
    	long startTime = System.nanoTime();
		System.out.println("UnsortedArray :"+Arrays.toString(a0));
		unsortedArray=a0;
        buildheap(unsortedArray);
        
        for(int i=total;i>0;i--){
        	swap(0, i);
            total=total-1;
            maxheap(unsortedArray, 0);
        }
        long endTime = System.nanoTime();
		System.out.println("sortedArray :"+Arrays.toString(unsortedArray));
		System.out.println("time taken via bubble sort: "+(endTime-startTime)+" nanoSeconds..");
		return endTime-startTime;
    }
	    
	public static long sortUsingBubbleSort(int... unsortedArray){
		long startTime = System.nanoTime();
		System.out.println("UnsortedArray :"+Arrays.toString(unsortedArray));
		boolean swapped=false;
		int total=unsortedArray.length;
		int count=0;
		do{
			swapped=false;
			for(int i=1;i<total;i++){
				int temp=unsortedArray[i];
				if(unsortedArray[i-1]>temp){
					unsortedArray[i]=unsortedArray[i-1];
					unsortedArray[i-1]=temp;
					swapped=true;
				}
			}
			total=total-1;
			//System.out.println("total :"+count+++")==>>sortedArray :"+Arrays.toString(unsortedArray));
		}while(swapped);
		long endTime = System.nanoTime();
		System.out.println("sortedArray :"+Arrays.toString(unsortedArray));
		System.out.println("time taken via heap sort: "+(endTime-startTime)+" nanoSeconds..");
		
		return endTime-startTime;
	}
	
	
	public static void main(String[] args){
		
		long t1=sortUsingBubbleSort(new int[]{9,8,7,9,5,4,3,2,1,0});
		
		long t2=sortUsingHeapSort(new int[]{9,8,7,9,5,4,3,2,1,0});
		double d=(t1/t2)*100.00/100.00;
		System.out.println("ratio >> heap : bubble >> "+d+" : "+1);
	}
}
