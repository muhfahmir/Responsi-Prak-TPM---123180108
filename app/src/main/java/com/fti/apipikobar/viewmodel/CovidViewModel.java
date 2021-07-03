package com.fti.apipikobar.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fti.apipikobar.model.fasilitas_kesehatan.FasilitasKesehatanDataItem;
import com.fti.apipikobar.model.fasilitas_kesehatan.FasilitasKesehatanResponse;
import com.fti.apipikobar.model.kasus_harian.KasusHarianContentItem;
import com.fti.apipikobar.model.kasus_harian.KasusHarianResponse;
import com.fti.apipikobar.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidViewModel extends ViewModel {
    private ApiMain apiMain;

//  getCovidHarian
    private MutableLiveData<ArrayList<KasusHarianContentItem>> listKasusHarianCovid = new MutableLiveData<>();

    public void setCovidKasusHarian(){
        if (this.apiMain == null){
            this.apiMain = new ApiMain();
        }

        apiMain.getApiCovid().getCovidHarian().enqueue(new Callback<KasusHarianResponse>() {
            @Override
            public void onResponse(Call<KasusHarianResponse> call, Response<KasusHarianResponse> response) {
                KasusHarianResponse responseKasusHarian = response.body();
                if (responseKasusHarian != null && responseKasusHarian.getData().getContent() != null){
                    ArrayList<KasusHarianContentItem> kasusHarianContentItems = responseKasusHarian.getData().getContent();
                    listKasusHarianCovid.postValue(kasusHarianContentItems);
                }
            }

            @Override
            public void onFailure(Call<KasusHarianResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<KasusHarianContentItem>> getCovidHarian(){
        return listKasusHarianCovid;
    }
//    end getCovidHarian

//    getFasilitasKesehatan
    private MutableLiveData<ArrayList<FasilitasKesehatanDataItem>> listFasilitasKesehatanCovid = new MutableLiveData<>();

    public void setCovidFasilitasKesehatan(){
        if(this.apiMain == null){
            this.apiMain = new ApiMain();
        }

        apiMain.getApiCovid().getCovidFaskes().enqueue(new Callback<FasilitasKesehatanResponse>() {
            @Override
            public void onResponse(Call<FasilitasKesehatanResponse> call, Response<FasilitasKesehatanResponse> response) {
                FasilitasKesehatanResponse responseFasilitasKesehatan = response.body();
                if (responseFasilitasKesehatan != null && responseFasilitasKesehatan.getData() != null){
                    ArrayList<FasilitasKesehatanDataItem> fasilitasKesehatanDataItems = responseFasilitasKesehatan.getData();
                    listFasilitasKesehatanCovid.postValue(fasilitasKesehatanDataItems);
                }
            }

            @Override
            public void onFailure(Call<FasilitasKesehatanResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<FasilitasKesehatanDataItem>> getFasilitasKesehatan(){
        return listFasilitasKesehatanCovid;
    }
//    end getFasilitasKesehatan
}
