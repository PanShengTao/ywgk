package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-2-28
 *     desc   :
 * </pre>
 */
public class BootImage {
    private String bannerPath;

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    @Override
    public String toString() {
        return "BootImage{" +
                "bannerPath='" + bannerPath + '\'' +
                '}';
    }
}
