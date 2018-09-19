package com.xiongch.lib_common.base;

import android.app.Application;
import android.content.Context;

import com.xiongch.lib_common.module.IAppLife;
import com.xiongch.lib_common.module.IModuleConfig;
import com.xiongch.lib_common.utils.ManifestParser;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDelegate implements IAppLife {
    private List<IModuleConfig> list;
    private List<IAppLife> appLifes;
    private List<Application.ActivityLifecycleCallbacks> liferecycleCallbacks;

    public ApplicationDelegate() {
        appLifes = new ArrayList<>();
        liferecycleCallbacks = new ArrayList<>();
    }

    @Override
    public void attachBaseContext(Context base) {
        ManifestParser manifestParser = new ManifestParser(base);
        list = manifestParser.parse();
        if (list != null && list.size() > 0) {
            for (IModuleConfig configModule : list) {
                configModule.injectAppLifecycle(base, appLifes);
                configModule.injectActivityLifecycle(base, liferecycleCallbacks);
            }
        }
        if (appLifes != null && appLifes.size() > 0) {
            for (IAppLife life : appLifes) {
                life.attachBaseContext(base);
            }
        }
    }

    @Override
    public void onCreate(Application application) {
        if (appLifes != null && appLifes.size() > 0) {
            for (IAppLife life : appLifes) {
                life.onCreate(application);
            }
        }
        if (liferecycleCallbacks != null && liferecycleCallbacks.size() > 0) {
            for (Application.ActivityLifecycleCallbacks life : liferecycleCallbacks) {
                application.registerActivityLifecycleCallbacks(life);
            }
        }
    }

    @Override
    public void onTerminate(Application application) {
        if (appLifes != null && appLifes.size() > 0) {
            for (IAppLife life : appLifes) {
                life.onTerminate(application);
            }
        }
        if (liferecycleCallbacks != null && liferecycleCallbacks.size() > 0) {
            for (Application.ActivityLifecycleCallbacks life : liferecycleCallbacks) {
                application.unregisterActivityLifecycleCallbacks(life);
            }
        }
    }
}
