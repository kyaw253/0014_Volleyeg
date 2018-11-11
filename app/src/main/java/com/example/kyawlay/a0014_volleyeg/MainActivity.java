package com.example.kyawlay.a0014_volleyeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Response.ErrorListener, Response.Listener<String> {
    TextView textResponse;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResponse=(TextView)findViewById(R.id.tv_Response);
        btnClick=(Button)findViewById(R.id.btn_click);

        btnClick.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View view) {
        RequestQueue queue=Volley.newRequestQueue(this);
        String url="https://www.google.com.mm/search?q=www&oq=www&aqs=chrome..69i57j69i60l5.7076j0j7&sourceid=chrome&ie=UTF-8";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
               this,this);
        queue.add(stringRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        textResponse.setText("This is not work");

    }

    @Override
    public void onResponse(String response) {
  textResponse.setText("Response is :"+response.substring(0,500));
    }
}
