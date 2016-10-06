package com.wosea.mangsonguyen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et_day;
    TextView tv_kq;
    Button taoday,xuatxuoi,xuatnguoc,minmax;
    int myArray[] =new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_day=(EditText)findViewById(R.id.editText);
        tv_kq=(TextView)findViewById(R.id.textView2); //textView1 ta sửa thuộc tính Text trong giao diện là "Dãy ngẫu nhiên"
        taoday=(Button)findViewById(R.id.button);
        xuatxuoi=(Button)findViewById(R.id.button2);
        xuatnguoc=(Button)findViewById(R.id.button3);
        minmax=(Button)findViewById(R.id.button4);

        taoday.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Random rd=new Random();
                String chuoi="";
                for(int i=0;i<10;i++)
                {
                    //mang[i]=rd.nextInt(10);     //từ 0 đến 9
                    myArray[i]=rd.nextInt(50-10+1)+10;   //từ 10->50   // (b-a+1)+a
                }
                ArraytoEditText();
            }

        });

        xuatxuoi.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ArraytoEditText();
            }
        });


        xuatnguoc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String chuoi="";
                for(int i=9;i>=0;i--)
                {
                    chuoi+= myArray[i]+ " ";
                }
                et_day.setText(chuoi);
            }
        });

        minmax.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int min=myArray[0];
                int max=myArray[0];
                for(int i=0;i<10;i++)
                {
                    if(myArray[i]<min) min=myArray[i];
                    if(myArray[i]>max) max=myArray[i];
                }
                tv_kq.setText("Min: "+min + " max: "+max);
            }
        });
    }

    public void ArraytoEditText()
    {
        String chuoi="";
        for(int i=0;i<10; i++)
        {
            chuoi +=myArray[i]+ " ";
        }
        et_day.setText(chuoi);
    }
}
