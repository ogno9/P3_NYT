package com.example.nytimesmostpopularmvvm.dagger.component;

import android.app.Application;

import com.example.nytimesmostpopularmvvm.MyApplication;
import com.example.nytimesmostpopularmvvm.dagger.ActivityBuilder;
import com.example.nytimesmostpopularmvvm.dagger.modules.ContextModule;
import com.example.nytimesmostpopularmvvm.dagger.modules.NetworkModule;
import com.example.nytimesmostpopularmvvm.dagger.modules.PicassoModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, NetworkModule.class, ActivityBuilder.class, PicassoModule.class, ContextModule.class})
public interface AppComponent {
    void inject(MyApplication app);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder url(@Named("url") String url);

        AppComponent build();
    }

}
