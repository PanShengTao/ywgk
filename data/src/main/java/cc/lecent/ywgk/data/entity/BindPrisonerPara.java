package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   : 绑定犯人材料
 * </pre>
 */
public class BindPrisonerPara {
    // 户口本本人页面
    private String householdOneself;
    // 户口本罪犯页面
    private String householdPrisoner;
    // 关系证明
    private String relationShip;
    // 犯人姓名
    private String personerName;
    // 监狱编号
    private Integer unitCode;
    // 监狱名称
    private String unitName;
    // 亲属关系
    private String relation;
    // 户口本户主页面信息
    private String householdHead;
    // 罪犯身份证号
    private String idCardNo;

    public String getHouseholdOneself() {
        return householdOneself;
    }

    public void setHouseholdOneself(String householdOneself) {
        this.householdOneself = householdOneself;
    }

    public String getHouseholdPrisoner() {
        return householdPrisoner;
    }

    public void setHouseholdPrisoner(String householdPrisoner) {
        this.householdPrisoner = householdPrisoner;
    }

    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    public String getPersonerName() {
        return personerName;
    }

    public void setPersonerName(String personerName) {
        this.personerName = personerName;
    }

    public Integer getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Integer unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getHouseholdHead() {
        return householdHead;
    }

    public void setHouseholdHead(String householdHead) {
        this.householdHead = householdHead;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }


}
