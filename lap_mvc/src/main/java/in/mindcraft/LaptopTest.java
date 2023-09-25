package in.mindcraft;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class LaptopTest {
	@RequestMapping("/add")
	public ModelAndView handleAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int lid = Integer.parseInt(request.getParameter("lid"));
		String make = request.getParameter("make");
		double cost = Double.parseDouble(request.getParameter("cost"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/laptop_db", "root", "root");
			PreparedStatement psmt = c.prepareStatement("Insert into laptop values (?,?,?)");
			psmt.setInt(1, lid);
			psmt.setString(2, make);
			psmt.setDouble(3, cost);
			
			int s = psmt.executeUpdate();
			if(s > 0) {
				String res = "Success!!!";
				System.out.println("Rows Inserted Success!!");
				mv.setViewName("res1.jsp");
				mv.addObject("result",res);
			}
			psmt.close();
			c.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mv;
	}
}
