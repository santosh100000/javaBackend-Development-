package flightDemo;

public class FlightData {

    private String src;

    private String desc;

    private double cost;

    public FlightData(String src, String desc, double cost) {
        this.src = src;
        this.desc = desc;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", desc='" + desc + '\'' +
                ", cost=" + cost +
                '}';
    }
}
