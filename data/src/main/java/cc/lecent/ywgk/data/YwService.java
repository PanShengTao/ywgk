package cc.lecent.ywgk.data;

import java.util.List;

import cc.lecent.http.Call;
import cc.lecent.http.anno.Body;
import cc.lecent.http.anno.GET;
import cc.lecent.http.anno.Header;
import cc.lecent.http.anno.Multipart;
import cc.lecent.http.anno.POST;
import cc.lecent.http.anno.Part;
import cc.lecent.http.anno.Query;
import cc.lecent.ywgk.data.entity.BannerImage;
import cc.lecent.ywgk.data.entity.BindPrisoner;
import cc.lecent.ywgk.data.entity.BindPrisonerPara;
import cc.lecent.ywgk.data.entity.BootImage;
import cc.lecent.ywgk.data.entity.Greeting;
import cc.lecent.ywgk.data.entity.GreetingDetil;
import cc.lecent.ywgk.data.entity.Login;
import cc.lecent.ywgk.data.entity.Meet;
import cc.lecent.ywgk.data.entity.MeetWay;
import cc.lecent.ywgk.data.entity.Page;
import cc.lecent.ywgk.data.entity.PrisonStyle;
import cc.lecent.ywgk.data.entity.Prisoner;
import cc.lecent.ywgk.data.entity.PublicityFamily;
import cc.lecent.ywgk.data.entity.PublicitySocial;
import cc.lecent.ywgk.data.entity.Relation;
import cc.lecent.ywgk.data.entity.SendGreeting;
import cc.lecent.ywgk.data.entity.Verified;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-12-18
 *     desc   : 狱务公开服务
 * </pre>
 */

public interface YwService {
    /**
     * 连接服务器
     *
     * @return 连接状态
     */
    @GET("m/v1/account/conectServer")
    Call<YwResponse<Boolean>> connect();

    /**
     * 获取引导图片列表
     *
     * @param unitCode 监狱编号(可选)
     * @return 图片列表
     */
    @GET("m/v1/bootImages")
    Call<YwResponse<List<BootImage>>> getBootImages(@Query("unitCode") Integer unitCode);

    /**
     * 发送短信验证码
     *
     * @param phoneNo 手机号码
     * @return 发送验证码结果
     */
    @GET("m/v1/account/sendSmsCode")
    Call<YwResponse<Boolean>> getSendSmsCode(@Query("phoneNo") String phoneNo);


    /**
     * 登录
     *
     * @param phoneNo 手机号码
     * @param smsCode 短信验证码
     * @return
     */
    @POST("m/v1/account/login")
    Call<YwResponse<Login>> login(@Query("phoneNo")String phoneNo, @Query("smsCode")String smsCode);

    /**
     * 实名认证
     *
     * @param verified 认证信息
     * @return
     */
    @POST("m/v1/certified/bindIdentityInfo")
    Call<YwResponse<Boolean>> verified(@Body Verified verified, @Header("ACCESS_TOKEN") String token);


    /**
     * 查找犯人
     *
     * @param unitCode 监狱编号
     * @param idCardNo 犯人身份证号
     * @param personName 犯人姓名
     * @return
     */
    @GET("m/v1/certified/getPersonEntity")
    Call<YwResponse<Prisoner>> findPrisoner(@Query("unitCode") Integer unitCode, @Query("idCardNo") String idCardNo, @Query("personName") String personName);

    /**
     * 获取家属绑定关系
     *
     * @param unitCode 监狱编号
     * @return
     */
    @GET("m/v1/relation/getRelationList")
    Call<YwResponse<List<Relation>>> getRelation(@Query("unitCode") Integer unitCode);

    /**
     * 绑定罪犯
     *
     * @param bindPrisonerPara 绑定材料
     * @return 绑定结果
     */
    @POST("m/v1/certified/onSubmitFamilyInfo")
    Call<YwResponse<Boolean>> postBindPrisoner(@Body BindPrisonerPara bindPrisonerPara, @Header("ACCESS_TOKEN") String token);

    /**
     * 获取家属绑定犯人列表
     *
     * @param token token
     * @return 犯人列表
     */
    @GET("m/v1/certified/personBindList")
    Call<YwResponse<List<BindPrisoner>>> bindPrisoner(@Header("ACCESS_TOKEN") String token);

    /**
     * 解除犯人与家属绑定
     *
     * @param token token
     * @return 解绑结果
     */
    @POST("m/v1/certified/delPersonBind")
    Call<YwResponse<Boolean>> removeBind(@Query("idCardNo") String idCardNo, @Header("ACCESS_TOKEN") String token);



