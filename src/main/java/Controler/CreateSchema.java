package Controler;

import Dao.Search_dao;
import Dao.Search_daoimpl;

public class CreateSchema {

	public static void main(String[] args) {

		Search_dao employeeDao = new Search_daoimpl();

		try {
			employeeDao.createSchema();
			System.out.println("\n Schema created successfully");
		} catch (Exception e) {
			System.out.println("\n Schema creation failed");
			e.printStackTrace();
		}

	}

}
