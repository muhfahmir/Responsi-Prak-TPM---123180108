package com.fti.apipikobar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fti.apipikobar.R;
import com.fti.apipikobar.model.kasus_harian.KasusHarianContentItem;

import java.util.ArrayList;

public class CovidKasusHarianAdapter extends RecyclerView.Adapter<CovidKasusHarianAdapter.ViewHolder> {

    private ArrayList<KasusHarianContentItem> kasusHarianContentItems = new ArrayList<>();

    public CovidKasusHarianAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<KasusHarianContentItem> items){
        kasusHarianContentItems.clear();
        kasusHarianContentItems.addAll(items);
        notifyDataSetChanged();
    }

    private Context context;

    @NonNull
    @Override
    public CovidKasusHarianAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list_harian,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidKasusHarianAdapter.ViewHolder holder, int position) {
        KasusHarianContentItem item = kasusHarianContentItems.get(position);
        holder.tvTanggal.setText(item.getTanggal());
        holder.tvKonfirmasi.setText("Terkonfirmasi     "+item.getConfirmationDiisolasi()+" kasus");
        holder.tvSembuh.setText("Sembuh     "+item.getConfirmationSelesai());
        holder.tvMeninggal.setText("Meninggal     "+item.getConfirmationMeninggal()+" kasus");
    }

    @Override
    public int getItemCount() {
        return kasusHarianContentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal,
                tvKonfirmasi,
                tvSembuh,
                tvMeninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.itemlist_harian_tv_tanggal);
            tvKonfirmasi = itemView.findViewById(R.id.itemlist_harian_tv_konfirmasi);
            tvSembuh = itemView.findViewById(R.id.itemlist_harian_tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.itemlist_harian_tv_meninggal);
        }
    }
}
