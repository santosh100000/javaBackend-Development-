package flightDemo;

import java.util.List;

public interface FlightSearchInterface {

    List<FlightData> getFlightDataBySrcDesc(String src, String desc);
}
