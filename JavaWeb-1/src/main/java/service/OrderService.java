package service;

import java.util.ArrayList;
import java.util.List;
import dao.OrderDAO;
import dao.ProductDAO;
import model.dto.OrderDTO;
import model.entity.Order;

public class OrderService {
	private OrderDAO orderDAO =new OrderDAO();
	private ProductDAO productDAO =new ProductDAO();
	
	//根據訂單項目(item)新增一筆訂單並回傳訂單顯示(OrderDTO)
	public OrderDTO addOrder(String item) {
		// 1.新增一筆訂單
		Order order = new Order();
		order.setItem(item);
		
		//order.setPrice(100); //價格一律100
		order.setPrice(productDAO.getProduct(item).getPrice());
		
		//傳給orderDAO儲存訂單
		orderDAO.save(order);
		
		OrderDTO orderDTO =new OrderDTO();
		orderDTO.setMessage("點了"+order.getItem()+"價格："+order.getPrice());
		
		return orderDTO;
	}
	
	//Get History
	public List<OrderDTO> getOrderHistory(){
		List<Order> orders =orderDAO.findAll(); //取得所有資料
		//將List<Order>轉List<OrderDTO>
		List<OrderDTO> orderDTOs = new ArrayList<>();
		//一筆一筆轉
		for(Order order:orders){
			OrderDTO dto = new OrderDTO();
			dto.setMessage("點了"+order.getItem()+"價格："+order.getPrice());
			orderDTOs.add(dto);
		}
		
		return orderDTOs;
	}
	
	//Delete an order dependent on index
	public OrderDTO removeOrder(String index) {
		return removeOrder(Integer.parseInt(index));
	}
	//Delete an order dependent on index
	public OrderDTO removeOrder(int index) {
		orderDAO.remove(index);
		//回報結果
		OrderDTO orderDTO =new OrderDTO();
		orderDTO.setMessage("index=" +(index+1)+".資料刪除成功");
		return orderDTO;
				}
	
	//Update
	public OrderDTO updatOrder(int index, String newItem) {
		Order order = orderDAO.getOrder(index);
		order.setItem(newItem);
		orderDAO.update(index, order);
		
		//回報結果
		OrderDTO orderDTO=new OrderDTO();
		orderDTO.setMessage("index=" +index+".資料修改成功");
		return orderDTO;
	}
	
}
