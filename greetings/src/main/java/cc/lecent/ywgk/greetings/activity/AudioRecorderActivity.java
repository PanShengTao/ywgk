package cc.lecent.ywgk.greetings.activity;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.greenrobot.eventbus.EventBus;

import java.util.UUID;

import cc.lecent.bbc.base.BaseActivity;

import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.util.Multimedia.MediaUtils;
import cc.lecent.ywgk.greetings.view.DataCorrection;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

/**
 * 录音界面
 */

public class AudioRecorderActivity extends BaseActivity {

    private TextView mic,info;
    private ImageView micIcon;
    private MediaUtils mediaUtils;
    private boolean isCancel;
    private Chronometer chronometer;
    private RelativeLayout audioLayout;
    private String duration;
    private boolean ret;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        mediaUtils = new MediaUtils(this);
        mediaUtils.setRecorderType(MediaUtils.MEDIA_AUDIO);
        mediaUtils.setTargetDir(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
        mediaUtils.setTargetName(UUID.randomUUID() + ".mp3");
        // btn
        mic = (TextView) findViewById(R.id.tv_mic);
        info = (TextView) findViewById(R.id.tv_info);
        mic.setOnTouchListener(touchListener);
        chronometer = (Chronometer) findViewById(R.id.time_display);
        chronometer.setOnChronometerTickListener(tickListener);
        micIcon = (ImageView) findViewById(R.id.mic_icon);
        audioLayout = (RelativeLayout) findViewById(R.id.audio_layout);
//        findViewById(R.id.cnb_title).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == PERMISSION_GRANTED) {
                startAnim(true);
                mediaUtils.record();
                ret = true;
            } else {
                Toast.makeText(this, "权限授予了，程序才能正常运行，请重新授予权限！", Toast.LENGTH_SHORT).show();
            }

        }
    }




    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ret = false;
            float downY = 0;
            int action = event.getAction();
            int i = v.getId();
            if (i == R.id.tv_mic) {
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        if (ActivityCompat.checkSelfPermission(AudioRecorderActivity.this, Manifest.permission.RECORD_AUDIO)
                                != PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(AudioRecorderActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, 100);
                        } else {
                            startAnim(true);
                            mediaUtils.record();
                            ret = true;
                        }

                        break;
                    case MotionEvent.ACTION_UP:
                        stopAnim();
                        if (isCancel) {
                            isCancel = false;
                            mediaUtils.stopRecordUnSave();
                            Toast.makeText(AudioRecorderActivity.this, "取消保存", Toast.LENGTH_SHORT).show();
                        } else {
                            int duration = getDuration(chronometer.getText().toString());
                            switch (duration) {
                                case -1:
                                    break;
                                case -2:
                                    mediaUtils.stopRecordUnSave();
                                    Toast.makeText(AudioRecorderActivity.this, "时间太短", Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    mediaUtils.stopRecordSave();
                                    String path = mediaUtils.getTargetFilePath();

//                                        Messenger.getDefault().send(path, 400);
                                    /**
                                     * 这里写数据回调
                                     */
                                    EventBus.getDefault().post(new DataCorrection(400, path));

                                    finish();
                                    break;
                            }
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float currentY = event.getY();
                        if (downY - currentY > 10) {
                            moveAnim();
                            isCancel = true;
                        } else {
                            isCancel = false;
                            startAnim(false);
                        }
                        break;
                }

            }
            return ret;
        }
    };

    Chronometer.OnChronometerTickListener tickListener = new Chronometer.OnChronometerTickListener() {
        @Override
        public void onChronometerTick(Chronometer chronometer) {
            if (SystemClock.elapsedRealtime() - chronometer.getBase() > 31 * 1000) {
                stopAnim();
                mediaUtils.stopRecordSave();
                Toast.makeText(AudioRecorderActivity.this, "录音时间最多30s", Toast.LENGTH_SHORT).show();
//                String path = mediaUtils.getTargetFilePath();
//                Toast.makeText(AudioRecorderActivity.this, "文件以保存至：" + path, Toast.LENGTH_SHORT).show();
            }
        }
    };

    private int getDuration(String str) {
        String a = str.substring(0, 1);
        String b = str.substring(1, 2);
        String c = str.substring(3, 4);
        String d = str.substring(4);
        if (a.equals("0") && b.equals("0")) {
            if (c.equals("0") && Integer.valueOf(d) < 1) {
                return -2;
            } else if (c.equals("0") && Integer.valueOf(d) > 1) {
                duration = d;
                return Integer.valueOf(d);
            } else {
                duration = c + d;
                return Integer.valueOf(c + d);
            }
        } else {
            duration = "60";
            return -1;
        }

    }

    private void startAnim(boolean isStart){
        audioLayout.setVisibility(View.VISIBLE);
        info.setText("上滑取消");
        mic.setBackground(getResources().getDrawable(R.drawable.mic_pressed_bg));
        micIcon.setBackground(null);
        micIcon.setBackground(getResources().getDrawable(R.drawable.ic_mic_white_24dp));
        if (isStart){
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.setFormat("%S");
            chronometer.start();
        }
    }

    private void stopAnim(){
        audioLayout.setVisibility(View.GONE);
        mic.setBackground(getResources().getDrawable(R.drawable.mic_bg));
        chronometer.stop();
    }

    private void moveAnim(){
        info.setText("松手取消");
        micIcon.setBackground(null);
        micIcon.setBackground(getResources().getDrawable(R.drawable.ic_undo_black_24dp));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
