package dal;

import java.util.List;

public interface DAO {
	
	public List<Object> getAll() throws Exception;
	public boolean save(Object obj) throws Exception;
	public boolean update(Object obj) throws Exception;
	public boolean delete(int id) throws Exception;
	public Object get(int id) throws Exception;
}
