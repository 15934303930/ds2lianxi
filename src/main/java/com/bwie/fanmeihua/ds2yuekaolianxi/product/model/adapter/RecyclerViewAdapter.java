package com.bwie.fanmeihua.ds2yuekaolianxi.product.model.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.fanmeihua.ds2yuekaolianxi.R;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.bean.ProductBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 作者：FMH
 * 时间:2018/1/13 16:32
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ProductBean productBean;
    private ViewHolder viewHolder;
    private OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(Context context, ProductBean productBean) {
        this.context = context;
        this.productBean = productBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xq_rlv_item, null, false);
        viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String s = productBean.getData().get(position).getImages().split("\\|")[0];
        Uri parse = Uri.parse(s);
        holder.rlv_sdv.setImageURI(parse);
        holder.rlv_price.setText("¥:"+productBean.getData().get(position).getBargainPrice()+"");
        holder.rlv_title.setText(productBean.getData().get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickListener(position);
            }
        });
    }
    public interface OnItemClickListener{
        void onItemClickListener(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public int getItemCount() {
        return productBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView rlv_sdv;
        private final TextView rlv_price;
        private final TextView rlv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            rlv_sdv = (SimpleDraweeView)itemView.findViewById(R.id.rlv_sdv);
            rlv_price = (TextView)itemView.findViewById(R.id.rlv_price);
            rlv_title = (TextView)itemView.findViewById(R.id.rlv_title);
        }
    }
}
