package com.services;

import java.sql.Date;
import java.util.List;

import com.bean.EmpDetails;
import com.bean.EmpLeave;


public interface EmpDetailsService 
{
	public EmpDetails getEmpDetails(int empId);
	
	public List<EmpLeave> getEmployeeLeaves(int empId); //fetching the list of leaves of employees
	
	public void setApprovede(int leaveNum); //getting approved by manager for an employee
	
	public void setDisApprovede(int leaveNum); //getting dis-approved by manager for an employee
	
	public void addEmployee(EmpDetails newObj);  //done
	
	public void addLeave(EmpLeave leave);    //have to discuss so dont work on t his fuctionality
	
	public int calLeavesBetweenGivenDates(String start,String end);  //done  code has to be put(bachhan)
	
	public double calPlanedLeaves(String Date);   //done  code has to be put(bachhan)

	public void deleteLeaveRequest(int empId,String start);  //done
}