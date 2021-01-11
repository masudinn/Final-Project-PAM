package com.masudinn.pam_2087.Model.AllTeam;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.masudinn.pam_2087.Db.ScheduleContract;

import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_ID;
import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_IMAGE;
import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_TITLE;

public class DataTeamsItem implements Parcelable {

	@SerializedName("idTeam")
	@Expose
	private String idTeam;
	@SerializedName("idSoccerXML")
	@Expose
	private String idSoccerXML;
	@SerializedName("idAPIfootball")
	@Expose
	private String idAPIfootball;
	@SerializedName("intLoved")
	@Expose
	private String intLoved;
	@SerializedName("strTeam")
	@Expose
	private String strTeam;
	@SerializedName("strTeamShort")
	@Expose
	private String strTeamShort;
	@SerializedName("strAlternate")
	@Expose
	private String strAlternate;
	@SerializedName("intFormedYear")
	@Expose
	private String intFormedYear;
	@SerializedName("strSport")
	@Expose
	private String strSport;
	@SerializedName("strLeague")
	@Expose
	private String strLeague;
	@SerializedName("idLeague")
	@Expose
	private String idLeague;
	@SerializedName("strLeague2")
	@Expose
	private String strLeague2;
	@SerializedName("idLeague2")
	@Expose
	private String idLeague2;
	@SerializedName("strLeague3")
	@Expose
	private String strLeague3;
	@SerializedName("idLeague3")
	@Expose
	private String idLeague3;
	@SerializedName("strLeague4")
	@Expose
	private String strLeague4;
	@SerializedName("idLeague4")
	@Expose
	private String idLeague4;
	@SerializedName("strLeague5")
	@Expose
	private String strLeague5;
	@SerializedName("idLeague5")
	@Expose
	private String idLeague5;
	@SerializedName("strLeague6")
	@Expose
	private String strLeague6;
	@SerializedName("idLeague6")
	@Expose
	private Object idLeague6;
	@SerializedName("strLeague7")
	@Expose
	private String strLeague7;
	@SerializedName("idLeague7")
	@Expose
	private Object idLeague7;
	@SerializedName("strDivision")
	@Expose
	private Object strDivision;
	@SerializedName("strManager")
	@Expose
	private String strManager;
	@SerializedName("strStadium")
	@Expose
	private String strStadium;
	@SerializedName("strKeywords")
	@Expose
	private String strKeywords;
	@SerializedName("strRSS")
	@Expose
	private String strRSS;
	@SerializedName("strStadiumThumb")
	@Expose
	private String strStadiumThumb;
	@SerializedName("strStadiumDescription")
	@Expose
	private String strStadiumDescription;
	@SerializedName("strStadiumLocation")
	@Expose
	private String strStadiumLocation;
	@SerializedName("intStadiumCapacity")
	@Expose
	private String intStadiumCapacity;
	@SerializedName("strWebsite")
	@Expose
	private String strWebsite;
	@SerializedName("strFacebook")
	@Expose
	private String strFacebook;
	@SerializedName("strTwitter")
	@Expose
	private String strTwitter;
	@SerializedName("strInstagram")
	@Expose
	private String strInstagram;
	@SerializedName("strDescriptionEN")
	@Expose
	private String strDescriptionEN;
	@SerializedName("strDescriptionDE")
	@Expose
	private String strDescriptionDE;
	@SerializedName("strDescriptionFR")
	@Expose
	private String strDescriptionFR;
	@SerializedName("strDescriptionCN")
	@Expose
	private Object strDescriptionCN;
	@SerializedName("strDescriptionIT")
	@Expose
	private String strDescriptionIT;
	@SerializedName("strDescriptionJP")
	@Expose
	private String strDescriptionJP;
	@SerializedName("strDescriptionRU")
	@Expose
	private String strDescriptionRU;
	@SerializedName("strDescriptionES")
	@Expose
	private String strDescriptionES;
	@SerializedName("strDescriptionPT")
	@Expose
	private String strDescriptionPT;
	@SerializedName("strDescriptionSE")
	@Expose
	private Object strDescriptionSE;
	@SerializedName("strDescriptionNL")
	@Expose
	private Object strDescriptionNL;
	@SerializedName("strDescriptionHU")
	@Expose
	private Object strDescriptionHU;
	@SerializedName("strDescriptionNO")
	@Expose
	private String strDescriptionNO;
	@SerializedName("strDescriptionIL")
	@Expose
	private Object strDescriptionIL;
	@SerializedName("strDescriptionPL")
	@Expose
	private Object strDescriptionPL;
	@SerializedName("strGender")
	@Expose
	private String strGender;
	@SerializedName("strCountry")
	@Expose
	private String strCountry;
	@SerializedName("strTeamBadge")
	@Expose
	private String strTeamBadge;
	@SerializedName("strTeamJersey")
	@Expose
	private String strTeamJersey;
	@SerializedName("strTeamLogo")
	@Expose
	private String strTeamLogo;
	@SerializedName("strTeamFanart1")
	@Expose
	private String strTeamFanart1;
	@SerializedName("strTeamFanart2")
	@Expose
	private String strTeamFanart2;
	@SerializedName("strTeamFanart3")
	@Expose
	private String strTeamFanart3;
	@SerializedName("strTeamFanart4")
	@Expose
	private String strTeamFanart4;
	@SerializedName("strTeamBanner")
	@Expose
	private String strTeamBanner;
	@SerializedName("strYoutube")
	@Expose
	private String strYoutube;
	@SerializedName("strLocked")
	@Expose
	private String strLocked;

