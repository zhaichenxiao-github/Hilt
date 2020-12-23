package com.example.hilt;

import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;
import com.zhpan.bannerview.utils.BannerUtils;

public class SimAdapter extends BaseBannerAdapter<BannerBean> {
    @Override
    protected void bindData(BaseViewHolder<BannerBean> holder, BannerBean data, int position, int pageSize) {
//        holder.setImageResource(R.id.banner_image,data.getImage());
        int adapterPosition = holder.getAdapterPosition();
        int realPosition = BannerUtils.getRealPosition(isCanLoop(), adapterPosition, pageSize);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_banner;
    }
}
