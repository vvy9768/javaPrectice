package com.maveric;

import java.util.Iterator;

public class java {
	
	
	public static void main(String[] args) {
		//splitInt("23,34,44,56,3,4,4,45,5,765");
	//	accendingOrder();
   minNum();
	}
	
	public static void splitInt(String str ) {
		String temp=null;
		String numString=str.replaceAll("\\D", " ");
	
		
	String [] strArr	=numString.split(" ");
	   for (int i = 0; i < strArr.length; i++) {
		   for (int j = 0; j < strArr.length; j++) {
			
	
		   if(Integer.parseInt(strArr[i])>Integer.parseInt(strArr[j])){
				temp=strArr[i];	
				strArr[i]=strArr[j];
				strArr[j]=temp;
				
				}
		} 
	   }
	   
	   for (int i = 0; i < strArr.length; i++) {
		   System.out.print(strArr[i]+","); 
		  
	}System.out.println();
	   System.out.println("higest num fro this array: "+strArr[0]);
	}
	public static void accendingOrder() {
		int [] a= {12,15,10};
		int temp=0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]<a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}System.out.print(a[0]+" ");
	}
	public static void minNum() {
		int arr[]= {13,4,55,6};
		int min=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				
			if(arr[i]<arr[j]) {
				min=arr[i];
			}
			}
		}System.out.println(min);
	}
		
	}
	


