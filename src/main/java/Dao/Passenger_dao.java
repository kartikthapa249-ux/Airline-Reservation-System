package Dao;

import java.util.List;
import Entitites.Passenger_entites;

public interface Passenger_dao {
    void createSchema() throws Exception;
    void createTable() throws Exception;
    int addPassenger(Passenger_entites passenger) throws Exception;
    int updatePassenger(Passenger_entites passenger) throws Exception;
    int removePassenger(int passengerId) throws Exception;
    Passenger_entites fetchPassengerDetails(int passengerId) throws Exception;
    List<Passenger_entites> getAllPassengers() throws Exception;
}
