package cn.edu.hyit.seppms.domain;

public class Menu {
    // 主键id
    private Integer id;
    // 菜单编号
    private int code;
    // 菜单父级编号
    private int pcode;
    // 当前菜单的所有父级编号
    private String pcodes;
    // 菜单名称
    private String name;
    // 菜单图标
    private String icon;
    // url地址
    private String url;
    // 菜单排序号
    private int num;
    // 菜单层级
    private int levels;
    // 是否是菜单(1:是 0:不是)
    private int isMenu;
    // 备注
    private String tips;
    // 状态(1:启用 2:冻结 3:删除)
    private int status;
    // 是否打开:    1:打开   0:不打开
    private boolean isOpen;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public String getPcodes() {
		return pcodes;
	}

	public void setPcodes(String pcodes) {
		this.pcodes = pcodes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	public int getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean open) {
		isOpen = open;
	}
}