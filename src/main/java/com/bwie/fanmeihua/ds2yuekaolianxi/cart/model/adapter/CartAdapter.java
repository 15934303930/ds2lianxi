package com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.fanmeihua.ds2yuekaolianxi.R;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.GetCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.PriceAndCount;

import java.util.List;

/**
 * 作者：FMH
 * 时间:2018/1/14 20:50
 */

public class CartAdapter extends BaseExpandableListAdapter{
    private Handler handler;
    private Context context;
    private List<GetCarts.DataBean> listGroup;
    private List<List<GetCarts.DataBean.ListBean>> listChilds;
    public CartAdapter(Context context, List<GetCarts.DataBean> listGroup, List<List<GetCarts.DataBean.ListBean>> listChilds, Handler handler) {
        this.context = context;
        this.listGroup = listGroup;
        this.listChilds = listChilds;
        this.handler = handler;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listChilds.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return listGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listChilds.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        GroupHolder holder;
        if (view == null){
            view = View.inflate(context, R.layout.group_item,null);
            holder = new GroupHolder();

            holder.check_group = view.findViewById(R.id.check_group);
            holder.text_group = view.findViewById(R.id.text_group);

            view.setTag(holder);

        }else {
            holder = (GroupHolder) view.getTag();
        }

        final GetCarts.DataBean dataBean = listGroup.get(i);
        //赋值
        holder.check_group.setChecked(dataBean.isGroupChecked());
        holder.text_group.setText(dataBean.getSellerName());

        //设置点击事件
        holder.check_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //2.1改变当前一级选中的状态
                dataBean.setGroupChecked(! dataBean.isGroupChecked());
                //2.2根据当前一级的状态,改变该组里面二级列表的状态
                changeChildState(i,dataBean.isGroupChecked());
                //2.3通过判断所有的一级组是否选中,来决定是否全选选中
                changeAllState(isAllGroupChecked());
                //2.4发送价格个数量:
                sendPriceAndCount();
                //刷新适配器
                notifyDataSetChanged();
            }
        });

        return view;
    }
    private void changeAllState(boolean allGroupChecked) {
        Message msg = Message.obtain();
        msg.what =1;
        msg.obj = allGroupChecked;
        handler.sendMessage(msg);

    }
    private boolean isAllGroupChecked() {
        for (int i=0;i<listGroup.size();i++){

            if (! listGroup.get(i).isGroupChecked()){
                return false;
            }
        }

        return true;
    }

    private void changeChildState(int groupPosition, boolean groupChecked) {
        List<GetCarts.DataBean.ListBean> listBeans = listChilds.get(groupPosition);

        for (int i=0;i<listBeans.size();i++){
            listBeans.get(i).setSelected(groupChecked? 1:0);
        }

    }

    @Override
    public View getChildView(final int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder holder;
        if (view == null){
            view = View.inflate(context, R.layout.child_item,null);
            holder = new ChildHolder();

            holder.text_add = view.findViewById(R.id.text_add);
            holder.text_num = view.findViewById(R.id.text_num);
            holder.text_jian = view.findViewById(R.id.text_jian);
            holder.text_title = view.findViewById(R.id.text_title);
            holder.text_price = view.findViewById(R.id.text_price);
            holder.image_good = view.findViewById(R.id.image_good);
            holder.check_child = view.findViewById(R.id.check_child);

            view.setTag(holder);

        }else {
            holder = (ChildHolder) view.getTag();
        }

        //赋值
        final GetCarts.DataBean.ListBean listBean = listChilds.get(i).get(i1);

        holder.text_num.setText(listBean.getNum()+"");//......注意
        holder.text_price.setText("¥"+listBean.getPrice());
        holder.text_title.setText(listBean.getTitle());
        //listBean.getSelected().....0false,,,1true
        //设置checkBox选中状态
        holder.check_child.setChecked(listBean.getSelected()==0? false:true);

        /*implementation 'com.github.bumptech.glide:glide:4.4.0'
        annotationProcessor 'com.github.bumptech.glide:compiler:4.4.0'*/
        //Glide.with(context).load(listBean.getImages().split("\\|")[0]).into(holder.image_good);
        String s = listBean.getImages().split("\\|")[0];
        Uri parse = Uri.parse(s);
        holder.image_good.setImageURI(parse);
        //设置点击事件
        holder.check_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //3.1点击改变当前子条目状态:....实际是改变当前的数据,,,刷新适配器
                listBean.setSelected(listBean.getSelected() ==0? 1:0);
                //3.2发送价钱和数量给界面显示
                sendPriceAndCount();
                //3.3判断当前子条目是否选中
                if (listBean.getSelected() == 1){
                    //判断一下当前组中所有的子条目是否全部选中
                    if (isAllChildSelected(i)){
                        //如果全部选中改变一下当前组的状态
                        changeGroupState(i,true);
                        //.确定是否改变全选
                        changeAllState(isAllGroupChecked());
                    }

                }else {
                    //如果没有选中改变一下当前组的状态
                    changeGroupState(i,false);
                    //.确定是否改变全选
                    changeAllState(isAllGroupChecked());
                }

                //刷新适配器
                notifyDataSetChanged();
            }
        });

        //加号:
        holder.text_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //改变当前位置 中商品的数量
                listBean.setNum(listBean.getNum()+1);

                //判断一下是否选中...计算价格数量
                if (listBean.getSelected() == 1){
                    sendPriceAndCount();
                }

                //
                notifyDataSetChanged();
            }
        });

        //减号
        holder.text_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = listBean.getNum();

                if (num == 1){
                    return;
                }

                listBean.setNum(num -1);

                //判断是否选中
                if (listBean.getSelected() == 1){
                    sendPriceAndCount();
                }

                notifyDataSetChanged();
            }
        });

        return view;
    }
    private void changeGroupState(int groupPosition, boolean b) {


        listGroup.get(groupPosition).setGroupChecked(b);

    }
    private boolean isAllChildSelected(int groupPosition) {
        List<GetCarts.DataBean.ListBean> listBeans = listChilds.get(groupPosition);

        for (int i=0;i<listBeans.size();i++){
            if (listBeans.get(i).getSelected() == 0){

                return false;
            }
        }

        return true;
    }
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    public void setIfCheckAll(boolean checked) {

        for (int i = 0;i<listGroup.size();i++){
            GetCarts.DataBean dataBean = listGroup.get(i);
            //设置组上面的checkBox是否选中
            dataBean.setGroupChecked(checked);

            List<GetCarts.DataBean.ListBean> listBeans = dataBean.getList();
            for (int j = 0; j< listBeans.size(); j++){
                //改变是否选中的状态...数据应该变的是
                listBeans.get(j).setSelected(checked? 1:0);
            }

        }

        //计算价钱和数量并且发送到mainActivity显示
        sendPriceAndCount();

        //刷新适配器
        notifyDataSetChanged();

    }
    private void sendPriceAndCount() {
        double price = 0;
        int count = 0;

        for (int i=0;i<listGroup.size();i++){
            List<GetCarts.DataBean.ListBean> listBeans = listGroup.get(i).getList();
            for (int j = 0;j<listBeans.size();j++){

                GetCarts.DataBean.ListBean listBean = listBeans.get(j);
                if (listBean.getSelected()==1){

                    price += listBean.getPrice()* listBean.getNum();
                    count += listBean.getNum();

                }
            }
        }

        PriceAndCount countPriceBean = new PriceAndCount(price, count);
        //显示到activity页面
        Message msg = Message.obtain();
        msg.what = 0;
        msg.obj = countPriceBean;
        handler.sendMessage(msg);

    }
    private class GroupHolder{
        CheckBox check_group;
        TextView text_group;
    }

    private class ChildHolder{
        CheckBox check_child;
        ImageView image_good;
        TextView text_title;
        TextView text_price;
        TextView text_jian;
        TextView text_num;
        TextView text_add;
    }
}
