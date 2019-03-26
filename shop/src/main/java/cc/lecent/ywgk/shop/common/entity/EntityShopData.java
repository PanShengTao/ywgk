package cc.lecent.ywgk.shop.common.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class EntityShopData implements MultiItemEntity {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVEN = 7;
    public static final int TYPE_EIGHT = 8;
    public static final int TYPE_NINE = 9;
    public String name;
    public int usenumber;
    public int serialnumber;

    public void setSerialnumber(int serialnumber) {
        this.serialnumber = serialnumber;
    }

    public int getSerialnumber() {
        return serialnumber;
    }

    public int getUsenumber() {
        return usenumber;
    }

    public void setUsenumber(int usenumber) {
        this.usenumber = usenumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

}