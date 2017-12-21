package com.bwie.newproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.TuiJianAdapter;
import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.fragment.ifragment.IShouFragment;
import com.bwie.newproject.presenter.ShouPresenter;
import com.bwie.newproject.view.SearActivity;
import com.bwie.newproject.widgth.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/12.
 * 首页
 */

public class ShouFragment extends Fragment implements IShouFragment {
    private Banner banner;
    private ShouPresenter shouPresenter;
    private ViewFlipper vf;
    private ImageView iv;
    private TextView tv;
    private RecyclerView tj_rv;
    private ViewPager vp;
    private List<Fragment> list7 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.shou, null);
        shouPresenter = new ShouPresenter(this);
        shouPresenter.setBanner();
        shouPresenter.setGrid();
        //添加Fragment
        list7.add(new ShouGridFragment1());
        list7.add(new ShouGridFragment2());
        banner = view.findViewById(R.id.shou_banner);
        vp = view.findViewById(R.id.shou_vp);
        vf = view.findViewById(R.id.vf);
        iv = view.findViewById(R.id.tit_sou);
        //跳转到搜索界面
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearActivity.class);
                startActivity(intent);
            }
        });
        tv = view.findViewById(R.id.shou_tj);
        tj_rv = view.findViewById(R.id.shou_rv2);
        initViewFlipper();
        tj_rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        Log.i("VP","VPPPP");
        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list7.get(position);
            }

            @Override
            public int getCount() {
                return list7.size();
            }
        });
        return view;
}

    /*跑马灯*/
    private void initViewFlipper() {
        vf.addView(View.inflate(getActivity(),R.layout.jingdong_text1,null));
        vf.addView(View.inflate(getActivity(),R.layout.jingdong_text2,null));
        vf.addView(View.inflate(getActivity(),R.layout.jingdong_text3,null));
    }

    //轮播+推荐
    @Override
    public void getBanner(ShouBean shouBean) {
        List<ShouBean.DataBean> data = shouBean.getData();
        List<String> img = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            img.add(data.get(i).getIcon());
        }
        banner.setImages(img).setImageLoader(new GlideImageLoader()).isAutoPlay(true).start();
        List<ShouBean.TuijianBean.ListBean> list = shouBean.getTuijian().getList();
        tv.setText("--"+shouBean.getTuijian().getName()+"--");
        tj_rv.setAdapter(new TuiJianAdapter(getContext(),list));
    }

    //九宫格
    @Override
    public void getGrid(GridBean gridBean) {

    }
}
