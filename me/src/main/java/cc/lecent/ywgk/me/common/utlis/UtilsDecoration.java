package cc.lecent.ywgk.me.common.utlis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cc.lecent.ywgk.me.R;


public class UtilsDecoration extends RecyclerView.ItemDecoration {

    public enum DividerType {
        TYPE_FFFFFF,
        TYPE_F2F2F2,
        TYPE_E4E4E4,
        TYPE_E8E8E8,
        TYPE_E10E10E10
    }

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;
    private int mOrientation;

    public UtilsDecoration(Context context, int orientation) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.ic_launcher_two);
        setOrientation(orientation);
    }

    public UtilsDecoration(Context context, int orientation, DividerType type) {
        switch (type) {
            case TYPE_FFFFFF:
                mDivider = ContextCompat.getDrawable(context, R.drawable.ic_launcher_one);
                break;
            case TYPE_F2F2F2:
                mDivider = ContextCompat.getDrawable(context, R.drawable.ic_launcher_two);
                break;
            case TYPE_E4E4E4:
                mDivider = ContextCompat.getDrawable(context, R.drawable.ic_launcher_three);
                break;
            case TYPE_E8E8E8:
                mDivider = ContextCompat.getDrawable(context, R.drawable.ic_launcher_four);
                break;
            case TYPE_E10E10E10:
                mDivider = ContextCompat.getDrawable(context, R.drawable.ic_launcher_five);

        }
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        //获取分割线的左边距，即RecyclerView的padding值
        final int left = parent.getPaddingLeft();
        //分割线右边距
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        //遍历所有item view，为它们的下方绘制分割线
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            //设置偏移的高度是mDivider.getIntrinsicHeight，该高度正是分割线的高度
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }


}
