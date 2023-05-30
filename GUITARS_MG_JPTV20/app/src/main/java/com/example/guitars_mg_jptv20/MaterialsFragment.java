package com.example.guitars_mg_jptv20;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MaterialsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MaterialsFragment extends Fragment {
    int imageIDX = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MaterialsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MaterialsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MaterialsFragment newInstance(String param1, String param2) {
        MaterialsFragment fragment = new MaterialsFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_materials, container, false);
        Button btnLeft = view.findViewById(R.id.imgBtn_left);
        TextView textView = view.findViewById(R.id.textid);
        textView.setBackgroundColor(Color.GRAY);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(16);
        textView.setPadding(30, 0, 30, 0);
        textView.setText("Липа (Basswood) Имеет светлый оттенок, волокна расположены достаточно плотно. ...\n" +
                "Ольха (Alder) ...\n" +
                "Болотный ясень (Swamp Ash) ...\n" +
                "Красное дерево (Mahogany) ...\n" +
                "Орех (Walnut) ...\n" +
                "Клен (Maple) ...\n" +
                "Фигурный клен (Figured Maple) ...\n" +
                "Тополь (Poplar)");
        btnLeft.setText("LEFT");
        btnLeft.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                imageIDX--;
                if (imageIDX < 0)
                    imageIDX = 1;
                ImageView imageView = view.findViewById(R.id.imgViewer);
                imageView.setImageResource(getImageID());
            }
        });
        Button btnRight = view.findViewById(R.id.imgBtn_right);
        btnRight.setText("RIGHT");
        btnRight.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                imageIDX++;
                if (imageIDX > 1)
                    imageIDX = 0;
                ImageView imageView = view.findViewById(R.id.imgViewer);
                imageView.setImageResource(getImageID());
            }
        });
        ImageView imageView = view.findViewById(R.id.imgViewer);
        imageView.setImageResource(getImageID());
        return view;
    }
    public int getImageID()
    {
        int imgID;
        switch (imageIDX) {
            case 0: imgID = R.drawable.hpm_0000_0001_0_img0101; break;
            case 1: imgID = R.drawable.hpm_0000_0007_0_img0036; break;
            default: imgID = R.drawable.hpm_0000_0007_0_img0036; break;
        }
        return imgID;
    }
}