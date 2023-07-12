package flightDemo;

import java.util.ArrayList;
import java.util.List;

public class NepalAirlineFlightSearch implements FlightSearchInterface{
    @Override
    public List<FlightData> getFlightDataBySrcDesc(String src, String desc) {
        List<FlightData> flightData = new ArrayList<>();
        flightData.add(new FlightData("SYD", "KTM", 1390.00));

        return flightData;
    }
}
