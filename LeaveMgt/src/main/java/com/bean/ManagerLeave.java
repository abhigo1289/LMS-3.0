/* this class contains the status of leave applied by employee to his/her manager */

package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MANAGERlEAVE")
public class ManagerLeave 
{
	@Id
	@Column(name="LEAVENUM")
	private int leaveNum;
	
	@Column(name="EMPID")
	private int empId;
	
	@Column(name="STATUS")
	private String status;
	
	public ManagerLeave() 
	{
		
	}

	public int getLeaveNum() {
		return leaveNum;
	}

	public void setLeaveNum(int leaveNum) {
		this.leaveNum = leaveNum;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
