package com.yanz.machine.shinva.record;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.yanz.machine.shinva.MainActivity;
import com.yanz.machine.shinva.R;
import com.yanz.machine.shinva.entity.SVisitRecord;
import com.yanz.machine.shinva.util.HttpUtil;

import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

public class RecordDetailActivity extends AppCompatActivity {
    private String uri="/record/createRecord";
    private EditText name;
    private EditText dept;
    private EditText weather;
    private Button date;
    private EditText content;
    private String rName;
    private String rDept;
    private String rNameCode;
    private String rDeptCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        Intent intent = getIntent();
        rName = intent.getStringExtra("name");
        rNameCode = intent.getStringExtra("nameCode");
        rDept=intent.getStringExtra("dept");
        rDeptCode=intent.getStringExtra("deptCode");
        name = (EditText) findViewById(R.id.et_record_detail_name);
        dept = (EditText) findViewById(R.id.et_record_detail_dept);
        weather = (EditText) findViewById(R.id.et_record_detail_weather);
        date = (Button) findViewById(R.id.et_record_detail_date);
        content = (EditText) findViewById(R.id.et_record_detail_content);
        final Calendar c = Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(RecordDetailActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        c.set(year, monthOfYear, dayOfMonth);
                        date.setText(DateFormat.format("yyyy-MM-dd", c));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
        initData(rName,rDept);
    }
    public void initData(String rName,String rDept){
        name.setText(rName);
        dept.setText(rDept);
    }
    public void addRecord(View view){
        String url= HttpUtil.BASE_URL+uri;
        SharedPreferences sp = getSharedPreferences("USERINFO",0);
        String makeCode = sp.getString("name", "");
        RequestParams params = new RequestParams();
        params.put("nameCode",rNameCode);
        params.put("name",rName);
        params.put("dept",rDept);
        params.put("deptCode",rDeptCode);
        params.put("weather",weather.getText().toString());
        params.put("content",content.getText().toString());
        params.put("date",date.getText().toString());
        params.put("makeCode",makeCode);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(RecordDetailActivity.this, "连接错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Toast.makeText(RecordDetailActivity.this, "成功!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RecordDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
