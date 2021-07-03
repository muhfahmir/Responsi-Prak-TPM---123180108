package com.fti.apipikobar.view.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fti.apipikobar.R;
import com.fti.apipikobar.adapter.CovidFasilitasKesehatanAdapter;
import com.fti.apipikobar.model.fasilitas_kesehatan.FasilitasKesehatanDataItem;
import com.fti.apipikobar.viewmodel.CovidViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FasilitasKesehatanFragment} factory method to
 * create an instance of this fragment.
 */
public class FasilitasKesehatanFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public FasilitasKesehatanFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment FasilitasKesehatanFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static FasilitasKesehatanFragment newInstance(String param1, String param2) {
//        FasilitasKesehatanFragment fragment = new FasilitasKesehatanFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    private CovidFasilitasKesehatanAdapter covidFasilitasKesehatanAdapter;
    private RecyclerView rvCovidFasilitas;
    private CovidViewModel covidViewModel;
    private CardView cvItem;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fasilitas_kesehatan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setTitle("Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Try Fetching Data");
        progressDialog.show();

        covidFasilitasKesehatanAdapter = new CovidFasilitasKesehatanAdapter(getContext());
        covidFasilitasKesehatanAdapter.notifyDataSetChanged();

        rvCovidFasilitas = view.findViewById(R.id.fragmentFasilitasKesehatan_rv);
        rvCovidFasilitas.setLayoutManager(new LinearLayoutManager(getActivity()));

        covidViewModel = new ViewModelProvider(this).get(CovidViewModel.class);
        covidViewModel.setCovidFasilitasKesehatan();
        covidViewModel.getFasilitasKesehatan().observe(this,getFasilitasKesehatan);

        rvCovidFasilitas.setAdapter(covidFasilitasKesehatanAdapter);

    }

    private Observer<ArrayList<FasilitasKesehatanDataItem>> getFasilitasKesehatan = new Observer<ArrayList<FasilitasKesehatanDataItem>>() {
        @Override
        public void onChanged(ArrayList<FasilitasKesehatanDataItem> fasilitasKesehatanDataItems) {
            if (fasilitasKesehatanDataItems != null){
                covidFasilitasKesehatanAdapter.setData(fasilitasKesehatanDataItems);
                progressDialog.hide();
            }
        }
    };
}