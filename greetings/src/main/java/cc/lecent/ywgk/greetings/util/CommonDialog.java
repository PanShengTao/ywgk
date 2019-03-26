package cc.lecent.ywgk.greetings.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cc.lecent.ywgk.greetings.R;

/**
 * 作者：RenJiaFen
 * 创建时间：2017/8/11 17:29.
 * 功能描述：应用内统一弹框样式
 */

public class CommonDialog {

    private Context mContext;
    private Display mDisplay;
    private Dialog mDialog;

    private LinearLayout mDialogLayout;
    private ImageView mDialogImage;
    private TextView mDialogTitle;
    private TextView mDialogMessage;
    private Button mBtnNegative;
    private ImageView mButtonDivider;
    private Button mBtnPositive;
//    private ImageView mBottomImg;

    private boolean mIsShowImage = false;
    private boolean mIsShowTitle = false;
    private boolean mIsShowMsg = false;
    private boolean mIsShowPosBtn = false;
    private boolean isRedBtn = false;//是否设置确定按钮为红色
    private boolean mIsShowNegBtn = false;
    private boolean mIsShowBottomImg = false;
    private boolean mIsNegativeBackground = false;//是否设置取消（左）按钮的颜色

    public CommonDialog(Context context) {
        this.mContext = context;

//      获取窗口服务，用于对屏幕进行相关设置
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        mDisplay = windowManager.getDefaultDisplay();
    }

    public CommonDialog builder() {
        // 获取dialog的布局
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.view_common_dialog, null);

        // 控件初始化
        mDialogLayout = (LinearLayout) view.findViewById(R.id.dialogLayout);
        mDialogImage = (ImageView) view.findViewById(R.id.dialogImage);
        mDialogTitle = (TextView) view.findViewById(R.id.dialogTitle);
        mDialogMessage = (TextView) view.findViewById(R.id.dialogMessage);
        mBtnNegative = (Button) view.findViewById(R.id.btNegative);
        mButtonDivider = (ImageView) view.findViewById(R.id.buttonDivider);
        mBtnPositive = (Button) view.findViewById(R.id.btnPositive);
//        mBottomImg = (ImageView) view.findViewById(R.id.bottomImg);
//        mDialogLayout.setVisibility(View.GONE);
        mDialogImage.setVisibility(View.GONE);
        mDialogTitle.setVisibility(View.GONE);
        mDialogMessage.setVisibility(View.GONE);
        mBtnNegative.setVisibility(View.GONE);
        mButtonDivider.setVisibility(View.GONE);
        mBtnPositive.setVisibility(View.GONE);
//        mBottomImg.setVisibility(View.GONE);

        // 创建系统Dialog并设置自定义背景
        mDialog = new Dialog(mContext, R.style.AlertDialogStyle);
        mDialog.setContentView(view);

        // 设置Dialog布局属性
        mDialogLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (mDisplay
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));

        return this;
    }

    /**
     * 设置弹框图标
     *
     * @param imageId 弹框图标
     * @return 弹框引用，用于设置其他属性
     */
    public CommonDialog setImage(int imageId) {
        mIsShowImage = true;
        //title默认有初始化值
        if (imageId < 0) {
//            mDialogImage.setBackgroundResource(R.drawable.dialog_error);
        } else {
            mDialogImage.setBackgroundResource(imageId);
        }
        return this;
    }

    public CommonDialog setMessageGravity(int gravity) {
        mDialogMessage.setGravity(gravity);
        return this;
    }


    /**
     * 设置弹框标题
     *
     * @param title 弹框标题
     * @return 弹框引用，用于设置其他属性
     */
    public CommonDialog setTitle(String title) {
        mIsShowTitle = true;
        //title默认有初始化值
        if ("".equals(title)) {
            mDialogTitle.setText("弹框标题");
        } else {
            mDialogTitle.setText(title);
        }
        return this;
    }

    /**
     * 设置标题栏的颜色
     *
     * @param colorId 标题栏的颜色值
     * @return 弹框引用，用于设置其他属性
     */
    public CommonDialog setTitleColor(int colorId) {
        mDialogTitle.setTextColor(colorId);
        return this;
    }

    /**
     * 设置弹框内容
     *
     * @param msg 弹框内容
     * @return 弹框引用，用于设置其他属性
     */
    public CommonDialog setMessage(String msg, boolean... isMessageGravity) {
        mIsShowMsg = true;
        if ("".equals(msg)) {
            mDialogMessage.setText("弹框内容");
        } else if (isMessageGravity.length > 0 && isMessageGravity[0]) {

            if (msg.length() > 17) {
                SpannableStringBuilder span = new SpannableStringBuilder("缩进" + msg.trim());
                span.setSpan(new ForegroundColorSpan(Color.TRANSPARENT), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                mDialogMessage.setText(span);
            } else {
                mDialogMessage.setGravity(Gravity.CENTER);
                mDialogMessage.setText(msg);
            }
        } else {
            if (msg.length() > 17) {
                mDialogMessage.setText("\u3000\u3000" + msg);
            } else {
                mDialogMessage.setGravity(Gravity.CENTER);
                mDialogMessage.setText(msg);
            }
        }
        return this;
    }


    /**
     * 取消弹框
     *
     * @param cancel 是否取消弹框
     * @return 弹框引用，用于设置其他属性
     */
    public CommonDialog setCancelable(boolean cancel) {
        mDialog.setCancelable(cancel);
        return this;
    }

    /**
     * 设置弹框确定按钮
     *
     * @param text     确定按钮内容
     * @param listener 确定按钮点击事件监听器
     * @return 弹框引用，用于设置其他属性
     */
    public CommonDialog setPositiveButton(String text,
                                          final View.OnClickListener listener) {
        mIsShowPosBtn = true;
        if ("".equals(text)) {
            mBtnPositive.setText("确定");
        } else {
            mBtnPositive.setText(text);
        }
        mBtnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                mDialog.dismiss();
            }
        });
        return this;
    }

    /**
     * 设置弹框确定按钮颜色
     */
    public CommonDialog setPositiveButtonColorRed() {
        isRedBtn = true;
        return this;
    }

    /**
     * 设置弹框取消按钮
     *
     * @param text     取消按钮内容
     * @param listener 取消按钮点击事件监听器
     * @return 弹框引用，用于设置其他属性
     */
    public CommonDialog setNegativeButton(String text,
                                          final View.OnClickListener listener) {
        mIsShowNegBtn = true;
        if ("".equals(text)) {
            mBtnNegative.setText("取消");
        } else {
            mBtnNegative.setText(text);
        }

        mBtnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                mDialog.dismiss();
            }
        });


        return this;
    }

    /**
     * 设置底部图片
     *
     * @param resId    图片资源
     * @param listener 取消按钮点击事件监听器
     * @return 弹框引用，用于设置其他属性
     */
