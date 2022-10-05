package com.example.cafeappsubmitv2;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.categoryappsubmitv2.R;

public class Food  implements Parcelable{
    private String name;
    private double price;
    private String desc;
    private int imageResourceID;
    public static final Food[] myBreakfast = {
            new Food("Pancake", 6.99, "Scrumptious, round, yellow", R.drawable.pancakes),
            new Food("Waffles", 7.50, "Crispy Golden Brown", R.drawable.waffles),
            new Food("Croissant", 3.45, "Buttery and flaky snack!", R.drawable.croissant)

    };
    public static final Food[] myLunch = {
            new Food("Cheese Pizza", 8.99, "Crispy, savory, greasy (30,000 cals)", R.drawable.pizza),
            new Food("Burger", 14.99, "Juicy, tender, and filling!", R.drawable.cheeseburger),
            new Food("Hotdog", 3.99, "Onions, tomatoes, and condiments of your choice!", R.drawable.hotdog)

    };
    public static final Food[] myDinner = {
            new Food("Steak", 25.99, "Baked potatoes served with a medium rare steak", R.drawable.steak),
            new Food("Sushi", 7.50, "Cold, fish and rice dish", R.drawable.sushi),
            new Food("Dosa w/ sambar", 15.99, "Melts in your mouth", R.drawable.dosa)

    };

public Food(String name, double price, String desc, int imageResourceID){
    this.name = name;
    this.price = price;
    this.desc = desc;
    this.imageResourceID = imageResourceID;
}
    public String toString(){
        return name;
    }

    // this code is needed for the Food class to work with Parcelable
    public static final Creator<Food> CREATOR = new
            Creator<Food>() {

                @Override
                public Food createFromParcel(Parcel parcel) {
                    return new Food(parcel);
                }

                @Override
                public Food[] newArray(int size) {
                    return new Food[0];
                }
            };
    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * @param parcel    the parcel that is received from the intent
     */

    public Food(Parcel parcel) {
        name = parcel.readString();
        price = parcel.readDouble();
        desc = parcel.readString();
        imageResourceID = parcel.readInt();
    }
    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(desc);
        dest.writeInt(imageResourceID);
    }

    public Food() {
        name = "";
        price = 0;
        desc = "";
        imageResourceID = 0;
    }
    /**
     * This method is required for the Parceable interface.  As of now, this method * is in the default state and doesn't really do anything.
     *
     * If your Parcelable class will have child classes, you'll need to
     * take some extra care with the describeContents() method. This would
     * let you identify the specific child class that should be created by
     * the Parcelable.Creator. You can read more about how this works on
     *  Stack Overflow with this link.
     *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
     * @return
     */

    @Override
    public int describeContents() {
        return 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }


}

