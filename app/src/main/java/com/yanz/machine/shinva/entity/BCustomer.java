package com.yanz.machine.shinva.entity;


import java.util.Date;



public class BCustomer implements java.io.Serializable {

	// Fields

	private Integer iautoid;
	private String ccustomerCode;
	private String ccustomerName;
	private String cupDepartmentCode;
	private String cupDepartmentName;
	private String csex;
	private String cage;
	private String ctelephone;
	private String caddress;
	private String cinterests;
	private String ceducation;
	private Date cbirthday;
	private String cfamilyStructure;
	private String cchildren;
	private String cdecisionMaking;
	private String ccondition;
	private String cmateHealth;
	private String cmakerCode;
	private String cmakerName;
	private String dmakeDate;
	private String cinfo;

	// Constructors

	/** default constructor */
	public BCustomer() {
	}

	/** minimal constructor */
	public BCustomer(Integer iautoid, String ctelephone) {
		this.iautoid = iautoid;
		this.ctelephone = ctelephone;
	}

	/** full constructor */
	public BCustomer(Integer iautoid, String ccustomerCode,
			String ccustomerName, String cupDepartmentCode,
			String cupDepartmentName, String csex, String cage,
			String ctelephone, String caddress, String cinterests,
			String ceducation, Date cbirthday, String cfamilyStructure,
			String cchildren, String cdecisionMaking, String ccondition,
			String cmateHealth, String cmakerCode, String cmakerName,
			String dmakeDate, String cinfo) {
		this.iautoid = iautoid;
		this.ccustomerCode = ccustomerCode;
		this.ccustomerName = ccustomerName;
		this.cupDepartmentCode = cupDepartmentCode;
		this.cupDepartmentName = cupDepartmentName;
		this.csex = csex;
		this.cage = cage;
		this.ctelephone = ctelephone;
		this.caddress = caddress;
		this.cinterests = cinterests;
		this.ceducation = ceducation;
		this.cbirthday = cbirthday;
		this.cfamilyStructure = cfamilyStructure;
		this.cchildren = cchildren;
		this.cdecisionMaking = cdecisionMaking;
		this.ccondition = ccondition;
		this.cmateHealth = cmateHealth;
		this.cmakerCode = cmakerCode;
		this.cmakerName = cmakerName;
		this.dmakeDate = dmakeDate;
		this.cinfo = cinfo;
	}


	public Integer getIautoid() {
		return this.iautoid;
	}

	public void setIautoid(Integer iautoid) {
		this.iautoid = iautoid;
	}


	public String getCcustomerCode() {
		return this.ccustomerCode;
	}

	public void setCcustomerCode(String ccustomerCode) {
		this.ccustomerCode = ccustomerCode;
	}

	public String getCcustomerName() {
		return this.ccustomerName;
	}

	public void setCcustomerName(String ccustomerName) {
		this.ccustomerName = ccustomerName;
	}

	public String getCupDepartmentCode() {
		return this.cupDepartmentCode;
	}

	public void setCupDepartmentCode(String cupDepartmentCode) {
		this.cupDepartmentCode = cupDepartmentCode;
	}


	public String getCupDepartmentName() {
		return this.cupDepartmentName;
	}

	public void setCupDepartmentName(String cupDepartmentName) {
		this.cupDepartmentName = cupDepartmentName;
	}


	public String getCsex() {
		return this.csex;
	}

	public void setCsex(String csex) {
		this.csex = csex;
	}


	public String getCage() {
		return this.cage;
	}

	public void setCage(String cage) {
		this.cage = cage;
	}


	public String getCtelephone() {
		return this.ctelephone;
	}

	public void setCtelephone(String ctelephone) {
		this.ctelephone = ctelephone;
	}


	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public String getCinterests() {
		return this.cinterests;
	}

	public void setCinterests(String cinterests) {
		this.cinterests = cinterests;
	}


	public String getCeducation() {
		return this.ceducation;
	}

	public void setCeducation(String ceducation) {
		this.ceducation = ceducation;
	}



	public Date getCbirthday() {
		return this.cbirthday;
	}

	public void setCbirthday(Date cbirthday) {
		this.cbirthday = cbirthday;
	}


	public String getCfamilyStructure() {
		return this.cfamilyStructure;
	}

	public void setCfamilyStructure(String cfamilyStructure) {
		this.cfamilyStructure = cfamilyStructure;
	}


	public String getCchildren() {
		return this.cchildren;
	}

	public void setCchildren(String cchildren) {
		this.cchildren = cchildren;
	}


	public String getCdecisionMaking() {
		return this.cdecisionMaking;
	}

	public void setCdecisionMaking(String cdecisionMaking) {
		this.cdecisionMaking = cdecisionMaking;
	}


	public String getCcondition() {
		return this.ccondition;
	}

	public void setCcondition(String ccondition) {
		this.ccondition = ccondition;
	}


	public String getCmateHealth() {
		return this.cmateHealth;
	}

	public void setCmateHealth(String cmateHealth) {
		this.cmateHealth = cmateHealth;
	}


	public String getCmakerCode() {
		return this.cmakerCode;
	}

	public void setCmakerCode(String cmakerCode) {
		this.cmakerCode = cmakerCode;
	}


	public String getCmakerName() {
		return this.cmakerName;
	}

	public void setCmakerName(String cmakerName) {
		this.cmakerName = cmakerName;
	}


	public String getDmakeDate() {
		return this.dmakeDate;
	}

	public void setDmakeDate(String dmakeDate) {
		this.dmakeDate = dmakeDate;
	}


	public String getCinfo() {
		return this.cinfo;
	}

	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}

}