package com.sandhosh.estrradodemo.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeResponseModel {

@SerializedName("httpcode")
@Expose
private Integer httpcode;
@SerializedName("status")
@Expose
private String status;
@SerializedName("message")
@Expose
private String message;
@SerializedName("data")
@Expose
private Data data;

public Integer getHttpcode() {
return httpcode;
}

public void setHttpcode(Integer httpcode) {
this.httpcode = httpcode;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

    public class Profiledata {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("image")
        @Expose
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }
    public class Region {

        @SerializedName("country_id")
        @Expose
        private String countryId;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("country_name")
        @Expose
        private String countryName;

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

    }
    public class Featured {

        @SerializedName("prd_id")
        @Expose
        private String prdId;
        @SerializedName("prd_name")
        @Expose
        private String prdName;
        @SerializedName("prd_image")
        @Expose
        private String prdImage;
        @SerializedName("qty")
        @Expose
        private String qty;
        @SerializedName("unit")
        @Expose
        private String unit;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("rating")
        @Expose
        private String rating;

        public String getPrdId() {
            return prdId;
        }

        public void setPrdId(String prdId) {
            this.prdId = prdId;
        }

        public String getPrdName() {
            return prdName;
        }

        public void setPrdName(String prdName) {
            this.prdName = prdName;
        }

        public String getPrdImage() {
            return prdImage;
        }

        public void setPrdImage(String prdImage) {
            this.prdImage = prdImage;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

    }
    public class Data {

        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("banner_slider")
        @Expose
        private List<BannerSlider> bannerSlider = null;
        @SerializedName("featured")
        @Expose
        private List<Featured> featured = null;
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;
        @SerializedName("profiledata")
        @Expose
        private Profiledata profiledata;
        @SerializedName("regions")
        @Expose
        private List<Region> regions = null;
        @SerializedName("cartcount")
        @Expose
        private Integer cartcount;

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public List<BannerSlider> getBannerSlider() {
            return bannerSlider;
        }

        public void setBannerSlider(List<BannerSlider> bannerSlider) {
            this.bannerSlider = bannerSlider;
        }

        public List<Featured> getFeatured() {
            return featured;
        }

        public void setFeatured(List<Featured> featured) {
            this.featured = featured;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public Profiledata getProfiledata() {
            return profiledata;
        }

        public void setProfiledata(Profiledata profiledata) {
            this.profiledata = profiledata;
        }

        public List<Region> getRegions() {
            return regions;
        }

        public void setRegions(List<Region> regions) {
            this.regions = regions;
        }

        public Integer getCartcount() {
            return cartcount;
        }

        public void setCartcount(Integer cartcount) {
            this.cartcount = cartcount;
        }

    }

    public class Category {

        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_image")
        @Expose
        private String categoryImage;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryImage() {
            return categoryImage;
        }

        public void setCategoryImage(String categoryImage) {
            this.categoryImage = categoryImage;
        }

    }
    public class BannerSlider {

        @SerializedName("slider_id")
        @Expose
        private String sliderId;
        @SerializedName("slider_name")
        @Expose
        private String sliderName;
        @SerializedName("slider_image")
        @Expose
        private String sliderImage;

        public String getSliderId() {
            return sliderId;
        }

        public void setSliderId(String sliderId) {
            this.sliderId = sliderId;
        }

        public String getSliderName() {
            return sliderName;
        }

        public void setSliderName(String sliderName) {
            this.sliderName = sliderName;
        }

        public String getSliderImage() {
            return sliderImage;
        }

        public void setSliderImage(String sliderImage) {
            this.sliderImage = sliderImage;
        }

    }
}