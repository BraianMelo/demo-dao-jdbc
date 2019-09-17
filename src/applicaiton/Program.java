package applicaiton;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("== TEST 1: seller find by id ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n== TEST 2: seller find by Department ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 3: seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller obj:list2) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 4: seller insert ===");
		Seller seller2 = new Seller(null,"Greg","greg.email.com",new Date(),4000,dep);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id = "+seller2.getId());
		
		System.out.println("\n== TEST 5: seller update ===");
		seller2 = sellerDao.findById(3);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Update complete!");
		
		System.out.println("\n== TEST 6: seller delete===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete!");
		sc.close();
	}

}
