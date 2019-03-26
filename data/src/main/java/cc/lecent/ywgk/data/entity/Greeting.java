package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   : 请求问候
 * </pre>
 */
public class Greeting {
    //发送问候时间
    private String createTime;
    //问候主题
    private String familyMatter;
    // id
    private String id;
    //罪犯姓名
    private String personName;
    // 审核状态 0审核状态 1审核通过 2审核未通过 3已读
    private int videoStatus;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFamilyMatter() {
        return familyMatter;
    }

    public void setFamilyMatter(String familyMatter) {
        this.familyMatter = familyMatter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(int videoStatus) {
        this.videoStatus = videoStatus;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "createTime='" + createTime + '\'' +
                ", familyMatter='" + familyMatter + '\'' +
                ", id='" + id + '\'' +
                ", personName='" + personName + '\'' +
                ", videoStatus=" + videoStatus +
                '}';
    }
}
