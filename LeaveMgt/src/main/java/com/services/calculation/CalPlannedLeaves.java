package com.services.calculation;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalPlannedLeaves
{
	static SimpleDateFormat myFormat;
	public double calPlannedLeaves(String date)
	{
		double totalplannedLeaves=0.00;
		double plannedleave = 0.0;
		double leaves = 0.0;
		myFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		SimpleDateFormat year=new SimpleDateFormat("yyyy");
		
	    Calendar	cal =Calendar.getInstance();
		cal.getTime();
		int dayOfCurrentDate=cal.get(Calendar.DAY_OF_YEAR);
		 Date currentdate=cal.getTime();
		 
		System.out.println("currentdate in date "+currentdate);
		System.out.println("day of current date"+dayOfCurrentDate);
		
		
		
		Date d=null;
		try {
			d = myFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(d);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);  
		Date Joiningdate=calendar.getTime();
		System.out.println("joiining date in date "+Joiningdate);
		System.out.println("joiningdayofyear "+ dayOfYear);
		
		 int currentquarter=0;
	    int quarter=0;
	    double addleaves=(dayOfCurrentDate/90);
		double con=(dayOfYear/90);
	
	
		double usedPlanedLeaves=0.0;
		int num=0;
		if(con<1)
		{   
			    quarter=1;
			    num=90-dayOfYear;
			    leaves= Math.round(leaves + (num / (11.125)));
				leaves =leaves/2;
		        System.out.println("leaves in 1st quarter "+leaves);
			    totalplannedLeaves=totalplannedLeaves+leaves;
		    	System.out.println("totalplannedleaves "+totalplannedLeaves);
		    
		}
		else if(con>=1 && con<2)
		{      
			 
			    quarter=2;
			    num=181-dayOfYear;
			    leaves=  Math.round(leaves + (num / (11.125)));
				leaves =leaves/2;
			    System.out.println("leaves in 2nd quarter "+leaves);
			    
			    totalplannedLeaves=totalplannedLeaves+leaves;
		    	System.out.println("totalplannedleaves "+totalplannedLeaves);
		}
		else if(con>=2 && con<3)
		{
			quarter=3;
			num = 273 - dayOfYear;
			leaves = Math.round(leaves + (num / (11.125)));
			leaves = leaves / 2;
			System.out.println("leaves in 3rd quarter " + leaves);

			totalplannedLeaves = totalplannedLeaves + leaves;
			System.out.println("totalplannedleaves " + totalplannedLeaves);
		}
		else
		{    quarter=4;
			 num=365-dayOfYear;
			 leaves= Math.round(leaves + (num / (11.125)));
			 leaves =leaves/2;
			 System.out.println("leaves in 4th quarter "+leaves);
			         
			 totalplannedLeaves=totalplannedLeaves+leaves;
			 System.out.println("totalplannedleaves "+totalplannedLeaves);
		}   
		
		
		if(addleaves<0)
		{currentquarter=1;}
		else if(addleaves>=1 && addleaves<2)
		{currentquarter=2;}
		else if(addleaves>=2 && addleaves<3)
		{currentquarter=3;}
		else if(addleaves>=3 && addleaves<4)
		{currentquarter=4;}
		 		
		
		   for(int i=quarter;i<currentquarter;i++)
		    {  
			   System.out.println("i = "+i);
			   totalplannedLeaves=totalplannedLeaves + 4;
		    }
		
		 System.out.println("final totalplannedleaves "+totalplannedLeaves);
		return totalplannedLeaves;
	}

}
