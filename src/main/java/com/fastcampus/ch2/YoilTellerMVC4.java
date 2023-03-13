package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC4 {
	@RequestMapping("/getyoilmvc4")
//	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
	public String main(MyDate mydate, Model model) throws IOException {
//		String yr=request.getParameter("year");
//		String mth=request.getParameter("mth");
		//if(!isValid(year,mth))return "yoilerror";
		//System.out.println("year"+" "+mydate.getMonth());
		model.addAttribute("myDate", mydate);
		model.addAttribute("yoil", getYoil(mydate));
		return "yoil";

	}

	private boolean isValid(int year, int mth) {
		// TODO Auto-generated method stub
		return false;
	}
	private char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(),date.getDate());
	}
	private char getYoil(int year, int month, int date) {
		Calendar cal=Calendar.getInstance();
		cal.set(year, month-1, date);
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		return " smtwtfs".charAt(dayOfWeek);
	}
}
