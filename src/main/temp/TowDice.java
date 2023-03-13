package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TowDice {
	@RequestMapping("/rolldice")
	public void main(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();

		int dx1=(int)(Math.random()*6)+1;
		int dx2=(int)(Math.random()*6)+1;
		out.println("<html>");

		out.println("<head>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h2>hello</h2>");
		
		out.println("<img src='resources/img/dice"+dx1+".jpg'>");
		out.println("<img src='resources/img/dice"+dx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
