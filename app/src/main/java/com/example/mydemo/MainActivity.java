package com.example.mydemo;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import device.DeviceFragment;
import health.HealthFragment;
import mine.MineFragment;
import motion.MotionFragment;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.iv_health)
    ImageView ivHealth;
    @BindView(R.id.tv_health)
    TextView tvHealth;
    @BindView(R.id.ll_health)
    LinearLayout llHealth;
    @BindView(R.id.iv_motion)
    ImageView ivMotion;
    @BindView(R.id.tv_motion)
    TextView tvMotion;
    @BindView(R.id.ll_motion)
    LinearLayout llMotion;
    @BindView(R.id.iv_device)
    ImageView ivDevice;
    @BindView(R.id.tv_device)
    TextView tvDevice;
    @BindView(R.id.ll_device)
    LinearLayout llDevice;
    @BindView(R.id.iv_mine)
    ImageView ivMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    private Unbinder unbinder;
    private HealthFragment healthFragment;
    private MotionFragment motionFragment;
    private DeviceFragment deviceFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        healthFragment = HealthFragment.newInstance();
        ivHealth.setSelected(true);
        tvHealth.setSelected(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, healthFragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @OnClick({R.id.ll_health, R.id.ll_motion, R.id.ll_device, R.id.ll_mine,R.id.iv_menu})
    public void onViewClicked(View view) {
        refrshView();
        switch (view.getId()) {
            case R.id.ll_health:
                ivHealth.setSelected(true);
                tvHealth.setSelected(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, healthFragment).commit();
                break;
            case R.id.ll_motion:
                ivMotion.setSelected(true);
                tvMotion.setSelected(true);
                if (motionFragment == null) {
                    motionFragment = MotionFragment.newInstance();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, motionFragment).commit();
                break;
            case R.id.ll_device:
                ivDevice.setSelected(true);
                tvDevice.setSelected(true);
                if (deviceFragment == null) {
                    deviceFragment = DeviceFragment.newInstance();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, deviceFragment).commit();
                break;
            case R.id.ll_mine:
                ivMine.setSelected(true);
                tvMine.setSelected(true);
                if (mineFragment == null) {
                    mineFragment = MineFragment.newInstance();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, mineFragment).commit();
                break;
            case R.id.iv_menu:

                break;
        }
    }

    private void refrshView() {
        ivHealth.setSelected(false);
        ivMotion.setSelected(false);
        ivDevice.setSelected(false);
        ivMine.setSelected(false);

        tvHealth.setSelected(false);
        tvMotion.setSelected(false);
        tvDevice.setSelected(false);
        tvMine.setSelected(false);
    }


}