package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer {

    private double prevTemp;
    private int dataPoint = 1;

    private JFrame frame;
    private JTextArea area;

    public ForecastDisplay(){
        frame = new JFrame();
        frame.setSize(300, 300);
        frame.setTitle("Forecast");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        area.setBackground(Color.yellow);
        frame.add(area);
        area.setText("Forecast: \n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        double avg = 0;
        if(prevTemp == 0) avg = temp;
        else avg = (prevTemp + temp) / dataPoint;
        prevTemp += temp;
        dataPoint++;

        area.setBackground(Color.yellow);
        area.setText("Forecast: \n");
        area.append("" + avg);
    }
}
