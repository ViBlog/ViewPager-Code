package eu.dubedout.vincent.viewpager.activity.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

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
    }

    private List<PageData> getPageDataList() {
        List<PageData> dummyDataList = new ArrayList<>();
        dummyDataList.add(new PageData("This is going to be"));
        dummyDataList.add(new PageData("LEGEN"));
        dummyDataList.add(new PageData("... wait for it ..."));
        dummyDataList.add(new PageData("DARY"));

        return dummyDataList;
    }
}
