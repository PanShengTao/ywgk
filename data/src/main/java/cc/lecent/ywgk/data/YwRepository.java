package cc.lecent.ywgk.data;

import java.io.File;
import java.util.List;

import cc.lecent.http.Service;
import cc.lecent.http.converter.json.GsonConverterFactory;
import cc.lecent.ywgk.data.entity.BannerImage;
import cc.lecent.ywgk.data.entity.BindPrisoner;
import cc.lecent.ywgk.data.entity.BindPrisonerPara;
import cc.lecent.ywgk.data.entity.BootImage;
import cc.lecent.ywgk.data.entity.Greeting;
import cc.lecent.ywgk.data.entity.GreetingDetil;
import cc.lecent.ywgk.data.entity.Login;
import cc.lecent.ywgk.data.entity.Page;
import cc.lecent.ywgk.data.entity.PrisonStyle;
import cc.lecent.ywgk.data.entity.Prisoner;
import cc.lecent.ywgk.data.entity.PublicityFamily;
import cc.lecent.ywgk.data.entity.PublicitySocial;
import cc.lecent.ywgk.data.entity.Relation;
import cc.lecent.ywgk.data.entity.SendGreeting;
import cc.lecent.ywgk.data.entity.Verified;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-1-14
 *     desc   : 狱务公开数据接口
 * </pre>
 */
public class YwRepository {
    private final Service service;
    private final YwService ywService;

    private String accessToken = "7ed5d18554a3446ca08a61552575ac76";

    private static YwRepository instance;

    static {
        createInstance("http://192.168.1.134:8084/");
    }

    public static YwRepository getInstance() {
        if (instance == null) {
            throw new RuntimeException("ywService is not init.");
        }

        return instance;
    }

    public static YwRepository createInstance(String baseUrl) {
        instance = new YwRepository.Builder().baseUrl(baseUrl).build();
        return instance;
    }


    private YwRepository(Service service, YwService baseService) {
        this.service = service;
        this.ywService = baseService;
    }

    /**
     * 连接服务器测试
     *
     * @param callback 连接结果
     */
    public void connect(YwCallback<Boolean> callback) {
        callback.onStart();

        ywService.connect().enqueue(new ConverterCallback<Boolean>() {
            @Override
            void onSuccess(Boolean aBoolean) {
                callback.onSuccess(true);

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();

            }
        });
    }


