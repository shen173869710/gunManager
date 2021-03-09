package com.auto.di.guan.manager.basemodel.model.respone;

public class WateringRecord {
    private long water_user_id;
    private long member_user_id;
    private String project_name;
    private String flow_meter_count;
    private String record_date;
    private String file_ext1;
    private String file_ext2;
    private String file_ext3;
    private String file_ext4;

    public long getWater_user_id() {
        return water_user_id;
    }

    public void setWater_user_id(long water_user_id) {
        this.water_user_id = water_user_id;
    }

    public long getMember_user_id() {
        return member_user_id;
    }

    public void setMember_user_id(long member_user_id) {
        this.member_user_id = member_user_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getFlow_meter_count() {
        return flow_meter_count;
    }

    public void setFlow_meter_count(String flow_meter_count) {
        this.flow_meter_count = flow_meter_count;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public String getFile_ext1() {
        return file_ext1;
    }

    public void setFile_ext1(String file_ext1) {
        this.file_ext1 = file_ext1;
    }

    public String getFile_ext2() {
        return file_ext2;
    }

    public void setFile_ext2(String file_ext2) {
        this.file_ext2 = file_ext2;
    }

    public String getFile_ext3() {
        return file_ext3;
    }

    public void setFile_ext3(String file_ext3) {
        this.file_ext3 = file_ext3;
    }

    public String getFile_ext4() {
        return file_ext4;
    }

    public void setFile_ext4(String file_ext4) {
        this.file_ext4 = file_ext4;
    }
}
