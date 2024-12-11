package com.example.FinalProject;

public class StudentEntity {
	
	private int StudentID;
	private String StudentName;
	private int StudentRegistration;
	private String StudentDepartment;
	public StudentEntity() {
		super();
	}
	public StudentEntity(String studentName, int studentRegistration, String studentDepartment) {
		super();
		StudentName = studentName;
		StudentRegistration = studentRegistration;
		StudentDepartment = studentDepartment;
	}
	public StudentEntity(int studentID, String studentName, int studentRegistration, String studentDepartment) {
		super();
		StudentID = studentID;
		StudentName = studentName;
		StudentRegistration = studentRegistration;
		StudentDepartment = studentDepartment;
	}
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getStudentRegistration() {
		return StudentRegistration;
	}
	public void setStudentRegistration(int studentRegistration) {
		StudentRegistration = studentRegistration;
	}
	public String getStudentDepartment() {
		return StudentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		StudentDepartment = studentDepartment;
	}
	@Override
	public String toString() {
		return "StudentEntity [StudentID=" + StudentID + ", StudentName=" + StudentName + ", StudentRegistration="
				+ StudentRegistration + ", StudentDepartment=" + StudentDepartment + "]";
	}
	
	
	
	

}
