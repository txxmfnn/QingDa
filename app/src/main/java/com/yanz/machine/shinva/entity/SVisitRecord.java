package com.yanz.machine.shinva.entity;




public class SVisitRecord implements java.io.Serializable {

	// Fields

	private Integer iautoid;
	private Integer ivisitTimes;
	private String ccustomerCode;
	private String ccustomerName;
	private String cupDepartmentCode;
	private String cupDepartmentName;
	private String cvisitContent;
	private String dvisitDate;
	private String cmakerCode;
	private String cmakerName;
	private String dmakeDate;
	private String cweather;

	// Constructors

	/** default constructor */
	public SVisitRecord() {
	}

	/** minimal constructor */
	public SVisitRecord(Integer iautoid) {
		this.iautoid = iautoid;
	}

	/** full constructor */
	public SVisitRecord(Integer iautoid, Integer ivisitTimes,
			String ccustomerCode, String ccustomerName,
			String cupDepartmentCode, String cupDepartmentName,
			String cvisitContent, String dvisitDate, String cmakerCode,
			String cmakerName, String dmakeDate, String cweather) {
		this.iautoid = iautoid;
		this.ivisitTimes = ivisitTimes;
		this.ccustomerCode = ccustomerCode;
		this.ccustomerName = ccustomerName;
		this.cupDepartmentCode = cupDepartmentCode;
		this.cupDepartmentName = cupDepartmentName;
		this.cvisitContent = cvisitContent;
		this.dvisitDate = dvisitDate;
		this.cmakerCode = cmakerCode;
		this.cmakerName = cmakerName;
		this.dmakeDate = dmakeDate;
		this.cweather = cweather;
	}

	// Property accessors


	public Integer getIautoid() {
		return this.iautoid;
	}

	public void setIautoid(Integer iautoid) {
		this.iautoid = iautoid;
	}


	public Integer getIvisitTimes() {
		return this.ivisitTimes;
	}

	public void setIvisitTimes(Integer ivisitTimes) {
		this.ivisitTimes = ivisitTimes;
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


	public String getCvisitContent() {
		return this.cvisitContent;
	}

	public void setCvisitContent(String cvisitContent) {
		this.cvisitContent = cvisitContent;
	}


	public String getDvisitDate() {
		return this.dvisitDate;
	}

	public void setDvisitDate(String dvisitDate) {
		this.dvisitDate = dvisitDate;
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


	public String getCweather() {
		return this.cweather;
	}

	public void setCweather(String cweather) {
		this.cweather = cweather;
	}


}