    /**
     * 获取应用引导图片列表
     *
     * @param unitCode 监狱编号(非必需)
     * @param callback 引导图片集合
     */
    public void getBootImages(Integer unitCode, YwCallback<List<BootImage>> callback) {
        callback.onStart();

        ywService.getBootImages(unitCode).enqueue(new ConverterCallback<List<BootImage>>() {
            @Override
            void onSuccess(List<BootImage> bootImages) {
                if (bootImages==null || bootImages.size()==0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(bootImages);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /********* 登录认证 **********/

    /**
     * 发送短信验证码
     *
     * @param phoneNo 手机号码
     * @param callback 发送结果
     */
    public void getSendSmsCode(String phoneNo, YwCallback<Boolean> callback) {
        callback.onStart();

        ywService.getSendSmsCode(phoneNo).enqueue(new ConverterCallback<Boolean>() {
            @Override
            void onSuccess(Boolean aBoolean) {
                callback.onSuccess(true);

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 登录
     *
     * @param phoneNo 手机号码
     * @param smsCode 短信验证码
     * @param callback 登录信息
     */
    public void login(String phoneNo, String smsCode, YwCallback<Login> callback) {
        callback.onStart();

        ywService.login(phoneNo, smsCode).enqueue(new ConverterCallback<Login>() {
            @Override
            void onSuccess(Login login) {
                if (login != null) {
                    accessToken = login.getAccessToken();
                    callback.onSuccess(login);
                } else {
                    callback.onNoData();
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 实名认证
     *
     * @param verified 认证信息
     * @param callback 认证结果
     */
    public void verified(Verified verified, YwCallback<Boolean> callback) {
        callback.onStart();

        ywService.verified(verified, accessToken).enqueue(new ConverterCallback<Boolean>() {
            @Override
            void onSuccess(Boolean aBoolean) {
                callback.onSuccess(true);

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 查找犯人信息
     *
     * @param unitCode 监狱编号
     * @param idCardNo 身份号码
     * @param personName 犯人姓名
     * @param callback 犯人信息
     */
    public void findPrisoner(Integer unitCode, String idCardNo, String personName, YwCallback<Prisoner> callback) {
        callback.onStart();

        ywService.findPrisoner(unitCode, idCardNo, personName).enqueue(new ConverterCallback<Prisoner>() {
            @Override
            void onSuccess(Prisoner prisoner) {
                if (prisoner != null) {
                    callback.onSuccess(prisoner);
                } else {
                    callback.onNoData();
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 获取家属绑定关系
     *
     * @param unitCode 监狱编号
     * @param callback 关系列表
     */
    public void getRelation(Integer unitCode, YwCallback<List<Relation>> callback) {
        callback.onStart();

        ywService.getRelation(unitCode).enqueue(new ConverterCallback<List<Relation>>() {

            @Override
            void onSuccess(List<Relation> relations) {
                if (relations == null || relations.size() == 0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(relations);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 绑定罪犯
     *
     * @param bindPrisoner 绑定材料
     * @param callback 绑定结果
     */
    public void postBindPrisoner(BindPrisonerPara bindPrisoner, YwCallback<Boolean> callback) {
        callback.onStart();

        ywService.postBindPrisoner(bindPrisoner, accessToken).enqueue(new ConverterCallback<Boolean>() {
            @Override
            void onSuccess(Boolean aBoolean) {
                callback.onSuccess(true);

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 获取家属绑定犯人列表
     *
     * @param callback 绑定列表
     */
    public void bindPrisoner(YwCallback<List<BindPrisoner>> callback) {
        callback.onStart();

        ywService.bindPrisoner(accessToken).enqueue(new ConverterCallback<List<BindPrisoner>>() {
            @Override
            void onSuccess(List<BindPrisoner> bindPrisoners) {
                if (bindPrisoners == null || bindPrisoners.size() == 0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(bindPrisoners);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 解除犯人与家属绑定
     *
     * @param callback 解绑结果
     */
    public void removeBind(String idCardNo, YwCallback<Boolean> callback) {
        callback.onStart();

        ywService.removeBind(idCardNo, accessToken).enqueue(new ConverterCallback<Boolean>() {
            @Override
            void onSuccess(Boolean aBoolean) {
                callback.onSuccess(aBoolean);

                callback.onFinish();

            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }


    /********* 亲情问候 **********/


    /**
     * 发送问候
     *
     * @param sendGreeting 问候内容
     * @param callback 问候ID
     */
    public void sendGreeting(SendGreeting sendGreeting, YwCallback<String> callback) {
        callback.onStart();

        ywService.sendGreeting(sendGreeting, accessToken).enqueue(new ConverterCallback<String>() {
            @Override
            void onSuccess(String s) {
                callback.onSuccess(s);

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }



    /**
     * 上传问候语音
     *
     * @param id 问候ID
     * @param file 语音文件
     * @param voiceTime 语音时长
     * @param callback 上传结果
     */
    public void uploadGreetingVoice(String id, File file, String voiceTime, YwCallback<Boolean> callback) {
        callback.onStart();

        RequestBody requestId = RequestBody.create(MediaType.parse("multipart/form-data"), id);

        RequestBody requestFile = RequestBody.create(MediaType.parse("audio/mpeg"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        RequestBody requestTime = RequestBody.create(MediaType.parse("multipart/form-data"), voiceTime);

        ywService.uploadGreetingVoice(requestId, body, requestTime, accessToken).enqueue(new ConverterCallback<Boolean>() {
            @Override
            void onSuccess(Boolean aBoolean) {
                callback.onSuccess(aBoolean);

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }


    /**
     * 上传问候视频
     *
     * @param id 问候ID
     * @param file 视频文件
     * @param videoTime 视频时长
     * @param callback 上传结果
     */
    public void uploadGreetingVideo(String id, File file, String videoTime, YwCallback<Boolean> callback) {
        callback.onStart();

        RequestBody requestId = RequestBody.create(MediaType.parse("multipart/form-data"), id);

        RequestBody requestFile = RequestBody.create(MediaType.parse("audio/mp4"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        RequestBody requestTime = RequestBody.create(MediaType.parse("multipart/form-data"), videoTime);

        ywService.uploadGreetingVideo(requestId, body, requestTime, accessToken).enqueue(new ConverterCallback<Boolean>() {
            @Override
            void onSuccess(Boolean aBoolean) {
                callback.onSuccess(aBoolean);

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 获取问候列表
     *
     * @param unitCode 监狱编号
     * @param callback 问候列表
     */
    public void getGreetings(Integer unitCode, YwCallback<List<Greeting>> callback) {
        callback.onStart();

        ywService.getGreetings(unitCode, accessToken).enqueue(new ConverterCallback<Page<List<Greeting>>>() {
            @Override
            void onSuccess(Page<List<Greeting>> listPage) {
                if (listPage == null || listPage.getTotal() == 0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(listPage.getRows());
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 获取问候详情
     *
     * @param id 问候ID
     * @param callback 问候详情
     */
    public void getGreetingDetil(String id, YwCallback<GreetingDetil> callback) {
        callback.onStart();

        ywService.getGreetingDetil(id, accessToken).enqueue(new ConverterCallback<GreetingDetil>() {
            @Override
            void onSuccess(GreetingDetil greetingDetil) {
                if (greetingDetil == null) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(greetingDetil);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }


    /********* 首页 **********/


    /**
     * 获取轮播图列表
     *
     * @param unitCode 监狱编号
     * @param type 轮播图类型(1:首页, 2:会见预约, 3:亲属汇款)
     * @param callback 回调
     */
    public void getBanners(Integer unitCode, Integer type, YwCallback<List<BannerImage>> callback) {
        callback.onStart();

        ywService.getBanners(unitCode, type).enqueue(new ConverterCallback<List<BannerImage>>() {
            @Override
            void onSuccess(List<BannerImage> bannerImages) {
                if (bannerImages==null || bannerImages.size()==0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(bannerImages);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 获取社会公示功能
     *
     * @param unitCode 监狱编号
     * @param callback 公示功能列表
     */
    public void getPublicitySocial(Integer unitCode, YwCallback<List<PublicitySocial>> callback) {
        callback.onStart();

        ywService.getPublicitySocial(unitCode).enqueue(new ConverterCallback<List<PublicitySocial>>() {
            @Override
            void onSuccess(List<PublicitySocial> publicitySocials) {
                if (publicitySocials==null || publicitySocials.size()==0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(publicitySocials);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 获取家属公示功能
     *
     * @param unitCode 监狱编号
     * @param callback 公示功能列表
     */
    public void getPublicityFamily(Integer unitCode, YwCallback<List<PublicityFamily>> callback) {
        callback.onStart();

        ywService.getPublicityFamily(unitCode).enqueue(new ConverterCallback<List<PublicityFamily>>() {
            @Override
            void onSuccess(List<PublicityFamily> publicityFamilies) {
                if (publicityFamilies==null || publicityFamilies.size()==0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(publicityFamilies);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }

    /**
     * 获取监狱风采功能
     *
     * @param unitCode 监狱编号
     * @param callback 公示功能列表
     */
    public void getPrisonStyle(Integer unitCode, YwCallback<List<PrisonStyle>> callback) {
        callback.onStart();

        ywService.getPrisonStyle(unitCode).enqueue(new ConverterCallback<List<PrisonStyle>>() {
            @Override
            void onSuccess(List<PrisonStyle> prisonStyles) {
                if (prisonStyles==null || prisonStyles.size()==0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(prisonStyles);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }
    // TODO 未完成


    /********* 会见预约 **********/

    /**
     * 获取家属绑定犯人列表
     *
     * @param callback 绑定列表
     */
    public void bindPrisonerThrough(YwCallback<List<BindPrisoner>> callback) {
        callback.onStart();

        ywService.bindPrisoner(1, accessToken).enqueue(new ConverterCallback<List<BindPrisoner>>() {
            @Override
            void onSuccess(List<BindPrisoner> bindPrisoners) {
                if (bindPrisoners == null || bindPrisoners.size() == 0) {
                    callback.onNoData();
                } else {
                    callback.onSuccess(bindPrisoners);
                }

                callback.onFinish();
            }

            @Override
            void onError(String err) {
                callback.onError(err);

                callback.onFinish();
            }
        });
    }







    /**
     * 构建访问器
     */
    public static final class Builder {
        private String baseUrl;
        private Service service;
        private YwService ywService;

        public YwRepository.Builder baseUrl(String baseUrl) {
//            checkNotNull(baseUrl, "必须设置baseUrl eg. new YwRepository.Builder().baseUrl(baseurl)");
            this.baseUrl = baseUrl;
            return this;
        }

        public YwRepository build() {

            service = new Service.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ywService = service.create(YwService.class);

            return new YwRepository(service, ywService);
        }
    }
}
