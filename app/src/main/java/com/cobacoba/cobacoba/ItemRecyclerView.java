package com.cobacoba.cobacoba;

public class ItemRecyclerView {
    private int mImageResource1;
    private int mImageResource2;
    private int mImageResource3;
    private int mImageResource4;
    private String mText1;
    private String mText2;

    public ItemRecyclerView(int imageResource1, int imageResource2, int imageResource3, int imageResource4, String text1, String text2){
        mImageResource1 = imageResource1;
        mImageResource2 = imageResource2;
        mImageResource3 = imageResource3;
        mImageResource4 = imageResource4;
        mText1 = text1;
        mText2 = text2;
    }

    public int getImageResource1(){

         return mImageResource1;
    }

    public int getImageResource2(){

        return mImageResource2;
    }

    public int getImageResource3(){

        return mImageResource3;
    }

    public int getImageResource4(){

        return mImageResource4;
    }

    public String getText1(){

        return mText1;
    }

    public String getText2(){

        return mText2;
    }
}
