package com.example.user.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 2017-10-15.
 */

public class Sub2Activity extends AppCompatActivity {
    Button btn1,btn2,btn3;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

        if(findViewById(R.id.container)!=null){
            if(savedInstanceState!=null){
                return;}

            Fragment_A first=new Fragment_A();
            first.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.container,first).commit();}

        Button btn3= (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }


        });

    }

    public void select(View v){
        Fragment fragment = null;
        switch(v.getId()){
            case R.id.btn1:fragment=new Fragment_A();break;
            case R.id.btn2:fragment=new Fragment_B();break;}

        FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();}



}

