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

    TextView totalPrice;
    TextView order;

    public CartAdapter(Context context,TextView total_price,TextView order) {
        this.context = context;
        this.items = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.totalPrice=total_price;
        this.order=order;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_cart, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final CartItem item = getItem(i);

        Product product = item.product;

        holder.title.setText(product.name);
        holder.count.setText(item.count + "");
        holder.p_price.setText(product.price);
        holder.p_featured_price.setText(product.featured_price);

        Glide.with(context).load(product.image_small).into(holder.image);

        if(item.is_selected==1){
            holder.selected.setImageResource(R.drawable.operator_selected);

        }else {
            holder.selected.setImageResource(R.drawable.operator_unselected);

        }


        final View finalView = view;

        holder.selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView imageView = (ImageView) finalView.findViewById(R.id.p_selected);
                selectedItem(item, imageView);

            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO  增加
                if (item.count < 5) {
                    item.count++;
                    TextView textView = (TextView) finalView.findViewById(R.id.p_count);
                    textView.setText(item.count + "");
                    totalPrice();
                }
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 减少
                if (item.count > 1) {
                    item.count--;
                    notifyDataSetChanged();
                    TextView textView = (TextView) finalView.findViewById(R.id.p_count);
                    textView.setText(item.count + "");
                    totalPrice();
                }
            }
        });


        return view;
    }

    public void selectedItem(CartItem item, ImageView imageView) {
        if (item.is_selected == 0) {
            imageView.setImageResource(R.drawable.operator_selected);
            item.is_selected = 1;
        } else {
            item.is_selected = 0;
            imageView.setImageResource(R.drawable.operator_unselected);
        }
        totalPrice();
    }

    public void totalPrice() {
        float price = 0;
        int count=0;
        for (CartItem item : items) {
            if (item.is_selected == 1) {
                price += Float.parseFloat(item.product.featured_price)*item.count;
                count+=item.count;
            }
        }

        totalPrice.setText("总价"+price);
        order.setText("去结算("+count+")");

    }

    static class ViewHolder {
        TextView title;
        TextView count;
        ImageView image;
        ImageView selected;
        TextView p_price;
        TextView p_featured_price;
        ImageView remove;

        ImageView minus, plus;


        ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.p_title);
            count = (TextView) view.findViewById(R.id.p_count);
            image = (ImageView) view.findViewById(R.id.p_image);
            selected = (ImageView) view.findViewById(R.id.p_selected);
            p_featured_price = (TextView) view.findViewById(R.id.p_featured_price);
            p_price = (TextView) view.findViewById(R.id.p_price);
            remove = (ImageView) view.findViewById(R.id.remove);
            minus = (ImageView) view.findViewById(R.id.minus);
            plus = (ImageView) view.findViewById(R.id.plus);
        }

    }

}
