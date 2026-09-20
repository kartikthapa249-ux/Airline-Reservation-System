package Dao;

import java.util.List;
import Entitites.Search_entites;

public interface Search_dao {
	 void createSchema() throws Exception ;
    void createTable() throws Exception;
    int addFlight(Search_entites flight) throws Exception;
    int updateFlight(Search_entites flight) throws Exception;
    int removeFlight(int flightId) throws Exception;
    Search_entites fetchFlightDetails(int flightId) throws Exception;
    List<Search_entites> getAllFlights() throws Exception;
}
