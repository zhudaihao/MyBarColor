package cn.wqgallery.mybarcolor;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBodyView(R.layout.activity_main);
        initView();
    }

    ImageView iv;
    private void initView() {
        //设置去掉状态栏
        notSetStatusBarColor();
        iv= (ImageView) findViewById(R.id.iv);
        iv.setImageResource(R.mipmap.tp);
    }


    public void one(View view) {
        setBarColor(R.color.colorAccent, 0);

    }

    public void two(View view) {
        setBarColor(R.color.colorPrimary, getStateBarHeight());
    }



}
