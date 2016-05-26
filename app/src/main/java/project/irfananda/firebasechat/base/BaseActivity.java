package project.irfananda.firebasechat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;


import id.gits.mvvmcore.activity.GitsActivity;
import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by ibun on 20/04/16.
 *
 */
public abstract class BaseActivity<C extends GitsController> extends GitsActivity<C> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
