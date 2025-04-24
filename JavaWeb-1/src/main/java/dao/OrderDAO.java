package dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public class OrderDAO {
	//用List模擬資料庫
	private static List<Order> orders =new CopyOnWriteArrayList<>();
	
	//存一筆資料
	public void save(Order order) {
		orders.add(order);
	}
	
	//Get history 
	public List<Order> findAll() {
		return orders;
	}
	//Delete
	public void remove(int index) {
		orders.remove(index);
	}
}
