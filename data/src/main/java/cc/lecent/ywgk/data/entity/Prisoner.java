package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   : 犯人
 * </pre>
 */
public class Prisoner {
    // 身份证
    private String identificationNumber;
    // 犯人编号
    private String personCode;
    // 犯人姓名
    private String personName;

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "identificationNumber='" + identificationNumber + '\'' +
                ", personCode='" + personCode + '\'' +
                ", personName='" + personName + '\'' +
                '}';
    }
}
