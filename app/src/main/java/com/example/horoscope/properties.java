package com.example.horoscope;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class properties extends Fragment {

    private Spinner zodiac;
    private String[] horos = {"Aries", "Tauras", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "scorpio", "Sagttarius", "Capricon", "Aquarius", "Pisces",};
    private Button checkBtn;
    private TextView zodiacName, zodiacProperty;
    private String selected;
    private int itemPos;


    ZodiacData zodiacData = new ZodiacData();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.properties, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        zodiac = (Spinner) view.findViewById(R.id.zodiacChose);
        checkBtn = (Button) view.findViewById(R.id.checkBtn);
        zodiacName = (TextView) view.findViewById(R.id.zodiacName);
        zodiacProperty = (TextView) view.findViewById(R.id.zodiacProperty);

        zodiacName.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        List<String> zod = new ArrayList<>();


        for (int a = 0; a < 12; a++) {
            zod.add(a, horos[a]);

        }

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, zod);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        zodiac.setAdapter(dataAdapter);

        zodiac.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Your Sign")) {

                    checkBtn.setClickable(false);

                } else {

                    checkBtn.setClickable(true);
                    selected = parent.getItemAtPosition(position).toString();
            itemPos=position;

                    Toast.makeText(parent.getContext(), "You chose: " + selected, Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String collectedDate=zodiacData.getDate(itemPos);
                //Toast.makeText(getActivity(), collectedDate, Toast.LENGTH_SHORT).show();
                zodiacName.setText(collectedDate);

                String collectedInfo=zodiacData.getInfo(itemPos);
                zodiacProperty.setText(collectedInfo);



            }
        });


    }
}
