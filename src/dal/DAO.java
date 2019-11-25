package dal;

import java.util.List;

public interface DAO {
	
	public List<Object> getAll() throws Exception;
	public int save(Object obj) throws Exception;
	public int update(Object obj) throws Exception;
	public int delete(int id) throws Exception;
	public Object get(int id) throws Exception;
}
