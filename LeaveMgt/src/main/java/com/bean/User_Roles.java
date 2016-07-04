/* this class basically contains the roles of employee */

package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class User_Roles 
{
	@Id
	@Column(name="user_role_id")
	private int user_Role_Id;
	
	@Column(name="EMPID")
	private int empId;
	
	@Column(name="role")
	private String role;	
	
	public User_Roles() 
	{
		
	}

	public int getUser_Role_Id() {
		return user_Role_Id;
	}

	public void setUser_Role_Id(int user_Role_Id) {
		this.user_Role_Id = user_Role_Id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
