package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-2-26
 *     desc   : 会见
 * </pre>
 */
public class Meet {
    // 监狱编号
    private Integer unitCode;

    // 犯人编号
    private String prisonerCode;
    // 犯人姓名
    private String prisonerName;

    // 关系编号
    private String relationshipCode;
    // 关系名称
    private String relationshipName;

    // 用户编号
    private String userCode;
    // 用户姓名
    private String userName;

    // 会见开始时间
    private String startDataTime;
    // 会见结束时间
    private String endDataTime;

    // 会见方式编号
    private String meetWayCode;
    // 会见方式名称
    private String meetWayName;

    // 备注
    private String remark;

    public int getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(int unitCode) {
        this.unitCode = unitCode;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public String getRelationshipCode() {
        return relationshipCode;
    }

    public void setRelationshipCode(String relationshipCode) {
        this.relationshipCode = relationshipCode;
    }

    public String getPrisonerName() {
        return prisonerName;
    }

    public void setPrisonerName(String prisonerName) {
        this.prisonerName = prisonerName;
    }

    public String getPrisonerCode() {
        return prisonerCode;
    }

    public void setPrisonerCode(String prisonerCode) {
        this.prisonerCode = prisonerCode;
    }

    public String getEndDataTime() {
        return endDataTime;
    }

    public void setEndDataTime(String endDataTime) {
        this.endDataTime = endDataTime;
    }

    public String getStartDataTime() {
        return startDataTime;
    }

    public void setStartDataTime(String startDataTime) {
        this.startDataTime = startDataTime;
    }

    public String getMeetWayCode() {
        return meetWayCode;
    }

    public void setMeetWayCode(String meetWayCode) {
        this.meetWayCode = meetWayCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getMeetWayName() {
        return meetWayName;
    }

    public void setMeetWayName(String meetWayName) {
        this.meetWayName = meetWayName;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "unitCode=" + unitCode +
                ", prisonerCode='" + prisonerCode + '\'' +
                ", prisonerName='" + prisonerName + '\'' +
                ", relationshipCode='" + relationshipCode + '\'' +
                ", relationshipName='" + relationshipName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", startDataTime='" + startDataTime + '\'' +
                ", endDataTime='" + endDataTime + '\'' +
                ", meetWayCode='" + meetWayCode + '\'' +
                ", meetWayName='" + meetWayName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
