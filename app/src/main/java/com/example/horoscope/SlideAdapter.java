package com.example.horoscope;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import bot.box.horology.pojo.Zodiac;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    Button saveBtn;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;






    ZodiacData zodiacData=new ZodiacData();

    String dataValue1=zodiacData.getValue();
   String dateToday=zodiacData.getDate();




    // list of images
    public int[] lst_images = {
            R.drawable.h_libra,
            R.drawable.h_leo,
            R.drawable.h_sagittarius,
            R.drawable.h_pisces
    };
    // list of titles
    public String[] lst_title = {
            "TODAY"+" ("+dateToday+")",
            "THIS WEEK",
            "THIS MONTH",
            "THIS YEAR"
    }   ;
    // list of descriptions
    public String[] lst_description = {
           dataValue1,
            "The focus on your sign intensifies this week as sweet Venus, your personal planet, moves in, encouraging you to be kind to yourself. Her presence here might also be an opportunity for an image change if this would help you develop more confidence. As delectable Venus also aligns with eccentric Uranus, the week ahead could see you indulging your unique taste in clothes and other items, no matter what others say. ",
            "ou’re coming into your own this month, and it’s time to rock and roll! Even if at times it feels like walking in the dark, have more faith in yourself and existence. The Taurus new moon on May 4 marks a new personal cycle and the official beginning of a seven-year phase of prolific growth.",
            "Your ruler, lovely Venus, doesn't go through any retrograde periods in 2019, but does that mean clear sailing for you all year? It's doubtful, Taurus, but you might get a break in the dominant areas of your life that she rules: love and money. "
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };


    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        final TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        final TextView description = (TextView) view.findViewById(R.id.txtdescription);


        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        saveBtn=view.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
               String titlesaved=txttitle.getText().toString().trim();
               String datasaved=description.getText().toString().trim();



                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                DatabaseReference myRef= firebaseDatabase.getReference(firebaseAuth.getUid());

                saveData saveData=new saveData(titlesaved,datasaved);
                myRef.setValue(saveData);

*/
            }
        });



        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {



        container.removeView((LinearLayout)object);
    }
}
