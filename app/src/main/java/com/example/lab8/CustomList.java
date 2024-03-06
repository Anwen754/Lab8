package com.example.lab8;

import static java.lang.Boolean.TRUE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This returns whether or not a city is already in the list.
     * @param city
     * This is the city to be checked.
     * @return
     * Returns a boolean, false if it is not in, true otherwise.
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This method throws an exception if trying to delete a city that does not exist in the list, otherwise the delete happens.
     * @param city
     * The city to be deleted.
     */
    public void deleteCity(City city){
        if (!hasCity(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }
}
