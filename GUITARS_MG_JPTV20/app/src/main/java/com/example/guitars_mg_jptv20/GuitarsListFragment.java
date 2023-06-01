package com.example.guitars_mg_jptv20;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuitarsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuitarsListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String DATABASE_NAME = "guitarStore.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "guitars"; // название таблицы в бд
    // названия столбцов
    DatabaseHelper databaseHelper;

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        guitarsCursor.close();
    }
    SQLiteDatabase db;
    Cursor guitarsCursor;
    SimpleCursorAdapter guitarAdapter;
    ListView guitarList;
    public GuitarsListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuitarsListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuitarsListFragment newInstance(String param1, String param2) {
        GuitarsListFragment fragment = new GuitarsListFragment();
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
        View view = inflater.inflate(R.layout.fragment_guitars_list, container, false);
        guitarList = (ListView) view.findViewById(R.id.list);
        Button addButton = (Button) view.findViewById(R.id.addButton);
        databaseHelper = new DatabaseHelper(view.getContext());
        db = databaseHelper.getReadableDatabase();
        // определяем, какие столбцы из курсора будут выводиться в ListView
        guitarsCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLE, null);
        String[] headers = new String[] {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_YEAR, DatabaseHelper.COLUMN_DESCRIPTION};
        // создаем адаптер, передаем в него курсор
        guitarAdapter = new SimpleCursorAdapter(view.getContext(), R.layout.list_row, guitarsCursor, headers, new int[]{R.id.name, R.id.year, R.id.description}, 0);
        guitarList.setAdapter(guitarAdapter);
//        view.getContext().deleteDatabase(DATABASE_NAME);
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddElementActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }
}