package core;

import java.util.List;

import Entities.Dish;
import dal.DishDAO;

public class DishService {

	public List<Dish> getAll() throws Exception{
		DishDAO dishDao = new DishDAO();

		return dishDao.getAll();
	}
	
	public boolean save(Dish dish) throws Exception{
		DishDAO dishDao = new DishDAO();

		List<Dish> dishes = getAll();
		
		if(dishes.size() > 100) {
			return false;
		}
		
		int counter = 0;
		for(int i = 0; i < dishes.size() && counter < 20; i ++) {
			if(dishes.get(i).getPrice() == dish.getPrice()) {
				counter++;
			}
		}
		
		if(counter < 20) {
			return dishDao.save(dish);
		} else {
			return false;
		}
	}
	
	public boolean update(Dish dish) throws Exception {
		DishDAO dishDao = new DishDAO();
		
		return dishDao.update(dish);
		
	}
	
	public boolean delete(int id) throws Exception {
		DishDAO dishDao = new DishDAO();
		
		return dishDao.delete(id);
	}
	
	public Dish get(int id) throws Exception {
		DishDAO dishDao = new DishDAO();
		
		return dishDao.get(id);
	}
	
}
