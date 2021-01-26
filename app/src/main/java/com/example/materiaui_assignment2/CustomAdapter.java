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
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.PersonViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<Person> mPerson;

    public CustomAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.next_screen, parent, false);
        PersonViewHolder viewHolder = new PersonViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        if(mPerson!=null){
            Person person = mPerson.get(position);
            holder.setData(person.getName(), position);
        } else {
            holder.personTextView.setText(R.string.app_name);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{
        private TextView personTextView;
        private int mPosition;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            personTextView = itemView.findViewById(R.id.textView);
        }

        public void setData(String name, int position) {
            personTextView.setText(name);
            mPosition = position;
        }
    }
}
