package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class HumidityAverageDisplay implements Observer {

    private double prevHumid;
    private int dataPoint = 1;

    private JFrame frame;
    private JTextArea area;

    public HumidityAverageDisplay(){
        frame = new JFrame();
        frame.setSize(300, 300);
        frame.setTitle("Humidity Average");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        area.setBackground(Color.green);
        frame.add(area);
        area.setText("Humidity Average: \n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        double avg = 0;
        if(prevHumid == 0) avg = humid;
        else avg = (prevHumid + humid) / dataPoint;
        prevHumid += humid;
        dataPoint++;

        area.setBackground(Color.green);
        area.setText("Humidity Average: \n");
        area.append("Humidity: " + avg);
    }
}
