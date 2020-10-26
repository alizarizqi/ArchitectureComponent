package com.architecturecomponent.aliza;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.architecturecomponent.aliza.databinding.FragmentInputBinding;
import com.architecturecomponent.aliza.viewModel.DetailViewModel;
import com.architecturecomponent.aliza.viewModel.viewModel;


public class InputFragment extends Fragment {

private viewModel vm;
    FragmentInputBinding binding;
    Bundle bundle;
    private String jumlah;

    public void setJumlah(String jumlah){
        this.jumlah = jumlah;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater,container,false);
        View view =binding.getRoot();

        binding.btnTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("nama", binding.spinnerNama.getSelectedItem().toString());
                if(binding.radioCash.isChecked()){
                    bundle.putString("metode", "Cash");
                }
                else{
                    bundle.putString("metode", "Debit");
                }

                bundle.putString("jumlah", binding.editJmlBrg.getText().toString());
                bundle.putString("harga", binding.editHargaBrg.getText().toString());
                bundle.putString("total", binding.txtTotal.getText().toString());
                bundle.putString("bayar", binding.editBayar.getText().toString());
                bundle.putString("kembalian", binding.txtKembalian.getText().toString());
                bundle.putString("bank", binding.spinnerBank.getSelectedItem().toString());

                Navigation.findNavController(view).navigate(R.id.action_inputFragment_to_detailFragment,bundle);
            }
        });

        binding.btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hrgBrg;
                double total;
                double jmlBrg = Double.parseDouble(binding.editJmlBrg.getText().toString());
                hrgBrg = Double.parseDouble(binding.editHargaBrg.getText().toString());
                total = jmlBrg*hrgBrg;
                binding.txtTotal.setText(String.valueOf(total));

            }
        });

        binding.btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bayar;
                double tt;
                bayar = Double.parseDouble(binding.editBayar.getText().toString());
                tt = Double.parseDouble(binding.txtTotal.getText().toString());
                double kembalian = bayar-tt;
                binding.txtKembalian.setText(String.valueOf(kembalian));

            }
        });






        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        vm = ViewModelProviders.of(this).get(viewModel.class);
//        // TODO: Use the ViewModel
//
//    }
}