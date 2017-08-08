package com.bwie.store1505d.model;

/**
 * Created by liqy on 2017/8/8.
 */

public class Product {


    public int id;
    public int category_id;
    public String image;
    public String featured_image;
    public String image_small;
    public String name;
    public int sort;
    public int created_at;
    public int created_by;
    public int updated_at;
    public int updated_by;
    public String price;
    public String featured_price;
    public String featured_position;
    public int featured_position_sort;
    public String app_featured_home;
    public int app_featured_home_sort;
    public String app_featured_image;
    public String short_description;
    public String meta_keywords;
    public String meta_description;
    public String is_audit;
    public String remarks;
    public String featured;
    public String description;
    public String image_medium;
    public String image_large;
    public String app_featured_topic;
    public int app_featured_topic_sort;
    public String app_long_image1;
    public String app_long_image2;
    public String app_long_image3;
    public int type_id;
    public String app_long_image4;
    public String app_long_image5;
    public int status;
    public String specs_json;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", image='" + image + '\'' +
                ", featured_image='" + featured_image + '\'' +
                ", image_small='" + image_small + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", created_at=" + created_at +
                ", created_by=" + created_by +
                ", updated_at=" + updated_at +
                ", updated_by=" + updated_by +
                ", price='" + price + '\'' +
                ", featured_price='" + featured_price + '\'' +
                ", featured_position='" + featured_position + '\'' +
                ", featured_position_sort=" + featured_position_sort +
                ", app_featured_home='" + app_featured_home + '\'' +
                ", app_featured_home_sort=" + app_featured_home_sort +
                ", app_featured_image='" + app_featured_image + '\'' +
                ", short_description='" + short_description + '\'' +
                ", meta_keywords='" + meta_keywords + '\'' +
                ", meta_description='" + meta_description + '\'' +
                ", is_audit='" + is_audit + '\'' +
                ", remarks='" + remarks + '\'' +
                ", featured='" + featured + '\'' +
                ", description='" + description + '\'' +
                ", image_medium='" + image_medium + '\'' +
                ", image_large='" + image_large + '\'' +
                ", app_featured_topic='" + app_featured_topic + '\'' +
                ", app_featured_topic_sort=" + app_featured_topic_sort +
                ", app_long_image1='" + app_long_image1 + '\'' +
                ", app_long_image2='" + app_long_image2 + '\'' +
                ", app_long_image3='" + app_long_image3 + '\'' +
                ", type_id=" + type_id +
                ", app_long_image4='" + app_long_image4 + '\'' +
                ", app_long_image5='" + app_long_image5 + '\'' +
                ", status=" + status +
                ", specs_json='" + specs_json + '\'' +
                '}';
    }
}
