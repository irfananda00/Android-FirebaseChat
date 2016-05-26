package project.irfananda.firebasechat.mvvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import project.irfananda.firebasechat.R;
import project.irfananda.firebasechat.base.BaseActivity;

public class MainActivity extends BaseActivity<MainController> {

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainController createController() {
        return new MainController();
    }
}
