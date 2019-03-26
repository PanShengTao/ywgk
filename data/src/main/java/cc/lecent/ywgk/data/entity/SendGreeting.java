package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   : 发送亲情问候
 * </pre>
 */
public class SendGreeting {
    // 监狱编号
    private Integer unitCode;
    // 犯人编号
    private String personCode;
    // 犯人姓名
    private String personName;
    // 问候内容
    private String videoMessage;
    // 问候主题
    private String familyMatter;

    public Integer getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Integer unitCode) {
        this.unitCode = unitCode;
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

    public String getVideoMessage() {
        return videoMessage;
    }

    public void setVideoMessage(String videoMessage) {
        this.videoMessage = videoMessage;
    }

    public String getFamilyMatter() {
        return familyMatter;
    }

    public void setFamilyMatter(String familyMatter) {
        this.familyMatter = familyMatter;
    }

    @Override
    public String toString() {
        return "SendGreeting{" +
                "unitCode='" + unitCode + '\'' +
                ", personCode='" + personCode + '\'' +
                ", personName='" + personName + '\'' +
                ", videoMessage='" + videoMessage + '\'' +
                ", familyMatter='" + familyMatter + '\'' +
                '}';
    }
}
