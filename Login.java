package com.studentInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Login {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcom to Student Management App");
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 To ADD  Student Data:");
			System.out.println("Press 2 To REMOVE  Student Data:");
			System.out.println("Press 3 To DISPLAY  Student Data:");
			System.out.println("Press 0 To Exit :");

			int data=Integer.parseInt(br.readLine());
			if(data==1) {
				//add  student
				System.out.println("Enter Student Name");
				String name=br.readLine();
				
				System.out.println("Enter Student Phone");
				String phone=br.readLine();
				
				System.out.println("Enter Student city");
				String city=br.readLine();
				
				Students student=new Students(name, phone, city);
				System.out.println(student);
				
			}else if(data==2) {
				//remove  student
				System.out.println("Remove");
			}else if(data==3) {
				//display  student
				System.out.println("Display");
			}else if(data==0) {
				//exit
				System.out.println("Exiting...");
				break;
			}else {
				//invalid input	
				System.out.println("Invalid input");
			}
		}
		
	}
////
}
