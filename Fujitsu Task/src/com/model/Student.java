/* Project : FujitsuTask
 * created By : Nandini
 * Created Date : 12/6/2021
 * Purpose : POJO class for Student - child class from Personnel
 */
package com.model;

import java.util.Date;

public class Student extends  Personnel{
	private Integer rollNumber;
	private String class_studying; //( col I)
	private Integer totalMarks;
	private String grade;//  ( Will be evaluated from totalMarks)
	private Integer secPercent; // ( Col V)
	private String hsStream; //  ( Col U)
	public Integer getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getClass_studying() {
		return class_studying;
	}
	public void setClass_studying(String class_studying) {
		this.class_studying = class_studying;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getSecPercent() {
		return secPercent;
	}
	public void setSecPercent(Integer secPercent) {
		this.secPercent = secPercent;
	}
	public String getHsStream() {
		return hsStream;
	}
	public void setHsStream(String hsStream) {
		this.hsStream = hsStream;
	}
	public Student(Integer id, String fullName, String gender, String dob, String age, String aadhar, String city,
			String contactNumber, Integer rollNumber, String class_studying, Integer totalMarks, String grade,
			Integer secPercent, String hsStream) {
		super(id, fullName, gender, dob, age, aadhar, city, contactNumber);
		this.rollNumber = rollNumber;
		this.class_studying = class_studying;
		this.totalMarks = totalMarks;
		this.grade = grade;
		this.secPercent = secPercent;
		this.hsStream = hsStream;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", class_studying=" + class_studying + ", totalMarks=" + totalMarks
				+ ", grade=" + grade + ", secPercent=" + secPercent + ", hsStream=" + hsStream + ", id=" + id
				+ ", fullName=" + fullName + ", gender=" + gender + ", dob=" + dob + ", age=" + age + ", aadhar="
				+ aadhar + ", city=" + city + ", contactNumber=" + contactNumber + "]";
	}
	
}
