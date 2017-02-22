package com.example.arialena.radiogroup_fragment;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.arialena.radiogroup_fragment.Fragment.BaseFragment;
import com.example.arialena.radiogroup_fragment.Fragment.CareAboutFragment;
import com.example.arialena.radiogroup_fragment.Fragment.MainFragment;
import com.example.arialena.radiogroup_fragment.Fragment.PersonFragment;
import com.example.arialena.radiogroup_fragment.Fragment.VidoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup mRadioGroup;
    private List<BaseFragment> mBaseFragments;
    private int position;//当前选中的位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化布局
        initView();
        //初始化数据
        initData();

        //设置监听
        setLIstener();

    }

    private void setLIstener() {

        mRadioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //默认选中第一个
        mRadioGroup.check(R.id.rb_main);
    }

    private void initData() {
        mBaseFragments = new ArrayList<>();
        mBaseFragments.add(new MainFragment());
        mBaseFragments.add(new VidoFragment());
        mBaseFragments.add(new CareAboutFragment());
        mBaseFragments.add(new PersonFragment());
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_main);
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {

            switch (i){
                case R.id.rb_main:
                    position = 0;
                    break;
                case R.id.rb_video:
                    position = 1;
                    break;
                case R.id.rb_care_about:
                    position = 2;
                    break;
                case R.id.rb_person:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }

            BaseFragment currentFragment = getFragment();
            replaceFragment(currentFragment);

        }
    }

    private void replaceFragment(BaseFragment fragment){
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction .replace(R.id.fl_main, fragment);
        transaction.commit();
    }

    private BaseFragment getFragment(){
        return mBaseFragments.get(position);
    }
}


