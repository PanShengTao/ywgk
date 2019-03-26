package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   : 绑定犯人信息
 * </pre>
 */
public class BindPrisoner {
    // 罪犯身份证号
    private String idCardNo;
    // 罪犯姓名
    private String personName;
    // 罪犯编号
    private String personCode;
    // 所属监狱
    private String unitName;
    // 监狱编号
    private Integer unitCode;
    // 审核状态 0待审核 1通过 2失败
    private int status;

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Integer unitCode) {
        this.unitCode = unitCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BindPrisoner{" +
                "idCardNo='" + idCardNo + '\'' +
                ", personName='" + personName + '\'' +
                ", personCode='" + personCode + '\'' +
                ", unitName='" + unitName + '\'' +
                ", unitCode=" + unitCode +
                ", status=" + status +
                '}';
    }
}
