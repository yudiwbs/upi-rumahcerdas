package com.upi.rumahcerdas.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.upi.rumahcerdas.R;
import com.upi.rumahcerdas.model.SubCategoryModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {

    private ArrayList<SubCategoryModel> subCategoryModels;
    private Context context;
    private int categoryIndex;

    SubCategoryAdapter(ArrayList<SubCategoryModel> subCategoryModels, Context context, int categoryIndex) {
        this.subCategoryModels = subCategoryModels;
        this.context = context;
        this.categoryIndex = categoryIndex;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.container_subcategory, viewGroup, false);

        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setIsRecyclable(false);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.subCategoryName.setText(subCategoryModels.get(i).getName());

        /*
         * Mewarnai konten
         */
        int[] drawable = {R.drawable.layout_container, R.drawable.layout_container_2, R.drawable.layout_container_3, R.drawable.layout_container_4, R.drawable.layout_container_5, R.drawable.layout_container_6};
        int selectedDrawable = drawable[categoryIndex % drawable.length];
        viewHolder.subCategoryContainer.setBackgroundResource(selectedDrawable);
        Bitmap selectedBitmap = getBitmap(selectedDrawable);
        int selectedColor = getDominantColor(selectedBitmap);
        viewHolder.subCategoryImage.setColorFilter(selectedColor);
        viewHolder.subCategoryName.setTextColor(selectedColor);
    }

    @Override
    public int getItemCount() {
        return subCategoryModels == null ? 0 : subCategoryModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout subCategoryContainer;
        ImageView subCategoryImage;
        TextView subCategoryName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            subCategoryContainer = itemView.findViewById(R.id.subcategory_container);
            subCategoryImage = itemView.findViewById(R.id.subcategory_image);
            subCategoryName = itemView.findViewById(R.id.subcategory_name);
        }
    }

    /*
     * Copied from https://gist.github.com/KKorvin/219555d4d3ee1828d7b0e808aad82930
     */
    private static int getDominantColor(Bitmap bitmap) {
        List<Palette.Swatch> swatchesTemp = Palette.from(bitmap).generate().getSwatches();
        List<Palette.Swatch> swatches = new ArrayList<>(swatchesTemp);
        Collections.sort(swatches, new Comparator<Palette.Swatch>() {
            @Override
            public int compare(Palette.Swatch swatch1, Palette.Swatch swatch2) {
                return swatch2.getPopulation() - swatch1.getPopulation();
            }
        });
        return swatches.get(1).getRgb();
    }

    /*
     * Copied from https://stackoverflow.com/a/35574775/8791891
     */
    private Bitmap getBitmap(int drawableRes) {
        Drawable drawable = context.getResources().getDrawable(drawableRes);
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
