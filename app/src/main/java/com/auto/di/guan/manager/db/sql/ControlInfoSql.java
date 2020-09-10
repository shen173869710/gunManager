package com.auto.di.guan.manager.db.sql;

import com.auto.di.guan.manager.db.ControlInfo;

import java.util.ArrayList;
import java.util.List;
public class ControlInfoSql {

    public static List<ControlInfo> queryControlList (int groupId) {
        List<ControlInfo> controlInfos = new ArrayList<>();
        int size = DeviceSql.getAllControl().size();
        for (int i = 0; i < size; i++) {
            ControlInfo info = DeviceSql.getAllControl().get(i);
            if (info.getValve_group_id() == groupId) {
                controlInfos.add(info);
            }
        }
        return controlInfos;
    }
}
