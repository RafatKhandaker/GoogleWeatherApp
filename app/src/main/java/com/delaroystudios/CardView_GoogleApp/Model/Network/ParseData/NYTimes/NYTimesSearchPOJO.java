package com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.NYTimes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RedDragon on 11/14/16.
 */

public class NYTimesSearchPOJO {
  //  -----------------------------------com.example.Byline.java-----------------------------------

    public class Byline {

        @SerializedName("person")
        @Expose
        private List<Object> person = new ArrayList<Object>();
        @SerializedName("original")
        @Expose
        private String original;
        @SerializedName("organization")
        @Expose
        private String organization;

        /**
         *
         * @return
         * The person
         */
        public List<Object> getPerson() {
            return person;
        }

        /**
         *
         * @param person
         * The person
         */
        public void setPerson(List<Object> person) {
            this.person = person;
        }

        /**
         *
         * @return
         * The original
         */
        public String getOriginal() {
            return original;
        }

        /**
         *
         * @param original
         * The original
         */
        public void setOriginal(String original) {
            this.original = original;
        }

        /**
         *
         * @return
         * The organization
         */
        public String getOrganization() {
            return organization;
        }

        /**
         *
         * @param organization
         * The organization
         */
        public void setOrganization(String organization) {
            this.organization = organization;
        }

    }
  // -----------------------------------com.example.Doc.java----------------------------------


    public class Doc {

        @SerializedName("web_url")
        @Expose
        private String webUrl;
        @SerializedName("snippet")
        @Expose
        private String snippet;
        @SerializedName("lead_paragraph")
        @Expose
        private String leadParagraph;
        @SerializedName("abstract")
        @Expose
        private Object _abstract;
        @SerializedName("print_page")
        @Expose
        private Object printPage;
        @SerializedName("blog")
        @Expose
        private List<Object> blog = new ArrayList<Object>();
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("Multimedia")
        @Expose
        private List<Object> multimedia = new ArrayList<Object>();
        @SerializedName("headline")
        @Expose
        private Headline headline;
        @SerializedName("keywords")
        @Expose
        private List<Object> keywords = new ArrayList<Object>();
        @SerializedName("pub_date")
        @Expose
        private String pubDate;
        @SerializedName("document_type")
        @Expose
        private String documentType;
        @SerializedName("news_desk")
        @Expose
        private Object newsDesk;
        @SerializedName("section_name")
        @Expose
        private String sectionName;
        @SerializedName("subsection_name")
        @Expose
        private String subsectionName;
        @SerializedName("byline")
        @Expose
        private Byline byline;
        @SerializedName("type_of_material")
        @Expose
        private String typeOfMaterial;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("word_count")
        @Expose
        private String wordCount;
        @SerializedName("slideshow_credits")
        @Expose
        private Object slideshowCredits;

        /**
         *
         * @return
         * The webUrl
         */
        public String getWebUrl() {
            return webUrl;
        }

        /**
         *
         * @param webUrl
         * The web_url
         */
        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        /**
         *
         * @return
         * The snippet
         */
        public String getSnippet() {
            return snippet;
        }

        /**
         *
         * @param snippet
         * The snippet
         */
        public void setSnippet(String snippet) {
            this.snippet = snippet;
        }

        /**
         *
         * @return
         * The leadParagraph
         */
        public String getLeadParagraph() {
            return leadParagraph;
        }

        /**
         *
         * @param leadParagraph
         * The lead_paragraph
         */
        public void setLeadParagraph(String leadParagraph) {
            this.leadParagraph = leadParagraph;
        }

        /**
         *
         * @return
         * The _abstract
         */
        public Object getAbstract() {
            return _abstract;
        }

        /**
         *
         * @param _abstract
         * The abstract
         */
        public void setAbstract(Object _abstract) {
            this._abstract = _abstract;
        }

        /**
         *
         * @return
         * The printPage
         */
        public Object getPrintPage() {
            return printPage;
        }

        /**
         *
         * @param printPage
         * The print_page
         */
        public void setPrintPage(Object printPage) {
            this.printPage = printPage;
        }

        /**
         *
         * @return
         * The blog
         */
        public List<Object> getBlog() {
            return blog;
        }

        /**
         *
         * @param blog
         * The blog
         */
        public void setBlog(List<Object> blog) {
            this.blog = blog;
        }

        /**
         *
         * @return
         * The source
         */
        public String getSource() {
            return source;
        }

        /**
         *
         * @param source
         * The source
         */
        public void setSource(String source) {
            this.source = source;
        }

        /**
         *
         * @return
         * The Multimedia
         */
        public List<Object> getMultimedia() {
            return multimedia;
        }

        /**
         *
         * @param multimedia
         * The Multimedia
         */
        public void setMultimedia(List<Object> multimedia) {
            this.multimedia = multimedia;
        }

        /**
         *
         * @return
         * The headline
         */
        public Headline getHeadline() {
            return headline;
        }

        /**
         *
         * @param headline
         * The headline
         */
        public void setHeadline(Headline headline) {
            this.headline = headline;
        }

        /**
         *
         * @return
         * The keywords
         */
        public List<Object> getKeywords() {
            return keywords;
        }

        /**
         *
         * @param keywords
         * The keywords
         */
        public void setKeywords(List<Object> keywords) {
            this.keywords = keywords;
        }

        /**
         *
         * @return
         * The pubDate
         */
        public String getPubDate() {
            return pubDate;
        }

