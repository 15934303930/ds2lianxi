package com.bwie.fanmeihua.ds2yuekaolianxi.cart.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.fanmeihua.ds2yuekaolianxi.R;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.adapter.CartAdapter;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.GetCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.PriceAndCount;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.presenter.CartPresenter;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements ICartView, View.OnClickListener {
    private CartPresenter cartPresenter;
    private CartAdapter cartAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                PriceAndCount countPriceBean = (PriceAndCount) msg.obj;

                //设置
                text_total.setText("合计:¥" + countPriceBean.getPrice());
                text_buy.setText("去结算(" + countPriceBean.getCount() + ")");
            } else if (msg.what == 1) {//改变全选
                boolean flag = (boolean) msg.obj;

                check_all.setChecked(flag);
            }
        }
    };
    /**
     * 编辑
     */
    private TextView tvBj;
    private RelativeLayout rlTitle;
    private ExpandableListView expanableListview;
    private CheckBox check_all;
    /**
     * 合计:¥0.00
     */
    private TextView text_total;
    /**
     * 去结算(0)
     */
    private TextView text_buy;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();
        cartPresenter = new CartPresenter(this);
        cartPresenter.getCartUrl();
        //去掉默认的指示器
        expanableListview.setGroupIndicator(null);
        //全选:...点击事件
        check_all.setOnClickListener(this);
    }

    @Override
    public void CartSuccess(GetCarts carBean) {
        //一个是一级标题的数据
        List<GetCarts.DataBean> listGroup = carBean.getData();

        //所有子条目的数据
        List<List<GetCarts.DataBean.ListBean>> listChilds = new ArrayList<>();
        for (int i = 0; i < listGroup.size(); i++) {
            listChilds.add(listGroup.get(i).getList());
        }

        //设置适配器
        cartAdapter = new CartAdapter(CartActivity.this, listGroup, listChilds, handler);
        expanableListview.setAdapter(cartAdapter);

        //展开所有
        for (int i = 0; i < listGroup.size(); i++) {
            expanableListview.expandGroup(i);
        }
    }

    private void initView() {
        tvBj = (TextView) findViewById(R.id.tv_bj);
        tvBj.setOnClickListener(this);
        rlTitle = (RelativeLayout) findViewById(R.id.rl_title);
        expanableListview = (ExpandableListView) findViewById(R.id.expanable_listview);
        check_all = (CheckBox) findViewById(R.id.check_all);
        check_all.setOnClickListener(this);
        text_total = (TextView) findViewById(R.id.text_total);
        text_buy = (TextView) findViewById(R.id.text_buy);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_bj:
                break;
            case R.id.check_all:
                cartAdapter.setIfCheckAll(check_all.isChecked());
                break;
        }
    }
}
