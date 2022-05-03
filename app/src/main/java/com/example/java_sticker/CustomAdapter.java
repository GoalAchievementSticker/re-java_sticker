package com.example.java_sticker;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AdapterViewholder>{


    //GridItem a = items.get(0);


    private static final int TYPE_HEADER =0;
    private static final int TYPE_ITEM = 1;

    Header header;
    ArrayList<GridItem> items_list ;

    public CustomAdapter(Header header,ArrayList<GridItem> items_list){
        this.header = header;
        this.items_list = items_list;
    }
//    public boolean isHeader(int position){
//        return position==0;
//    }
    public static class AdapterViewholder extends RecyclerView.ViewHolder{

        ImageView sticker_img;
        TextView sticker_tittle;
        public AdapterViewholder(@NonNull View itemView){
            super(itemView);

            sticker_img =(ImageView) itemView.findViewById(R.id.sticker_img);
            sticker_tittle = (TextView) itemView.findViewById(R.id.sticker_title);
        }
    }




    @NonNull
    @Override
    public CustomAdapter.AdapterViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(viewType == TYPE_HEADER){
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new VHHeader(view);
       }else if(viewType == TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_grid, parent, false);
            return new VHItem(view);
        }
        throw new RuntimeException("ther is no type that matches the type" + viewType + "+ make sure your using types correctly");

//        CustomAdapter.AdapterViewholder holder = new CustomAdapter.AdapterViewholder(view);
//        return holder;
    }

    private GridItem getItem(int position){
        return items_list.get(position);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.AdapterViewholder holder, int position) {
        if(holder instanceof VHHeader)
        {
            VHHeader VHheader = (VHHeader)holder;
            VHheader.sticker_tittle.setText(header.getHeader());
        }
        else if(holder instanceof VHItem)
        {
            GridItem currentItem = getItem(position-1);
            VHItem VHitem = (VHItem)holder;
            VHitem.iv.setBackgroundResource(currentItem.getResId());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position)
    {
            return position == 0;
    }

//        GridItem item = items_list.get(position);
//        //holder.sticker_img.setImageResource(item.getResId());
//        holder.sticker_tittle.setText(item.getResText());



//    @Override
//    public long getItemId(int position){
//        return position;
//    }

    @Override
    public int getItemCount() {
        return items_list.size()+1;
    }


    class VHHeader extends CustomAdapter.AdapterViewholder{
        TextView sticker_tittle;
        public VHHeader(View itemView) {
            super(itemView);
            this.sticker_tittle = (TextView)itemView.findViewById(R.id.sticker_title);
        }
    }


    class VHItem extends CustomAdapter.AdapterViewholder{
        ImageView iv;
        public VHItem(View itemView) {
            super(itemView);
            this.iv = (ImageView)itemView.findViewById(R.id.sticker_img);
        }
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup viewGroup){
//        final Context context = viewGroup.getContext();
//        final GridItem gridItem = items.get(position);
//        //final TitleItem titleItem = titleItems.get(position);
//
//        if(convertView == null){
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.custom_grid, viewGroup, false);
//
//            ImageView sticker_img = (ImageView) convertView.findViewById(R.id.sticker_img);
//            TextView sticker_title = (TextView) convertView.findViewById(R.id.sticker_title);
//
//
//            sticker_title.setText(gridItem.getResText());
//        }else{
//            View view = new View(context);
//            view = (View) convertView;
//        }
//
//        return convertView;
//    }



}
