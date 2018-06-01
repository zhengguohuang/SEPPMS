package cn.edu.hyit.seppms.domain;

public class Relation {
	private Integer id;
	// 角色名：student leader admin
	private String roleName;
	// 菜单对象
	private Menu menu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
