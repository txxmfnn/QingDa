package com.yanz.machine.shinva.customer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.yanz.machine.shinva.MainActivity;
import com.yanz.machine.shinva.R;
import com.yanz.machine.shinva.entity.BCustomer;
import com.yanz.machine.shinva.entity.SPlan;
import com.yanz.machine.shinva.login.LoginActivity;
import com.yanz.machine.shinva.planSearch.InputPlanActivity;
import com.yanz.machine.shinva.util.ClickUtil;
import com.yanz.machine.shinva.util.HttpUtil;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class CustomerActivity extends AppCompatActivity {
    private String uri="/customer/findCustomer";
    private Context mContext;
    private ImageView ivDeleteText;
    private EditText etCustomerName;
    private Button btSearch;
    private ListView lvResult;
    private List<BCustomer> customers = new ArrayList<BCustomer>();
    private InputCustomerAdapter adapter;
    ProgressDialog proDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ivDeleteText = (ImageView) findViewById(R.id.iv_input_customer_deleteText);
        etCustomerName = (EditText) findViewById(R.id.et_input_customer_search);
        btSearch = (Button) findViewById(R.id.bt_input_customer_search);
        lvResult = (ListView) findViewById(R.id.lv_input_customer_result);
        adapter = new InputCustomerAdapter(customers);
        lvResult.setAdapter(adapter);
        ivDeleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etCustomerName.setText("");
            }
        });
        etCustomerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length()==0){
                    ivDeleteText.setVisibility(View.GONE);
                }else {
                    ivDeleteText.setVisibility(View.VISIBLE);
                }
            }
        });
        btSearch.setOnClickListener(new ClickUtil() {
            @Override
            protected void onNoDoubleClick(View view) {
                proDialog = ProgressDialog.show(CustomerActivity.this,"正在查询","请稍候...");
                initData();
            }
        });
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BCustomer customer = (BCustomer) lvResult.getItemAtPosition(position);
                String autoId = customer.getIautoid().toString();
                Intent intent = new Intent();
                intent.putExtra("autoId",autoId);
                intent.setClass(CustomerActivity.this, CustomerDetailActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initData(){
        String url = HttpUtil.BASE_URL+uri;
        RequestParams params = new RequestParams();
        params.put("name",etCustomerName.getText().toString());
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                proDialog.dismiss();
                Toast.makeText(CustomerActivity.this,"请检查网络配置情况", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                proDialog.dismiss();
                String[] message = responseString.split("@@");
                String result = message[1];
                Gson gson = new Gson();
                List<BCustomer> list;
                list = gson.fromJson(result,new TypeToken<List<BCustomer>>(){}.getType());
                customers.clear();
                customers.addAll(list);
                adapter.notifyDataSetChanged();

            }
        });
    }

    //listView的适配器
    class InputCustomerAdapter extends BaseAdapter{
        List<BCustomer>  customerList;
        public InputCustomerAdapter(List<BCustomer> customerList){
            this.customerList=customerList;
        }

        @Override
        public int getCount() {
            return customerList.size();
        }

        @Override
        public Object getItem(int position) {
            return customerList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return  position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView = getLayoutInflater().inflate(R.layout.item_line2,parent,false);
            }
            TextView tvCustomerName = BaseViewHolder.get(convertView, R.id.tv_item_head);
            TextView tvAge = BaseViewHolder.get(convertView,R.id.tv_item_num);
            TextView tvAddress = BaseViewHolder.get(convertView,R.id.tv_item_report);
            TextView tvTelephone = BaseViewHolder.get(convertView,R.id.tv_item_mid);
            TextView tvInterest = BaseViewHolder.get(convertView,R.id.tv_item_foot);
            BCustomer customer = customerList.get(position);
            tvCustomerName.setText(customer.getCcustomerName());
            tvAge.setText(customer.getCage());
            tvAddress.setText(customer.getCaddress());
            tvTelephone.setText(customer.getCtelephone());
            tvInterest.setText(customer.getCinterests());

            return convertView;
        }
    }
}
