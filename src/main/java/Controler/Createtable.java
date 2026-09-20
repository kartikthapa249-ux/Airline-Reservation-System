package Controler;

import Dao.Search_dao;
import Dao.Search_daoimpl;

public class Createtable {

	public static void main(String[] args) {

		Search_dao employeeDao = new Search_daoimpl();

		try {
			employeeDao.createTable();
			System.out.println("\n Table created successfully");
		} catch (Exception e) {
			System.out.println("\n Table creation failed");
			e.printStackTrace();
		}

	}

}
