package com.bwie.newproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.MyAdapter;
import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.fragment.ifragment.IShouFragment;
import com.bwie.newproject.presenter.ShouPresenter;
import com.stone.card.library.CardSlidePanel;

/**
 * Created by 乔晓慧 on 2017/12/12.
 * 发现
 */

public class FaFragment extends Fragment implements IShouFragment {
    private View view;
    private ImageView notifyChange;
    private CardSlidePanel imageSlidePanel;
    private ShouPresenter shouPresenter;
    CardSlidePanel.CardSwitchListener cardSwitchListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fa, null);
        initView(view);
        shouPresenter = new ShouPresenter(this);
        shouPresenter.setBanner();
        return view;
    }

    private void initView(View view) {
        notifyChange = (ImageView) view.findViewById(R.id.notify_change);
        notifyChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSlidePanel.getAdapter().notifyDataSetChanged();
            }
        });
        imageSlidePanel = (CardSlidePanel) view.findViewById(R.id.image_slide_panel);
        // 1. 左右滑动监听
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
                //Toast.makeText(MainActivity.this, "正在显示"+list.get(index).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCardVanish(int index, int type) {
                //Toast.makeText(MainActivity.this, "正在消失"+list.get(index).getTitle(), Toast.LENGTH_SHORT).show();
            }
        };
        imageSlidePanel.setCardSwitchListener(cardSwitchListener);
    }

    @Override
    public void getBanner(ShouBean shouBean) {
        MyAdapter adapter = new MyAdapter(getContext(), shouBean.getTuijian().getList());
        imageSlidePanel.setAdapter(adapter);
    }

    @Override
    public void getGrid(GridBean gridBean) {

    }
}
