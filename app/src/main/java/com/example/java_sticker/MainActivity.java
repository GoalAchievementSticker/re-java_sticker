package com.example.java_sticker;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class MainActivity extends AppCompatActivity {

    //private GridView gridView = null;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    //GridItem gridItem;
    //TitleItem titleItem;
    private ArrayList<GridItem> items;
    private GridLayoutManager gridLayoutManager;
    EditText sticker_count;
    EditText sticker_dlg_title;
    Button noBtn;
    Button yesBtn;
    //ArrayList<String> titleItems;
    Dialog custom_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.grid_recyclerview);
        //GridViewWithHeaderAndFooter mGridView = (GridViewWithHeaderAndFooter) findViewById(R.id.gridViewHeader);



        items = new ArrayList<>();
        try {
            adapter = new CustomAdapter(getHeader(), getGridItems());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);
        //titleItems = new ArrayList<String>();

        gridLayoutManager = new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(gridLayoutManager);
        custom_dialog = new Dialog(MainActivity.this);

        custom_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        custom_dialog.setContentView(R.layout.custom_dialog);
        sticker_count = (EditText) custom_dialog.findViewById(R.id.sticker_count);
        sticker_dlg_title = (EditText) custom_dialog.findViewById(R.id.sticker_dlg_title);
        noBtn = custom_dialog.findViewById(R.id.noBtn);
        yesBtn = custom_dialog.findViewById(R.id.yesBtn);

        //header 추가
        //final View header = getLayoutInflater().inflate(R.layout.)
        Button btn = (Button) findViewById(R.id.dialogButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

    }

    public Header getHeader(){
        Header header = new Header();
        header.setHeader(sticker_dlg_title.getText().toString());
        return header;
    }

    public ArrayList<GridItem> getGridItems() throws ParseException {
        ArrayList<GridItem> items = new ArrayList<GridItem>();
        String vi = sticker_count.getText().toString();
        int it = 0;
        it = NumberFormat.getInstance().parse(vi).intValue();
        for(int i=0; i<it; i++){
            items.add(new GridItem());

        }
        return items;
    }

    public void showDialog(){
        custom_dialog.show();


        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                custom_dialog.dismiss();
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String vi = sticker_count.getText().toString();
                //int it = 0;
                //ArrayList<Integer> di = new ArrayList<>();
                try {
                    //it = NumberFormat.getInstance().parse(vi).intValue();

                    //items.add(new GridItem(i, sticker_dlg_title.getText().toString()));
                    //Toast.makeText(getApplicationContext(), it, Toast.LENGTH_LONG).show();

//                    for(int i=0; i<it; i++){
//                        items.add(new GridItem(i, sticker_dlg_title.getText().toString()));;
//
//                    }
                    //titleItems.add(sticker_dlg_title.getText().toString());
//                    items.add(new GridItem(it,sticker_dlg_title.getText().toString()));

                    //adapter.items = items;
                    getHeader();
                    getGridItems();
                    adapter.notifyDataSetChanged();
                } catch (ParseException e) {
                    e.printStackTrace();
                }





                custom_dialog.dismiss();
            }
        });


    }
}