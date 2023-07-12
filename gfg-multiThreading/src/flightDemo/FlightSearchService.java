package flightDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FlightSearchService {
    private List<FlightSearchInterface> flightSearchInterfaceList;

    private ExecutorService executorService;

    public FlightSearchService(List<FlightSearchInterface> flightSearchInterfaceList) {
        this.flightSearchInterfaceList = flightSearchInterfaceList;
        executorService = Executors.newFixedThreadPool(15);
    }

    //Implementation of getFlightData
    public List<FlightData> getFlightDataBySrcDesc(String src, String desc){
        List<Callable<List<FlightData>>> callableList = new ArrayList<>();
        List<FlightData> response = new ArrayList<>();
        for(FlightSearchInterface flightSearchInterface: flightSearchInterfaceList){
            callableList.add(new Callable<List<FlightData>>() {
                @Override
                public List<FlightData> call() throws Exception {
                    return flightSearchInterface.getFlightDataBySrcDesc(src, desc);
                }
            });
        }
        try {
            List<Future<List<FlightData>>> futureList = executorService.invokeAll(callableList);
            for (Future<List<FlightData>> future: futureList){
                response.addAll(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return response;
    }
}
