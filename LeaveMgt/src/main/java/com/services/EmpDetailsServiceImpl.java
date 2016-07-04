package com.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.EmpDetails;
import com.bean.EmpLeave;
import com.bean.EmpLogin;
import com.bean.User_Roles;
import com.calculation.CalLeaves;
import com.calculation.CalPlannedLeaves;


@Service("empDetailsService")
@Transactional
public class EmpDetailsServiceImpl implements EmpDetailsService {

	@Autowired
	SessionFactory sf;
	Session s;
	Transaction t;

	public EmpDetailsServiceImpl() {
	}

	@Override
	public EmpDetails getEmpDetails(int empId) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Current id code is " + empId);
		Query q = s.createQuery("FROM EmpDetails  where empid=?");

		q.setInteger(0, empId);

		List<EmpDetails> e = q.list();
		EmpDetails empdetails = null;

		for (EmpDetails emp : e) {

			empdetails = emp;
		}

		s.close();
		return empdetails;
	}

	@Override
	public void setApprovede(int leaveNum) 
	{
		s = sf.openSession();
		t = s.beginTransaction();
		Query q=s.createQuery("update ManagerLeave set status=:n where leavenum=:i");  
		q.setParameter("n","approved");  
		q.setParameter("i",leaveNum);  
		int status=q.executeUpdate();  
		System.out.println("employee status has been changed to approved"+status);  
		t.commit();  
	}
	
	@Override
	public void setDisApprovede(int leaveNum) 
	{
		s = sf.openSession();
		t = s.beginTransaction();
		Query q=s.createQuery("update ManagerLeave set status=:n where leavenum=:i");  
		q.setParameter("n","dis-approved");  
		q.setParameter("i",leaveNum);  
		int status=q.executeUpdate();  
		System.out.println("employee status has been changed to dis - approved"+status);  
		t.commit();  
		
	}
	
	@Override
	public List<EmpLeave> getEmployeeLeaves(int empId) 
	{
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("fetching the leaves of employee" + empId);
		Query q = s.createQuery("FROM EmpLeave where empid=?");

		q.setInteger(0, empId);

		List<EmpLeave> e = q.list();
		System.out.println("successfully return the list of employees leave");
		return e;
	}
	
	
	@Override
	public void addEmployee(EmpDetails newObj) 
	{
		s = sf.openSession();
		t = s.beginTransaction();
		
		EmpLogin elogin=new EmpLogin();
		
		elogin.setEmpId(newObj.getEmpId());
		elogin.setPassword("demo");
		elogin.setEnabled(true);		
		s.save(elogin);
		
		User_Roles roles = new User_Roles();
		roles.setEmpId(newObj.getEmpId());
		roles.setRole("ROLE_USER");
		s.save(roles);   //here it may give prob just cz of role_id which is auto increment in database
		
		
		System.out.println("adding new employee with empid " +newObj.getEmpId());		
		
		s.save(newObj);			
		System.out.println("employee successfully addedd");
		t.commit();
		s.close();	
	}
	
	@Override    // adding a leave for employee in database by checking his type of leave
 	public void addLeave(EmpLeave leave)
	{
		s = sf.openSession();
		t = s.beginTransaction();
				
		EmpLeave eleave=new EmpLeave();
		
		CalLeaves cl=new CalLeaves();
		int leaves = cl.calLeaves(leave.getStartDate(),leave.getEndDate());
		String typeOfLeave=leave.getTypeOfLeave();
		
		if(typeOfLeave.equalsIgnoreCase("plannedLeaves"))
		{
			eleave.setFirstHalf(leaves);
			eleave.setSecondHalf(leaves);
		}
		else if(typeOfLeave.equalsIgnoreCase("unplannedLeaves"))
		{
			eleave.setFirstHalf(leaves);
			eleave.setSecondHalf(leaves);
		}
		//else if(typeOfLeave.equalsIgnoreCase(""))
		
		
	
		
			
	}
	
	@Override  //returning the leaves calculation between two dates
	public int calLeavesBetweenGivenDates(String start, String end) 
	{
		CalLeaves cl=new CalLeaves();
		int leaves = cl.calLeaves(start, end);
		
		return leaves;
	}
	
	 @Override   //only returning the plannedleaves which is going to show to manager when he add an employee
	public double calPlanedLeaves(String date) 
	 {
		 CalPlannedLeaves cl=new CalPlannedLeaves();
		 double plannedLeaves=cl.calPlannedLeaves(date);				 
		return plannedLeaves;
	}
		
	@Override
	public void deleteLeaveRequest(int empId,String start) 
	{
		s = sf.openSession();
		t = s.beginTransaction();
		
		SimpleDateFormat formatter = null;
        Date convertedDate = null;
        
        System.out.println("comming date is "+start);
      
        
        formatter =new SimpleDateFormat("yyyy-mm-dd"); // here we have to check in which format date is comming from front end and accoring to that we have to set format
        try {
			convertedDate =(Date) formatter.parse("yyyy-mm-dd");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
        System.out.println("Date after conversion is  " + convertedDate);
		
		Query query = s.createQuery("Delete from EmpLeave e where e.empid = :x and e.startdate = :y");
		query.setParameter("x",empId);
		query.setParameter("y",convertedDate);
		query.executeUpdate();
		
		t.commit();
		System.out.println("employee leave has been deleted successfully");
	}
	
	
	
}