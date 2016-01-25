package com.ccav.bai.myapp.activity;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ccav.bai.myapp.R;

public class MainActivity extends Activity {

    //个性签名
    private TextView qianming;
    //我的资料
    private TextView ziliao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局文件，默认是main_activity
        setContentView(R.layout.yemian);
        //设置个性签名点击事件
        setQianmingClick();
    }

    /**
     * 个性签名点击事件
     */
    public void setQianmingClick(){
        qianming = (TextView)findViewById(R.id.qianming);
        qianming.setOnClickListener(new TextView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,qianming.getText(),Toast.LENGTH_SHORT).show();
            }
        });
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
