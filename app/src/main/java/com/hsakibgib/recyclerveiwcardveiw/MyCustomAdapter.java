package com.hsakibgib.recyclerveiwcardveiw;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    Context context;
    ArrayList<Information> data;
    LayoutInflater inflater;

    int previousposition=0;

// automatically created constructor from getData() call in MainActivity
    public MyCustomAdapter(Context context, ArrayList<Information> data) {
      this.context=context;
      this.data=data;
      inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.list_item_row,parent,false);
        MyViewHolder holder= new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) // from here click things are decided on imageView used
    {
        myViewHolder.textView.setText(data.get(position).title);
        myViewHolder.imageView.setImageResource(data.get(position).imageId);

        if(position>previousposition){  //scrolling down
            AnimationHelper.animate(myViewHolder,true);
        }
        else{ // scrolling up
            AnimationHelper.animate(myViewHolder,false);
        }


        /*start codes for add or remove data from dataset*/
        previousposition=position;
        final int currentposition = position;
        final Information infoData= data.get(position);
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Onclick called on position "+ position, Toast.LENGTH_SHORT).show();
             // addItem(currentposition,infoData);
                //Intent go_to_next= new Intent(MyCustomAdapter.this,);

                Intent intent= new Intent(context, NorthIndianCuisine.class);
                //intent.putExtra(name:"imagename", infoData.getImgname());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

        myViewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "Onlong clicked at position "+ position, Toast.LENGTH_SHORT).show();
                removeItem(infoData);
                return true;

            }
        });
    }

    private void removeItem(Information infoData) {
        int currPosition= data.indexOf(infoData);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    private void addItem(int position, Information infoData) {
        data.add(position,infoData);
        notifyItemInserted(position);

    }

    @Override
    public int getItemCount()//this returns the length of our dataset
    {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.tv);
            imageView=itemView.findViewById(R.id.img);
        }
    }
}
