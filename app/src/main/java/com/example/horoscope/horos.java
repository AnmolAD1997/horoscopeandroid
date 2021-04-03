package com.example.horoscope;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import bot.box.horology.annotation.DURATION;
import bot.box.horology.annotation.SUNSIGN;
import bot.box.horology.api.Horoscope;
import bot.box.horology.delegate.Response;
import bot.box.horology.hanshake.HorologyController;
import bot.box.horology.pojo.Zodiac;

import static bot.box.horology.annotation.DURATION.time;

public class horos extends Fragment {

    private LinearLayout layoutAries, layoutTaurus, layoutGemini, layoutCancer, layoutLeo, layoutVirgo, layoutLibra,
            layoutScorpio, layoutSagittarius, layoutCapricorn, layoutAquarius, layoutPisces;

        String values;
        String date;


    ZodiacData zodiacData = new ZodiacData();







    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.horoscopepage, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutAries = (LinearLayout) view.findViewById(R.id.layoutAries);
        layoutAries.setOnClickListener(onClickListener);
        layoutTaurus = (LinearLayout) view.findViewById(R.id.layoutTaurus);
        layoutTaurus.setOnClickListener(onClickListener);
        layoutGemini = (LinearLayout) view.findViewById(R.id.layoutGemini);
        layoutGemini.setOnClickListener(onClickListener);
        layoutCancer = (LinearLayout) view.findViewById(R.id.layoutCancer);
        layoutCancer.setOnClickListener(onClickListener);
        layoutLeo = (LinearLayout) view.findViewById(R.id.layoutLeo);
        layoutLeo.setOnClickListener(onClickListener);
        layoutVirgo = (LinearLayout) view.findViewById(R.id.layoutVirgo);
        layoutVirgo.setOnClickListener(onClickListener);
        layoutLibra = (LinearLayout) view.findViewById(R.id.layoutLibra);
        layoutLibra.setOnClickListener(onClickListener);
        layoutScorpio = (LinearLayout) view.findViewById(R.id.layoutScorpio);
        layoutScorpio.setOnClickListener(onClickListener);
        layoutSagittarius = (LinearLayout) view.findViewById(R.id.layoutSagittarius);
        layoutSagittarius.setOnClickListener(onClickListener);
        layoutCapricorn = (LinearLayout) view.findViewById(R.id.layoutCapricorn);
        layoutCapricorn.setOnClickListener(onClickListener);
        layoutAquarius = (LinearLayout) view.findViewById(R.id.layoutAquarius);
        layoutAquarius.setOnClickListener(onClickListener);
        layoutPisces = (LinearLayout) view.findViewById(R.id.layoutPisces);
        layoutPisces.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.layoutAries:


                            Horoscope hAries = new Horoscope.Zodiac(getActivity()).showLoader(true)
                                    .requestSunSign(SUNSIGN.ARIES).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                            HorologyController cAries = new HorologyController(new Response() {
                                @Override
                                public void onResponseObtained(Zodiac zodiac) {

                                    showHoroscopeDialog(zodiac, true, "");
                                }

                                @Override
                                public void onErrorObtained(String errormsg) {
                                    showHoroscopeDialog(null, false, errormsg);
                                }
                            });


                            cAries.requestConstellations(hAries);



                    break;

                case R.id.layoutTaurus:
                    Horoscope hTaurus = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.TAURUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cTaurus = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cTaurus.requestConstellations(hTaurus);
                    break;


                case R.id.layoutGemini:
                    Horoscope hGemini = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.GEMINI).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cGemini = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cGemini.requestConstellations(hGemini);
                    break;


                case R.id.layoutCancer:
                    Horoscope hCancer = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.CANCER).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cCancer = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cCancer.requestConstellations(hCancer);
                    break;


                case R.id.layoutLeo:
                    Horoscope hLeo = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.LEO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cLeo = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cLeo.requestConstellations(hLeo);
                    break;


                case R.id.layoutVirgo:
                    Horoscope hVirgo = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.VIRGO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cVirgo = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cVirgo.requestConstellations(hVirgo);
                    break;


                case R.id.layoutLibra:
                    Horoscope hLibra = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.LIBRA).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cLibra = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cLibra.requestConstellations(hLibra);
                    break;


                case R.id.layoutScorpio:
                    Horoscope hScorpio = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.SCORPIO).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cScorpio = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cScorpio.requestConstellations(hScorpio);
                    break;


                case R.id.layoutSagittarius:
                    Horoscope hSagittarius = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.SAGITTARIUS).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cSagittarius = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cSagittarius.requestConstellations(hSagittarius);
                    break;


                case R.id.layoutCapricorn:
                    Horoscope hCapricorn = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.CAPRICORN).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cCapricorn = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cCapricorn.requestConstellations(hCapricorn);
                    break;


                case R.id.layoutAquarius:
                    Horoscope hAquarius = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.AQUARIUS).requestDuration(DURATION.TODAY).
                                    isDebuggable(true).fetchHoroscope();
                    HorologyController cAquarius = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cAquarius.requestConstellations(hAquarius);
                    break;


                case R.id.layoutPisces:
                    Horoscope hPisces = new Horoscope.Zodiac(getActivity()).showLoader(true)
                            .requestSunSign(SUNSIGN.PISCES).requestDuration(DURATION.TODAY).isDebuggable(true).fetchHoroscope();
                    HorologyController cPisces = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            showHoroscopeDialog(zodiac, true, "");
                        }

                        @Override
                        public void onErrorObtained(String errormsg) {
                            showHoroscopeDialog(null, false, errormsg);
                        }
                    });
                    cPisces.requestConstellations(hPisces);
                    break;

            }
        }
    };

    private void showHoroscopeDialog(Zodiac z, boolean isSuccsess, String errormsg) {

        values = z.getHoroscope();
            date=z.getDate();

        zodiacData.setValue(values);
        zodiacData.setDate(date);


        Intent slidingScreen = new Intent(getActivity(), SlideActivity.class);
        startActivity(slidingScreen);
                /*


               final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.custom_dialog);

                TextView title = (TextView) dialog.findViewById(R.id.title);
                TextView date = (TextView) dialog.findViewById(R.id.date);
                TextView body = (TextView) dialog.findViewById(R.id.body);

                if (isSuccsess) {
                    title.setText(z.getSunSign());
                    date.setText(z.getDate()+"(TODAY)");
                    body.setText(z.getHoroscope());
                } else {
                    body.setText(errormsg);
                }
                dialog.show();
*/
    }

}







