package com.example.guitars_mg_jptv20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LinkFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LinkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LinkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinkFragment newInstance(String param1, String param2) {
        LinkFragment fragment = new LinkFragment();
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
        View view = inflater.inflate(R.layout.fragment_link, container, false);
        EditText link = view.findViewById(R.id.editTextText2);
        Button buttonMain = view.findViewById(R.id.button3);
        Button buttonGo = view.findViewById(R.id.button4);
        WebView webView = view.findViewById(R.id.webView1);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        buttonGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = link.getText().toString().trim();
                if(url.isEmpty()) {
                    Toast.makeText(view.getContext(), "Please enter url",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl(url);
            }
        });
        buttonMain.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String staticContent="<h2>Select web page</h2>" +
                        "<ul><li><a href='https://unsplash.com/s/photos/guitar'>GuitarPhotos</a></li>"
                        +"<li><a href='https://guitargirlmag.com/tips/the-basics-parts-of-the-guitar/'>The Basics: Parts of the Guitar</a></li></ul>";
                webView.loadData(staticContent, "text/html", "UTF-8");
            }
        });
        return view;
    }
}