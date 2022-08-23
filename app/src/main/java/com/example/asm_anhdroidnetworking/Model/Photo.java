package com.example.asm_anhdroidnetworking.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Photo implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private Integer farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private Integer ispublic;
    @SerializedName("isfriend")
    @Expose
    private Integer isfriend;
    @SerializedName("isfamily")
    @Expose
    private Integer isfamily;
    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("dateupload")
    @Expose
    private String dateupload;
    @SerializedName("lastupdate")
    @Expose
    private String lastupdate;
    @SerializedName("datetaken")
    @Expose
    private String datetaken;
    @SerializedName("datetakengranularity")
    @Expose
    private Integer datetakengranularity;
    @SerializedName("datetakenunknown")
    @Expose
    private Integer datetakenunknown;
    @SerializedName("ownername")
    @Expose
    private String ownername;
    @SerializedName("iconserver")
    @Expose
    private String iconserver;
    @SerializedName("iconfarm")
    @Expose
    private Integer iconfarm;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("machine_tags")
    @Expose
    private String machineTags;
    @SerializedName("originalsecret")
    @Expose
    private String originalsecret;
    @SerializedName("originalformat")
    @Expose
    private String originalformat;
    @SerializedName("date_faved")
    @Expose
    private String dateFaved;
    @SerializedName("latitude")
    @Expose
    private Integer latitude;
    @SerializedName("longitude")
    @Expose
    private Integer longitude;
    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;
    @SerializedName("context")
    @Expose
    private Integer context;
    @SerializedName("media")
    @Expose
    private String media;
    @SerializedName("media_status")
    @Expose
    private String mediaStatus;
    @SerializedName("url_sq")
    @Expose
    private String urlSq;
    @SerializedName("height_sq")
    @Expose
    private Integer heightSq;
    @SerializedName("width_sq")
    @Expose
    private Integer widthSq;
    @SerializedName("url_t")
    @Expose
    private String urlT;
    @SerializedName("height_t")
    @Expose
    private Integer heightT;
    @SerializedName("width_t")
    @Expose
    private Integer widthT;
    @SerializedName("url_s")
    @Expose
    private String urlS;
    @SerializedName("height_s")
    @Expose
    private Integer heightS;
    @SerializedName("width_s")
    @Expose
    private Integer widthS;
    @SerializedName("url_q")
    @Expose
    private String urlQ;
    @SerializedName("height_q")
    @Expose
    private Integer heightQ;
    @SerializedName("width_q")
    @Expose
    private Integer widthQ;
    @SerializedName("url_m")
    @Expose
    private String urlM;
    @SerializedName("height_m")
    @Expose
    private Integer heightM;
    @SerializedName("width_m")
    @Expose
    private Integer widthM;
    @SerializedName("url_n")
    @Expose
    private String urlN;
    @SerializedName("height_n")
    @Expose
    private Integer heightN;
    @SerializedName("width_n")
    @Expose
    private Integer widthN;
    @SerializedName("url_z")
    @Expose
    private String urlZ;
    @SerializedName("height_z")
    @Expose
    private Integer heightZ;
    @SerializedName("width_z")
    @Expose
    private Integer widthZ;
    @SerializedName("url_c")
    @Expose
    private String urlC;
    @SerializedName("height_c")
    @Expose
    private Integer heightC;
    @SerializedName("width_c")
    @Expose
    private Integer widthC;
    @SerializedName("url_l")
    @Expose
    private String urlL;
    @SerializedName("height_l")
    @Expose
    private Integer heightL;
    @SerializedName("width_l")
    @Expose
    private Integer widthL;
    @SerializedName("url_o")
    @Expose
    private String urlO;
    @SerializedName("height_o")
    @Expose
    private Integer heightO;
    @SerializedName("width_o")
    @Expose
    private Integer widthO;
    @SerializedName("pathalias")
    @Expose
    private String pathalias;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    public Integer getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(Integer isfriend) {
        this.isfriend = isfriend;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getDateupload() {
        return dateupload;
    }

    public void setDateupload(String dateupload) {
        this.dateupload = dateupload;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getDatetaken() {
        return datetaken;
    }

    public void setDatetaken(String datetaken) {
        this.datetaken = datetaken;
    }

    public Integer getDatetakengranularity() {
        return datetakengranularity;
    }

    public void setDatetakengranularity(Integer datetakengranularity) {
        this.datetakengranularity = datetakengranularity;
    }

    public Integer getDatetakenunknown() {
        return datetakenunknown;
    }

    public void setDatetakenunknown(Integer datetakenunknown) {
        this.datetakenunknown = datetakenunknown;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getIconserver() {
        return iconserver;
    }

    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    public Integer getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMachineTags() {
        return machineTags;
    }

    public void setMachineTags(String machineTags) {
        this.machineTags = machineTags;
    }

    public String getOriginalsecret() {
        return originalsecret;
    }

    public void setOriginalsecret(String originalsecret) {
        this.originalsecret = originalsecret;
    }

    public String getOriginalformat() {
        return originalformat;
    }

    public void setOriginalformat(String originalformat) {
        this.originalformat = originalformat;
    }

    public String getDateFaved() {
        return dateFaved;
    }

    public void setDateFaved(String dateFaved) {
        this.dateFaved = dateFaved;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getContext() {
        return context;
    }

    public void setContext(Integer context) {
        this.context = context;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getMediaStatus() {
        return mediaStatus;
    }

    public void setMediaStatus(String mediaStatus) {
        this.mediaStatus = mediaStatus;
    }

    public String getUrlSq() {
        return urlSq;
    }

    public void setUrlSq(String urlSq) {
        this.urlSq = urlSq;
    }

    public Integer getHeightSq() {
        return heightSq;
    }

    public void setHeightSq(Integer heightSq) {
        this.heightSq = heightSq;
    }

    public Integer getWidthSq() {
        return widthSq;
    }

    public void setWidthSq(Integer widthSq) {
        this.widthSq = widthSq;
    }

    public String getUrlT() {
        return urlT;
    }

    public void setUrlT(String urlT) {
        this.urlT = urlT;
    }

    public Integer getHeightT() {
        return heightT;
    }

    public void setHeightT(Integer heightT) {
        this.heightT = heightT;
    }

    public Integer getWidthT() {
        return widthT;
    }

    public void setWidthT(Integer widthT) {
        this.widthT = widthT;
    }

    public String getUrlS() {
        return urlS;
    }

    public void setUrlS(String urlS) {
        this.urlS = urlS;
    }

    public Integer getHeightS() {
        return heightS;
    }

    public void setHeightS(Integer heightS) {
        this.heightS = heightS;
    }

    public Integer getWidthS() {
        return widthS;
    }

    public void setWidthS(Integer widthS) {
        this.widthS = widthS;
    }

    public String getUrlQ() {
        return urlQ;
    }

    public void setUrlQ(String urlQ) {
        this.urlQ = urlQ;
    }

    public Integer getHeightQ() {
        return heightQ;
    }

    public void setHeightQ(Integer heightQ) {
        this.heightQ = heightQ;
    }

    public Integer getWidthQ() {
        return widthQ;
    }

    public void setWidthQ(Integer widthQ) {
        this.widthQ = widthQ;
    }

    public String getUrlM() {
        return urlM;
    }

    public void setUrlM(String urlM) {
        this.urlM = urlM;
    }

    public Integer getHeightM() {
        return heightM;
    }

    public void setHeightM(Integer heightM) {
        this.heightM = heightM;
    }

    public Integer getWidthM() {
        return widthM;
    }

    public void setWidthM(Integer widthM) {
        this.widthM = widthM;
    }

    public String getUrlN() {
        return urlN;
    }

    public void setUrlN(String urlN) {
        this.urlN = urlN;
    }

    public Integer getHeightN() {
        return heightN;
    }

    public void setHeightN(Integer heightN) {
        this.heightN = heightN;
    }

    public Integer getWidthN() {
        return widthN;
    }

    public void setWidthN(Integer widthN) {
        this.widthN = widthN;
    }

    public String getUrlZ() {
        return urlZ;
    }

    public void setUrlZ(String urlZ) {
        this.urlZ = urlZ;
    }

    public Integer getHeightZ() {
        return heightZ;
    }

    public void setHeightZ(Integer heightZ) {
        this.heightZ = heightZ;
    }

    public Integer getWidthZ() {
        return widthZ;
    }

    public void setWidthZ(Integer widthZ) {
        this.widthZ = widthZ;
    }

    public String getUrlC() {
        return urlC;
    }

    public void setUrlC(String urlC) {
        this.urlC = urlC;
    }

    public Integer getHeightC() {
        return heightC;
    }

    public void setHeightC(Integer heightC) {
        this.heightC = heightC;
    }

    public Integer getWidthC() {
        return widthC;
    }

    public void setWidthC(Integer widthC) {
        this.widthC = widthC;
    }

    public String getUrlL() {
        return urlL;
    }

    public void setUrlL(String urlL) {
        this.urlL = urlL;
    }

    public Integer getHeightL() {
        return heightL;
    }

    public void setHeightL(Integer heightL) {
        this.heightL = heightL;
    }

    public Integer getWidthL() {
        return widthL;
    }

    public void setWidthL(Integer widthL) {
        this.widthL = widthL;
    }

    public String getUrlO() {
        return urlO;
    }

    public void setUrlO(String urlO) {
        this.urlO = urlO;
    }

    public Integer getHeightO() {
        return heightO;
    }

    public void setHeightO(Integer heightO) {
        this.heightO = heightO;
    }

    public Integer getWidthO() {
        return widthO;
    }

    public void setWidthO(Integer widthO) {
        this.widthO = widthO;
    }

    public String getPathalias() {
        return pathalias;
    }

    public void setPathalias(String pathalias) {
        this.pathalias = pathalias;
    }
}
