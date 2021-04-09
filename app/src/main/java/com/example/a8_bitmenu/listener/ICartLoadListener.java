package com.example.a8_bitmenu.listener;

import com.example.a8_bitmenu.model.CartModel;
import com.example.a8_bitmenu.model.DrinkModel;

import java.util.List;

public interface ICartLoadListener {
    void onCartLoadSuccess(List<CartModel> cartModelList);
    void onCartLoadFailed(String message);
}
