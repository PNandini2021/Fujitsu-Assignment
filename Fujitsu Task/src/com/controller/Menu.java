/* Project : FujitsuTask
 * created By : Nandini
 * Created Date : 12/6/2021
 * Purpose : Starting point of Application 
 */

package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.model.Student;
import com.model.Teacher;


public class Menu {

	public static void main(String[] args) {
	System.out.println("Reading Excel File.... ");	
	Task1 t1 = new Task1();
	Task2 t2 = new Task2();
	ArrayList<Student> s1 = new ArrayList<Student>(); 
	ArrayList<Teacher> th1 = new ArrayList<Teacher>(); 
    
	try {
		System.out.println("Creating Array List .... ");	
		
		t1.createArrayList(); // Calling Task 1 - to create ArrayList 
		s1  = t1.getStudentList(); // Getting Student List
		th1=t1.getTeacherList();   // Getting Teacher List 
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
    t2.createDirectory(s1,th1);
	}

}
