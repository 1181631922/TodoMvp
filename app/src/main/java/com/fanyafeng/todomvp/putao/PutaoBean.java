package com.fanyafeng.todomvp.putao;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

/**
 * Author： fanyafeng
 * Data： 16/12/6 10:32
 * Email: fanyafeng@live.cn
 */
public class PutaoBean implements Parcelable{
    private String detailUrl;
    private String img;
    private int quantity;
    private int salePrice;
    private String cnName;
    private String enName;
    private int id;

    public PutaoBean(JSONObject jsonObject) {
        setDetailUrl(jsonObject.optString("detail_url"));
        setImg(jsonObject.optString("img"));
        setQuantity(jsonObject.optInt("quantity"));
        setSalePrice(jsonObject.optInt("sale_price"));
        setCnName(jsonObject.optString("cn_name"));
        setEnName(jsonObject.optString("en_name"));
        setId(jsonObject.optInt("id"));
    }


    protected PutaoBean(Parcel in) {
        detailUrl = in.readString();
        img = in.readString();
        quantity = in.readInt();
        salePrice = in.readInt();
        cnName = in.readString();
        enName = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(detailUrl);
        dest.writeString(img);
        dest.writeInt(quantity);
        dest.writeInt(salePrice);
        dest.writeString(cnName);
        dest.writeString(enName);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PutaoBean> CREATOR = new Creator<PutaoBean>() {
        @Override
        public PutaoBean createFromParcel(Parcel in) {
            return new PutaoBean(in);
        }

        @Override
        public PutaoBean[] newArray(int size) {
            return new PutaoBean[size];
        }
    };

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PutaoBean{" +
                "detailUrl='" + detailUrl + '\'' +
                ", img='" + img + '\'' +
                ", quantity=" + quantity +
                ", salePrice=" + salePrice +
                ", cnName='" + cnName + '\'' +
                ", enName='" + enName + '\'' +
                ", id=" + id +
                '}';
    }
}
