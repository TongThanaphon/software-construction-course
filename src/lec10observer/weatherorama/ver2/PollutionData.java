package lec10observer.weatherorama.ver2;

public class PollutionData extends Subject{

    private double pm2_5;

    public void setPM2_5(double pm2_5){
        this.pm2_5 = pm2_5;
        notifyObservers();
    }

    public double getPM2_5(){ return pm2_5; }

}
