package com.linchaolong.android.imagepicker;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import java.io.File;

/**
 * Created by linchaolong on 2017/5/10.
 */
public class Utils {

  /**
   * 兼容 Android N，Intent中不能使用 file:///*
   *
   * @param context
   * @param uri
   * @return
   */
  public static Uri getIntentUri(Context context, Uri uri){
    //support android N+
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
      return getContentUri(context, uri);
    }else{
      return uri;
    }
  }

  public static Uri getContentUri(Context context, Uri fileUri){
    return FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".imagePicker.provider", new File(fileUri.getPath()));
  }

}
