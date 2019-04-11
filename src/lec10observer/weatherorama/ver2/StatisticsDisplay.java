package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWave;
    private double prevPM;
    private int datapoint1 = 1, datapoint2 = 1;

    private JFrame frame;
    private JTextArea area, oceanArea, pollutionArea;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 600);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(200, 200);
        area.setBackground(Color.ORANGE);
        area.setText("Average Condition:\n");

        oceanArea = new JTextArea(200, 200);
        oceanArea.setBackground(Color.green);
        oceanArea.setText("Average Wave Height: \n");

        pollutionArea = new JTextArea(200, 200);
        pollutionArea.setBackground(Color.yellow);
        pollutionArea.setText("Average Pollution: \n");

        frame.setLayout(new GridLayout(3, 1));
        frame.add(area);
        frame.add(oceanArea);
        frame.add(pollutionArea);
    }

    @Override
    public void update(Subject data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;

            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            double avg = (prevTemp + weatherData.getTemperature()) / 2;
            prevTemp = avg;

            area.setBackground(Color.ORANGE);
            area.setText("Average Condition:\n");
            area.append("Temperature = " + avg);
        }
        if(data instanceof OceanData){
            OceanData oceanData = (OceanData) data;
            double avg;
            if(prevWave == 0) avg = oceanData.getWaveHeight();
            else avg = (prevWave + oceanData.getWaveHeight()) / datapoint1;
            prevWave += oceanData.getWaveHeight();
            datapoint1++;
            oceanArea.setBackground(Color.green);
            oceanArea.setText("Average Wave Height: \n");
            oceanArea.append("Wave Height: " + avg);
        }
        if(data instanceof PollutionData){
            PollutionData pollutionData = (PollutionData) data;

            double avg2;
            if(prevPM == 0) avg2 = pollutionData.getPM2_5();
            else avg2 = (prevPM + pollutionData.getPM2_5()) / datapoint2;
            prevPM += pollutionData.getPM2_5();
            datapoint2++;
            pollutionArea.setBackground(Color.yellow);
            pollutionArea.setText("Average Pollution: \n");
            pollutionArea.append("PM 2.5 = " + avg2);
        }
    }
}
