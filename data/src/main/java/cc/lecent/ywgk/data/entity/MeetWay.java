package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-2-26
 *     desc   : 会见方式
 * </pre>
 */
public class MeetWay {
    private String meetWayCode;
    private String meetWayName;

    public String getMeetWayCode() {
        return meetWayCode;
    }

    public void setMeetWayCode(String meetWayCode) {
        this.meetWayCode = meetWayCode;
    }

    public String getMeetWayName() {
        return meetWayName;
    }

    public void setMeetWayName(String meetWayName) {
        this.meetWayName = meetWayName;
    }

    @Override
    public String toString() {
        return "MeetWay{" +
                "meetWayCode='" + meetWayCode + '\'' +
                ", meetWayName='" + meetWayName + '\'' +
                '}';
    }
}
