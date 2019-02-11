package com.upi.rumahcerdas.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.upi.rumahcerdas.R;
import com.upi.rumahcerdas.model.CategoryModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryModel> categoryModels;
    private Context context;

    private RecyclerView subCategoryContainer = null;

    public CategoryAdapter(ArrayList<CategoryModel> categoryModels, Context context) {
        this.categoryModels = categoryModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.container_category, viewGroup, false);

        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setIsRecyclable(false);

        /*
         * Mendapatkan subkategori konten
         */
        subCategoryContainer = view.findViewById(R.id.subcategories_container);
        subCategoryContainer.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.categoryName.setText(categoryModels.get(i).getName());

        subCategoryContainer.setAdapter(new SubCategoryAdapter(categoryModels.get(i).getSubCategories(), context, i));
    }

    @Override
    public int getItemCount() {
        return categoryModels == null ? 0 : categoryModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.category_name);
        }
    }
}
