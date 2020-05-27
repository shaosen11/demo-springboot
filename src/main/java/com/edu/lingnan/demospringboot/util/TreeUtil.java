package com.edu.lingnan.demospringboot.util;

import com.edu.lingnan.demospringboot.entity.MenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:59 2020/5/27
 */
public class TreeUtil {

    public static List<MenuVo> toTree(List<MenuVo> treeList, Integer pid) {
        List<MenuVo> retList = new ArrayList<MenuVo>();
        for (MenuVo parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }
    private static MenuVo findChildren(MenuVo parent, List<MenuVo> treeList) {
        for (MenuVo child : treeList) {
            if (parent.getId().equals(child.getPid())) {
                if (parent.getChild() == null) {
                    parent.setChild(new ArrayList<>());
                }
                parent.getChild().add(findChildren(child, treeList));
            }
        }
        return parent;
    }
}
