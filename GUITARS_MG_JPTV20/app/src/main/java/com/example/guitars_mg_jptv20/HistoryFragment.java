package com.example.guitars_mg_jptv20;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int imageIDX;
    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        View view =inflater.inflate(R.layout.fragment_history, container, false);
        Button btnLeft = view.findViewById(R.id.imgBtn_left);
        TextView textView = view.findViewById(R.id.textid);
        textView.setBackgroundColor(Color.GRAY);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(16);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setPadding(30, 0, 30, 0);
        textView.setText("Первые упоминания о музыкальном инструменте под названием «гитара» датируются 13 веком. В 15-м веке в Испании изобретают инструмент имеющий пять сдвоенных струн. Такой инструмент был назван испанской гитарой и стал музыкальным символом Испании. От современной гитары ее отличал вытянутый корпус и маленькая мензура.");
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
            case 0: imgID = R.drawable.jan_vermeer_van_delft_013; break;
            case 1: imgID = R.drawable.my_mates_3__2082240480_; break;
            default: imgID = R.drawable.my_mates_3__2082240480_; break;
        }
        return imgID;
    }
}