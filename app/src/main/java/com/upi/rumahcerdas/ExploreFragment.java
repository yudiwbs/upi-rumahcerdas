package com.upi.rumahcerdas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.upi.rumahcerdas.adapter.CategoryAdapter;
import com.upi.rumahcerdas.model.CategoryModel;
import com.upi.rumahcerdas.model.SubCategoryModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ExploreFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        /*
         * Mendapatkan konten highlight
         */
        int NUMBER_OF_HIGHLIGHTS = 6;

        CarouselView highlightsContainer = view.findViewById(R.id.highlights_container);
        highlightsContainer.setPageCount(NUMBER_OF_HIGHLIGHTS);
        highlightsContainer.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(final int position) {
                @SuppressLint("InflateParams") View content_highlight = getLayoutInflater().inflate(R.layout.container_highlight, null);

                /*
                 * Mengeset isi konten
                 */
                ImageView contentImageBackground = content_highlight.findViewById(R.id.image_background);
                contentImageBackground.setImageResource(R.drawable.sample_image);

                // Mengeset color filter gambar latar
                // untuk memudahkan pengguna membaca teks abstrak
                contentImageBackground.setColorFilter(adjustAlpha(
                        getDominantColor(
                                BitmapFactory.decodeResource(
                                        Objects.requireNonNull(getContext()).getResources(),
                                        R.drawable.sample_image)),
                        0.5f
                ));
//                contentImageBackground.setColorFilter(
//                        adjustAlpha(
//                                ContextCompat.getColor(
//                                        Objects.requireNonNull(getContext()),
//                                        R.color.colorPrimary
//                                ),
//                                0.6f
//                        )
//                );

                TextView contentAbstract = content_highlight.findViewById(R.id.text_description);
                contentAbstract.setText("Lorem ipsum dolor sit amet, ullum populo...");

                /*
                 * Mengeset onClickListener konten
                 */
                content_highlight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Clicked item: " + position, Toast.LENGTH_SHORT).show();
                    }
                });

                return content_highlight;
            }
        });

        /*
         * Mendapatkan kategori konten
         */
        RecyclerView categoriesContainer = view.findViewById(R.id.categories_container);
        categoriesContainer.setLayoutManager(new LinearLayoutManager(getActivity()));
        categoriesContainer.setAdapter(new CategoryAdapter(
                new ArrayList<CategoryModel>() {{
                    add(new CategoryModel(
                            "Category 1",
                            new ArrayList<SubCategoryModel>() {{
                                add(new SubCategoryModel("Subcategory 1"));
                                add(new SubCategoryModel("Subcategory 2"));
                                add(new SubCategoryModel("Subcategory 3"));
                                add(new SubCategoryModel("Subcategory 4"));
                                add(new SubCategoryModel("Subcategory 5"));
                            }}
                    ));
                    add(new CategoryModel(
                            "Category 2",
                            new ArrayList<SubCategoryModel>() {{
                                add(new SubCategoryModel("Subcategory 6"));
                                add(new SubCategoryModel("Subcategory 7"));
                                add(new SubCategoryModel("Subcategory 8"));
                                add(new SubCategoryModel("Subcategory 9"));
                                add(new SubCategoryModel("Subcategory 10"));
                            }}
                    ));
                    add(new CategoryModel(
                            "Category 3",
                            new ArrayList<SubCategoryModel>() {{
                                add(new SubCategoryModel("Subcategory 11"));
                                add(new SubCategoryModel("Subcategory 12"));
                                add(new SubCategoryModel("Subcategory 13"));
                                add(new SubCategoryModel("Subcategory 14"));
                                add(new SubCategoryModel("Subcategory 15"));
                            }}
                    ));
                    add(new CategoryModel(
                            "Category 4",
                            new ArrayList<SubCategoryModel>() {{
                                add(new SubCategoryModel("Subcategory 1"));
                                add(new SubCategoryModel("Subcategory 2"));
                                add(new SubCategoryModel("Subcategory 3"));
                                add(new SubCategoryModel("Subcategory 4"));
                                add(new SubCategoryModel("Subcategory 5"));
                            }}
                    ));
                    add(new CategoryModel(
                            "Category 5",
                            new ArrayList<SubCategoryModel>() {{
                                add(new SubCategoryModel("Subcategory 6"));
                                add(new SubCategoryModel("Subcategory 7"));
                                add(new SubCategoryModel("Subcategory 8"));
                                add(new SubCategoryModel("Subcategory 9"));
                                add(new SubCategoryModel("Subcategory 10"));
                            }}
                    ));
                    add(new CategoryModel(
                            "Category 6",
                            new ArrayList<SubCategoryModel>() {{
                                add(new SubCategoryModel("Subcategory 11"));
                                add(new SubCategoryModel("Subcategory 12"));
                                add(new SubCategoryModel("Subcategory 13"));
                                add(new SubCategoryModel("Subcategory 14"));
                                add(new SubCategoryModel("Subcategory 15"));
                            }}
                    ));
                }},
                getActivity()
        ));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /*
     * Copied from https://gist.github.com/KKorvin/219555d4d3ee1828d7b0e808aad82930
     */
    public static int getDominantColor(Bitmap bitmap) {
        List<Palette.Swatch> swatchesTemp = Palette.from(bitmap).generate().getSwatches();
        List<Palette.Swatch> swatches = new ArrayList<>(swatchesTemp);
        Collections.sort(swatches, new Comparator<Palette.Swatch>() {
            @Override
            public int compare(Palette.Swatch swatch1, Palette.Swatch swatch2) {
                return swatch2.getPopulation() - swatch1.getPopulation();
            }
        });
        return swatches.size() > 2 ? swatches.get(2).getRgb() : swatches.get(0).getRgb();
    }

    /*
     * Copied from https://stackoverflow.com/a/15319676/8791891
     */
    @ColorInt
    public static int adjustAlpha(@ColorInt int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
}