	protected DataTeamsItem(Parcel in) {
		idTeam = in.readString();
		idSoccerXML = in.readString();
		idAPIfootball = in.readString();
		intLoved = in.readString();
		strTeam = in.readString();
		strTeamShort = in.readString();
		strAlternate = in.readString();
		intFormedYear = in.readString();
		strSport = in.readString();
		strLeague = in.readString();
		idLeague = in.readString();
		strLeague2 = in.readString();
		idLeague2 = in.readString();
		strLeague3 = in.readString();
		idLeague3 = in.readString();
		strLeague4 = in.readString();
		idLeague4 = in.readString();
		strLeague5 = in.readString();
		idLeague5 = in.readString();
		strLeague6 = in.readString();
		strLeague7 = in.readString();
		strManager = in.readString();
		strStadium = in.readString();
		strKeywords = in.readString();
		strRSS = in.readString();
		strStadiumThumb = in.readString();
		strStadiumDescription = in.readString();
		strStadiumLocation = in.readString();
		intStadiumCapacity = in.readString();
		strWebsite = in.readString();
		strFacebook = in.readString();
		strTwitter = in.readString();
		strInstagram = in.readString();
		strDescriptionEN = in.readString();
		strDescriptionDE = in.readString();
		strDescriptionFR = in.readString();
		strDescriptionIT = in.readString();
		strDescriptionJP = in.readString();
		strDescriptionRU = in.readString();
		strDescriptionES = in.readString();
		strDescriptionPT = in.readString();
		strDescriptionNO = in.readString();
		strGender = in.readString();
		strCountry = in.readString();
		strTeamBadge = in.readString();
		strTeamJersey = in.readString();
		strTeamLogo = in.readString();
		strTeamFanart1 = in.readString();
		strTeamFanart2 = in.readString();
		strTeamFanart3 = in.readString();
		strTeamFanart4 = in.readString();
		strTeamBanner = in.readString();
		strYoutube = in.readString();
		strLocked = in.readString();
	}

	public static final Creator<DataTeamsItem> CREATOR = new Creator<DataTeamsItem>() {
		@Override
		public DataTeamsItem createFromParcel(Parcel in) {
			return new DataTeamsItem(in);
		}

		@Override
		public DataTeamsItem[] newArray(int size) {
			return new DataTeamsItem[size];
		}
	};

	public DataTeamsItem(){

	}

	public DataTeamsItem(Cursor cursor){
		this.idTeam = ScheduleContract.getColumnString(cursor,Schedule_ID);
		this.strTeam = ScheduleContract.getColumnString(cursor,Schedule_TITLE);
		this.strTeamBadge = ScheduleContract.getColumnString(cursor,Schedule_IMAGE);
	}

	public String getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(String idTeam) {
		this.idTeam = idTeam;
	}

	public String getIdSoccerXML() {
		return idSoccerXML;
	}

	public void setIdSoccerXML(String idSoccerXML) {
		this.idSoccerXML = idSoccerXML;
	}

	public String getIdAPIfootball() {
		return idAPIfootball;
	}

