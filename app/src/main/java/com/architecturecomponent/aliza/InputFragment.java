package com.architecturecomponent.aliza;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.architecturecomponent.aliza.databinding.FragmentInputBinding;
import com.architecturecomponent.aliza.models.Kasir;
import com.architecturecomponent.aliza.viewModel.DetailViewModel;
import com.architecturecomponent.aliza.viewModel.viewModel;


public class InputFragment extends Fragment {

private viewModel vm;

    Bundle bundle;
    public Kasir kasir;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final FragmentInputBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_input, container,false);
        vm = new ViewModelProvider(this).get(viewModel.class);
        binding.setKasir(kasir);
        binding.setViewModelPenjualan(vm);
        binding.setLifecycleOwner(this);
        kasir = new Kasir();


        binding.btnTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                kasir.setNamaBarang(binding.spinnerNama.getSelectedItem().toString());
                kasir.setHargaBarang(binding.editHargaBrg.getText().toString());
                kasir.setJumlahBarang(binding.editJmlBrg.getText().toString());
                kasir.setBayar(binding.editBayar.getText().toString());
                kasir.setKembalian(binding.txtKembalian.getText().toString());
                kasir.setTotal(binding.txtTotal.getText().toString());
                kasir.setBank(binding.spinnerBank.getSelectedItem().toString());

                bundle.putParcelable("kasir",kasir);
                Navigation.findNavController(view).navigate(R.id.action_inputFragment_to_detailFragment,bundle);
            }
        });

        binding.radioCash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    kasir.setMetodeBayar("Cash");
                }
            }
        });
        binding.radioDebit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    kasir.setMetodeBayar("Debit");
                }
            }
        });

//        binding.btnTotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double hrgBrg;
//                double total;
//                double jmlBrg = Double.parseDouble(binding.editJmlBrg.getText().toString());
//                hrgBrg = Double.parseDouble(binding.editHargaBrg.getText().toString());
//                total = jmlBrg*hrgBrg;
//                binding.txtTotal.setText(String.valueOf(total));
//
//            }
//        });
//
//        binding.btnHasil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double bayar;
//                double tt;
//                bayar = Double.parseDouble(binding.editBayar.getText().toString());
//                tt = Double.parseDouble(binding.txtTotal.getText().toString());
//                double kembalian = bayar-tt;
//                binding.txtKembalian.setText(String.valueOf(kembalian));
//
//            }
//        });
        binding.btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.totalHarga(Integer.parseInt(kasir.getJumlahBarang()), Integer.parseInt(kasir.getHargaBarang()));

            }
        });

        binding.btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.kembalian(Integer.parseInt(kasir.getBayar()), Integer.parseInt(kasir.getTotal()));

            }
        });






        return binding.getRoot();
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        vm = ViewModelProviders.of(this).get(viewModel.class);
//        // TODO: Use the ViewModel
//
//    }
}