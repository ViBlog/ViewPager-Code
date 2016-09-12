package eu.dubedout.vincent.viewpager.activity.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpager.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.activity_main_viewpager) ViewPager activityMainViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeViews();
    }

    private void initializeViews() {
        List<PageData> pageDataList = getPageDataList();
        MainActivityPagerAdapter adapter = new MainActivityPagerAdapter(pageDataList);
        activityMainViewpager.setAdapter(adapter);
        activityMainViewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this, "New page selected: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<PageData> getPageDataList() {
        List<PageData> dummyDataList = new ArrayList<>();
        dummyDataList.add(new PageData("Page 1", "This is going to be"));
        dummyDataList.add(new PageData("Page 2", "LEGEN"));
        dummyDataList.add(new PageData("Page 3", "... wait for it ..."));
        dummyDataList.add(new PageData("Page 4", "DARY"));

        return dummyDataList;
    }
}
