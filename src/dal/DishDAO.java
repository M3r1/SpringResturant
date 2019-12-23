package dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Entities.Dish;


public class DishDAO implements DAO{

	@Override
	public List<Object> getAll() throws Exception {
		
		ArrayList<Object> dishList= new ArrayList<Object>();

        FileInputStream fis = new FileInputStream("dishfile");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Object dishObj;
        while( (dishObj = ois.readObject()) != null ){
            Dish dish = (Dish) dishObj;
            dishList.add(dish);
        }
        
        ois.close();
        fis.close();
        
        return dishList;
        
	}

	@Override
	public boolean save(Object obj) throws Exception {
		
		if(obj.getClass() == Dish.class) {
			FileOutputStream fos= new FileOutputStream("dishfile", true);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
			fos.close();

			return true;
		}
		else {
			return false;
		}

	}

	@Override
	public boolean update(Object obj) throws Exception {
		
//		if(obj.getClass() == Dish.class) {
//			
//			List<Object> values =  getAll();
//			
//			boolean existFlag = false;
//			for(int i = 0; i < values.size() && !existFlag; i++) {
//				
//				Dish dish = (Dish) values.get(i);
//				
//				if(dish.equals((Dish)obj)) {
//					existFlag = true;
//				}
//				
//			}
//			
//			if(existFlag) {
//			
//				FileOutputStream fos= new FileOutputStream("dishfile", true);
//				ObjectOutputStream oos= new ObjectOutputStream(fos);
//		        
//		        Object dishObj;
//		        while( (dishObj = ois.readObject()) != null ){
//		            Dish dish = (Dish) dishObj;
//		            dishList.add(dish);
//		        }
//		        
//		        ois.close();
//		        fis.close();
//	
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//		else {
//			//change to custom
//			throw new Exception();
//		}
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
			
//		List<Object> values =  getAll();
//			
//		boolean existFlag = false;
//		for(int i = 0; i < values.size() && !existFlag; i++) {
//			
//			Dish dish = (Dish) values.get(i);
//				
//			if(dish.getId() == id) {
//				existFlag = true;
//			}
//			
//		}
//			
//		if(existFlag) {
//			
//			ArrayList<Object> dishList= new ArrayList<Object>();
//
//	        FileInputStream fis = new FileInputStream("dishfile");
//	        ObjectInputStream ois = new ObjectInputStream(fis);
//		        
//	        Object dishObj;
//	        while( (dishObj = ois.readObject()) != null ){
//	            Dish dish = (Dish) dishObj;
//	            dishList.add(dish);
//		    }
//		        
//		    ois.close();
//		    fis.close();
//	
//			return true;
//		}
//		else {
//			return false;
//		}
		return false;
	}

	@Override
	public Object get(int id) throws Exception {
			
		List<Object> values =  getAll();
			
		for(int i = 0; i < values.size(); i++) {
				
			Dish dish = (Dish) values.get(i);
				
			if(dish.getId() == id) {
				return dish;
			}
				
		}
		
		return null;
	}
	

}
