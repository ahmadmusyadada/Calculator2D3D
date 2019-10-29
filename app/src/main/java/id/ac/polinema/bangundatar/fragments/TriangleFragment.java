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
public class TriangleFragment extends Fragment {
    TextView sisi1, sisi2, alas, jenisSegitiga, outputPerhitungan, outputRumus;
    Button calculateLuas, calculateKeliling;

    public TriangleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_triangle, container, false);
        jenisSegitiga = view.findViewById(R.id.hasil_jenis_segititga);
        sisi1 = view.findViewById(R.id.sisi1);
        sisi2 = view.findViewById(R.id.sisi2);
        alas = view.findViewById(R.id.sisi3);
        outputPerhitungan = view.findViewById(R.id.hasil_perhitungan);
        outputRumus = view.findViewById(R.id.hasil_rumus);
        calculateLuas = view.findViewById(R.id.calculate_luas);
        calculateKeliling = view.findViewById(R.id.calculate_keliling);

        calculateLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sisisatu = Double.valueOf(sisi1.getText().toString());
                double sisidua = Double.valueOf(sisi2.getText().toString());
                double alassegitiga = Double.valueOf(alas.getText().toString());
                double hasil = 0;

                if (alassegitiga == sisisatu && alassegitiga == sisidua){
                    jenisSegitiga.setText("Segitiga sama sisi");
                    hasil = (Math.pow(sisisatu, 2) / 4) * Math.sqrt(3);
                    outputPerhitungan.setText(String.valueOf(hasil));
                    outputRumus.setText("Alas pangkat 2, dibagi 4, dikali akar 3");
                } else if (sisisatu == sisidua){
                    jenisSegitiga.setText("Segitiga sama kaki");
                    double tinggi = Math.pow(sisidua, 2) - Math.pow(alassegitiga/2, 2);
                    hasil = alassegitiga * tinggi;
                    outputPerhitungan.setText(String.valueOf(hasil));
                    outputRumus.setText("Alas x Tinggi");
                } else {
                    jenisSegitiga.setText("Segitiga sembarang");
                    double s = 0.5 * (sisisatu + sisidua + alassegitiga);
                    hasil = Math.sqrt(s * (s - sisisatu) * (s - sisidua) * (s - alassegitiga));
                    outputPerhitungan.setText(String.valueOf(hasil));
                    outputRumus.setText("Akar s(s - s1)(s - s2)(s - a)");
                }
            }
        });

        calculateKeliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sisisatu = Double.valueOf(sisi1.getText().toString());
                double sisidua = Double.valueOf(sisi2.getText().toString());
                double alassegitiga = Double.valueOf(alas.getText().toString());
                double hasil = 0;

                if (alassegitiga == sisisatu && alassegitiga == sisidua){
                    jenisSegitiga.setText("Segitiga sama sisi");
                } else if (sisisatu == sisidua){
                    jenisSegitiga.setText("Segitiga sama kaki");
                } else {
                    jenisSegitiga.setText("Segitiga sembarang");
                }

                hasil = sisisatu + sisidua + alassegitiga;
                outputPerhitungan.setText(String.valueOf(hasil));
                outputRumus.setText("Tambahkan semua sisi");
            }
        });
        return view;
    }
}
