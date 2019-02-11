package com.upi.rumahcerdas.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryModel implements Serializable {

    private String name;
    private ArrayList<SubCategoryModel> subCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SubCategoryModel> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<SubCategoryModel> subCategories) {
        this.subCategories = subCategories;
    }

    public CategoryModel(String name, ArrayList<SubCategoryModel> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }

}
