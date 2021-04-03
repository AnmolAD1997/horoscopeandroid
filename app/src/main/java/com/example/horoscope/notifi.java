package com.example.horoscope;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;

public class notifi extends Fragment {

    private Switch aSwitch;
    static private Spinner hour, minute, second;
    static int value = 0;
    static int hello;
    static int hello1;
    static int hello2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.notification, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        aSwitch = (Switch) view.findViewById(R.id.switchBtn);
        hour = view.findViewById(R.id.hour);
        minute = view.findViewById(R.id.minute);
        second = view.findViewById(R.id.second);


        List<Integer> hour1 = new ArrayList<>();
        List<Integer> minute1 = new ArrayList<>();
        List<Integer> second1 = new ArrayList<>();

        hour1.add(0,hello);
        minute1.add(0,hello1);
        second1.add(0,hello2);


        for (int a = 0; a < 24; a++) {
            hour1.add(a+1, a);
        }

        for (int a = 0; a < 60; a++) {
            minute1.add(a+1, a);
            second1.add(a+1, a);
        }

        ArrayAdapter<String> dataAdapter;
        ArrayAdapter<String> dataAdapter1;
        ArrayAdapter<String> dataAdapter2;
        dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, hour1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dataAdapter1 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, minute1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dataAdapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, second1);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        hour.setAdapter(dataAdapter);
        minute.setAdapter(dataAdapter1);
        second.setAdapter(dataAdapter2);



        if (value == 0) {
            aSwitch.setChecked(false);
        } else {

            aSwitch.setChecked(true);
        }



        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (value == 0) {
                    value = 1;
                } else {
                    value = 0;
                }

                hello = (int) hour.getSelectedItem();
               hello1 = (int) minute.getSelectedItem();
               hello2 = (int) second.getSelectedItem();
                Toast.makeText(getActivity(), "Notification Set For " + hello + " Hour " + hello1 + " Minutes and " + hello2 + " Seconds", Toast.LENGTH_SHORT).show();
            }


        });
/*

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {






                    Calendar calendar=Calendar.getInstance();


                    calendar.set(Calendar.HOUR_OF_DAY,00);
                    calendar.set(Calendar.MINUTE,27);
                    calendar.set(Calendar.SECOND,10);

                    Intent intent=new Intent(getActivity().getApplicationContext(),Notification_receiver.class);
                    intent.setAction("Message");
                    PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity().getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);



            }
        });


*/
    }


}