//    public CommonDialog setBottomImg(int resId, final View.OnClickListener listener) {
//        mIsShowBottomImg = true;
//        mBottomImg.setBackgroundResource(resId);
//        mBottomImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onClick(v);
//                mDialog.dismiss();
//            }
//        });
//        return this;
//    }

    /**
     * 获取底部图片引用
     *
     * @return 底部图片引用
     */
//    public ImageView getBottomImg() {
//        return mBottomImg;
//    }
    public CommonDialog setNegativeButtonBackground(int color) {
        mIsNegativeBackground = true;
        mBtnNegative.setBackgroundResource(color);
        return this;
    }

    public CommonDialog setNegativeButtonTextColor(int color) {
        mBtnNegative.setTextColor(color);
        return this;
    }

    /**
     * 根据设置的属性设定布局样式
     */
    private void setLayout() {
        if (!mIsShowTitle && !mIsShowMsg) {
            mDialogTitle.setText("弹框标题");
            mDialogTitle.setVisibility(View.VISIBLE);
        }

        if (mIsShowImage) {
            mDialogImage.setVisibility(View.VISIBLE);
        }

        if (mIsShowTitle) {
            mDialogTitle.setVisibility(View.VISIBLE);
        }

        if (mIsShowMsg) {
            mDialogMessage.setVisibility(View.VISIBLE);
        }

        if (!mIsShowPosBtn && !mIsShowNegBtn) {
            mBtnPositive.setText("确定");
            mBtnPositive.setVisibility(View.VISIBLE);
            mBtnPositive.setBackgroundResource(R.drawable.dialog_button_right);
            mBtnPositive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDialog.dismiss();
                }
            });
        }

        if (mIsShowPosBtn && mIsShowNegBtn) {
            mBtnPositive.setVisibility(View.VISIBLE);
            mBtnPositive.setBackgroundResource(R.drawable.dialog_button_right);

            mBtnNegative.setVisibility(View.VISIBLE);
            if (!mIsNegativeBackground) {
                mBtnNegative.setBackgroundResource(R.drawable.dialog_button_left);
            }

            mButtonDivider.setVisibility(View.VISIBLE);
        }

        if (mIsShowPosBtn && !mIsShowNegBtn) {
            mBtnPositive.setVisibility(View.VISIBLE);
            mBtnPositive.setBackgroundResource(R.drawable.dialog_button_bottom);
        }

        if (!mIsShowPosBtn && mIsShowNegBtn) {
            mBtnNegative.setVisibility(View.VISIBLE);
            mBtnNegative.setBackgroundResource(R.drawable.dialog_button_bottom);
        }

//        if (mIsShowBottomImg) {
//            mBottomImg.setVisibility(View.VISIBLE);
//        }

//        if (isRedBtn) {
//            mBtnPositive.setBackgroundResource(R.drawable.red_btn_background);
//        }
    }

    public void show() {
        setLayout();
        mDialog.show();
    }

    public boolean isShow() {
        return mDialog.isShowing();
    }
}
