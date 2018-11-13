package cn.wqgallery.mybarcolor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by AsionReachel on 2016/2/23.
 * E-mail:AsionReachel@qq.com
 */
public abstract class BaseActivity extends FragmentActivity {
    protected View status_bar_fix;
    private ViewGroup contentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        contentView = (ViewGroup) findViewById(R.id.base_content);
        status_bar_fix = (View) findViewById(R.id.status_bar_fix);
    }

    /**
     * 设置内容页面
     *
     * @param layoutId
     */
    protected View setBodyView(int layoutId) {
        return View.inflate(this, layoutId, contentView);
    }

    protected void setBarColor(int color, int height) {
        status_bar_fix.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));//填充状态栏
        status_bar_fix.setBackgroundResource(color);
    }

    /**
     * 获取状态栏高度,在页面还没有显示出来之前
     */
    public int getStateBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 设置不需要设置状态栏的颜色
     * <p>
     * 是否设置StatusBar的颜色，绝大部分是要设置的，特殊的不需要设置，例如一个Activity中有多个Fragment的
     * Activity，多个Fragment的状态栏颜色可能不相同，那就只好交给Fragment自己去设置。遇到这样的Activity
     * 需要返回false
     */
    protected void notSetStatusBarColor() {
        StatusBarUtil.setStatusBarTranslucent(this);
    }


}