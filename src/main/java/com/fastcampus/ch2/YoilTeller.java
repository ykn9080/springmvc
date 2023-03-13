package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {
	@RequestMapping("/getyoil")
	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String yr=request.getParameter("year");
		String mth=request.getParameter("mth");
		//System.out.println(yr+" "+mth);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//out.println(yr.toString()+" "+mth.toString());
		System.out.println(mth);
		System.out.println(yr);
	}

}
