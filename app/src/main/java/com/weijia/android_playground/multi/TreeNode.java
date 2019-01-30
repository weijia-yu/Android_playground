package com.weijia.android_playground.multi;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    TreeNode parent   = null;
    List children = new ArrayList();

    public synchronized void addChild(TreeNode child){
        if(!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
        Log.d("multi","finish action1");
    }

    public synchronized void addChildOnly(TreeNode child){
        if(!this.children.contains(child)){
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent){
        this.parent = parent;
        parent.addChildOnly(this);
        Log.d("multi","finish action2");
    }

    public synchronized void setParentOnly(TreeNode parent){
        this.parent = parent;
    }
}