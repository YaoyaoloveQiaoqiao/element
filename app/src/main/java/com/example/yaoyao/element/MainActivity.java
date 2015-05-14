package com.example.yaoyao.element;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
    private PopupWindow popupWindow;
    private View parent;
    /**菜单弹出来时候的菜单项图案*/
    private int[] images = { R.drawable.i1, R.drawable.i2, R.drawable.i3,
            R.drawable.i4, R.drawable.i5, R.drawable.i6, R.drawable.i7,
            R.drawable.i8 };
    /**菜单弹出来时候的菜单项文字*/
    private String[] names = { "搜索", "文件管理", "下载管理", "全屏", "网址", "书签", "加入书签",
            "分享页面" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**PopupWindow的界面*/
        View contentView = getLayoutInflater()
                .inflate(R.layout.popwindow, null);
        /**网格布局界面*/
        GridView gridView = (GridView) contentView.findViewById(R.id.gridView);
        /**设置网格布局的适配器*/
        gridView.setAdapter(getAdapter());
        /**设置网格布局的菜单项点击时候的Listener*/
        gridView.setOnItemClickListener(new ItemClickListener());
        /**初始化PopupWindow*/
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);// 取得焦点
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        /**设置PopupWindow弹出和退出时候的动画效果*/
        popupWindow.setAnimationStyle(R.style.animation);

        parent = this.findViewById(R.id.main);
    }

    private final class ItemClickListener implements OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();//关闭
            }
        }
    }

    /**返回网格布局的适配器*/
    private ListAdapter getAdapter() {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < images.length; i++) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("image", images[i]);
            item.put("name", names[i]);
            data.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data,
                R.layout.grid_item, new String[] { "image", "name" },
                new int[] { R.id.imageView, R.id.textView });
        return simpleAdapter;
    }

    public void openPopWindow(View v) {
        /**设置PopupWindow弹出后的位置*/
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }
}
/*public class MainActivity extends ActionBarActivity {

    private Button Na;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Na = (Button)findViewById(R.id.Na);

        MyOnClick click = new MyOnClick();
        Na.setOnClickListener(click);
    }

    private class MyOnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/