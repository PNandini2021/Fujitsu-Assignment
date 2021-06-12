/* Project : FujitsuTask
 * created By : Nandini
 * Created Date : 12/6/2021
 * Purpose : Task 2  - to  create JSON from Array List and store in a file . 
 */

package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.Student;
import com.model.Teacher;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Task2 {
//To take directory name from user and create if does not exist ...
	
public void createDirectory(ArrayList<Student> s1,ArrayList<Teacher> t1)
{
	Scanner s = new Scanner(System.in);
	System.out.println("Enter directory to store JSON");
	String dirName = s.nextLine();
	
	File theDir = new File(dirName);
	if (!theDir.exists()){
	    theDir.mkdirs();
	}
	System.out.println(dirName + " created Sucessfully");
	Task2 t2 = new Task2();
	t2.createJSON(s1,t1,dirName);
}

public void createJSON(ArrayList<Student> studentList,ArrayList<Teacher> teacherList,String dirName)
{
	// Use this builder to construct a Gson instance when you need to set configuration options other than the default.
			GsonBuilder gsonBuilder = new GsonBuilder();
	// This is the main class for using Gson. Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or fromJson(String, Class) methods on it. 
	// Gson instances are Thread-safe so you can reuse them freely across multiple threads.
			Gson gson = gsonBuilder.create();
	 			String studJSONObject = gson.toJson(studentList);
			Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
			String studprettyJson = prettyGson.toJson(studentList);
			String teacherJSONObject = gson.toJson(studentList);
			String teacherprettyJson = prettyGson.toJson(studentList);
	       // write json in  a file
			ObjectMapper mapper = new ObjectMapper(); 
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter()); 
		    /* tried this code to append file with record count. Works good but formatting changes hence not added count 
		     * try {
			    File file = new File(dirName + "/studentList.json");
			        JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(file));

			        mapper.writeValue(g, stud_string);
			        mapper.writeValue(g, studentList);
			        g.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }*/
		try
		{
				writer.writeValue(new File(dirName + "/studentList.json"), studentList);
				writer.writeValue(new File(dirName + "/teacherList.json"), teacherList);
				
				System.out.println("JSON  File created sucessfully");
		
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
}
}
