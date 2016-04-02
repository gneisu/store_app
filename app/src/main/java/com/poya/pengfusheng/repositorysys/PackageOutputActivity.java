package com.poya.pengfusheng.repositorysys;

import android.support.v4.app.Fragment;

import com.poya.pengfusheng.repositorysys.fragment.PackageInputFragment;
import com.poya.pengfusheng.repositorysys.fragment.PackageOutputFragment;

/**
 * Created by pengfusheng on 2016/1/27.
 */
public class PackageOutputActivity extends BaseActivity {
    @Override
    protected Fragment createFragment() {
        return new PackageOutputFragment();
    }
}
