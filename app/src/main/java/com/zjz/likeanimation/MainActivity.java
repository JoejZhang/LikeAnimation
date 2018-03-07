package com.zjz.likeanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private boolean isLike;//是否点赞状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.iv_main);
        isLike = true;//先设置为没有点赞状态

        final Animation animationLike = AnimationUtils.loadAnimation(this, R.anim.iv_main_like);//点赞动画
        animationLike.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                isLike = true;//改为点赞状态
            }
        });
        final Animation animationUnLike = AnimationUtils.loadAnimation(this, R.anim.iv_main_unlike);//取消点赞动画
        animationUnLike.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                isLike = false;//取消点赞状态
            }
        });


        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLike) {
                    mImageView.startAnimation(animationUnLike);//取消点赞
                } else {
                    mImageView.startAnimation(animationLike);//点赞
                }
            }
        });

    }
}
