package Controler;


import Dao.Passenger_dao;
import Dao.Passenger_daoimpl;
public class Schema {

	public static void main(String[] args) {

		Passenger_dao employeeDao = new Passenger_daoimpl();

		try {
			employeeDao.createSchema();
			System.out.println("\n Schema created successfully");
		} catch (Exception e) {
			System.out.println("\n Schema creation failed");
			e.printStackTrace();
		}

	}

}
