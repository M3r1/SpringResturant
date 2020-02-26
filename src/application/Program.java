package application;

import java.util.ArrayList;

import Entities.Dish;
import dal.DishDAO;

public class Program {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		DishDAO dao = new DishDAO();
		try {
			Dish d = new Dish();
			d.setName("b");
			d.setPrice(5);
			
			
			dao.save(d);



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("daaaa");

		}
		
		try {
			System.out.println(((ArrayList)dao.getAll()).size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
