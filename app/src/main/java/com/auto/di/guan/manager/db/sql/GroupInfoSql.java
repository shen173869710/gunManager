package com.auto.di.guan.manager.db.sql;

import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.db.GroupInfo;

import java.util.ArrayList;
import java.util.List;

public class GroupInfoSql {

    public static List<GroupInfo> getJoinGroup() {
        List<GroupInfo> groupInfos = new ArrayList<>();
        int size = BaseApp.getGroupInfos().size();
        for (int i = 0; i < size; i++) {
            GroupInfo groupInfo = BaseApp.getGroupInfos().get(i);
            if (groupInfo.getGroupIsJoin()) {
                groupInfos.add(groupInfo);
            }
        }
        return groupInfos;
    }
}
