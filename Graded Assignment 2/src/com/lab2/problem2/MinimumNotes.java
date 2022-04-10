package com.lab2.problem2;


import java.util.Scanner;

public class MinimumNotes {
	static Scanner sc = new Scanner(System.in);
	
	static void paymentApproach(int amount, int arr[]) {
		sort(arr);													//calling sort function to sort input array in decreasing order
		int temp = amount;
		System.out.println("Minimum notes required are: ");
		
		/*
		 * Example : 12, 5, 123, 18
		 * amount = temp = 158
		 * Sorted Array : 123, 18, 12, 5 
		 * 1st iteration : temp = 158-123=35 | 123:1
		 * 2nd iteration : temp = 35-18=17   | 18:1
		 * 3rd iteration : temp = 17-12=17   | 12:1
		 * 4th iteration : temp = 5-5=0 	 | 5:1  
		*/
		

		for(int i = 0; i<arr.length; i++) {							//loop decrements the largest denomination from amount till 
			int counter = 0;										//the amount becomes smaller than the denomination 
			while(temp>=arr[i] && temp>0) {							//a 'counter' variable keeps track of the number of notes we require 
				temp-=arr[i];										//for each denomination and prints it in every iteration
				counter++;
			}
			if(counter!=0)											//printing only the denominations which contribute to the final output
				System.out.println(arr[i]+" : "+counter);
		}
	}
	
	static void sort(int arr[]) {									//loop to Bubble Sort input array in descending order
		for(int i = 0; i<arr.length-1;i++) {
			for(int j = 0; j<arr.length-1-i;j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter the size of currency denominations: ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the currency denominations value: ");
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the amount you want to pay: ");
		int amount = sc.nextInt();
		
		paymentApproach(amount,arr);
		
	}
}
