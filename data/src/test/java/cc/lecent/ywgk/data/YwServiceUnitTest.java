package cc.lecent.ywgk.data;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import cc.lecent.ywgk.data.entity.BannerImage;
import cc.lecent.ywgk.data.entity.BindPrisoner;
import cc.lecent.ywgk.data.entity.BindPrisonerPara;
import cc.lecent.ywgk.data.entity.BootImage;
import cc.lecent.ywgk.data.entity.Greeting;
import cc.lecent.ywgk.data.entity.GreetingDetil;
import cc.lecent.ywgk.data.entity.Login;
import cc.lecent.ywgk.data.entity.PrisonStyle;
import cc.lecent.ywgk.data.entity.Prisoner;
import cc.lecent.ywgk.data.entity.PublicityFamily;
import cc.lecent.ywgk.data.entity.PublicitySocial;
import cc.lecent.ywgk.data.entity.Relation;
import cc.lecent.ywgk.data.entity.SendGreeting;
import cc.lecent.ywgk.data.entity.Verified;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-2-18
 *     desc   : 购物服务测试
 * </pre>
 */
public class YwServiceUnitTest {
    // 异步任务控制器
    private static CountDownLatch latch;

    // 基础数据
    private static YwRepository ywService;

    // 省局编号
    private Integer superUnitCode = 5200;

    // 监狱编号
    private Integer unitCode = 5201;

    // 监区编号
    private String prisonAreaCode = "423456788";

    // 商品类别编号
    private Long categoryCode = 2L;

    // 多监区编号
    private String prisonAreaCodes = "223456788,455312321";

    // 管理员编号
    private String adminCode = "123456";

    // 狱警编号
    private String prisonGuardCode = "52524";

    // 犯人编号
    private String prisonerCode = "5201005620";

    // 设备编号
    private String deviceCode = "0x00000000";

    // 返回行数
    private Integer rows = 10;

    // 返回页数
    private Integer page = 1;

    private String phoneNo = "18096051254";

    private String accessToken = "d50eba91f0ad4164bde0432e3f4b50f4";

    private String idCardNo = "511523198506251985";

    @BeforeClass
    public static void init() {
        latch = new CountDownLatch(1);

        ywService = YwRepository.createInstance("http://192.168.1.78:8084/");
    }


