package com.example.hee.adapterview_practice;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//어댑터 생성 및 연결
public class MainActivity extends AppCompatActivity {
    static MyAdapter adapter; //listview와 item을 연결해주는 커스텀어댑터 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listview에 들어갈 객체 선언
        //title과 description 두 가지 string 객체를 데이터로 갖는 itemdata라는 객체들을 배열의 현태로 저장하는 클래스
        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem("안드로이드\n프로그래밍","수2.3","B107"));
        data.add(new MyItem("소프트웨어\n설계 패턴 A","월5.6수5","B105"));
        data.add(new MyItem("소프트웨어\n설계 패턴 B","월야2.3.수야1","B105"));

        //list어댑터 생성 - 실제 리스트로 들어갈 내용 담도록
        adapter = new MyAdapter(this,R.layout.layout, data);

        //list 뷰 만듦 list id
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //listview 기타설정
        listView.setDivider(new ColorDrawable(Color.RED));
        listView.setDividerHeight(5);

        //listview이벤트 처리 -클릭했을때
        //parent는 adapterview의 속성을 모두 사용할 수 있다.
        //position은 클릭한 row의 position을 반환해준다.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {
                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
                String classname = ((MyItem)adapter.getItem(position)).nClassname;
                Toast.makeText(MainActivity.this, classname + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
