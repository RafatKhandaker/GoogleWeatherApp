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

    public String getStatus() {
        return this.status;
    }

    public List<Results> getResults() {
        return this.results;
    }


    public class Results {
        String section;
        String subsection;
        String title;
        String _abstract;
        String url;
        String byline;
        String item_type;
        String updated_type;
        String created_date;
        String material_type_facet;
        String kicker;
        String published_date;
        List<String> des_facet = new ArrayList<>();
        List<String> org_facet = new ArrayList<>();
        List<String> per_facet = new ArrayList<>();
        List<String> geo_facet = new ArrayList<>();
        private List<Multimedia> multimedia = new ArrayList<>();

        public List<Multimedia> getMultimedia() {
            return multimedia;
        }


        String short_url;

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