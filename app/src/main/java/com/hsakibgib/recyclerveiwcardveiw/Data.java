package com.hsakibgib.recyclerveiwcardveiw;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Information> getData() {
        ArrayList<Information> data = new ArrayList<>();

        int[] images = {
                R.drawable.north_indian,
                R.drawable.south_indian,
                R.drawable.chinese,
                R.drawable.mexican,

                R.drawable.italian,

                R.drawable.korean_cuisine,
                R.drawable.spanish_cuisine,

                R.drawable.french_food,
               /* R.drawable.parrot2,

                R.drawable.tiger1,
                R.drawable.tiger2,
                R.drawable.tiger3*/
        };

        String[] categories= {"North Indian","South Indian","Chinese","Mexican ","Italian","Korean Cuisine","Spanish Cuisine","French Cuisine"};

        for(int i=0;i<images.length;i++)
        {
            Information current= new Information();
            current.title=categories[i];
            current.imageId=images[i];
            data.add(current);
        }
        return data;
    }
}
