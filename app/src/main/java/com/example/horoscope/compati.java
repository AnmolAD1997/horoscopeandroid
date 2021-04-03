package com.example.horoscope;

import android.content.Intent;
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

public class compati extends Fragment {

private Spinner zodiac1,zodiac2;
    private String [] horos={"Aries","Tauras","Gemini","Cancer","Leo","Virgo","Libra","scorpio","Sagttarius","Capricon","Aquarius","Pisces"};
    private Button checkBtn;
    private String selected1,selected2;
    private TextView compatidata;

    ZodiacData zodiacData=new ZodiacData();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        return inflater.inflate(R.layout.compatibility,container,false);





    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        zodiac1=(Spinner)view.findViewById(R.id.zodiacChose);
        zodiac2=(Spinner)view.findViewById(R.id.zodiac2);
        checkBtn=(Button)view.findViewById(R.id.checkBtn);
        compatidata=(TextView)view.findViewById(R.id.zodiacProperty);

        List<String> zod1=new ArrayList<>();
        List<String> zod2=new ArrayList<>();

        for(int a=0;a<12;a++){
            zod1.add(a,horos[a]);
           zod2.add(a,horos[a]);
        }

        ArrayAdapter<String> dataAdapter;
        dataAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,zod1);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);





       zodiac1.setAdapter(dataAdapter);

       zodiac1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               if(parent.getItemAtPosition(position).equals("Choose Your Sign")){



               }else{


                   selected1=parent.getItemAtPosition(position).toString();

                   Toast.makeText(parent.getContext(),"You chose: "+selected1,Toast.LENGTH_SHORT).show();

               }

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {



           }
       });



        zodiac2.setAdapter(dataAdapter);

        zodiac2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals("Choose Your Sign")){




                }else{


                    selected2=parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(),"You chose: "+selected2,Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected1.equals(zodiac1.getSelectedItem())&&selected2.equals(zodiac2.getSelectedItem())){

                    compatidata.setText(zodiacData.Method(zodiac1.getSelectedItem(),zodiac2.getSelectedItem()));

                }


            }
        });








    }
}
