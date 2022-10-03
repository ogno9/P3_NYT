package com.example.nytimesmostpopularmvvm.interfaces;

public interface ItemClickListener<T> {
    void onItemClick(int position, T model);
}
