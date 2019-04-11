package lec10observer.weatherorama.ver2;

import java.util.Scanner;

public class InputUI {

    public void receive(WeatherData weatherData, OceanData oceanData, PollutionData pollutionData) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("----- Please input new data -----");

            System.out.print("Temperature: ");
            double temp = Double.parseDouble(in.nextLine());

            System.out.print("Humidity: ");
            double humid = Double.parseDouble(in.nextLine());

            System.out.print("Pressure: ");
            double pressure = Double.parseDouble(in.nextLine());

            // set new data, causing weatherData subject
            // to "notify" all observers (via calling an update() method)
            weatherData.setMeasurement(temp, humid, pressure);

            System.out.print("Wave Height: ");
            double height = Double.parseDouble(in.nextLine());
            oceanData.setWaveHeight(height);

            System.out.print("Wind: ");
            double wind = Double.parseDouble(in.nextLine());
            oceanData.setWindGust(wind);

            System.out.print("PM 2.5: ");
            double pm2_5 = Double.parseDouble(in.nextLine());
            pollutionData.setPM2_5(pm2_5);
        }
    }
}
