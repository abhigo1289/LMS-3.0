/* this class contains the login details of an employee */

package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOGIN")
public class EmpLogin 
{
	@Id
	@Column(name="EMPID")
	private int empId;
	
	@Column(name="EMPPASSWORD")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;	

	public EmpLogin() 
	{
	
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
