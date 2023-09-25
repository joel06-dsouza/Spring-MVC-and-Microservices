package in.mindcraft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowLaptop {
	@RequestMapping("/show")
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/laptop_db", "root", "root");
			String query = "SELECT * FROM laptop";
			PreparedStatement psmt = c.prepareStatement(query);
			
			
			ResultSet rst = psmt.executeQuery();	
			
			List<Laptop> lp = new ArrayList<>();
			
			while(rst.next()) {
				int id = rst.getInt("lid");
				String make = rst.getString("make");
				double cost = rst.getDouble("cost");
				
				Laptop lps = new Laptop(id, make, cost);
				lp.add(lps);
			}
			
			mv.setViewName("res2.jsp");
			mv.addObject("list",lp.toString());
			for(Laptop l:lp) {
				System.out.println(l.toString());
				mv.addObject("laptopResultSet", l.toString());
			}
			
			rst.close();
			psmt.close();
			c.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return mv;
		
	}
}
