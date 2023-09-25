package in.mindcraft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class LaptopController {
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		String lidParam = request.getParameter("lid");
		int lid = Integer.parseInt(lidParam);
		String make = request.getParameter("make");
		String costParam = request.getParameter("cost");
		double cost = Double.parseDouble(costParam);
		String action = request.getParameter("action");
		
		ModelAndView mv = new ModelAndView();
		
		if ("Add".equals(action)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost/laptop_db", "root", "root");
				PreparedStatement psmt = c.prepareStatement("Insert into laptop values (?,?,?)");
				psmt.setInt(1, lid);
				psmt.setString(2, make);
				psmt.setDouble(3, cost);
				
				int s = psmt.executeUpdate();
				if(s > 0) {
					System.out.println("Rows Inserted Successfully!!");
				}
				psmt.close();
				c.close();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} 
		else if ("Show".equals(action)) 
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost/laptop_db", "root", "root");
				String query = "SELECT * FROM laptop";
				PreparedStatement psmt = c.prepareStatement(query);
				
				ResultSet rst = psmt.executeQuery();		
				
//				while(rst.next()) {
//					System.out.println(rst.getInt("lid")+"   "+rst.getString("make")+"   "+rst.getDouble("cost"));
//				}
				
				mv.setViewName("result.jsp");
				mv.addObject("laptopResultSet", rst);

				psmt.close();
				c.close();
				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return mv;
		
		
	}
}
