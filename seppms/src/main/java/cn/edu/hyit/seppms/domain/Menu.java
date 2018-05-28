package cn.edu.hyit.seppms.domain;

import java.sql.Date;

public class Menu {
    // 主键id
    private Integer id;
    // 菜单编号
    private String code;
    // 菜单父级编号
    private String pcode;
    // 当前菜单的所有父级编号
    private String pcodes;
    // 菜单名称
    private String name;
    // 菜单图标
    private String icon;
    // url地址
    private String url;
    // 菜单排序号
    private Integer num;
    // 菜单层级
    private Integer levels;
    // 是否是菜单(1:是 0:不是)
    private boolean ismenu;
    // 备注
    private String tips;
    // 状态(1:启用 2:冻结 3:删除)
    private boolean status;
    // 是否打开:    1:打开   0:不打开
    private boolean isopen;



    
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the pcode
	 */
	public String getPcode() {
		return pcode;
	}
	/**
	 * @param pcode the pcode to set
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	/**
	 * @return the pcodes
	 */
	public String getPcodes() {
		return pcodes;
	}
	/**
	 * @param pcodes the pcodes to set
	 */
	public void setPcodes(String pcodes) {
		this.pcodes = pcodes;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * @return the levels
	 */
	public Integer getLevels() {
		return levels;
	}
	/**
	 * @param levels the levels to set
	 */
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	/**
	 * @return the ismenu
	 */
	public boolean isIsmenu() {
		return ismenu;
	}
	/**
	 * @param ismenu the ismenu to set
	 */
	public void setIsmenu(boolean ismenu) {
		this.ismenu = ismenu;
	}
	/**
	 * @return the tips
	 */
	public String getTips() {
		return tips;
	}
	/**
	 * @param tips the tips to set
	 */
	public void setTips(String tips) {
		this.tips = tips;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the isopen
	 */
	public boolean isIsopen() {
		return isopen;
	}
	/**
	 * @param isopen the isopen to set
	 */
	public void setIsopen(boolean isopen) {
		this.isopen = isopen;
	}

    
}