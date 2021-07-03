package com.fti.apipikobar.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fti.apipikobar.R;
import com.fti.apipikobar.model.fasilitas_kesehatan.FasilitasKesehatanDataItem;

import java.util.ArrayList;

public class CovidFasilitasKesehatanAdapter extends RecyclerView.Adapter<CovidFasilitasKesehatanAdapter.ViewHolder> {

    private ArrayList<FasilitasKesehatanDataItem> fasilitasKesehatanDataItems = new ArrayList<>();

    private Context context;

    public CovidFasilitasKesehatanAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<FasilitasKesehatanDataItem> items){
        fasilitasKesehatanDataItems.clear();
        fasilitasKesehatanDataItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CovidFasilitasKesehatanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list_faskes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidFasilitasKesehatanAdapter.ViewHolder holder, int position) {
        FasilitasKesehatanDataItem item = fasilitasKesehatanDataItems.get(position);
        holder.tvNama.setText(item.getNama().toString());
        holder.tvAlamat.setText(item.getAlamat().toString());
        holder.btnMaps.setOnClickListener(v->{
            Uri gmIntentUri = Uri.parse(
                    "geo:"+ item.getLatitude() +
                     "," + item.getLongitude() +
                     "?q=" + item.getNama()
            );
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        });
    }

    @Override
    public int getItemCount() {
        return fasilitasKesehatanDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.itemlist_faskes_nama);
            tvAlamat =itemView.findViewById(R.id.itemlist_faskes_alamat);
            btnMaps = itemView.findViewById(R.id.itemlist_faskes_btnMaps);
            btnMaps.setBackgroundColor(Color.rgb(255,168gi,1));
        }
    }
}
