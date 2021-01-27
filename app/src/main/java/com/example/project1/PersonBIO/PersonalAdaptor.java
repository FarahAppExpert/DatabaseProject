package com.example.project1.PersonBIO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.DatabaseListView;
import com.example.project1.R;
import com.example.project1.entities.Person;

import java.util.List;

public class PersonalAdaptor extends RecyclerView.Adapter<PersonalAdaptor.MyViewHolder>
{

    private List<Person> PersonListAdaptor;
    private Context context;

    public PersonalAdaptor (Context context)
    {
       this.context = context;
    }



    @NonNull
   @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup GroupParent, int ViewTypeParent)
   {
       View viewHolder = LayoutInflater.from(context).inflate(R.layout.person_list_raw, GroupParent, false);
       return new MyViewHolder(viewHolder);
   }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(PersonListAdaptor.get(position).getName());
        holder.email.setText(PersonListAdaptor.get(position).getEmail());
        holder.phone.setText(PersonListAdaptor.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        if(PersonListAdaptor==null) {
            return 0;
        }
        return PersonListAdaptor.size() ;
    }

    public void setPersonDataInAdapter(List<Person> mPersonList) {
        PersonListAdaptor = mPersonList;
        notifyDataSetChanged();
    }

    /**
     * Caching view references== row
     */
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, email, phone;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            phone = itemView.findViewById(R.id.tvPhone);
            image = itemView.findViewById(R.id.imgView);

        }
    }
}

    @NonNull
    @Override
    public PersonalAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalAdaptor.MyViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }
}
