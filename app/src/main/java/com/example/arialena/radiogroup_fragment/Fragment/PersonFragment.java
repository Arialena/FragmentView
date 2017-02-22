package com.example.arialena.radiogroup_fragment.Fragment;

import android.util.Log;
import android.view.View;

import com.example.arialena.radiogroup_fragment.R;

/**
 * Created by arialena on 17-2-21.
 */

public class PersonFragment extends BaseFragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private View mainFragmentVIew;

    @Override
    protected View initView() {
        Log.e(TAG, "首页页面Fragment页面被初始化了。。。");
        mainFragmentVIew = View.inflate(mContext, R.layout.fragment_person, null);
        return mainFragmentVIew;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "首页页面Fragment页面被初始化了。。。");
    }
}

