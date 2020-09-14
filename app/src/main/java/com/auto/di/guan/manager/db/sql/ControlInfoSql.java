package com.auto.di.guan.manager.db.sql;

import com.auto.di.guan.manager.db.ControlInfo;
import java.util.ArrayList;
import java.util.List;

public class ControlInfoSql {
    /**
     *
     * @return
     */
    public static List<ControlInfo> queryControlList () {
        List<ControlInfo> controlInfos = new ArrayList<>();
        int size = DeviceSql.getAllControl().size();
        for (int i = 0; i < size; i++) {
            ControlInfo info = DeviceSql.getAllControl().get(i);
            controlInfos.add(info);
        }
        return controlInfos;
    }

    public static List<ControlInfo> queryControlList (int groupId) {
        List<ControlInfo> controlInfos = new ArrayList<>();
        int size = DeviceSql.getAllControl().size();
        for (int i = 0; i < size; i++) {
            ControlInfo info = DeviceSql.getAllControl().get(i);
            if (info.getValveGroupId() == groupId) {
                controlInfos.add(info);
            }
        }
        return controlInfos;
    }

    /**
     *    更新单个设备信息
     */
    public static void updataControlInfo(ControlInfo info) {
        List<ControlInfo> controlInfos = queryControlList();
        int size = controlInfos.size();
        for (int i = 0; i < size; i++) {
            ControlInfo co = controlInfos.get(i);
            if (co.getValveSwitchId() == info.getValveSwitchId()) {
                co.setValveStatus(info.getValveStatus());
            }
        }

    }
}
