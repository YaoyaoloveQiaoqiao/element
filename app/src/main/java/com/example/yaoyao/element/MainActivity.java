package com.example.yaoyao.element;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = LayoutInflater.from(this);

        View root = inflater.inflate(R.layout.h, null);
        // final PopupWindow popup=new PopupWindow(root,280,360);
        final PopupWindow popup=new PopupWindow(root, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);





        Button button=(Button)findViewById(R.id.Li);
        popup.setBackgroundDrawable(new BitmapDrawable());
        //设置点击窗口外边窗口消失
        popup.setOutsideTouchable(true);
        // 设置此参数获得焦点，否则无法点击
        popup.setFocusable(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popup.isShowing()) {
                    // 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
                    popup.dismiss();
                } else {
                    // 显示窗口
                    popup.showAtLocation(findViewById(R.id.main), Gravity.CENTER, 20, 20);
                }

            }
        });
    }


//    private Button H=null;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        H = (Button)findViewById(R.id.H);
//
//        //MyOnClick click = new MyOnClick();
//        H.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent=new Intent();
//                intent.setClass(MainActivity.this,H.class);
//                startActivity(intent);
//            }
//
//        });
//    }
//
//
//    private class MyOnClick implements View.OnClickListener{
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
//
//

}
