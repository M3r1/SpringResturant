package dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import Entities.Order;


public class OrderDAO implements DAO<Order>{

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Order> getAll() throws Exception {
		
		 ArrayList<Order> arraylist= new ArrayList<Order>();

		 FileInputStream fis = new FileInputStream("myfile");
		 ObjectInputStream ois = new ObjectInputStream(fis);
		 arraylist = (ArrayList<Order>) ois.readObject();
		 ois.close();
		 fis.close();
		 
		 return arraylist;
	}

	@Override
	public boolean save(Order obj) throws Exception {
		
		ArrayList<Order> arrayList = getAll();
		
		if(arrayList.contains(obj)) {
			throw new Exception("Object already exists");
		}else {
			arrayList.add(obj);
		    Collections.sort(arrayList);   
		    
		    writeToFile(arrayList);
	        
	        return true;
		}


	}
	
	
	private void writeToFile(ArrayList<Order> arrayList) throws Exception{
	    FileOutputStream fos= new FileOutputStream("Orderfile");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(arrayList);
        oos.close();
        fos.close();
	}

	@Override
	public boolean update(Order obj) throws Exception {
		
		ArrayList<Order> arrayList = getAll();
		
		if(arrayList.contains(obj)) {
			Order d = arrayList.get(arrayList.indexOf(obj));
			d.setOrderTime(obj.getOrderTime());
			d.setTableDishes(obj.getTableDishes());
			d.setTableNum(obj.getTableNum());
			
			writeToFile(arrayList);
			
			return true;

		}else {
			return false;
		}

	}

	@Override
	public boolean delete(int id) throws Exception {
			
		ArrayList<Order> arrayList = getAll();
		
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i).getId() == id) {
				arrayList.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Order get(int id) throws Exception {
			
		ArrayList<Order> arrayList = getAll();
		
		for (Order d: arrayList) {
			if(d.getId() == id) {
				return d;
			}
		}
		
		return null;
	}
	

}
