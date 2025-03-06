package com.studentInfo;

public class Students {

	// TODO Auto-generated method stub
	private int studentID;
	private String studentName;
	private String studentPhone;
	private String city;

	public static void main(String[] args) {

	}

	public Students(int studentID, String studentName, String studentPhone, String city) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.city = city;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Students [studentID=" + studentID + ", studentName=" + studentName + ", studentPhone=" + studentPhone
				+ ", city=" + city + "]";
	}

	public Students(String studentName, String studentPhone, String city) {
		super();
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.city = city;
	}

}
