package com.fti.apipikobar.service;

import com.fti.apipikobar.model.fasilitas_kesehatan.FasilitasKesehatanResponse;
import com.fti.apipikobar.model.kasus_harian.KasusHarianResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidRepository {
    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<KasusHarianResponse> getCovidHarian();

    @GET("sebaran_v2/jabar/faskes")
    Call<FasilitasKesehatanResponse> getCovidFaskes();
}
