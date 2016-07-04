package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

//	Maps empdetails.html template view in "/WEB-INF/pages/velocity/" folder 
	@RequestMapping(value="/empdetails")
	public String getEmpdetailsTemplate(){
		return "empdetails";
	}
	
//	Maps new_leave.html template view in "/WEB-INF/pages/velocity/" folder 
	@RequestMapping(value="/new_leave")
	public String getNewLeaveTemplate(){
		return "new_leave";
	}
	
//	Maps approved_leave.html template view in "/WEB-INF/pages/velocity/" folder 
	@RequestMapping(value="/approved_leave")
	public String getApprovedLeaveTemplate(){
		return "approved_leave";
	}
	
//	Maps new_emp.html template view in "/WEB-INF/pages/velocity/" folder 
	@RequestMapping(value="/new_emp")
	public String getNewEmpTemplate(){
		return "new_emp";
	}
	
//	Maps approve_leave_emp.html template view in "/WEB-INF/pages/velocity/" folder 
	@RequestMapping(value="/approve_leave_emp")
	public String getApproveLeaveEmpTemplate(){
		return "approve_leave_emp";
	}
	
//	Maps blank.html template view in "/WEB-INF/pages/velocity/" folder 
	@RequestMapping(value="/blank")
	public String getBlankTemplate(){
		return "blank";
	}
}
