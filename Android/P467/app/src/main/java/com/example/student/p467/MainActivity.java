package com.example.student.p467;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<item> list;
    LinearLayout container;
    GridView gridView;
    ItemAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        container = findViewById(R.id.container);

        list = new ArrayList<>();
        list.add(new item("소녀시대","010-111-1234",30,R.drawable.c1));
        list.add(new item("소녀시대","010-456-4567",30,R.drawable.c2));
        list.add(new item("소녀시대","010-111-7894",30,R.drawable.c3));
        list.add(new item("소녀시대","010-111-5522",30,R.drawable.c4));
        list.add(new item("소녀시대","010-111-3242",30,R.drawable.c5));
        list.add(new item("소녀시대","010-897-3242",30,R.drawable.c6));
        list.add(new item("소녀시대","010-159-3242",30,R.drawable.c7));

        itemAdapter = new ItemAdapter(list);
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(itemAdapter);


    }

    public void clickbt(View v){
        itemAdapter.addItem(new item("한현우","010-1234-789",30,R.drawable.c5));
        itemAdapter.notifyDataSetChanged();  //리스트뷰 리프레쉬~~
    }

    public class ItemAdapter extends BaseAdapter {
        ArrayList<item> list;
        public ItemAdapter() {

        }

        public ItemAdapter(ArrayList<item> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return list.get(i).resId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View vw = null;
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            vw = inflater.inflate(R.layout.item,container,true);
            TextView name = vw.findViewById(R.id.textView);
            TextView phone = vw.findViewById(R.id.textView2);
            TextView age = vw.findViewById(R.id.textView3);
            ImageView img = vw.findViewById(R.id.imageView);

            name.setText(list.get(i).getName());
            phone.setText(list.get(i).getMobile());
            age.setText(list.get(i).getAge()+ "");
            img.setImageResource(list.get(i).getResId());

            return vw;
        }

        public void addItem(item item) {
            list.add(item);
        }

    }


}

