package cc.lecent.ywgk.greetings.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;

import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.view.CustomerVideoView;


public class DialogVideo {

    private Dialog dialog;
    private CustomerVideoView video;
    private Activity activity;
    private String url;

    public DialogVideo(Activity activity, String url) {
        this.activity = activity;
        this.url = url;
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_video, null);
        dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.setContentView(view);
        video = view.findViewById(R.id.video);
//        view.findViewById(R.id.cnb_title).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
    }

    public void show(String url) {
        dialog.show();
        setVideo(url);
    }

    private void setVideo(String url) {
        final Uri uri = Uri.parse(url);
        video.setMediaController(new MediaController(activity));//显示控制栏
        video.setVideoURI(uri);//为视频播放器设置视频路径
        video.setZOrderOnTop(true);
        video.setZOrderMediaOverlay(true);
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (video != null) {
                    video.stopPlayback();
                    dialog.dismiss();
//                    video.setVideoURI(uri);//为视频播放器设置视频路径
//                    video.setMediaController(new MediaController(activity));//显示控制栏
                }

            }
        });
        video.start();//开始播放视频
        video.setMediaController(new MediaController(activity));//显示控制栏
    }
}
