package com.example.horoscope;


public class ZodiacData {

    static String  value;
    static String date;


    public ZodiacData(String value, String date) {
        this.value = value;
        this.date=date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public ZodiacData() {

    }

    public String returnedData;
    public String [] zodiacDates={"Aires (March 21 - April 19)","Tauras(April 20 - May 20)","Gemini (May 21 - June 20)","Cancer (June 21 - July 22)","Leo (July 23 - August 22)","Virgo (August 23 - September 22)","Libra (September 23 - October 22)","Scorpio (October 23 - November 21)","Sagittarius (November 22 - December 21)","Capricorn (December 22 - January 19)","Aquarius (January 20 - February 18)","Pisces (February 19 - March 20)"};
    public String [] zodiacProperty ={"Aries has very improvising nature.Mostly Aries have high tendencey to group up with people.",
            "The Taurus zodiac sign is the 2nd sign of the zodiac. The Taurus people are practical, creative, loyal, possessive, temperamental, sensually indulgent, down-to-earth, dependable, persistent and practical.",
            "The Gemini zodiac sign is the 3rd sign of the zodiac. The Gemini people are curious, elusive, unpredictable, changeable, versatile, childlike, romantic, playful, friendly, talkative and have a keen intellect.",
            "The Cancer zodiac sign is the 4th sign of the zodiac. The Cancer people are cautious, protective, nurturing, secretive, instinctive, needy, sensitive, funny, empathetic and deeply complex people.",
            "The Leo zodiac sign is the 5th sign of the zodiac. The Leos are distinctive, provocative, demanding, goal-oriented, flamboyant, self-made, warm, outgoing, sincere and loyal people.",
            "The Virgo zodiac sign is the 6th sign of the zodiac. The Virgos are discriminating, obsessive, realistic, analytical, reliable, self-contained, knowledgeable, predictable, obsessive, discriminating, street-smart, detailed and modest people.",
            "The Libra zodiac sign is the 7th sign of the zodiac. The Libra is the only zodiac sign that has an inanimate object, the scales, as its symbol. Librans are harmonious, civilized, intellectual, sophisticated, seductive, elegant, creative, witty, balanced, sociable and people who maintain their status quo.",
            "The Scorpio zodiac sign is the 8th sign of the zodiac. The Scorpio people are intense, magnetic, erotic, challenging, secretive, powerful, broody, passionate, immovable and penetrating.",
            "The Sagittarius zodiac sign is the 9th sign of the zodiac. The Sagittarius are adventurous, hilarious, extrovert, romantics, spirited, unstoppable, generous, happy and open-minded.",
            "The Capricorn zodiac sign is the 10th sign of the zodiac. The Capricorn people are organized, respectful, devoted, classy, materialistic, serious, staid, ambitious and practical.",
            "The Aquarius zodiac sign is the 11th sign of the zodiac. Aquarius people are original, idealistic, rebellious, independent, inventors, open minded and honest.",
            "The Pisces zodiac sign is the 12th sign of the zodiac. Pisceans are dreamy, erratic, creative, romantic, compassionate, elusive, imaginative, sensitive and kind people."};



    public String Method(Object data1, Object data2) {

        if(data1.equals("Gemini")&&data2.equals("Tauras")){

            returnedData="They have 70% Match \n"+"They can be a good couple. Their relationship is well matched.";
            return  returnedData;

        }
        if(data1.equals("Tauras")&&data2.equals("Libra")){

            returnedData="They have 20% Match \n"+"May face a lot of problem when together.";
            return  returnedData;

        }
        if(data1.equals("Libra")&&data2.equals("Gemini")){

            returnedData="They have 70% Match \n"+"Can have good life ahead if decision are taken from both end.";
            return  returnedData;

        }
        if(data1.equals("Gemini")&&data2.equals("Scorpio")){

            returnedData="They have 50% Match \n"+"It's a good chance that they have better relationship.";
            return  returnedData;

        }
        if(data1.equals("Leo")&&data2.equals("Capricon")){

            returnedData="They have 80% Match \n"+"They can be one of the best match among all other.";
            return  returnedData;

        }

        else

            returnedData="You wll have good relationship and values towards each other.healthy life is expected.";
            return returnedData;


    }





    public String getDate(int pointer) {

       return zodiacDates[pointer];


    }

    public String getInfo(int pointer) {

        return zodiacProperty[pointer];
    }




}
