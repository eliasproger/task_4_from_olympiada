import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileReader;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException
    {
        String result = "";
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using
        int[] bus = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] metro = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] taxi = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int dBus = bus[0], tBus = bus[1], wBus = bus[2], dMetro = metro[0], tMetro = metro[1], wMetro = metro[2], dTaxi = taxi[0], tTaxi = taxi[1];

        int busTotal = dBus+tBus+wBus, metroTotal = dMetro+tMetro+wMetro, taxiTotal = dTaxi+tTaxi;
        int minValue = min(min(busTotal, metroTotal), taxiTotal);

        if (busTotal != metroTotal && busTotal != taxiTotal && metroTotal != taxiTotal) {
            if (minValue == busTotal) {
                result = "Bus";
            } else if (minValue == metroTotal) {
                result = "Metro";
            } else {
                result = "Taxi";
            }
        } else {
            if (busTotal == metroTotal) {
                result = "Metro";
            } else if (busTotal == taxiTotal) {
                result = "Bus";
            }
            if (metroTotal == taxiTotal) {
                result = "Metro";
            }
        }
        System.out.println(result);
    }
}