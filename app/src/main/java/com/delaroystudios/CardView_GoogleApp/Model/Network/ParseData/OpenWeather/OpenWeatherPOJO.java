package com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.OpenWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by RedDragon on 1/4/17.
 */

public class OpenWeatherPOJO {
    private City city;
    private String cod;
    private Float message;
    private Integer cnt;
    private java.util.List<List> list = new ArrayList<List>();

    /**
     * @return The city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return The message
     */
    public Float getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(Float message) {
        this.message = message;
    }

    /**
     * @return The cnt
     */
    public Integer getCnt() {
        return cnt;
    }

    /**
     * @param cnt The cnt
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /**
     * @return The list
     */
    public java.util.List<List> getList() {
        return list;
    }

    /**
     * @param list The list
     */
    public void setList(java.util.List<List> list) {
        this.list = list;
    }

//---------------------------------------com.example.City.java--------------------------------------

    public class City {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("coord")
        @Expose
        private Coord coord;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("population")
        @Expose
        private long population;
        @SerializedName("sys")
        @Expose
        private Sys sys;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public City withId(long id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public City withName(String name) {
            this.name = name;
            return this;
        }

        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public City withCoord(Coord coord) {
            this.coord = coord;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public City withCountry(String country) {
            this.country = country;
            return this;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }

        public City withPopulation(long population) {
            this.population = population;
            return this;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public City withSys(Sys sys) {
            this.sys = sys;
            return this;
        }

    }

//--------------------------------------com.example.Clouds.java-------------------------------------

    public class Clouds {

        @SerializedName("all")
        @Expose
        private long all;

        public long getAll() {
            return all;
        }

        public void setAll(long all) {
            this.all = all;
        }

        public Clouds withAll(long all) {
            this.all = all;
            return this;
        }

    }

//---------------------------------------com.example.Coord.java-------------------------------------

    public class Coord {

        @SerializedName("lon")
        @Expose
        private double lon;
        @SerializedName("lat")
        @Expose
        private double lat;

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public Coord withLon(double lon) {
            this.lon = lon;
            return this;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public Coord withLat(double lat) {
            this.lat = lat;
            return this;
        }

    }



//----------------------------------------com.example.List.java-------------------------------------

    public class List {

        @SerializedName("dt")
        @Expose
        private long dt;
        @SerializedName("main")
        @Expose
        private Main main;
        @SerializedName("weather")
        @Expose
        private java.util.List<Weather> weather = null;
        @SerializedName("clouds")
        @Expose
        private Clouds clouds;
        @SerializedName("wind")
        @Expose
        private Wind wind;
        @SerializedName("rain")
        @Expose
        private Rain rain;
        @SerializedName("sys")
        @Expose
        private Sys_ sys;
        @SerializedName("dt_txt")
        @Expose
        private String dtTxt;
        @SerializedName("snow")
        @Expose
        private Snow snow;

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
        }

        public List withDt(long dt) {
            this.dt = dt;
            return this;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public List withMain(Main main) {
            this.main = main;
            return this;
        }

        public java.util.List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(java.util.List<Weather> weather) {
            this.weather = weather;
        }

        public List withWeather(java.util.List<Weather> weather) {
            this.weather = weather;
            return this;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public List withClouds(Clouds clouds) {
            this.clouds = clouds;
            return this;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public List withWind(Wind wind) {
            this.wind = wind;
            return this;
        }

        public Rain getRain() {
            return rain;
        }

        public void setRain(Rain rain) {
            this.rain = rain;
        }

        public List withRain(Rain rain) {
            this.rain = rain;
            return this;
        }

        public Sys_ getSys() {
            return sys;
        }

        public void setSys(Sys_ sys) {
            this.sys = sys;
        }

        public List withSys(Sys_ sys) {
            this.sys = sys;
            return this;
        }

        public String getDtTxt() {
            return dtTxt;
        }

        public void setDtTxt(String dtTxt) {
            this.dtTxt = dtTxt;
        }

        public List withDtTxt(String dtTxt) {
            this.dtTxt = dtTxt;
            return this;
        }

        public Snow getSnow() {
            return snow;
        }

        public void setSnow(Snow snow) {
            this.snow = snow;
        }

        public List withSnow(Snow snow) {
            this.snow = snow;
            return this;
        }

    }

//----------------------------------com.example.Main.java-------------------------------------------

    public class Main {

        @SerializedName("temp")
        @Expose
        private double temp;
        @SerializedName("temp_min")
        @Expose
        private double tempMin;
        @SerializedName("temp_max")
        @Expose
        private double tempMax;
        @SerializedName("pressure")
        @Expose
        private double pressure;
        @SerializedName("sea_level")
        @Expose
        private double seaLevel;
        @SerializedName("grnd_level")
        @Expose
        private double grndLevel;
        @SerializedName("humidity")
        @Expose
        private double humidity;
        @SerializedName("temp_kf")
        @Expose
        private double tempKf;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public Main withTemp(double temp) {
            this.temp = temp;
            return this;
        }

        public double getTempMin() {
            return tempMin;
        }

        public void setTempMin(double tempMin) {
            this.tempMin = tempMin;
        }

        public Main withTempMin(double tempMin) {
            this.tempMin = tempMin;
            return this;
        }

        public double getTempMax() {
            return tempMax;
        }

        public void setTempMax(double tempMax) {
            this.tempMax = tempMax;
        }

        public Main withTempMax(double tempMax) {
            this.tempMax = tempMax;
            return this;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public Main withPressure(double pressure) {
            this.pressure = pressure;
            return this;
        }

        public double getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(double seaLevel) {
            this.seaLevel = seaLevel;
        }

        public Main withSeaLevel(double seaLevel) {
            this.seaLevel = seaLevel;
            return this;
        }

        public double getGrndLevel() {
            return grndLevel;
        }

        public void setGrndLevel(double grndLevel) {
            this.grndLevel = grndLevel;
        }

        public Main withGrndLevel(double grndLevel) {
            this.grndLevel = grndLevel;
            return this;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(long humidity) {
            this.humidity = humidity;
        }

        public Main withHumidity(long humidity) {
            this.humidity = humidity;
            return this;
        }

        public double getTempKf() {
            return tempKf;
        }

        public void setTempKf(long tempKf) {
            this.tempKf = tempKf;
        }

        public Main withTempKf(long tempKf) {
            this.tempKf = tempKf;
            return this;
        }

    }

//--------------------------------------com.example.Rain.java---------------------------------------


    public class Rain {


    }

//-----------------------------------com.example.Snow.java------------------------------------------

    public class Snow {

        @SerializedName("3h")
        @Expose
        private double _3h;

        public double get3h() {
            return _3h;
        }

        public void set3h(double _3h) {
            this._3h = _3h;
        }

        public Snow with3h(double _3h) {
            this._3h = _3h;
            return this;
        }

    }

//----------------------------------------com.example.Sys.java--------------------------------------

    public class Sys {

        @SerializedName("population")
        @Expose
        private long population;

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }

        public Sys withPopulation(long population) {
            this.population = population;
            return this;
        }

    }

//-----------------------------------com.example.Sys_.java------------------------------------------

    public class Sys_ {

        @SerializedName("pod")
        @Expose
        private String pod;

        public String getPod() {
            return pod;
        }

        public void setPod(String pod) {
            this.pod = pod;
        }

        public Sys_ withPod(String pod) {
            this.pod = pod;
            return this;
        }

    }

//-----------------------------------com.example.Weather.java-----------------------------------

    public class Weather {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Weather withId(long id) {
            this.id = id;
            return this;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public Weather withMain(String main) {
            this.main = main;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Weather withDescription(String description) {
            this.description = description;
            return this;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Weather withIcon(String icon) {
            this.icon = icon;
            return this;
        }

    }

//-----------------------------------com.example.Wind.java-----------------------------------


    public class Wind {

        @SerializedName("speed")
        @Expose
        private double speed;
        @SerializedName("deg")
        @Expose
        private double deg;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public Wind withSpeed(double speed) {
            this.speed = speed;
            return this;
        }

        public double getDeg() {
            return deg;
        }

        public void setDeg(long deg) {
            this.deg = deg;
        }

        public Wind withDeg(long deg) {
            this.deg = deg;
            return this;
        }

    }
}