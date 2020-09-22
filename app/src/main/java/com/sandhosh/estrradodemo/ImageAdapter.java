package com.sandhosh.estrradodemo;

import android.content.Context;
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ImageView;

import com.sandhosh.estrradodemo.model.HomeResponseModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageAdapter extends PagerAdapter {
    Context mContext;
   List<HomeResponseModel.BannerSlider> bannerSlider;
  
    ImageAdapter(Context context, List<HomeResponseModel.BannerSlider> bannerSliders) {
        this.mContext = context;
        this.bannerSlider=bannerSliders;
    }  

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override  
    public Object instantiateItem(ViewGroup container, int position) {  
        ImageView imageView = new ImageView(mContext);  
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(mContext).load(String.valueOf(bannerSlider.get(position).getSliderImage())).into(imageView);
        container.addView(imageView, 0);
        return imageView;  
    }  
  
    @Override  
    public void destroyItem(ViewGroup container, int position, Object object) {  
        ((ViewPager) container).removeView((ImageView) object);  
    }  
  
    @Override  
    public int getCount() {  
        return bannerSlider.size();
    }  
}  