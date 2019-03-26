package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-2-26
 *     desc   : 家属公示内容
 * </pre>
 */
public class PublicityFamilyContent {
    // 编号
    private String code;
    // 内容展示图片Url
    private String imageUrl;
    // 标题
    private String title;
    // 副标题
    private String subtitle;
    // 具体内容url
    private String contentUrl;
    // 发布单位
    private String unit;
    // 发布时间
    private String date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PublicitySocialContent{" +
                "code='" + code + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", contentUrl='" + contentUrl + '\'' +
                ", unit='" + unit + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
