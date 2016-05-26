package project.irfananda.firebasechat.base;

import android.databinding.ViewDataBinding;

import id.gits.mvvmcore.controller.GitsController;
import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by ibun on 20/04/16.
 *
 */
public abstract class BaseController<VM extends GitsVM, B extends ViewDataBinding> extends GitsController<VM, B> {
}
