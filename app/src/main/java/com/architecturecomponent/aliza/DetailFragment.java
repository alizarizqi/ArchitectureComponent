package com.architecturecomponent.aliza;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.architecturecomponent.aliza.databinding.DetailFragmentBinding;

import com.architecturecomponent.aliza.models.Kasir;
import com.architecturecomponent.aliza.viewModel.DetailViewModel;
import com.architecturecomponent.aliza.viewModel.viewModel;

public class DetailFragment extends Fragment {

    private viewModel vm;
    DetailFragmentBinding binding;

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false);
        vm = new ViewModelProvider(this).get(viewModel.class);
        Kasir kasir =requireArguments().getParcelable("kasir");
        binding.setViewModelPenjualan(vm);
        binding.setLifecycleOwner(this);


//        binding.txtnama.setText(getArguments().getString("nama"));
//        binding.txtprovinsi.setText(getArguments().getString("jumlah"));
//        binding.txttelpRumah.setText(getArguments().getString("harga"));
//        binding.txthp.setText(getArguments().getString("total"));
//        binding.textView3.setText(getArguments().getString("metode"));
//        binding.txtbayar.setText(getArguments().getString("bayar"));
//        binding.textView10.setText(getArguments().getString("kembalian"));
//        binding.textView12.setText(getArguments().getString("bank"));



        return binding.getRoot();
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
//        // TODO: Use the ViewModel
//    }

}