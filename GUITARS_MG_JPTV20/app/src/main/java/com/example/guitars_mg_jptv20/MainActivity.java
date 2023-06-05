package com.example.guitars_mg_jptv20;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Initialize variables
    TabLayout tabLayout;
    ViewPager viewPager;
    CheckBox chb;

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor guitarsCursor;
    SimpleCursorAdapter guitarAdapter;
    ListView guitarList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assign variable
        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        chb = findViewById(R.id.checkBox6);
        // Initialize array list
        ArrayList<String> arrayList=new ArrayList<>(0);

        // Add title in array list
        arrayList.add("Information");
        arrayList.add("Materials");
        arrayList.add("History");
        arrayList.add("Link");
        arrayList.add("GuitarsList");
        // Setup tab layout
        tabLayout.setupWithViewPager(viewPager);
        // Prepare view pager
        prepareViewPager(viewPager,arrayList);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // добавляем пункты меню
        menu.add(0, 0, 0, "Information");
        menu.add(0, 1, 0, "Materials");
        menu.add(0, 2, 0, "History");
        menu.add(0, 3, 0, "Link");
        menu.add(0, 4, 0, "GuitarsList");
        menu.add(1, 5, 0, "First");
        menu.add(1, 6, 0, "Latest");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 0:
                tabLayout.getTabAt(0).select();
                break;
            case 1:
                tabLayout.getTabAt(1).select();
                break;
            case 2:
                tabLayout.getTabAt(2).select();
                break;
            case 3:
                tabLayout.getTabAt(3).select();
                break;
            case 4:
                tabLayout.getTabAt(4).select();
                break;
            case 5:
                tabLayout.getTabAt(0).select();
                break;
            case 6:
                tabLayout.getTabAt(4).select();
                break;
            default:
                tabLayout.getTabAt(0).select();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        // Initialize main adapter
        MainAdapter adapter=new MainAdapter(getSupportFragmentManager());

        // Initialize main fragment
        InformationFragment informationFragment=new InformationFragment();
        MaterialsFragment materialsFragment=new MaterialsFragment();
        HistoryFragment historyFragment=new HistoryFragment();
        LinkFragment linkFragment=new LinkFragment();
        GuitarsListFragment guitarsListFragment=new GuitarsListFragment();
        // Use for loop
//        for(int i=0;i<arrayList.size();i++)
//        {
//            // Initialize bundle
////            Bundle bundle=new Bundle();
//
//            // Put title
////            bundle.putString("title",arrayList.get(i));
//
//            // set argument
////            mainFragment.setArguments(bundle);
//
//            // Add fragment
//                adapter.addFragment(mainFragment,arrayList.get(i));
//                mainFragment=new MainFragment();
//        }

        adapter.addFragment(informationFragment,arrayList.get(0));
//        informationFragment=new informationFragment();

        adapter.addFragment(materialsFragment,arrayList.get(1));
        materialsFragment=new MaterialsFragment();

        adapter.addFragment(historyFragment,arrayList.get(2));
        historyFragment=new HistoryFragment();
        adapter.addFragment(linkFragment,arrayList.get(3));
        linkFragment=new LinkFragment();
        adapter.addFragment(guitarsListFragment,arrayList.get(4));
        guitarsListFragment= new GuitarsListFragment();
        // set adapter
        viewPager.setAdapter(adapter);
    }

    private class MainAdapter extends FragmentPagerAdapter {
        // Initialize arrayList
        ArrayList<Fragment> fragmentArrayList= new ArrayList<>();
        ArrayList<String> stringArrayList=new ArrayList<>();

//        int[] imageList={R.drawable.information,R.drawable.materials,R.drawable.history};

        // Create constructor
        public void addFragment(Fragment fragment,String s)
        {
            // Add fragment
            fragmentArrayList.add(fragment);
            // Add title
            stringArrayList.add(s);
        }

        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            // return fragment position
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            // Return fragment array list size
            return fragmentArrayList.size();
        }

//        @Nullable
//        @Override
        public CharSequence getPageTitle(int position) {
//
//            // Initialize drawable
//            Drawable drawable= ContextCompat.getDrawable(getApplicationContext()
//                    ,imageList[position]);
//
//            // set bound
//            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),
//                    drawable.getIntrinsicHeight());
//
//            // Initialize spannable image
            SpannableString spannableString=new SpannableString(""+stringArrayList.get(position));
//
//            // Initialize image span
//            ImageSpan imageSpan=new ImageSpan(drawable,ImageSpan.ALIGN_BOTTOM);
//
//            // Set span
//            spannableString.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//            // return spannable string
            return spannableString;
        }
    }
}