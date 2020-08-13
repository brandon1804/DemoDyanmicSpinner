package sg.edu.rp.c346.id18044455.demodyanmicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Button btnU;
    Spinner spn2;
    ArrayList<String>alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        btnU = findViewById(R.id.btnUpdate);
        spn2 = findViewById(R.id.spinner2);

        alNumbers= new ArrayList<>();
        /*
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");
         */


        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        alNumbers.clear();
                        String[] strENumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strENumbers));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(2);
                        aaNumbers.notifyDataSetChanged();
                        break;
                    case 1:
                        alNumbers.clear();
                        String[] strONumbers = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strONumbers));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(1);
                        aaNumbers.notifyDataSetChanged();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });








        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if(pos == 0){
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else{
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }

                spn2.setAdapter(aaNumbers);
            }
        });






    }//end of onCreate()



}//end of class