package com.yanz.machine.shinva.entity;



/**
 * BUser entity. @author MyEclipse Persistence Tools
 */

public class BUser implements java.io.Serializable {

	// Fields

	private Integer iautoid;
	private String ccode;
	private String cname;
	private String csex;
	private String cdepartmentCode;
	private String cdepartmentName;
	private String cjobPosition;
	private String cbirthPlace;
	private String cnational;
	private String cbirthday;
	private String cheight;
	private String cweight;
	private String chealth;
	private String cidNumber;
	private String cwedStatus;
	private String cpolitics;
	private String ceducation;
	private String cmajor;
	private String dworkDate;
	private String cschool;
	private String cgraduationDate;
	private String chuKou;
	private String ccontactAddress;
	private String cemail;
	private String ctelephone;
	private String cexpectSalary;
	private String druZhiDate;
	private String csalary;
	private String dleaveDate;
	private String cleaveReason;
	private String cinfo;
	private String cpassword;
	private Boolean boperate;
	private String cworkExperience;
	private String ctoWorkDate;
	private String ctrialTime;
	private String ctrialSalary;
	private String cformalSalary;

	// Constructors

	/** default constructor */
	public BUser() {
	}

	/** minimal constructor */
	public BUser(Integer iautoid) {
		this.iautoid = iautoid;
	}

	/** full constructor */
	public BUser(Integer iautoid, String ccode, String cname, String csex,
			String cdepartmentCode, String cdepartmentName,
			String cjobPosition, String cbirthPlace, String cnational,
			String cbirthday, String cheight, String cweight, String chealth,
			String cidNumber, String cwedStatus, String cpolitics,
			String ceducation, String cmajor, String dworkDate,
			String cschool, String cgraduationDate, String chuKou,
			String ccontactAddress, String cemail, String ctelephone,
			String cexpectSalary, String druZhiDate, String csalary,
			String dleaveDate, String cleaveReason, String cinfo,
			String cpassword, Boolean boperate, String cworkExperience,
			String ctoWorkDate, String ctrialTime, String ctrialSalary,
			String cformalSalary) {
		this.iautoid = iautoid;
		this.ccode = ccode;
		this.cname = cname;
		this.csex = csex;
		this.cdepartmentCode = cdepartmentCode;
		this.cdepartmentName = cdepartmentName;
		this.cjobPosition = cjobPosition;
		this.cbirthPlace = cbirthPlace;
		this.cnational = cnational;
		this.cbirthday = cbirthday;
		this.cheight = cheight;
		this.cweight = cweight;
		this.chealth = chealth;
		this.cidNumber = cidNumber;
		this.cwedStatus = cwedStatus;
		this.cpolitics = cpolitics;
		this.ceducation = ceducation;
		this.cmajor = cmajor;
		this.dworkDate = dworkDate;
		this.cschool = cschool;
		this.cgraduationDate = cgraduationDate;
		this.chuKou = chuKou;
		this.ccontactAddress = ccontactAddress;
		this.cemail = cemail;
		this.ctelephone = ctelephone;
		this.cexpectSalary = cexpectSalary;
		this.druZhiDate = druZhiDate;
		this.csalary = csalary;
		this.dleaveDate = dleaveDate;
		this.cleaveReason = cleaveReason;
		this.cinfo = cinfo;
		this.cpassword = cpassword;
		this.boperate = boperate;
		this.cworkExperience = cworkExperience;
		this.ctoWorkDate = ctoWorkDate;
		this.ctrialTime = ctrialTime;
		this.ctrialSalary = ctrialSalary;
		this.cformalSalary = cformalSalary;
	}


	public Integer getIautoid() {
		return this.iautoid;
	}

	public void setIautoid(Integer iautoid) {
		this.iautoid = iautoid;
	}


	public String getCcode() {
		return this.ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}


	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCsex() {
		return this.csex;
	}

	public void setCsex(String csex) {
		this.csex = csex;
	}


	public String getCdepartmentCode() {
		return this.cdepartmentCode;
	}

	public void setCdepartmentCode(String cdepartmentCode) {
		this.cdepartmentCode = cdepartmentCode;
	}

	public String getCdepartmentName() {
		return this.cdepartmentName;
	}

	public void setCdepartmentName(String cdepartmentName) {
		this.cdepartmentName = cdepartmentName;
	}
	public String getCjobPosition() {
		return this.cjobPosition;
	}

	public void setCjobPosition(String cjobPosition) {
		this.cjobPosition = cjobPosition;
	}


	public String getCbirthPlace() {
		return this.cbirthPlace;
	}

