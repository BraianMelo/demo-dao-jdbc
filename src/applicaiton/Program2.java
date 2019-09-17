package applicaiton;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n== TEST 1: department insert ===");
		Department obj  = new Department(null, "Music");
		departmentDao.insert(obj);
		System.out.println("Inserted! New id = "+obj.getId());
		
	}

}
