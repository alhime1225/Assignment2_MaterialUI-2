package com.example.materiaui_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materiaui_assignment2.model.Person;

import java.util.List;

//TODO 1. Extend RecylerView.Adapter
//Viewholder is for caching purpose
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {
    private List<Person> mPersonList;
    private Context mContext;
    public PersonAdapter(Context context){
        this.mContext = context;
    }

    //TODO 3. Overide adapter methods : onCreateViewHolder, onBindViewHolder, getItemCount
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_person, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mPersonList.get(position).getName());
        holder.email.setText(mPersonList.get(position).getEmail());
        holder.phone.setText(mPersonList.get(position).getPhone());
    }

    //TODO 5. Inflating the row
    @Override
    public int getItemCount() {
        //specifies how many values is going to be displayed
        if(mPersonList == null)
        {
           return 0;
        }
        return mPersonList.size();
    }

    public void setPersonDataInAdapter(List<Person> personList) {
        mPersonList = personList;
        notifyDataSetChanged();
    }

    //TODO 2. Create a viewholder inner class. Make sure you create a constructor since there is no default constructor
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, email, phone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //TODO 4. Finishing the viewholder implementation
            name = itemView.findViewById(R.id.txtViewName);
            email = itemView.findViewById(R.id.txtViewEmail);
            phone = itemView.findViewById(R.id.txtViewPhone);
        }
    }
}