    @Test // 测试连接服务
    public void connect() {
        ywService.connect(new YwCallback<Boolean>() {

            @Override
            public void onSuccess(Boolean aBoolean) {
                printSucceed(aBoolean);
                Assert.assertTrue(aBoolean);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 测试获取引导图片列表
    public void getBootImages() {
        ywService.getBootImages(unitCode, new YwCallback<List<BootImage>>() {
            @Override
            public void onSuccess(List<BootImage> bootImages) {
                printSucceed(bootImages);
            }

            @Override
            public void onNoData() {
                printSucceed("onNoData");
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });

    }

    @Test // 发送短信验证码
    public void getSendSmsCode() {
        ywService.getSendSmsCode("18096051255", new YwCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                printSucceed(aBoolean);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });

    }

    @Test // 登录
    public void login() {
        ywService.login("18096051255", "123456", new YwCallback<Login>() {
            @Override
            public void onSuccess(Login login) {
                printSucceed(login);
                accessToken = login.getAccessToken();
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 认证
    public void verified() {
        Verified verified = new Verified("张三", 1, "汉", "1991-1-1", "贵州省贵阳市", "52213019940917419X", "仁怀公安局", "1994-09-17", "2022-09-17", "1", "2","3");

        ywService.verified(verified, new YwCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                printSucceed(aBoolean);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 查找犯人
    public void findPrisoner() {
        ywService.findPrisoner(unitCode, "522130199409174899", "王阳明", new YwCallback<Prisoner>() {
            @Override
            public void onSuccess(Prisoner prisoner) {
                printSucceed(prisoner);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });

    }

    @Test // 获取家属绑定关系
    public void getRelation() {
        ywService.getRelation(unitCode, new YwCallback<List<Relation>>() {
            @Override
            public void onSuccess(List<Relation> relations) {
                printSucceed(relations);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }


    @Test // 获取家属绑定关系
    public void postBindPrisoner() {
        BindPrisonerPara bindPrisonerPara = new BindPrisonerPara();
        bindPrisonerPara.setIdCardNo("511523198506251985");
        bindPrisonerPara.setHouseholdOneself("1");
        bindPrisonerPara.setHouseholdPrisoner("1");
        bindPrisonerPara.setRelationShip("1");
        bindPrisonerPara.setPersonerName("周克华");
        bindPrisonerPara.setUnitCode(5201);
        bindPrisonerPara.setUnitName("羊艾监狱");
        bindPrisonerPara.setRelation("父子");
        bindPrisonerPara.setHouseholdHead("1");

        ywService.postBindPrisoner(bindPrisonerPara, new YwCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                printSucceed(aBoolean);

            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 获取家属绑定犯人列表
    public void bindPrisoner() {
        ywService.bindPrisoner(new YwCallback<List<BindPrisoner>>() {
            @Override
            public void onSuccess(List<BindPrisoner> bindPrisoners) {
                printSucceed(bindPrisoners);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }




    @Test // 解除犯人与家属绑定
    public void removeBind() {
        ywService.removeBind(idCardNo, new YwCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                printSucceed(aBoolean);

            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }


    /********* 亲情问候 **********/


    @Test // 发送问候
    public void sendGreeting() {
        SendGreeting sendGreeting = new SendGreeting();
        sendGreeting.setUnitCode(unitCode);
        sendGreeting.setPersonCode("5201005720");
        sendGreeting.setPersonName("王阳明");
        sendGreeting.setVideoMessage("问候内容");
        sendGreeting.setFamilyMatter("问候主题");

        ywService.sendGreeting(sendGreeting, new YwCallback<String>() {
            @Override
            public void onSuccess(String s) {
                printSucceed(s);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }


    @Test // 上传问候语音
    public void uploadGreetingVoice() {
        String id = "201903071759179381824248531362";
        File file = new File("/home/bigoat/Music/bensound-sunny.mp3");

        ywService.uploadGreetingVoice(id, file, "11`11", new YwCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                printSucceed(aBoolean);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 上传问候视频
    public void uploadGreetingVideo() {
        String id = "201903071759179381824248531362";
        File file = new File("/home/bigoat/Videos/dde-introduction.mp4");

        ywService.uploadGreetingVideo(id, file, "11`11", new YwCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                printSucceed(aBoolean);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 获取问候列表
    public void getGreetings() {
        ywService.getGreetings(unitCode, new YwCallback<List<Greeting>>() {
            @Override
            public void onSuccess(List<Greeting> greetings) {
                printSucceed(greetings);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 获取问候详情
    public void getGreetingDetil() {
        ywService.getGreetingDetil("201903071759179381824248531362", new YwCallback<GreetingDetil>() {
            @Override
            public void onSuccess(GreetingDetil greetingDetil) {
                printSucceed(greetingDetil);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }


    /********* 首页 **********/


    @Test // 获取轮播图列表
    public void getBanners() {
        ywService.getBanners(unitCode, 1, new YwCallback<List<BannerImage>>() {
            @Override
            public void onSuccess(List<BannerImage> bannerImages) {
                printSucceed(bannerImages);
            }

            @Override
            public void onNoData() {
                printSucceed("onNoData");
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 获取社会公示功能
    public void getPublicitySocial() {
        ywService.getPublicitySocial(unitCode,new YwCallback<List<PublicitySocial>>() {
            @Override
            public void onSuccess(List<PublicitySocial> publicitySocials) {
                printSucceed(publicitySocials);
            }

            @Override
            public void onNoData() {
                printSucceed("onNoData");
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 获取家属公示功能
    public void getPublicityFamily() {
        ywService.getPublicityFamily(unitCode,new YwCallback<List<PublicityFamily>>() {
            @Override
            public void onSuccess(List<PublicityFamily> publicityFamilies) {
                printSucceed(publicityFamilies);
            }

            @Override
            public void onNoData() {
                printSucceed("onNoData");
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }

    @Test // 获取监狱风采功能
    public void getPrisonStyle() {
        ywService.getPrisonStyle(unitCode,new YwCallback<List<PrisonStyle>>() {
            @Override
            public void onSuccess(List<PrisonStyle> prisonStyles) {
                printSucceed(prisonStyles);

            }

            @Override
            public void onNoData() {
                printSucceed("onNoData");
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }


    /********* 会见预约 **********/


    @Test // 获取家属绑定犯人列表
    public void bindPrisoner2() {
        ywService.bindPrisonerThrough(new YwCallback<List<BindPrisoner>>() {
            @Override
            public void onSuccess(List<BindPrisoner> bindPrisoners) {
                printSucceed(bindPrisoners);
            }

            @Override
            public void onError(String err) {
                Assert.assertTrue(err,false);
            }

            @Override
            public void onFinish() {
                latch.countDown();
            }
        });
    }


    @After
    public void funAfter() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printSucceed(Object o) {
        if (o instanceof List) {
            for (Object s : (List)o)
                System.out.println(s.toString());
        } else {
            System.out.println(o.toString());
        }
    }

    private void printErr(Object o) {
        if (o instanceof List) {
            for (Object s : (List)o)
                System.err.println(s.toString());
        } else {
            System.err.println(o.toString());
        }
    }
}