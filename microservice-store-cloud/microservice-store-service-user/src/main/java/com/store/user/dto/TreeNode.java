package com.store.user.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyouhong
 * @since 2018-05-09
 *
 */
@Data
public class TreeNode {
    protected int id;
    protected int parentId;
    protected List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
