package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC {
	@RequestMapping("/getyoilmvc")
//	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
	public String main(int year, int month,int day, Model model) throws IOException {
//		String yr=request.getParameter("year");
//		String mth=request.getParameter("mth");
		//if(!isValid(year,mth))return "yoilerror";
		//System.out.println(year+" "+month);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		return "yoil";
		
	}

	private boolean isValid(int year, int mth) {
		// TODO Auto-generated method stub
		return false;
	}

}
