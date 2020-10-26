package com.architecturecomponent.aliza.viewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.architecturecomponent.aliza.models.Kasir;

public class viewModel extends ViewModel{
    public MutableLiveData<Double> totalHargaMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Double> kembalianMutableLiveData = new MutableLiveData<>();
    public Kasir kasir = new Kasir();
    public LiveData<Double> getTotalHargaMutableLiveData() {
        return totalHargaMutableLiveData;
    }
    public LiveData<Double> getKembalianMutableLiveData(){return kembalianMutableLiveData;}

//    public void totalHarga(){
//        double hrgBrg;
//        double total;
//        double jmlBrg = Double.parseDouble(kasir.setJumlahBarang(kasir.getJumlahBarang()));
//        hrgBrg = Double.parseDouble(kasir.setHargaBarang(kasir.getHargaBarang()));
//        total = jmlBrg*hrgBrg;
//        kasir.setTotal(String.valueOf(total));
//    }
//    public void kembalian(){
//        double bayar = Double.parseDouble(kasir.setBayar(kasir.getBayar()));
//        double tt = Double.parseDouble(kasir.getTotal());
//        double kembalian = bayar-tt;
//        kasir.setKembalian(String.valueOf(kembalian));
//
//    }
    public void calculateTotal(int jumlahBuku, int harga) {
    totalHargaMutableLiveData.setValue((double) jumlahBuku * (double) harga);
}

    public void kembalian(int bayar, int total){
        kembalianMutableLiveData.setValue((double) bayar - (double) total);
    }

}
