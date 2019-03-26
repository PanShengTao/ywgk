package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-2-28
 *     desc   : 轮播图片
 * </pre>
 */
public class BannerImage {
    private String bannerPath;

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    @Override
    public String toString() {
        return "BannerImage{" +
                "bannerPath='" + bannerPath + '\'' +
                '}';
    }
}
