package com.rocedar.lib.sdk.rcgallery.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rocedar.lib.sdk.rcgallery.R;
import com.rocedar.lib.sdk.rcgallery.dto.FolderInfo;
import com.rocedar.lib.sdk.rcgallery.config.GalleryConfig;
import com.rocedar.lib.sdk.rcgallery.config.GalleryPick;

import java.util.List;


/**
 * 文件夹列表适配器
 * Created by Yancy on 2016/11/1.
 */
public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {

    private Context mContext;
    private Activity mActivity;
    private LayoutInflater mLayoutInflater;
    private List<FolderInfo> result;
    private final static String TAG = "FolderAdapter";

    private GalleryConfig galleryConfig = GalleryPick.getInstance().getGalleryConfig();
    private int mSelector = 0;
    private OnClickListener onClickListener;

    public FolderAdapter(Activity mActivity, Context mContext, List<FolderInfo> result) {
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.result = result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.gallery_item_folder, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (position == 0) {
            holder.tvGalleryFolderName.setText(mContext.getString(R.string.gallery_all_folder));
            holder.tvGalleryPhotoNum.setText(mContext.getString(R.string.gallery_photo_num, getTotalImageSize()));
            if (result.size() > 0) {
                galleryConfig.getImageLoader().showLocationImage(result.get(0).photoInfo.path, holder.ivGalleryFolderImage, true);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelector = 0;
                    onClickListener.onClick(null);
                }
            });

            if (mSelector == 0) {
                holder.ivGalleryIndicator.setVisibility(View.VISIBLE);
            } else {
                holder.ivGalleryIndicator.setVisibility(View.GONE);
            }
            return;
        }
        final FolderInfo folderInfo = result.get(position - 1);
        holder.tvGalleryFolderName.setText(folderInfo.name);
        holder.tvGalleryPhotoNum.setText(mContext.getString(R.string.gallery_photo_num, folderInfo.photoInfoList.size()));
        galleryConfig.getImageLoader().showLocationImage(folderInfo.photoInfo.path, holder.ivGalleryFolderImage, true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelector = holder.getAdapterPosition() + 1;
                onClickListener.onClick(folderInfo);
            }
        });

        if (mSelector == holder.getAdapterPosition() + 1) {
            holder.ivGalleryIndicator.setVisibility(View.VISIBLE);
        } else {
            holder.ivGalleryIndicator.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return result.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivGalleryFolderImage;
        private TextView tvGalleryFolderName;
        private TextView tvGalleryPhotoNum;
        private ImageView ivGalleryIndicator;

        public ViewHolder(View itemView) {
            super(itemView);
            ivGalleryFolderImage = (ImageView) itemView.findViewById(R.id.ivGalleryFolderImage);
            tvGalleryFolderName = (TextView) itemView.findViewById(R.id.tvGalleryFolderName);
            tvGalleryPhotoNum = (TextView) itemView.findViewById(R.id.tvGalleryPhotoNum);
            ivGalleryIndicator = (ImageView) itemView.findViewById(R.id.ivGalleryIndicator);
        }

    }


    public interface OnClickListener {
        void onClick(FolderInfo folderInfo);
    }

    /**
     * @return 所有图片数量
     */
    private int getTotalImageSize() {
        int result = 0;
        if (this.result != null && this.result.size() > 0) {
            for (FolderInfo folderInfo : this.result) {
                result += folderInfo.photoInfoList.size();
            }
        }
        return result;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
/*
 *   ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 *     ┃　　　┃
 *     ┃　　　┃
 *     ┃　　　┗━━━┓
 *     ┃　　　　　　　┣┓
 *     ┃　　　　　　　┏┛
 *     ┗┓┓┏━┳┓┏┛
 *       ┃┫┫　┃┫┫
 *       ┗┻┛　┗┻┛
 *        神兽保佑
 *        代码无BUG!
 */