	public void setIdAPIfootball(String idAPIfootball) {
		this.idAPIfootball = idAPIfootball;
	}

	public String getIntLoved() {
		return intLoved;
	}

	public void setIntLoved(String intLoved) {
		this.intLoved = intLoved;
	}

	public String getStrTeam() {
		return strTeam;
	}

	public void setStrTeam(String strTeam) {
		this.strTeam = strTeam;
	}

	public String getStrTeamShort() {
		return strTeamShort;
	}

	public void setStrTeamShort(String strTeamShort) {
		this.strTeamShort = strTeamShort;
	}

	public String getStrAlternate() {
		return strAlternate;
	}

	public void setStrAlternate(String strAlternate) {
		this.strAlternate = strAlternate;
	}

	public String getIntFormedYear() {
		return intFormedYear;
	}

	public void setIntFormedYear(String intFormedYear) {
		this.intFormedYear = intFormedYear;
	}

	public String getStrSport() {
		return strSport;
	}

	public void setStrSport(String strSport) {
		this.strSport = strSport;
	}

	public String getStrLeague() {
		return strLeague;
	}

	public void setStrLeague(String strLeague) {
		this.strLeague = strLeague;
	}

	public String getIdLeague() {
		return idLeague;
	}

	public void setIdLeague(String idLeague) {
		this.idLeague = idLeague;
	}

	public String getStrLeague2() {
		return strLeague2;
	}

	public void setStrLeague2(String strLeague2) {
		this.strLeague2 = strLeague2;
	}

	public String getIdLeague2() {
		return idLeague2;
	}

	public void setIdLeague2(String idLeague2) {
		this.idLeague2 = idLeague2;
	}

	public String getStrLeague3() {
		return strLeague3;
	}

	public void setStrLeague3(String strLeague3) {
		this.strLeague3 = strLeague3;
	}

	public String getIdLeague3() {
		return idLeague3;
	}

	public void setIdLeague3(String idLeague3) {
		this.idLeague3 = idLeague3;
	}

	public String getStrLeague4() {
		return strLeague4;
	}

	public void setStrLeague4(String strLeague4) {
		this.strLeague4 = strLeague4;
	}

	public String getIdLeague4() {
		return idLeague4;
	}

	public void setIdLeague4(String idLeague4) {
		this.idLeague4 = idLeague4;
	}

	public String getStrLeague5() {
		return strLeague5;
	}

	public void setStrLeague5(String strLeague5) {
		this.strLeague5 = strLeague5;
	}

	public String getIdLeague5() {
		return idLeague5;
	}

	public void setIdLeague5(String idLeague5) {
		this.idLeague5 = idLeague5;
	}

	public String getStrLeague6() {
		return strLeague6;
	}

	public void setStrLeague6(String strLeague6) {
		this.strLeague6 = strLeague6;
	}

	public Object getIdLeague6() {
		return idLeague6;
	}

	public void setIdLeague6(Object idLeague6) {
		this.idLeague6 = idLeague6;
	}

	public String getStrLeague7() {
		return strLeague7;
	}

	public void setStrLeague7(String strLeague7) {
		this.strLeague7 = strLeague7;
	}

	public Object getIdLeague7() {
		return idLeague7;
	}

	public void setIdLeague7(Object idLeague7) {
		this.idLeague7 = idLeague7;
	}

	public Object getStrDivision() {
		return strDivision;
	}

	public void setStrDivision(Object strDivision) {
		this.strDivision = strDivision;
	}

	public String getStrManager() {
		return strManager;
	}

	public void setStrManager(String strManager) {
		this.strManager = strManager;
	}

	public String getStrStadium() {
		return strStadium;
	}

	public void setStrStadium(String strStadium) {
		this.strStadium = strStadium;
	}

	public String getStrKeywords() {
		return strKeywords;
	}

	public void setStrKeywords(String strKeywords) {
		this.strKeywords = strKeywords;
	}

	public String getStrRSS() {
		return strRSS;
	}

	public void setStrRSS(String strRSS) {
		this.strRSS = strRSS;
	}

	public String getStrStadiumThumb() {
		return strStadiumThumb;
	}

	public void setStrStadiumThumb(String strStadiumThumb) {
		this.strStadiumThumb = strStadiumThumb;
	}

	public String getStrStadiumDescription() {
		return strStadiumDescription;
	}

