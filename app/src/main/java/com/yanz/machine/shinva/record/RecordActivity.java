package com.yanz.machine.shinva.record;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.yanz.machine.shinva.Adapter.BaseViewHolder;
import com.yanz.machine.shinva.R;
import com.yanz.machine.shinva.customer.CustomerDetailActivity;
import com.yanz.machine.shinva.entity.SVisitRecord;
import com.yanz.machine.shinva.util.ClickUtil;
import com.yanz.machine.shinva.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RecordActivity extends AppCompatActivity {
    private String uri="/record/findRecord";
    private Context mContext;
    private ImageView ivDeleteText;
    private EditText etRecordName;
    private Button btSearch;
    private ListView lvResult;
    ProgressDialog proDialog;
    private List<SVisitRecord> records = new ArrayList<SVisitRecord>();
    private InputRecordAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ivDeleteText = (ImageView) findViewById(R.id.iv_input_record_deleteText);
        etRecordName = (EditText) findViewById(R.id.et_input_record_search);
        btSearch = (Button) findViewById(R.id.bt_input_record_search);
        lvResult = (ListView) findViewById(R.id.lv_input_record_result);
        adapter =new InputRecordAdapter(records);
        lvResult.setAdapter(adapter);
        ivDeleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etRecordName.setText("");
            }
        });
        etRecordName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==0){
                    ivDeleteText.setVisibility(View.GONE);
                }else {
                    ivDeleteText.setVisibility(View.VISIBLE);
                }
            }
        });
        btSearch.setOnClickListener(new ClickUtil() {
            @Override
            protected void onNoDoubleClick(View view) {
                //proDialog = ProgressDialog.show(RecordActivity.this,"正在查询","请稍候...");
                initData();
            }
        });

        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SVisitRecord record = (SVisitRecord) lvResult.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.putExtra("record",(Parcelable)record);
                intent.setClass(RecordActivity.this, RecordDetailActivity.class);
                startActivity(intent);
            }
        });
        //1699+4680+2299

    }
    public void initData(){
        String url = HttpUtil.BASE_URL+uri;
        RequestParams params = new RequestParams();
        params.put("name",etRecordName.getText().toString());
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                //proDialog.dismiss();
                Toast.makeText(RecordActivity.this,"请检查网络配置情况", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                //proDialog.dismiss();

                String[] message = responseString.split("@@");
                String result = message[1];
                Gson gson = new Gson();
                List<SVisitRecord> list;
                list = gson.fromJson(result,new TypeToken<List<SVisitRecord>>(){}.getType());
                Log.e("meng","查询的记录:"+list.get(0).getCcustomerName());
                records.clear();
                records.addAll(list);
                adapter.notifyDataSetChanged();
            }
        });
    }
    //listView适配器
    private class InputRecordAdapter extends BaseAdapter{
        List<SVisitRecord> recordList;
        public InputRecordAdapter(List<SVisitRecord> recordList){
            this.recordList= recordList;
        }

        @Override
        public int getCount() {
            return recordList.size();
        }

        @Override
        public Object getItem(int position) {
            return recordList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView = getLayoutInflater().inflate(R.layout.item_line2,parent,false);
            }
            TextView tvName = BaseViewHolder.get(convertView,R.id.tv_item_head);
            TextView tvDept = BaseViewHolder.get(convertView,R.id.tv_item_other);
            TextView tvDate = BaseViewHolder.get(convertView,R.id.tv_item_report);
            TextView tvRecord = BaseViewHolder.get(convertView,R.id.tv_item_mid);
            SVisitRecord record = recordList.get(position);
            tvName.setText(record.getCcustomerName());
            tvDept.setText(record.getCupDepartmentName());
            tvDate.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
            tvDate.setText(record.getDvisitDate());
            tvRecord.setText(record.getCvisitContent());
            return convertView;
        }
    }
}
