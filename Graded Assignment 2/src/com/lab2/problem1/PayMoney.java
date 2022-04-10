package com.lab2.problem1;

import java.util.Scanner;

public class PayMoney {
	static Scanner sc = new Scanner(System.in);

	static void transactionCheck(int totTargets,int[] arr) {
		int target=0; 
		while(totTargets!=0) { 
			System.out.println("Enter the value of target: ");
			target = sc.nextInt();
			
			targetAchieved(target, arr); //Check if target has been achieved or not
			System.out.println();
			
			totTargets--;				 //Decrement remaining targets by 1 
			
		}
		
		//return target;
	}
	
	static void targetAchieved(int target, int[] arr) {
		int sum=arr[0];
		int counter=0; 					 //Counter to keep track of transactions in every iteration
		for(int i=1;i<arr.length;i++) {
			if(sum>target) {
				counter++; 
				break;	 				 //Break if target is achieved in first transaction
			}
			else {
				sum += arr[i];
				counter++;				 //else add element to sum and increment counter
			}
		}
		if(sum<target)
			System.out.println("Target not achieved.");
		else
			System.out.println("Target achieved after "+counter+ " transactions");
		return;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the size of transaction array: ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the values of array: ");
		for(int i = 0; i < size; i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Enter the total no of targets that needs to be achieved: ");
		int totTargets = sc.nextInt();
		
		transactionCheck(totTargets,arr);   
	}

}
