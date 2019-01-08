package com.example.lvxiaohao.day06_app01;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by LVXIAOHAO on 2018/12/31.
 */
@ContentView(R.layout.activity_register)
public class RegisterActivity extends Activity {



    //TODO 注册界面

    @ViewInject(R.id.et_account)
    private EditText et_account;

    @ViewInject(R.id.et_pwd)
    private EditText et_pwd;

    @ViewInject(R.id.et_username)
    private EditText et_username;

    @ViewInject(R.id.et_phone)
    private EditText et_phone;

    @ViewInject(R.id.et_identifying_code)
    private EditText et_identifying_code;

//    @ViewInject(R.id.btn_reg)
//    private Button btn_reg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        x.view().inject(this);

    }

    @Event(R.id.btn_reg)
    private void onClick(View v){

        //TODO 短信验证

        //TODO 获取用户信息
        String regaccount=et_account.getText().toString();
        String regpwd=et_pwd.getText().toString();
        String regusername=et_username.getText().toString();
        String regphone=et_phone.getText().toString();
        String regic=et_identifying_code.getText().toString();
        //TODO 验证用户信息
        String select_sql="select * from user" ;
//        Cursor cursor=database.rawQuery(select_sql,null);
//        while (cursor.moveToNext()){
//            String accountdb=cursor.getString(cursor.getColumnIndex("account"));
//            if(accountdb.equals(regaccount))
//            {
//                Log.i("test","用户已存在");
//            }
//        }

        //TODO 信息写入数据库


        //TODO 跳转到登录界面

    }
}
