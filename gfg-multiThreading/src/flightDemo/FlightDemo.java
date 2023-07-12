package flightDemo;

import java.util.ArrayList;
import java.util.List;

public class FlightDemo {

    public static void main(String[] args) {
        List<FlightSearchInterface> flightSearchInterfaceList = new ArrayList<>();
        flightSearchInterfaceList.add(new QantasFlightSearch());
        flightSearchInterfaceList.add(new NepalAirlineFlightSearch());

        FlightSearchService flightSearchService = new FlightSearchService(flightSearchInterfaceList);
        List<FlightData> flightData  = flightSearchService.getFlightDataBySrcDesc("CBR", "KTM");

        System.out.println(flightData);

    }

}
