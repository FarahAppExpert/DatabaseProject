package com.example.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.entities.Person;

import java.util.List;

public class PersonalAdaptor extends RecyclerView.Adapter<PersonalAdaptor.ViewHolder> {

    private List<Person> PersonListAdaptor;
    private Context context;

    public PersonalAdaptor(Context context) {
        this.context = context;
    }




    public void setPersonDataInAdapter(List<Person> mPersonList) {
        PersonListAdaptor = mPersonList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonalAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalAdaptor.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Name;
        TextView Email;
        TextView Phone;
        ImageView Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.nametext);
            Email = itemView.findViewById(R.id.emailtext);
            Phone = itemView.findViewById(R.id.phonetext);
            Image = itemView.findViewById(R.id.image_List);
        }
    }
}

