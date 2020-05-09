package com.uc.portocashier.directory;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uc.portocashier.R;
import com.uc.portocashier.model.User;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.CardViewHolder> {

    private Context context;

    private ArrayList<User> listUser;

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public AdapterUser(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterUser.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_user, parent, false);
        return new AdapterUser.CardViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final AdapterUser.CardViewHolder holder, int position) {
        final User u = getListUser().get(position);
        holder.txt_name.setText(u.getNama());
        holder.txt_age.setText(" Harga: "+u.getUmur());
        holder.txt_address.setText(" Pembayaran:"+u.getAlamat());
    }

    @Override
    public int getItemCount() {
        return getListUser().size();
    }

     public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name, txt_age, txt_address;
         public CardViewHolder(View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.display_name);
            txt_age = itemView.findViewById(R.id.display_age);
            txt_address = itemView.findViewById(R.id.display_address);
        }
    }
}
