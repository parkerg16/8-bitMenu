package com.example.a8_bitmenu.listener;

import com.example.a8_bitmenu.model.DrinkModel;

import java.util.List;

public interface IDrinkLoadListener {

    void onDrinkLoadSuccess(List<DrinkModel> drinkModelList);
    void onDrinkLoadFailed(String message);

}
