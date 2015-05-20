package com.example.yaoyao.element;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Created by yaoyao on 2015/5/19.
 */
public class PopupWindowActivity extends Activity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View root =this.getLayoutInflater().inflate(R.layout.h,null);
      // final PopupWindow popup=new PopupWindow(root,280,360);
        final PopupWindow popup=new PopupWindow();
        popup.setContentView(root);


        popup.setFocusable(true);

        Button button=(Button)findViewById(R.id.Li);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.showAtLocation(findViewById(R.id.Li), Gravity.CENTER,20,20);
               //   popup.show

            }
        });
    }


}
