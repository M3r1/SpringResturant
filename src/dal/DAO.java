package dal;

import java.util.ArrayList;


public interface DAO<T> {
	
	public ArrayList<T> getAll() throws Exception;
	public boolean save(T obj) throws Exception;
	public boolean update(T obj) throws Exception;
	public boolean delete(int id) throws Exception;
	public T get(int id) throws Exception;

}
