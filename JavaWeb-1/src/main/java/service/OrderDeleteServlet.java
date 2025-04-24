package service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.OrderDTO;

@WebServlet("/order/delete")
public class OrderDeleteServlet extends HttpServlet {

	private OrderService orderService=new OrderService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Want Delete the index
		String index = req.getParameter("index");
		
		//Delete process
		OrderDTO orderDTO =orderService.removeOrder(index);
	}
	
	
}
