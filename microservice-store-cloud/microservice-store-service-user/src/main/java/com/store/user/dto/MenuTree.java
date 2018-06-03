package com.store.user.dto;

import com.store.vo.MenuVO;
import lombok.Data;

/**
 * @author chenyouhong
 * @since 2018-05-19
 *
 */
@Data
public class MenuTree extends TreeNode {

    private String icon;

    private String name;

    private String url;

    /**
     * 请求方法
     */
    private String method;

    private boolean spread = false;

    private String path;

    private String component;

    private String authority;

    private String redirect;

    private String code;

    private Integer type;

    private String label;

    private Integer sort;

    public MenuTree() {
    }

    public MenuTree(int id, String name, int parentId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.label = name;
    }

    public MenuTree(int id, String name, MenuTree parent) {
        this.id = id;
        this.parentId = parent.getId();
        this.name = name;
        this.label = name;
    }

    public MenuTree(MenuVO menuVo) {
        this.id = menuVo.getId();
        this.parentId = menuVo.getParentId();
        this.icon = menuVo.getIcon();
        this.name = menuVo.getName();
        this.url = menuVo.getUrl();
        this.path = menuVo.getPath();
        this.component = menuVo.getComponent();
        this.type = menuVo.getType();
        this.label = menuVo.getName();
        this.sort = menuVo.getSort();
    }

}
