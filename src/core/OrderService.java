package core;

import java.util.List;

import Entities.Order;
import dal.OrderDAO;

public class OrderService {

	public List<Order> getAll() throws Exception{
		OrderDAO OrderDao = new OrderDAO();

		return OrderDao.getAll();
	}
	
	public boolean save(Order Order) throws Exception{
		OrderDAO OrderDao = new OrderDAO();

		List<Order> Orderes = getAll();
		
		if(Orderes.size() > 100) {
			return false;
		}
		
		int counter = 0;
		for(int i = 0; i < Orderes.size() && counter < 20; i ++) {
			if(Orderes.get(i).getOrderTime() == Order.getOrderTime()) {
				counter++;
			}
		}
		
		if(counter < 20) {
			return OrderDao.save(Order);
		} else {
			return false;
		}
	}
	
	public int update(Order order) throws Exception {
		OrderDAO orderDao = new OrderDAO();

		List<Order> orderes = getAll();
		
		if(orderes.contains(order)) {
			int counter = 0;
			for(int i = 0; i < orderes.size() && counter < 20; i ++) {
				if(orderes.get(i).getOrderTime() == order.getOrderTime()) {
					counter++;
				}
			}
			
			if(counter < 20) {
				boolean b = orderDao.update(order);
				if(b) {
					return 0;
				} else {
					return 2;
				}
			} else {
				return 3;
			}
		} else {
			return 4;
		}
		
		
	}
	
	public boolean delete(int id) throws Exception {
		OrderDAO OrderDao = new OrderDAO();
		
		return OrderDao.delete(id);
	}
	
	public Order get(int id) throws Exception {
		OrderDAO OrderDao = new OrderDAO();
		
		return OrderDao.get(id);
	}
	
}
