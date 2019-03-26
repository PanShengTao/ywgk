package cc.lecent.ywgk.data;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-12-18
 *     desc   : 后台响应实体
 * </pre>
 */
public class YwResponse<T> {
    public int code;
    public T obj;
    public String msg;
    public String errCode;
    public int type;

    @Override
    public String toString() {
        return "YwResponse{" +
                "code=" + code +
                ", obj=" + obj +
                ", msg='" + msg + '\'' +
                ", errCode='" + errCode + '\'' +
                ", type=" + type +
                '}';
    }
}