    /********* 亲情问候 **********/

    /**
     * 发送问候
     *
     * @param sendGreeting 问候内容
     * @param token token
     * @return 解绑结果
     */
    @POST("m/v1/familyGreeting/insertFamilyGreeting")
    Call<YwResponse<String>> sendGreeting(@Body SendGreeting sendGreeting, @Header("ACCESS_TOKEN") String token);

    /**
     * 上传问候语音
     *
     * @param token token
     * @return 解绑结果
     */
    @Multipart
    @POST("m/v1/familyGreeting/voiceUpload")
    Call<YwResponse<Boolean>> uploadGreetingVoice(@Part("id") RequestBody greetingId,
                                                  @Part MultipartBody.Part file,
                                                  @Part("voiceTime") RequestBody voiceTime,
                                                  @Header("ACCESS_TOKEN") String token);
    /**
     * 上传问候视频
     *
     * @param token token
     * @return 解绑结果
     */
    @Multipart
    @POST("m/v1/familyGreeting/videoUpload")
    Call<YwResponse<Boolean>> uploadGreetingVideo(@Part("id") RequestBody greetingId,
                                                  @Part MultipartBody.Part file,
                                                  @Part("videoTime") RequestBody voiceTime,
                                                  @Header("ACCESS_TOKEN") String token);

    /**
     * 获取问候列表
     *
     * @param unitCode 监狱编号
     * @param token token
     * @return
     */
    @GET("m/v1/familyGreeting/findFamilyGreeting")
    Call<YwResponse<Page<List<Greeting>>>> getGreetings(@Query("unitCode") Integer unitCode, @Header("ACCESS_TOKEN") String token);

    /**
     * 获取问候详情
     *
     * @param id 问候ID
     * @param token token
     * @return 问候详情
     */
    @GET("/m/v1/familyGreeting/findFamilyGreetingDetils")
    Call<YwResponse<GreetingDetil>> getGreetingDetil(@Query("id") String id, @Header("ACCESS_TOKEN") String token);


    /********* 首页 **********/

    /**
     * 获取轮播图列表
     *
     * @param unitCode 监狱编号
     * @param type 轮播图类型(1:首页, 2:会见预约, 3:亲属汇款)
     * @return 图片列表
     */
    @GET("m/v1/banners")
    Call<YwResponse<List<BannerImage>>> getBanners(@Query("unitCode") Integer unitCode, @Query("type") Integer type);


    /**
     * 获取社会公示功能
     * @param unitCode 监狱编号
     *
     * @return 公示功能列表
     */
    @GET("m/v1/publicity/social")
    Call<YwResponse<List<PublicitySocial>>> getPublicitySocial(@Query("unitCode") Integer unitCode);

    /**
     * 获取家属公示功能
     * @param unitCode 监狱编号
     *
     * @return 公示功能列表
     */
    @GET("/m/v1/publicity/family")
    Call<YwResponse<List<PublicityFamily>>> getPublicityFamily(@Query("unitCode") Integer unitCode);

    /**
     * 获取监狱风采功能
     * @param unitCode 监狱编号
     *
     * @return 风采功能列表
     */
    @GET("/m/v1/publicity/style")
    Call<YwResponse<List<PrisonStyle>>> getPrisonStyle(@Query("unitCode") Integer unitCode);

    // TODO 未完成


    /********* 会见预约 **********/


    /**
     * 获取家属绑定犯人列表(审核已通过)
     * @param status 0待审核 1审核通过 2审核失败
     * @param token token
     * @return 犯人列表
     */
    @GET("m/v1/certified/personBindList")
    Call<YwResponse<List<BindPrisoner>>> bindPrisoner(@Query("status") Integer status, @Header("ACCESS_TOKEN") String token);

    /**
     * 获取剩余预约次数
     *
     * @param personCode 犯人编号
     * @param token token
     *
     * @return 剩余预约次数
     */
    @GET("m/v1/setting/getVisitSetting")
    Call<YwResponse<Integer>> getMeetCount(@Query("prisonerCode") String personCode, @Header("ACCESS_TOKEN") String token);


    /**
     * 获取预约方式
     *
     * @param userCode 用户编号(可选)
     *
     * @return 预约方式
     */
    @GET("m/v1/meetWay")
    Call<YwResponse<List<MeetWay>>> getMeetWay(@Query("userCode") String userCode);








    /**
     * 提交预约
     *
     * @param meet 预约信息
     *
     * @return 预约结果
     */
    @GET("m/v1/meetWay")
    Call<YwResponse<List<MeetWay>>> postMeet(@Body Meet meet);

}