        /**
         *
         * @param pubDate
         * The pub_date
         */
        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        /**
         *
         * @return
         * The documentType
         */
        public String getDocumentType() {
            return documentType;
        }

        /**
         *
         * @param documentType
         * The document_type
         */
        public void setDocumentType(String documentType) {
            this.documentType = documentType;
        }

        /**
         *
         * @return
         * The newsDesk
         */
        public Object getNewsDesk() {
            return newsDesk;
        }

        /**
         *
         * @param newsDesk
         * The news_desk
         */
        public void setNewsDesk(Object newsDesk) {
            this.newsDesk = newsDesk;
        }

        /**
         *
         * @return
         * The sectionName
         */
        public String getSectionName() {
            return sectionName;
        }

        /**
         *
         * @param sectionName
         * The section_name
         */
        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        /**
         *
         * @return
         * The subsectionName
         */
        public String getSubsectionName() {
            return subsectionName;
        }

        /**
         *
         * @param subsectionName
         * The subsection_name
         */
        public void setSubsectionName(String subsectionName) {
            this.subsectionName = subsectionName;
        }

        /**
         *
         * @return
         * The byline
         */
        public Byline getByline() {
            return byline;
        }

        /**
         *
         * @param byline
         * The byline
         */
        public void setByline(Byline byline) {
            this.byline = byline;
        }

        /**
         *
         * @return
         * The typeOfMaterial
         */
        public String getTypeOfMaterial() {
            return typeOfMaterial;
        }

        /**
         *
         * @param typeOfMaterial
         * The type_of_material
         */
        public void setTypeOfMaterial(String typeOfMaterial) {
            this.typeOfMaterial = typeOfMaterial;
        }

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The _id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The wordCount
         */
        public String getWordCount() {
            return wordCount;
        }

        /**
         *
         * @param wordCount
         * The word_count
         */
        public void setWordCount(String wordCount) {
            this.wordCount = wordCount;
        }

        /**
         *
         * @return
         * The slideshowCredits
         */
        public Object getSlideshowCredits() {
            return slideshowCredits;
        }

        /**
         *
         * @param slideshowCredits
         * The slideshow_credits
         */
        public void setSlideshowCredits(Object slideshowCredits) {
            this.slideshowCredits = slideshowCredits;
        }

    }
  //-----------------------------------com.example.Example.java-----------------------------------

    public class Example {

        @SerializedName("response")
        @Expose
        private Response response;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("copyright")
        @Expose
        private String copyright;

        /**
         *
         * @return
         * The response
         */
        public Response getResponse() {
            return response;
        }

        /**
         *
         * @param response
         * The response
         */
        public void setResponse(Response response) {
            this.response = response;
        }

        /**
         *
         * @return
         * The status
         */
        public String getStatus() {
            return status;
        }

        /**
         *
         * @param status
         * The status
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         *
         * @return
         * The copyright
         */
        public String getCopyright() {
            return copyright;
        }

        /**
         *
         * @param copyright
         * The copyright
         */
        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

    }

// -----------------------------------com.example.Headline.java-----------------------------------

    public class Headline {

        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("print_headline")
        @Expose
        private String printHeadline;

        /**
         *
         * @return
         * The main
         */
        public String getMain() {
            return main;
        }

        /**
         *
         * @param main
         * The main
         */
        public void setMain(String main) {
            this.main = main;
        }

        /**
         *
         * @return
         * The printHeadline
         */
        public String getPrintHeadline() {
            return printHeadline;
        }

        /**
         *
         * @param printHeadline
         * The print_headline
         */
        public void setPrintHeadline(String printHeadline) {
            this.printHeadline = printHeadline;
        }

    }
//--------------------------------------com.example.Meta.java--------------------------------------

    public class Meta {

        @SerializedName("hits")
        @Expose
        private int hits;
        @SerializedName("time")
        @Expose
        private int time;
        @SerializedName("offset")
        @Expose
        private int offset;

        /**
         *
         * @return
         * The hits
         */
        public int getHits() {
            return hits;
        }

        /**
         *
         * @param hits
         * The hits
         */
        public void setHits(int hits) {
            this.hits = hits;
        }

        /**
         *
         * @return
         * The time
         */
        public int getTime() {
            return time;
        }

        /**
         *
         * @param time
         * The time
         */
        public void setTime(int time) {
            this.time = time;
        }

        /**
         *
         * @return
         * The offset
         */
        public int getOffset() {
            return offset;
        }

        /**
         *
         * @param offset
         * The offset
         */
        public void setOffset(int offset) {
            this.offset = offset;
        }

    }
//-------------------------------------com.example.Response.java-----------------------------------

    public class Response {

        @SerializedName("meta")
        @Expose
        private Meta meta;
        @SerializedName("docs")
        @Expose
        private List<Doc> docs = new ArrayList<Doc>();

        /**
         *
         * @return
         * The meta
         */
        public Meta getMeta() {
            return meta;
        }

        /**
         *
         * @param meta
         * The meta
         */
        public void setMeta(Meta meta) {
            this.meta = meta;
        }

        /**
         *
         * @return
         * The docs
         */
        public List<Doc> getDocs() {
            return docs;
        }

        /**
         *
         * @param docs
         * The docs
         */
        public void setDocs(List<Doc> docs) {
            this.docs = docs;
        }

    }
}
