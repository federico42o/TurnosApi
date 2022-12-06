package com.informatorio.app.utils;


import java.util.Date;

public final class CheckDate {
	
	public static Boolean check(Date date) {;
		
	
	if (date == null) {
		return true;
	}
	return date.after(new Date());
	}

}
