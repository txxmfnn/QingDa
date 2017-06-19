package com.yanz.machine.shinva.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.yanz.machine.shinva.R;
import com.yanz.machine.shinva.entity.BCustomer;
import com.yanz.machine.shinva.record.RecordDetailActivity;
import com.yanz.machine.shinva.util.HttpUtil;

import org.codehaus.jackson.map.ObjectMapper;

import cz.msebera.android.httpclient.Header;

public class CustomerDetailActivity extends AppCompatActivity {
    private String uri = "/customer/findCustomerDetail";
    private String autoId;
    BCustomer customer = new BCustomer();
    private TextView name;
    private TextView age;
    private TextView dept;
    private TextView address;
    private TextView telephone;
    private TextView birthday;
    private TextView condition;
    private TextView mate;
    private TextView interesting;
    private TextView family;
    private TextView child;
    private TextView decision;
    //提取姓名/编码|门店/编码
    private String rName;
    private String rNameCode;
    private String rDept;
    private String rDeptCode;
    private Button addRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
        Intent intent = getIntent();
        autoId = intent.getStringExtra("autoId");
        name = (TextView) findViewById(R.id.tv_customer_detail_name);
        age = (TextView) findViewById(R.id.tv_customer_detail_age);
        dept = (TextView) findViewById(R.id.tv_customer_detail_dept);
        address = (TextView) findViewById(R.id.tv_customer_detail_address);
        telephone = (TextView) findViewById(R.id.tv_customer_detail_telephone);
        birthday = (TextView) findViewById(R.id.tv_customer_detail_bir);
        condition = (TextView) findViewById(R.id.tv_customer_detail_condition);
        mate = (TextView) findViewById(R.id.tv_customer_detail_mate);
        interesting = (TextView) findViewById(R.id.tv_customer_detail_interesting);
        family = (TextView) findViewById(R.id.tv_customer_detail_family);
        child = (TextView) findViewById(R.id.tv_customer_detail_child);
        decision = (TextView) findViewById(R.id.tv_customer_detail_decision);
        addRecord= (Button) findViewById(R.id.bt_customer_detail_add_record);
        initData();
    }
    public void initData(){
        String url = HttpUtil.BASE_URL+uri;
        RequestParams params = new RequestParams();
        params.put("autoId",autoId);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(CustomerDetailActivity.this, "连接错误PlanSearchActivity", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                if (statusCode==200){
                    try {
                        if (responseString.contains("true@@")){
                            String[] message = responseString.split("@@");
                            String result = message[1];
                            ObjectMapper objectMapper = new ObjectMapper();
                            customer = objectMapper.readValue(result,new BCustomer().getClass());
                            loadInfo();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public void loadInfo() throws InterruptedException{
        if (customer!=null){
            CustomerDetailActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    name.setText(customer.getCcustomerName());
                    age.setText(customer.getCage());
                    address.setText(customer.getCaddress());
                    telephone.setText(customer.getCtelephone());
                    dept.setText(customer.getCupDepartmentName());
                    decision.setText(customer.getCdecisionMaking());
                    family.setText(customer.getCfamilyStructure());
                    birthday.setText(customer.getCbirthday());
                    condition.setText(customer.getCcondition());
                    child.setText(customer.getCchildren());
                    mate.setText(customer.getCmateHealth());
                    interesting.setText(customer.getCinterests());
                    //设置回访记录需要数据
                    rName=customer.getCcustomerName();
                    rNameCode=customer.getCcustomerCode();
                    rDept= customer.getCupDepartmentName();
                    rDeptCode=customer.getCupDepartmentCode();
                }
            });
        }
    }
    public void toAddRecord(View view){
        Intent intent = new Intent();
        intent.putExtra("name",rName);
        intent.putExtra("nameCode",rNameCode);
        intent.putExtra("dept",rDept);
        intent.putExtra("deptCode",rDeptCode);
        intent.setClass(CustomerDetailActivity.this, RecordDetailActivity.class);
        startActivity(intent);
    }
}
