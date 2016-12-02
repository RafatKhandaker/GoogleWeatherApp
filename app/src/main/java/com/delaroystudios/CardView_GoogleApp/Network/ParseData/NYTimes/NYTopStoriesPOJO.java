package com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RedDragon on 11/8/16.
 */

public class NYTopStoriesPOJO {

    private String status;
    private String copyright;
    private String section;
    private String last_updated;
    private int num_results;
    private  List<Results> results = new ArrayList<>();

    public String getLast_updated(){return this.last_updated; }

    public String getStatus() {
        return this.status;
    }

    public List<Results> getResults() {
        return this.results;
    }


    public class Results {

        private String section;
        private String subsection;
        private String title;
        private String _abstract;
        private String url;
        private String byline;
        private String item_type;
        private String updated_type;
        private String created_date;
        private String material_type_facet;
        private String kicker;
        private String published_date;
        private String short_url;
        private List<String> des_facet = new ArrayList<>();
        private List<String> org_facet = new ArrayList<>();
        private List<String> per_facet = new ArrayList<>();
        private List<String> geo_facet = new ArrayList<>();
        private List<Multimedia> multimedia = new ArrayList<>();


        public List<Multimedia> getMultimedia() {
            return multimedia;
        }

        public String getUrl(){ return url; }

        public String getTitle() {
            return this.title;
        }

        public String getByline() {
            return this.byline;
        }
    }


        public class Multimedia {

        private String url;
        private String format;
        private int height;
        private int width;
        private String type;
        private String subtype;
        private String caption;
        private String copyright;

        public String getUrl() {
            return this.url;
        }
    }



    public class des_facet {
    }

    public class org_facet {
    }

    public class per_facet {
    }

    public class geo_facet {
    }

}