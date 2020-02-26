package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Entities.Dish;


public class DishDAO implements DAO<Dish>{

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Dish> getAll() throws Exception {
		
		 ArrayList<Dish> arraylist= new ArrayList<Dish>();

		 File file = new File("dishfile");
		 if(file.exists())
		 {
			 FileInputStream fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis);
			 arraylist = (ArrayList<Dish>) ois.readObject();
			 ois.close();
			 fis.close();
			 
			 return arraylist;
		 }else {
			 return null;
		 }
	}

	@Override
	public boolean save(Dish obj) throws Exception {
		
		
		ArrayList<Dish> arrayList = getAll();
		
		if(arrayList == null) {
			arrayList = new ArrayList<Dish>();
		}
		if(!arrayList.contains(obj)) {
			arrayList.add(obj);
		    
		    writeToFile(arrayList);
	        
	        return true;
		}else {
			throw new Exception("Object already exists");
		}


	}
	
	
	private void writeToFile(ArrayList<Dish> arrayList) throws Exception{

		FileOutputStream fos= new FileOutputStream("dishfile");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(arrayList);
		oos.close();
		fos.close();

	}

	@Override
	public boolean update(Dish obj) throws Exception {
		
		ArrayList<Dish> arrayList = getAll();
		
		if(arrayList.contains(obj)) {
			Dish d = arrayList.get(arrayList.indexOf(obj));
			d.setName(obj.getName());
			d.setPrice(obj.getPrice());
			
			writeToFile(arrayList);
			
			return true;

		}else {
			return false;
		}

	}

	@Override
	public boolean delete(int id) throws Exception {
			
		ArrayList<Dish> arrayList = getAll();
		
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i).getId() == id) {
				arrayList.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Dish get(int id) throws Exception {
			
		ArrayList<Dish> arrayList = getAll();
		
		for (Dish d: arrayList) {
			if(d.getId() == id) {
				return d;
			}
		}
		
		return null;
	}
	

}
