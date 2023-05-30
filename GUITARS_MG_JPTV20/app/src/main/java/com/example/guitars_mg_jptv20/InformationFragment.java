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
 * Use the {@link InformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationFragment extends Fragment {
    int imageIDX = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformationFragment newInstance(String param1, String param2) {
        InformationFragment fragment = new InformationFragment();
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
    //---------------------------------------------------------
//    private void changeImage()
//    {
//        ImageView imageView = view.findViewById(R.id.imgViewer);
//        imageView.setImageResource(getImageID());
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_information, container, false);
        Button btnLeft = view.findViewById(R.id.imgBtn_left);
        TextView textView = view.findViewById(R.id.textid);
        textView.setBackgroundColor(Color.GRAY);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(16);
        textView.setPadding(30, 0, 30, 0);
        textView.setText("Гита́ра[1] — струнный щипковый музыкальный инструмент. Применяется в качестве аккомпанирующего или сольного инструмента во многих стилях и направлениях музыки, среди которых романс, блюз, кантри, фламенко, рок, джаз. Изобретённая в XX веке электрическая гитара произвела значительные изменения в музыке и тем самым оказала сильное влияние на массовую культуру. Также есть классическая гитара, гитара фламенко, испанская гитара и некоторые другие виды.");
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
            case 0: imgID = R.drawable._30px_rickenbacker_330jg; break;
            case 1: imgID = R.drawable.guitars; break;
            default: imgID = R.drawable.guitars; break;
        }
        return imgID;
    }
}
