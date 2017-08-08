package com.bwie.store1505d.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.store1505d.R;
import com.bwie.store1505d.model.CartItem;
import com.bwie.store1505d.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqy on 2017/8/8.
 */

public class CartAdapter extends BaseAdapter {


    List<CartItem> items;
    Context context;
    LayoutInflater inflater;

    public CartAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    public void addData(List<CartItem> list) {
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public CartItem getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_cart, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        CartItem item = getItem(i);

        Product product = item.product;

        holder.title.setText(product.name);
        holder.count.setText(item.count + "");

        Glide.with(context).load(product.image_small).into(holder.image);

        if (item.is_selected == 1) {
            holder.selected.setImageResource(R.drawable.operator_selected);
        } else {
            holder.selected.setImageResource(R.drawable.operator_unselected);
        }

        return view;
    }

    static class ViewHolder {
        TextView title;
        TextView count;
        ImageView image;
        ImageView selected;

        ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.p_title);
            count = (TextView) view.findViewById(R.id.p_count);
            image = (ImageView) view.findViewById(R.id.p_image);
            selected = (ImageView) view.findViewById(R.id.p_selected);
        }
    }

}
