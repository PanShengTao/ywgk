package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   : 问候详情
 * </pre>
 */
public class GreetingDetil {
    //主题
    private String familyMatter;
    //罪犯姓名
    private String personName;
    //用户名称
    private String userName;
    //消息
    private String videoMessage;
    //视频地址
    private String videoPath;
    //视频时长
    private String videoTime;
    //音频地址
    private String voicePath;
    //音频时长
    private String voiceTime;
    //审核状态 0审批中 1审批通过 2失败 3已阅读
    private int videoStatus;


    public String getFamilyMatter() {
        return familyMatter;
    }

    public void setFamilyMatter(String familyMatter) {
        this.familyMatter = familyMatter;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVideoMessage() {
        return videoMessage;
    }

    public void setVideoMessage(String videoMessage) {
        this.videoMessage = videoMessage;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public int getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(int videoStatus) {
        this.videoStatus = videoStatus;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    @Override
    public String toString() {
        return "GreetingDetil{" +
                "familyMatter='" + familyMatter + '\'' +
                ", personName='" + personName + '\'' +
                ", userName='" + userName + '\'' +
                ", videoMessage='" + videoMessage + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", videoStatus=" + videoStatus +
                ", voicePath='" + voicePath + '\'' +
                '}';
    }
}