	public void setCbirthPlace(String cbirthPlace) {
		this.cbirthPlace = cbirthPlace;
	}


	public String getCnational() {
		return this.cnational;
	}

	public void setCnational(String cnational) {
		this.cnational = cnational;
	}


	public String getCbirthday() {
		return this.cbirthday;
	}

	public void setCbirthday(String cbirthday) {
		this.cbirthday = cbirthday;
	}


	public String getCheight() {
		return this.cheight;
	}

	public void setCheight(String cheight) {
		this.cheight = cheight;
	}


	public String getCweight() {
		return this.cweight;
	}

	public void setCweight(String cweight) {
		this.cweight = cweight;
	}


	public String getChealth() {
		return this.chealth;
	}

	public void setChealth(String chealth) {
		this.chealth = chealth;
	}


	public String getCidNumber() {
		return this.cidNumber;
	}

	public void setCidNumber(String cidNumber) {
		this.cidNumber = cidNumber;
	}


	public String getCwedStatus() {
		return this.cwedStatus;
	}

	public void setCwedStatus(String cwedStatus) {
		this.cwedStatus = cwedStatus;
	}


	public String getCpolitics() {
		return this.cpolitics;
	}

	public void setCpolitics(String cpolitics) {
		this.cpolitics = cpolitics;
	}


	public String getCeducation() {
		return this.ceducation;
	}

	public void setCeducation(String ceducation) {
		this.ceducation = ceducation;
	}

	public String getCmajor() {
		return this.cmajor;
	}

	public void setCmajor(String cmajor) {
		this.cmajor = cmajor;
	}


	public String getDworkDate() {
		return this.dworkDate;
	}

	public void setDworkDate(String dworkDate) {
		this.dworkDate = dworkDate;
	}


	public String getCschool() {
		return this.cschool;
	}

	public void setCschool(String cschool) {
		this.cschool = cschool;
	}


	public String getCgraduationDate() {
		return this.cgraduationDate;
	}

	public void setCgraduationDate(String cgraduationDate) {
		this.cgraduationDate = cgraduationDate;
	}


	public String getChuKou() {
		return this.chuKou;
	}

	public void setChuKou(String chuKou) {
		this.chuKou = chuKou;
	}


	public String getCcontactAddress() {
		return this.ccontactAddress;
	}

	public void setCcontactAddress(String ccontactAddress) {
		this.ccontactAddress = ccontactAddress;
	}


	public String getCemail() {
		return this.cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}


	public String getCtelephone() {
		return this.ctelephone;
	}

	public void setCtelephone(String ctelephone) {
		this.ctelephone = ctelephone;
	}


	public String getCexpectSalary() {
		return this.cexpectSalary;
	}

	public void setCexpectSalary(String cexpectSalary) {
		this.cexpectSalary = cexpectSalary;
	}


	public String getDruZhiDate() {
		return this.druZhiDate;
	}

	public void setDruZhiDate(String druZhiDate) {
		this.druZhiDate = druZhiDate;
	}


	public String getCsalary() {
		return this.csalary;
	}

	public void setCsalary(String csalary) {
		this.csalary = csalary;
	}


	public String getDleaveDate() {
		return this.dleaveDate;
	}

	public void setDleaveDate(String dleaveDate) {
		this.dleaveDate = dleaveDate;
	}


	public String getCleaveReason() {
		return this.cleaveReason;
	}

	public void setCleaveReason(String cleaveReason) {
		this.cleaveReason = cleaveReason;
	}


	public String getCinfo() {
		return this.cinfo;
	}

	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}


	public String getCpassword() {
		return this.cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}


	public Boolean getBoperate() {
		return this.boperate;
	}

	public void setBoperate(Boolean boperate) {
		this.boperate = boperate;
	}


	public String getCworkExperience() {
		return this.cworkExperience;
	}

	public void setCworkExperience(String cworkExperience) {
		this.cworkExperience = cworkExperience;
	}


	public String getCtoWorkDate() {
		return this.ctoWorkDate;
	}

	public void setCtoWorkDate(String ctoWorkDate) {
		this.ctoWorkDate = ctoWorkDate;
	}


	public String getCtrialTime() {
		return this.ctrialTime;
	}

	public void setCtrialTime(String ctrialTime) {
		this.ctrialTime = ctrialTime;
	}


	public String getCtrialSalary() {
		return this.ctrialSalary;
	}

	public void setCtrialSalary(String ctrialSalary) {
		this.ctrialSalary = ctrialSalary;
	}


	public String getCformalSalary() {
		return this.cformalSalary;
	}

	public void setCformalSalary(String cformalSalary) {
		this.cformalSalary = cformalSalary;
	}

}