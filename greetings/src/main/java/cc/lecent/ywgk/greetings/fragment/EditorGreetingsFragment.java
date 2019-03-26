package cc.lecent.ywgk.greetings.fragment;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Messenger;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.sh.shvideolibrary.VideoInputDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.bbc.utils.ToastUtils;
import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.dialog.DialogVideo;
import cc.lecent.ywgk.greetings.model.EditorGreetingsModel;
import cc.lecent.ywgk.greetings.databinding.FragmentEditorGreetingsBinding;
import cc.lecent.ywgk.greetings.util.CommonDialog;
import cc.lecent.ywgk.greetings.util.StringUtils;
import cc.lecent.ywgk.greetings.view.DataCorrection;


/**
 * 编辑亲情问候
 */
public class EditorGreetingsFragment extends BaseFragment implements VideoInputDialog.VideoCall {
    private FragmentEditorGreetingsBinding binding;
    private EditorGreetingsModel model;
    private CommonDialog mCommonDialog;
    private boolean isYY = true;
    private boolean isSP = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        model=new EditorGreetingsModel(this);
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_editor_greetings,container,false);
        binding.setViewModel(model);
        initView();

        return binding.getRoot();
    }

    private void initView() {
        mCommonDialog = new CommonDialog(getActivity())
                .builder()
                .setTitle("提示");
        LinearLayoutManager ms = new LinearLayoutManager(getActivity());
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.bnsRecyclerViewMain.setLayoutManager(ms);

        setOnClick();

        binding.inputStr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 1000) {
                    s.delete(1000, s.length());
                }
                int num = s.length();
                binding.inputNum.setText(String.valueOf(num));

            }
        });

        model.audioPath.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (!isYY) {
                    isYY = true;
                    return;
                }
                if (StringUtils.isEmptyString(model.audioPath.get())) {
                    binding.llYy.setVisibility(View.GONE);
                } else {
                    binding.llYy.setVisibility(View.VISIBLE);
                }
            }
        });
        model.videoPath.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (!isSP) {
                    isSP = true;
                    return;
                }
                if (StringUtils.isEmptyString(model.videoPath.get())) {
                    binding.llSp.setVisibility(View.GONE);
                } else {
                    binding.llSp.setVisibility(View.VISIBLE);
                }
            }
        });

        List<Integer> integerList = new ArrayList<>();
        integerList.add(R.drawable.add_yy);
        integerList.add(R.drawable.add_sp);



        //添加联系人
        binding.ivTjlxr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.llTjlxr.isShown()){
                    binding.llTjlxr.setVisibility(View.VISIBLE);
                }else{
                    binding.llTjlxr.setVisibility(View.GONE);
                }

            }
        });

        //删除语音
        binding.ivYysc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCommonDialog.setMessage("确定删除该语音吗？")//失败原因
                        .setPositiveButton("确定", new View.OnClickListener() {//setNegativeButton取消，setPositiveButton确定
                            @Override
                            public void onClick(View v) {
                                isYY = false;
                                model.audioPath.set("");
                                binding.llYy.setVisibility(View.GONE);
                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                        .show();

            }
        });

        //删除视频
        binding.ivSpsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCommonDialog.setMessage("确定删除该视频吗？")//失败原因
                        .setPositiveButton("确定", new View.OnClickListener() {//setNegativeButton取消，setPositiveButton确定
                            @Override
                            public void onClick(View v) {
                                isSP = false;
                                model.videoPath.set("");
                                binding.llSp.setVisibility(View.GONE);
                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                        .show();


            }
        });


    }





    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onEventBackData(DataCorrection event) {
       String path= event.path;
        if (event.type==400) {
            if (StringUtils.isEmptyString(model.audioPath.get()) && StringUtils.isEmptyString(model.videoPath.get())){
                isSP = true;
                model.audioPath.set(path);
                model.videoPath.set("");
                long time = getTime(path) / 1000;//获取时长"S"
                long size = getSize(path) / 1024;//获取文件大小"KB"
                model.audioTime.set(time);
                model.audioSize.set(size);
                binding.tvMic.setText(time + "s");
            }else {

                mCommonDialog.setMessage("新录制的语音会将前面录制音频覆盖，确定覆盖吗？")
                        .setPositiveButton("确定", new View.OnClickListener() {//setNegativeButton取消，setPositiveButton确定
                            @Override
                            public void onClick(View v) {
                                isSP = true;
                                model.audioPath.set(path);
                                model.videoPath.set("");
                                long time = getTime(path) / 1000;//获取时长"S"
                                long size = getSize(path) / 1024;//获取文件大小"KB"
                                model.audioTime.set(time);
                                model.audioSize.set(size);
                                binding.tvMic.setText(time + "s");
                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                        .show();
            }


        }else if (event.type==401){

            isYY = true;
            model.videoPath.set(path);
            model.audioPath.set("");
            long time = getTime(path) / 1000;//获取时长"S"
            long size = getSize(path) / 1024;//获取文件大小"KB"
            model.videoTime.set(time);
            model.videoSize.set(size);
//                setVideo();
            setFirstFrameDrawable(model.videoPath.get());


        }
    }




    private MediaPlayer mediaPlayer;
    private VideoView video;


    private void setOnClick() {
        binding.tvMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMediaPlayer();
            }
        });

        binding.llBfsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogVideo dialogVideo = new DialogVideo(getActivity(),model.videoPath.get());
                dialogVideo.show(model.videoPath.get());
            }
        });

    }

    private void setVideo() {
//        video = binding.video;
        String url = model.videoPath.get();
        final Uri uri = Uri.parse(url);
        video.setVideoURI(uri);//为视频播放器设置视频路径
        video.setMediaController(new MediaController(getActivity()));//显示控制栏
//                video.start();//开始播放视频
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (video != null) {
                    video.setVideoURI(uri);//为视频播放器设置视频路径
                    video.setMediaController(new MediaController(getActivity()));//显示控制栏
                }

            }
        });


    }

    Bitmap firstFrame;

    private void setFirstFrameDrawable(final String url) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
