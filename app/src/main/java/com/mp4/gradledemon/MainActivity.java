package com.mp4.gradledemon;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    String channel = getAppMetaData("APP_CHANNEL");
        if(channel != null)
            Toast.makeText(this, channel, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取Application下面的metaData
     *
     * @param
     * @return
     * @author SHANHY
     * @date   2015年12月30日
     */
    public String getAppMetaData(String meta_name){
        try {
            ApplicationInfo appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData.getString(meta_name);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
