/* Project : FujitsuTask
 * created By : Nandini
 * Created Date : 12/6/2021
 * Purpose : Task 1  - to read from csv file and create Array List. 
 */

package com.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.model.Complete;
import com.model.Student;
import com.model.Teacher;

import sun.util.resources.LocaleData;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;


public class Task1 {
	  static final String CSV_FILENAME = "F:\\Fujitsu Task\\src\\resource\\master-data2.csv";
	    public ArrayList<Student> studentList = new  ArrayList<Student>();
	  	public ArrayList<Teacher> teacherList= new ArrayList<Teacher>();
	  	
	  public void createArrayList() throws IOException,ParseException
	  {
	  	  	//start reading csv file
	  	
	         try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), 
	        		CsvPreference.STANDARD_PREFERENCE))
	        {
	            // the header elements are used to map the values to the bean
	            final String[] headers = beanReader.getHeader(true);
	            final CellProcessor[] processors = getProcessors();
	            Complete  customer;
	            String gender,fullname;
	            while ((customer = beanReader.read(Complete.class, headers, processors)) != null)
	            {
	               fullname = customer.getFirstname() + " " + customer.getLastname();
	               if(customer.getGender().equals("f"))
	                	 gender = "female";
	               	else
	                     gender = "male";
	                Date dob=new SimpleDateFormat("MM/dd/yyyy").parse(customer.getDob()); 
	                String pattern = "dd/MM/yyyy";
	                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                	String date = simpleDateFormat.format(dob);
	                String age = calcAge(date);
	                if(customer.getCategory().equals("student"))
	                {
	                	String grade = calcGrade(customer.getSec_percent());
	                	studentList.add(new Student(customer.getId(),fullname,gender,date,age,customer.getAadhar_number(),customer.getCity(),
	                	customer.getContact_number(),Integer.parseInt(customer.getRoll_no()),customer.getClass_no(),Integer.parseInt(customer.getTotal_marks())
	                	,grade,Integer.parseInt(customer.getSec_percent()),customer.getHs_stream()));
	                		
	                } 
	                else //for teacher
	                {
	                	Date doj=new SimpleDateFormat("MM/dd/yyyy").parse(customer.getDoj()); 
	                	String pattern1 = "dd/MM/yyyy";
	                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern);
                    	String join_date = simpleDateFormat.format(doj);
	                	String str_sub_teachers = customer.getSubject_teaches();
	                	String service_period = calService(join_date);
	                	List<String> sub_teachers = new ArrayList<String>(Arrays.asList(str_sub_teachers.split("-")));
	                			
	              		teacherList.add(new Teacher(customer.getId(),fullname,gender,date,age,customer.getAadhar_number(),customer.getCity(),
                				customer.getContact_number(),customer.getEmp_no(),customer.getClass_teacher_of(),join_date,service_period
                				,customer.getPrevious_school(),customer.getPost(),Integer.parseInt(customer.getSalary()),sub_teachers));
                  }
	        
	    } //while
	        }
	         System.out.println("ArrayList Sucessfully Created");	
	     	
	  }
	  
	    /**
	     * Sets up the processors used for the examples.
	     */
	    private static CellProcessor[] getProcessors() {
	 	        final CellProcessor[] processors = new CellProcessor[] {
	                new NotNull(new ParseInt()), // Id
	                new NotNull(), // Catageory
	                new NotNull(), // firstname
	                new NotNull(), //lastname
	                new NotNull(), //gender
	                new NotNull(), //doj
	                new Optional(),	                new Optional(),
	                new Optional(),	                new Optional(),
	                new Optional(),	                new Optional(),
	                new Optional(),	                new Optional(),
	                new Optional(),	                new Optional(),
	                new Optional(),	                new Optional(),
	                new Optional(), new Optional(), new Optional(),	                new Optional()
	               
	        };
	        return processors;
	    }
	
	/* Method to calculate Age using Date of Birth 	 */
	  public static String calcAge(String dob)
	  {
		  LocalDate bday = LocalDate.of(Integer.parseInt(dob.substring(6,10)),Integer.parseInt(dob.substring(3,5)),Integer.parseInt(dob.substring(1,2)));
		  LocalDate today = LocalDate.now(); 
		  Period age = Period.between(bday, today); 
		  int years = age.getYears(); 
		  int months = age.getMonths(); 
		  return years + " Years and " + months + " Months";
	  }
	  /* Method to calculate service period using Joing Date */
	  public static String calService(String doj)
	  {
		    
		  LocalDate join_day = LocalDate.of(Integer.parseInt(doj.substring(6,10)),Integer.parseInt(doj.substring(3,5)),Integer.parseInt(doj.substring(1,2)));
		  LocalDate today = LocalDate.now();
		  Period age = Period.between(join_day, today); 
		  int years = age.getYears(); 
		  int months = age.getMonths(); 
		  return years + " Years and " + months + " Months";
	  }
	  
	  /* Method to return Student Array List */ 
	  public ArrayList<Student> getStudentList()
	  {
		return studentList;
		
	  }
	  /* Method to return Teacher Array List */ 
	  public ArrayList<Teacher> getTeacherList()
	  {
		  return teacherList;
	  }
	  /* Method to Calculate grade of student using his percentage  */ 
	  private String calcGrade(String perc)
	  {
		  float percentage = Float.parseFloat(perc);
		  if (percentage > 75) return "A";
		  else if (percentage>=60 && percentage < 75) return "B";
		  else if (percentage>=45 && percentage < 60) return "c";
		  else if (percentage>=35 && percentage < 45) return "D";
		  else 
			  return "F";
	  }
}