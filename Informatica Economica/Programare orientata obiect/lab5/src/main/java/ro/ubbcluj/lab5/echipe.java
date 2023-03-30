/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ubbcluj.lab5;

/**
 *
 * @author alexandra
 */

class Weather{
    void now()
    { System.out.println("The weather now");} 
}

class SunnyWeather extends Weather{
    public void now(){System.out.println("Sunny Weather");}
}
class CloudyWeather extends Weather{
    public void now(){System.out.println("Cloudy Weather");}
}
class RainyWeather extends Weather{
    public void now(){System.out.println("Rainy Weather");}
}

class Forecast{
    Weather weather= new SunnyWeather();
    public void changeSunny(){weather=new SunnyWeather();}
    public void changeCloudy(){weather=new CloudyWeather();}
    public void changeRainy(){weather=new RainyWeather();}
    void getWeather(){weather.now();}
}

public class echipe {
    public static void main(String[] args){
        Forecast forecast=new Forecast();
        forecast.getWeather();
        forecast.changeCloudy();
        forecast.getWeather();
        forecast.changeRainy();
        forecast.getWeather();
    }
   
}
