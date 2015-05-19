package com.example.yaoyao.element;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;




public class MainActivity extends Activity {

    private Button H=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        H = (Button)findViewById(R.id.H);

        //MyOnClick click = new MyOnClick();
        H.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,H.class);
                startActivity(intent);
            }

        });
    }


    private class MyOnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }



}