//        if (Build.VERSION.SDK_INT >= 14) {
//            mmr.setDataSource(getActivity(),url, new HashMap<String, String>());
//        } else {
//            mmr.setDataSource(url);
//        }
        mmr.setDataSource(url);
        firstFrame = mmr.getFrameAtTime();
        firstFrame = big(firstFrame, 100, 100);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                binding.video.setImageBitmap(firstFrame);
            }
        });
    }

    //把传进来的bitmap对象转换为宽度为x,长度为y的bitmap对象
    public static Bitmap big(Bitmap b, float x, float y) {
        int w = b.getWidth();
        int h = b.getHeight();
        float sx = (float) x / w;
        float sy = (float) y / h;
        Matrix matrix = new Matrix();
        //也可以按两者之间最大的比例来设置放大比例，这样不会是图片压缩
//        float bigerS = Math.max(sx,sy);
//        matrix.postScale(bigerS,bigerS);
        matrix.postScale(sx, sy); // 长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(b, 0, 0, w,
                h, matrix, true);
        return resizeBmp;
    }

    private void setMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        } else {
            mediaPlayer.stop();
            binding.tvMic.setText("点击播放");
        }
        //设置类型
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            /* 为MediaPlayer 设置数据源 */
            String url = model.audioPath.get();
            mediaPlayer.setDataSource(url);
            /* 准备 */
            mediaPlayer.prepare();
            //将播放器捕捉的画面展示到SurfaceView画面上
//                    mediaPlayer.setDisplay(sv_main_surface.getHolder());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mediaPlayer.start();
        binding.tvMic.setText("播放中");
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                    mediaPlayer = null;
                    binding.tvMic.setText("点击播放");
                }

            }
        });
    }

    private int getTime(String url) {
        int duration = 0;
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            duration = mediaPlayer.getDuration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return duration;
    }

    public long getSize(String url) {
        long sizeBtye = 0;
        File f = new File(url);
        if (f.exists() && f.isFile()) {
            sizeBtye = f.length();
        }
        return sizeBtye;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void videoPathCall(final String path) {
        if (StringUtils.isEmptyString(model.audioPath.get()) && StringUtils.isEmptyString(model.videoPath.get())){
            isYY = true;
            model.videoPath.set(path);
            model.audioPath.set("");
            long time = getTime(path) / 1000;//获取时长"S"
            long size = getSize(path) / 1024;//获取文件大小"KB"
            model.videoTime.set(time);
            model.videoSize.set(size);
//                setVideo();
            setFirstFrameDrawable(model.videoPath.get());
        }else {
            mCommonDialog.setMessage("新录制的视频会将前面录制音频覆盖，确定覆盖吗？")//失败原因
                    .setPositiveButton("确定", new View.OnClickListener() {//setNegativeButton取消，setPositiveButton确定
                        @Override
                        public void onClick(View v) {
                            isYY = true;
                            model.videoPath.set(path);
                            model.audioPath.set("");
                            long time = getTime(path) / 1000;//获取时长"S"
                            long size = getSize(path) / 1024;//获取文件大小"KB"
                            model.videoTime.set(time);
                            model.videoSize.set(size);
//                setVideo();
                            setFirstFrameDrawable(model.videoPath.get());
                        }
                    }).setNegativeButton("取消", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            })
                    .show();
        }

    }

}
