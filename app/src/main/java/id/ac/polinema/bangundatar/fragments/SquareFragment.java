package id.ac.polinema.bangundatar.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import id.ac.polinema.bangundatar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SquareFragment extends Fragment {
    TextView sisi1, sisi2, jenisPersegi, outputPerhitungan, outputRumus;
    Button calculateLuas, calculateKeliling;

    public SquareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_square, container, false);
        jenisPersegi = view.findViewById(R.id.hasil_jenis_persegi);
        sisi1 = view.findViewById(R.id.sisi1_persegi);
        sisi2 = view.findViewById(R.id.sisi2_persegi);
        outputPerhitungan = view.findViewById(R.id.hasil_perhitungan_persegi);
        outputRumus = view.findViewById(R.id.hasil_rumus_persegi);
        calculateLuas = view.findViewById(R.id.calculate_luas_persegi);
        calculateKeliling = view.findViewById(R.id.calculate_keliling_persegi);

        calculateLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sisisatu = Double.valueOf(sisi1.getText().toString());
                double sisidua = Double.valueOf(sisi2.getText().toString());
                double hasil = 0;

                if (sisisatu == sisidua) {
                    jenisPersegi.setText("Persegi (segi empat)");
                    hasil = sisisatu * sisidua;
                    outputPerhitungan.setText(String.valueOf(hasil));
                    outputRumus.setText("Sisi kali sisi");
                } else {
                    jenisPersegi.setText("Persegi panjang");
                    hasil = sisisatu * sisidua;
                    outputPerhitungan.setText(String.valueOf(hasil));
                    outputRumus.setText("Panjang kali lebar");
                }
            }
        });

        calculateKeliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sisisatu = Double.valueOf(sisi1.getText().toString());
                double sisidua = Double.valueOf(sisi2.getText().toString());
                double hasil = 0;

                if (sisisatu == sisidua){
                    jenisPersegi.setText("Persegi (segi empat)");
                    hasil = sisisatu * 4;
                    outputPerhitungan.setText(String.valueOf(hasil));
                    outputRumus.setText("Tambahkan semua sisi (atau) sisi kali 4");
                } else {
                    jenisPersegi.setText("Persegi panjang");
                    hasil = (sisisatu * 2) + (sisidua * 2);
                    outputPerhitungan.setText(String.valueOf(hasil));
                    outputRumus.setText("Panjang kali 2 ditambah lebar kali 2");
                }
            }
        });
        return view;
    }

}
