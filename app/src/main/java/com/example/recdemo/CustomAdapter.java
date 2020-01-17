package com.example.recdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    Context context;
    ArrayList<DataPojo> mylst;
    String value = "";
    private class VIEW_TYPES
    {
        public static final int HEADER = 1;
        public static final int NORMAL = 2;
        public static final int FOOTER = 3;
    }

    public CustomAdapter(Context context, ArrayList<DataPojo> mylst)
    {
        this.context = context;
        this.mylst = mylst;
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;

        switch (viewType)
        {
            case VIEW_TYPES.NORMAL:
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_layout, parent, false);
                break;
            case VIEW_TYPES.HEADER:
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
                break;
            case VIEW_TYPES.FOOTER:
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_layout, parent, false);
                break;
            default:
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_layout, parent, false);
                break;

        }
        return new MyViewHolder(rootView);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent, tvHeader, tvFooter;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = (TextView)itemView.findViewById(R.id.tvHeader);
            tvContent = (TextView)itemView.findViewById(R.id.tvContent);
            tvFooter = (TextView)itemView.findViewById(R.id.tvFooter);

        }
    }
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType)
        {
            case VIEW_TYPES.HEADER:
                Log.i("My Header = ","called");
                holder.tvHeader.setText("Content = My Header....");
                break;
            case VIEW_TYPES.NORMAL:
                Log.i("My Content = ","called");
                DataPojo dp = mylst.get(position);
                holder.tvContent.setText("Content = Name="+dp.getName()+"Dept="+dp.getDept()+",Salary="+dp.getSalary());
                break;
            case VIEW_TYPES.FOOTER:
                Log.i("My Footer = ","called");
                holder.tvFooter.setText("Content = My Footer....");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mylst.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(mylst.get(position).isHeader)
        {
            return VIEW_TYPES.HEADER;
        }
        else if(mylst.get(position).isFooter)
        {
            return VIEW_TYPES.FOOTER;
        }
        else
        {
            return VIEW_TYPES.NORMAL;
        }

    }

    
}
