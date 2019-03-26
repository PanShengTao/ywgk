package cc.lecent.ywgk.data;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-12-18
 *     desc   : 基础数据回调
 * </pre>
 */
public abstract class YwCallback<T> {

    /** 开始前 */
    public void onStart() {};

    /** 请求成功 */
    public abstract void onSuccess(T t);

    /** 无数据 */
    public void onNoData() {};

    /** 请求失败 */
    public void onError(String err) {};

    /** 请求完成 */
    public void onFinish() {};
}
