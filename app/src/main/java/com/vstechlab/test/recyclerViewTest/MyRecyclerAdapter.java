package com.vstechlab.test.recyclerViewTest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vstechlab.test.R;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    List<Contact> mContacts;

    Context mContext;

    public MyRecyclerAdapter(List<Contact> contacts, Context context) {
        if (contacts != null)
            mContacts = contacts;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Contact contact = mContacts.get(position);
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ContactDetailsActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.tvContact.setText(contact.getContact());
        holder.tvName.setText(contact.getName());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvContact;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvContact = (TextView) itemView.findViewById(R.id.tv_contact);
        }
    }
}
