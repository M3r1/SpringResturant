package dal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class DishDAO implements DAO{

	@Override
	public List<Object> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Object obj) throws Exception {
//	       ArrayList<String> al=new ArrayList<String>();
//	       al.add("Hello");
//	       al.add("Hi");
//	       al.add("Howdy");
//
//	       try{
//	         FileOutputStream fos= new FileOutputStream("dishfile");
//	         ObjectOutputStream oos= new ObjectOutputStream(fos);
//	         oos.writeObject(al);
//	         oos.close();
//	         fos.close();
//	       }catch(IOException ioe){
//	            ioe.printStackTrace();
//	        }
		return 0;
	}

	@Override
	public int update(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object get(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
