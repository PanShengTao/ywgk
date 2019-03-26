package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   :
 * </pre>
 */
public class Verified {
    /**
     * name : 罗发港
     * sex : 1
     * national : 汉
     * birthday : 1994-09-17
     * address : 贵州省贵阳市
     * idCardNo : 52213019940917489X
     * issuingOrg : 仁怀公安局
     * validityBegin : 1994-09-17
     * validityEnd : 1994-09-17
     * idcardFront : @imageData
     * idcardBack : @imageData
     * cardHand : @imageData
     */
    // 姓名
    private String name;
    // 性别 1男 2女
    private int sex;
    // 名族
    private String national;
    // 生日
    private String birthday;
    // 地址
    private String address;
    // 身份证
    private String idCardNo;
    // 身份签发机关
    private String issuingOrg;
    // 身份证有效时间起
    private String validityBegin;
    // 身份有效时间止
    private String validityEnd;
    // 身份证正面
    private String idcardFront;
    // 身份证反面
    private String idcardBack;
    // 手持证照
    private String cardHand;


    public Verified() {
    }

    public Verified(String name, int sex, String national, String birthday, String address, String idCardNo, String issuingOrg, String validityBegin, String validityEnd, String idcardFront, String idcardBack, String cardHand) {
        this.name = name;
        this.sex = sex;
        this.national = national;
        this.birthday = birthday;
        this.address = address;
        this.idCardNo = idCardNo;
        this.issuingOrg = issuingOrg;
        this.validityBegin = validityBegin;
        this.validityEnd = validityEnd;
        this.idcardFront = idcardFront;
        this.idcardBack = idcardBack;
        this.cardHand = cardHand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getIssuingOrg() {
        return issuingOrg;
    }

    public void setIssuingOrg(String issuingOrg) {
        this.issuingOrg = issuingOrg;
    }

    public String getValidityBegin() {
        return validityBegin;
    }

    public void setValidityBegin(String validityBegin) {
        this.validityBegin = validityBegin;
    }

    public String getValidityEnd() {
        return validityEnd;
    }

    public void setValidityEnd(String validityEnd) {
        this.validityEnd = validityEnd;
    }

    public String getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(String idcardFront) {
        this.idcardFront = idcardFront;
    }

    public String getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {
        this.idcardBack = idcardBack;
    }

    public String getCardHand() {
        return cardHand;
    }

    public void setCardHand(String cardHand) {
        this.cardHand = cardHand;
    }

    @Override
    public String toString() {
        return "Verified{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", national='" + national + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", issuingOrg='" + issuingOrg + '\'' +
                ", validityBegin='" + validityBegin + '\'' +
                ", validityEnd='" + validityEnd + '\'' +
                ", idcardFront='" + idcardFront + '\'' +
                ", idcardBack='" + idcardBack + '\'' +
                ", cardHand='" + cardHand + '\'' +
                '}';
    }
}