	public void setStrStadiumDescription(String strStadiumDescription) {
		this.strStadiumDescription = strStadiumDescription;
	}

	public String getStrStadiumLocation() {
		return strStadiumLocation;
	}

	public void setStrStadiumLocation(String strStadiumLocation) {
		this.strStadiumLocation = strStadiumLocation;
	}

	public String getIntStadiumCapacity() {
		return intStadiumCapacity;
	}

	public void setIntStadiumCapacity(String intStadiumCapacity) {
		this.intStadiumCapacity = intStadiumCapacity;
	}

	public String getStrWebsite() {
		return strWebsite;
	}

	public void setStrWebsite(String strWebsite) {
		this.strWebsite = strWebsite;
	}

	public String getStrFacebook() {
		return strFacebook;
	}

	public void setStrFacebook(String strFacebook) {
		this.strFacebook = strFacebook;
	}

	public String getStrTwitter() {
		return strTwitter;
	}

	public void setStrTwitter(String strTwitter) {
		this.strTwitter = strTwitter;
	}

	public String getStrInstagram() {
		return strInstagram;
	}

	public void setStrInstagram(String strInstagram) {
		this.strInstagram = strInstagram;
	}

	public String getStrDescriptionEN() {
		return strDescriptionEN;
	}

	public void setStrDescriptionEN(String strDescriptionEN) {
		this.strDescriptionEN = strDescriptionEN;
	}

	public String getStrDescriptionDE() {
		return strDescriptionDE;
	}

	public void setStrDescriptionDE(String strDescriptionDE) {
		this.strDescriptionDE = strDescriptionDE;
	}

	public String getStrDescriptionFR() {
		return strDescriptionFR;
	}

	public void setStrDescriptionFR(String strDescriptionFR) {
		this.strDescriptionFR = strDescriptionFR;
	}

	public Object getStrDescriptionCN() {
		return strDescriptionCN;
	}

	public void setStrDescriptionCN(Object strDescriptionCN) {
		this.strDescriptionCN = strDescriptionCN;
	}

	public String getStrDescriptionIT() {
		return strDescriptionIT;
	}

	public void setStrDescriptionIT(String strDescriptionIT) {
		this.strDescriptionIT = strDescriptionIT;
	}

	public String getStrDescriptionJP() {
		return strDescriptionJP;
	}

	public void setStrDescriptionJP(String strDescriptionJP) {
		this.strDescriptionJP = strDescriptionJP;
	}

	public String getStrDescriptionRU() {
		return strDescriptionRU;
	}

	public void setStrDescriptionRU(String strDescriptionRU) {
		this.strDescriptionRU = strDescriptionRU;
	}

	public String getStrDescriptionES() {
		return strDescriptionES;
	}

	public void setStrDescriptionES(String strDescriptionES) {
		this.strDescriptionES = strDescriptionES;
	}

	public String getStrDescriptionPT() {
		return strDescriptionPT;
	}

	public void setStrDescriptionPT(String strDescriptionPT) {
		this.strDescriptionPT = strDescriptionPT;
	}

	public Object getStrDescriptionSE() {
		return strDescriptionSE;
	}

	public void setStrDescriptionSE(Object strDescriptionSE) {
		this.strDescriptionSE = strDescriptionSE;
	}

	public Object getStrDescriptionNL() {
		return strDescriptionNL;
	}

	public void setStrDescriptionNL(Object strDescriptionNL) {
		this.strDescriptionNL = strDescriptionNL;
	}

	public Object getStrDescriptionHU() {
		return strDescriptionHU;
	}

	public void setStrDescriptionHU(Object strDescriptionHU) {
		this.strDescriptionHU = strDescriptionHU;
	}

	public String getStrDescriptionNO() {
		return strDescriptionNO;
	}

	public void setStrDescriptionNO(String strDescriptionNO) {
		this.strDescriptionNO = strDescriptionNO;
	}

	public Object getStrDescriptionIL() {
		return strDescriptionIL;
	}

	public void setStrDescriptionIL(Object strDescriptionIL) {
		this.strDescriptionIL = strDescriptionIL;
	}

	public Object getStrDescriptionPL() {
		return strDescriptionPL;
	}

	public void setStrDescriptionPL(Object strDescriptionPL) {
		this.strDescriptionPL = strDescriptionPL;
	}

