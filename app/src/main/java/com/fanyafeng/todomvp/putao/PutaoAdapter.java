package com.fanyafeng.todomvp.putao;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.todomvp.R;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/12/6 10:31
 * Email: fanyafeng@live.cn
 */
public class PutaoAdapter extends BaseRecyclerAdapter<PutaoAdapter.ShowWineViewHolder> {
    private Context context;
    private List<PutaoBean> productWineBeanList;

    public PutaoAdapter(Context context, List<PutaoBean> productWineBeanList) {
        this.context = context;
        this.productWineBeanList = productWineBeanList;
    }


    @Override
    public ShowWineViewHolder getViewHolder(View view) {
        return new ShowWineViewHolder(view);
    }

    @Override
    public ShowWineViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_show_wine, parent, false);
        return (new ShowWineViewHolder(view));
    }

    @Override
    public void onBindViewHolder(ShowWineViewHolder holder, int position, boolean isItem) {
        final PutaoBean productWineBean = productWineBeanList.get(position);
        holder.sdv_show_wine_view.setImageURI(Uri.parse(productWineBean.getImg()));
        holder.sdv_show_wine_view.setAdjustViewBounds(true);
        holder.sdv_show_wine_view.setAspectRatio(1.0f);
        holder.tv_show_wine_cnname.setText(productWineBean.getCnName());
        holder.tv_show_wine_enname.setText(productWineBean.getEnName());
        holder.tv_show_wine_price.setText("人民币" + productWineBean.getSalePrice());
    }


    @Override
    public int getAdapterItemCount() {
        return productWineBeanList.size();
    }

    class ShowWineViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layoutShowWine;
        SimpleDraweeView sdv_show_wine_view;
        ImageView wineState;
        ImageView wineCollect;
        TextView tv_show_wine_cnname;
        TextView tv_show_wine_enname;
        TextView tv_show_wine_price;
        TextView tv_show_wine_realprice;
        TextView tv_show_number_state;

        public ShowWineViewHolder(View itemView) {
            super(itemView);
            layoutShowWine = (RelativeLayout) itemView.findViewById(R.id.layoutShowWine);
            sdv_show_wine_view = (SimpleDraweeView) itemView.findViewById(R.id.sdv_show_wine_view);
            tv_show_wine_cnname = (TextView) itemView.findViewById(R.id.tv_show_wine_cnname);
            tv_show_wine_enname = (TextView) itemView.findViewById(R.id.tv_show_wine_enname);
            tv_show_wine_price = (TextView) itemView.findViewById(R.id.tv_show_wine_price);
            tv_show_wine_realprice = (TextView) itemView.findViewById(R.id.tv_show_wine_realprice);
            tv_show_number_state = (TextView) itemView.findViewById(R.id.tv_show_number_state);
            wineState = (ImageView) itemView.findViewById(R.id.wineState);
            wineCollect = (ImageView) itemView.findViewById(R.id.wineCollect);
        }
    }
}
