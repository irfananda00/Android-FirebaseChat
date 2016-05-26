package project.irfananda.firebasechat.base;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

import id.gits.mvvmcore.controller.GitsController;
import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by ibun on 21/04/16.
 *
 */
public abstract class BaseVM<C extends GitsController, B extends ViewDataBinding> extends GitsVM<C, B> {

    public BaseVM(AppCompatActivity activity, C controller, B binding) {
        super(activity, controller, binding);

        if (activity.getSupportActionBar() != null)
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }
}
