package com.example.sqlite_pract;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter <ClientAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView rfc, nombre, tel, correo;

        public ViewHolder(View itemView) {
            super(itemView);
            rfc = (TextView) itemView.findViewById(R.id.idRfc);
            nombre = (TextView) itemView.findViewById(R.id.idNombre);
            tel = (TextView) itemView.findViewById(R.id.idTel);
            correo = (TextView) itemView.findViewById(R.id.idCorreo);
        }
    }

    public List<ClientModel> clientsList ;

    public ClientAdapter(List<ClientModel> clientsList) {
        this.clientsList = clientsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_client, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.rfc.setText(clientsList.get(position).getRfc());
        holder.nombre.setText(clientsList.get(position).getNombre());
        holder.tel.setText(clientsList.get(position).getTel());
        holder.correo.setText(clientsList.get(position).getCorreo());
    }

    @Override
    public int getItemCount() {
        return clientsList.size();
    }
}
