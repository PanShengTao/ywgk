package cc.lecent.ywgk.data;


import cc.lecent.http.Call;
import cc.lecent.http.Callback;
import cc.lecent.http.Response;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-12-18
 *     desc   : 请求转换类
 * </pre>
 */
abstract class ConverterCallback<T> implements Callback<YwResponse<T>> {
    @Override
    public void onResponse(Call<YwResponse<T>> call, Response<YwResponse<T>> response) {
        try {
            YwResponse<T> dataResponse = response.body();

            if (dataResponse == null) {
                throw new Exception("解析数据格式失败，请联系后台管理员处理: \n" + response.toString());
            }

            // 判断是否请求成功
            if (dataResponse.code == 200) {
                onSuccess(dataResponse.obj);
            } else {
                String msg = dataResponse.msg == null ? "未知错误信息" : dataResponse.msg;
                throw new Exception("[ "+ dataResponse.code + " - " + dataResponse.errCode +" ]: " + msg);
            }
        } catch (Exception e) {
            onError(e.getMessage());
        }
    }

    @Override
    public void onFailure(Call<YwResponse<T>> call, Throwable t) {
        t.printStackTrace();
        onError(t.getMessage());
    }

    abstract void onSuccess(T t);

    abstract void onError(String err);
}
