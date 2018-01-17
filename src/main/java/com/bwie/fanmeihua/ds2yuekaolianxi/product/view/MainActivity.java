package com.bwie.fanmeihua.ds2yuekaolianxi.product.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.fanmeihua.ds2yuekaolianxi.R;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.view.DetailActivity;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.adapter.RecyclerViewAdapter;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.bean.ProductBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.presenter.ProductPresenter;

public class MainActivity extends AppCompatActivity implements IProductView {

    private RecyclerView mXqRlv;
    private ProductPresenter productPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productPresenter = new ProductPresenter(this);
        productPresenter.getProductUrl();
        initView();
    }
    private void initView() {
        mXqRlv = (RecyclerView) findViewById(R.id.xq_rlv);
    }
    @Override
    public void getProductData(final ProductBean productBean) {
        mXqRlv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,productBean);
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                /*for (int i = 0; i <productBean.getData().size(); i++) {
                    intent.putExtra("pid",productBean.getData().get(i).getPid()+"");
                }*/
                intent.putExtra("pid",productBean.getData().get(position).getPid()+"");
                startActivity(intent);
            }
        });
        mXqRlv.setAdapter(recyclerViewAdapter);
    }


}
