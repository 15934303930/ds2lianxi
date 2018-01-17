package com.bwie.fanmeihua.ds2yuekaolianxi.detail.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.fanmeihua.ds2yuekaolianxi.R;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.view.CartActivity;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.AddCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.DetailBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.presenter.DetailPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener, IDetailView {

    private SimpleDraweeView mXqSdv;
    /**
     * TextView
     */
    private TextView mXqTitle;
    /**
     * 购物车
     */
    private TextView mXqCart;
    /**
     * 加入购物车
     */
    private Button mXqAdd;
    /**
     * 立即购买
     */
    private Button mXqBuy;
    private DetailPresenter detailPresenter;
    private int i;
    private TextView mXqprice;
    private TextView mXqstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        i = Integer.parseInt(pid);
        initView();
        detailPresenter = new DetailPresenter(this);
        detailPresenter.getDetailUrl(i);
    }

    private void initView() {
        mXqSdv = (SimpleDraweeView) findViewById(R.id.xq_sdv);
        mXqTitle = (TextView) findViewById(R.id.xq_title);
        mXqprice = (TextView) findViewById(R.id.xq_price);
        mXqstore = (TextView) findViewById(R.id.xq_store);
        mXqCart = (TextView) findViewById(R.id.xq_cart);
        mXqCart.setOnClickListener(this);
        mXqAdd = (Button) findViewById(R.id.xq_add);
        mXqAdd.setOnClickListener(this);
        mXqBuy = (Button) findViewById(R.id.xq_buy);
        mXqBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.xq_add:
                detailPresenter.getAddCartslUrl(i);
                break;
            case R.id.xq_buy:
                break;
            case R.id.xq_cart:
                Intent intent = new Intent(DetailActivity.this, CartActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void getDetailData(DetailBean detailBean) {
        String s = detailBean.getData().getImages().split("\\|")[0];
        Uri parse = Uri.parse(s);
        mXqSdv.setImageURI(parse);
        mXqTitle.setText(detailBean.getData().getTitle());
        mXqprice.setText("¥:"+detailBean.getData().getBargainPrice()+"");
        mXqstore.setText(detailBean.getSeller().getName());
    }

    @Override
    public void getAddCartsData(AddCarts addCarts) {
        Toast.makeText(DetailActivity.this,addCarts.getMsg(),Toast.LENGTH_SHORT).show();
    }
}
