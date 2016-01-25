package com.ccav.bai.myapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.ccav.bai.myapp.R;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Administrator on 2015/12/4.
 */
public class StartActivity extends Activity{

    /**
     * 启动页图片
     */
    private ImageView startPageImage;

    /**
     * 启动页图片的动画伸缩效果
     */
    private ScaleAnimation mScaleAnimation;

    /**
     * 启动页图片名称
     */
    private String startPageFileName = "start_page.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局文件
        setContentView(R.layout.start_page);
        //初始化启动页图片
        initStartPage();
    }

    /**
     * 初始化启动页图片
     */
    public void initStartPage(){
        startPageImage = (ImageView)findViewById(R.id.startPageImage);
        //从缓存中查询启动页图片
        File startPageFile = new File(getCacheDir(),startPageFileName);
        if(startPageFile.exists()){
            Log.e("liuchao","从缓存中查询到图片");
            //给ImageView赋值
            Bitmap bitmap = BitmapFactory.decodeFile(startPageFile.getAbsolutePath());
            if (bitmap != null) {
                startPageImage.setImageBitmap(bitmap);
            }
        }

        //设置启动页图片动画效果参数
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1500);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //图片展示完成之后跳转
                skipMyHome();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //设置启动页图片动画效果
        startPageImage.setAnimation(scaleAnimation);
    }

    /**
     * 图片加载完成之后跳转到首页面
     */
    public void skipMyHome(){
        //设置要跳转的Activity，可以附带参数
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        intent.putExtra("hello", "world");
        //此方法用户跳转
        startActivity(intent);
        //关闭当前页面
        finish();
    }

    /**
     * 当从此Activity跳转到另一个Activity时，会执行此方法
     */
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(StartActivity.this, R.string.welcome, Toast.LENGTH_SHORT);
        Log.e("liuchao","当从此Activity跳转到另一个Activity时，会执行此方法");
    }
}
