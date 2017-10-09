package com.example.hee.adapterview_practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hee on 2017-10-09.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private ArrayList<MyItem> mItems = new ArrayList<MyItem>();       //인자로 받아온 itemdata를 저장하기 위한 어댑터

    //내 어댑터 생성자를통해 itemdata을 받는다
    public MyAdapter(Context context, int resource, ArrayList<MyItem> items) {
        mContext = context;
        mItems = items;
        mResource = resource;
    }

    //리스트 뷰의 아이템 개수를 int로 반환
    @Override
    public int getCount() {
        return mItems.size();
    }

    //podition에 해당하는 아이템을 객체의 형태로 반환
    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    //position에 해당하는 아이템id를 반환
    @Override
    public long getItemId(int position) {
        return position;
    }

    //받아온 데이터를 listview의 아이템으로 만들어주는 메소드 , convertview는 재활용이 가능한 뷰이다
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertview가 한번도 생성된 적이없다면
        if (convertView == null) {
            //레이아웃 초기화 불러옴 , 콘텍스트 불러오고 뷰객체 만듦
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent, false);
        }
        //아이템 객체 정의  Set Text 01
        TextView classname = (TextView) convertView.findViewById(R.id.textId1);
        classname.setText(mItems.get(position).nClassname);

        // Set Text 02
        TextView classtime = (TextView) convertView.findViewById(R.id.textId2);
        classtime.setText(mItems.get(position).nClasstime);

        // Set Text 03
        TextView classlocation = (TextView) convertView.findViewById(R.id.textId3);
        classlocation.setText(mItems.get(position).nClasslocation);

        return convertView;
    }
}

class MyItem {
    String nClassname;   //강좌이름 text
    String nClasstime; // 강좌시간text
    String nClasslocation; //강의실 위치text

    MyItem(String aClassname, String aClasstime, String aClasslocation) {
        nClassname = aClassname;
        nClasstime = aClasstime;
        nClasslocation = aClasslocation;
    }

}
