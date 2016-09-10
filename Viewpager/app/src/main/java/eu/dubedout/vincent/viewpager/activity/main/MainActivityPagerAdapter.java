package eu.dubedout.vincent.viewpager.activity.main;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eu.dubedout.vincent.viewpager.R;

public class MainActivityPagerAdapter extends PagerAdapter {

    private final List<PageData> itemList;

    public MainActivityPagerAdapter(List<PageData> itemList) {
        this.itemList = itemList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_page_data, container, false);
        bindData(view, position);
        container.addView(view);
        return view;
    }

    private void bindData(View view, int position) {
        PageData pageData = itemList.get(position);

        TextView textView = (TextView) view.findViewById(R.id.item_page_data_text);
        textView.setText(pageData.text);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
