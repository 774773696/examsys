package com.qfedu.examsys.pojo;

import java.util.List;

// 菜单实体类
public class MenuInfo {

    private Integer menuId; //菜单的id
    private String menuName;// 菜单的名字
    private String url; // 菜单对应的url

    //子菜单列表
    private List<MenuInfo> childMenus;


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuInfo> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenuInfo> childMenus) {
        this.childMenus = childMenus;
    }
}