	public String getStrGender() {
		return strGender;
	}

	public void setStrGender(String strGender) {
		this.strGender = strGender;
	}

	public String getStrCountry() {
		return strCountry;
	}

	public void setStrCountry(String strCountry) {
		this.strCountry = strCountry;
	}

	public String getStrTeamBadge() {
		return strTeamBadge;
	}

	public void setStrTeamBadge(String strTeamBadge) {
		this.strTeamBadge = strTeamBadge;
	}

	public String getStrTeamJersey() {
		return strTeamJersey;
	}

	public void setStrTeamJersey(String strTeamJersey) {
		this.strTeamJersey = strTeamJersey;
	}

	public String getStrTeamLogo() {
		return strTeamLogo;
	}

	public void setStrTeamLogo(String strTeamLogo) {
		this.strTeamLogo = strTeamLogo;
	}

	public String getStrTeamFanart1() {
		return strTeamFanart1;
	}

	public void setStrTeamFanart1(String strTeamFanart1) {
		this.strTeamFanart1 = strTeamFanart1;
	}

	public String getStrTeamFanart2() {
		return strTeamFanart2;
	}

	public void setStrTeamFanart2(String strTeamFanart2) {
		this.strTeamFanart2 = strTeamFanart2;
	}

	public String getStrTeamFanart3() {
		return strTeamFanart3;
	}

	public void setStrTeamFanart3(String strTeamFanart3) {
		this.strTeamFanart3 = strTeamFanart3;
	}

	public String getStrTeamFanart4() {
		return strTeamFanart4;
	}

	public void setStrTeamFanart4(String strTeamFanart4) {
		this.strTeamFanart4 = strTeamFanart4;
	}

	public String getStrTeamBanner() {
		return strTeamBanner;
	}

	public void setStrTeamBanner(String strTeamBanner) {
		this.strTeamBanner = strTeamBanner;
	}

	public String getStrYoutube() {
		return strYoutube;
	}

	public void setStrYoutube(String strYoutube) {
		this.strYoutube = strYoutube;
	}

	public String getStrLocked() {
		return strLocked;
	}

	public void setStrLocked(String strLocked) {
		this.strLocked = strLocked;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(idTeam);
		dest.writeString(idSoccerXML);
		dest.writeString(idAPIfootball);
		dest.writeString(intLoved);
		dest.writeString(strTeam);
		dest.writeString(strTeamShort);
		dest.writeString(strAlternate);
		dest.writeString(intFormedYear);
		dest.writeString(strSport);
		dest.writeString(strLeague);
		dest.writeString(idLeague);
		dest.writeString(strLeague2);
		dest.writeString(idLeague2);
		dest.writeString(strLeague3);
		dest.writeString(idLeague3);
		dest.writeString(strLeague4);
		dest.writeString(idLeague4);
		dest.writeString(strLeague5);
		dest.writeString(idLeague5);
		dest.writeString(strLeague6);
		dest.writeString(strLeague7);
		dest.writeString(strManager);
		dest.writeString(strStadium);
		dest.writeString(strKeywords);
		dest.writeString(strRSS);
		dest.writeString(strStadiumThumb);
		dest.writeString(strStadiumDescription);
		dest.writeString(strStadiumLocation);
		dest.writeString(intStadiumCapacity);
		dest.writeString(strWebsite);
		dest.writeString(strFacebook);
		dest.writeString(strTwitter);
		dest.writeString(strInstagram);
		dest.writeString(strDescriptionEN);
		dest.writeString(strDescriptionDE);
		dest.writeString(strDescriptionFR);
		dest.writeString(strDescriptionIT);
		dest.writeString(strDescriptionJP);
		dest.writeString(strDescriptionRU);
		dest.writeString(strDescriptionES);
		dest.writeString(strDescriptionPT);
		dest.writeString(strDescriptionNO);
		dest.writeString(strGender);
		dest.writeString(strCountry);
		dest.writeString(strTeamBadge);
		dest.writeString(strTeamJersey);
		dest.writeString(strTeamLogo);
		dest.writeString(strTeamFanart1);
		dest.writeString(strTeamFanart2);
		dest.writeString(strTeamFanart3);
		dest.writeString(strTeamFanart4);
		dest.writeString(strTeamBanner);
		dest.writeString(strYoutube);
		dest.writeString(strLocked);
	}
}