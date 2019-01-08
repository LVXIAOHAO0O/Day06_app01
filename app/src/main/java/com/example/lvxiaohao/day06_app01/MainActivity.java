package com.example.lvxiaohao.day06_app01;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {

    //TODO 登录界面

    @ViewInject(R.id.et_account_login)
    private EditText et_account_login;

    @ViewInject(R.id.et_pwd_login)
    private EditText et_pwd_login;

//    @ViewInject(R.id.btn_login)
//    private Button btn_login;

    @ViewInject(R.id.cb_savepwd)
    private CheckBox cb_savepwd;

    private DbHelper helper;
    private SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化
        x.view().inject(this);
        //TODO 加载数据
        //加载用户信息
        loadInfo();
        //获取数据可读写对象
        helper=new DbHelper(this);
        database=helper.getWritableDatabase();
        Log.i("test","database");
    }

    //TODO 导入用户信息
    private void loadInfo() {
        SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
        //TODO 从文件获取数据
        String account=sp.getString("account","");
        String pwd=sp.getString("pwd","");
        int status=0,i=0;
        status=sp.getInt("status",i);
        //TODO 写入数据到输入框
        et_account_login.setText(account);
        et_pwd_login.setText(pwd);

        Log.i("test","loadInfo");

        //TODO 判断记住密码的状态
        if(status==1)
        {
            cb_savepwd.setChecked(true);
            Log.i("test","setChecked");
        }
    }


    //TODO 登录按钮 注册按钮
    @Event(value = {R.id.btn_login})
    private void onClick(View v){
        //TODO 1.获取用户的信息 完成
        String account=et_account_login.getText().toString();
        String pwd=et_pwd_login.getText().toString();
        //TODO 2. 验证用户的身份 完成
        if(account.length()==0||account.equals("")) {
            Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();

            return;
        }
        if(pwd.length()==0||pwd.equals("")) {
            Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();

            return;
        }
        //TODO 3. 如果用户信息正确，则保存
        if(account.equals("admin")&&pwd.equals("123")){

            SharedPreferences.Editor sp=getSharedPreferences("user",MODE_PRIVATE).edit();
            //判断用户是否要记住密码
            if(cb_savepwd.isChecked()){
                //保存 user.xml
                //保存账号
                sp.putString("account",account);

                //保存密码
                sp.putString("pwd",pwd);

                //记住密码的状态 0：不选中 1：选中
                sp.putInt("status",1);

                //TODO ？
                //提交

            }
            else{
                //清除
                sp.putString("account","");
                sp.putString("pwd","");
                sp.putInt("status",0);

            }
            sp.commit();
        } else{//账号或密码不正确
            Toast.makeText(MainActivity.this,"用户名或密码不正确",Toast.LENGTH_LONG).show();

        }


    }





}
