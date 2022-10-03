package com.example.nytimesmostpopularmvvm.presentation.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.nytimesmostpopularmvvm.data.entities.Article;
import com.example.nytimesmostpopularmvvm.domain.ArticlesUseCase;

import java.util.List;

public class ArticlesViewModel extends ViewModel {

    private ArticlesUseCase articlesUseCase;


    ArticlesViewModel(ArticlesUseCase articlesUseCase) {
        this.articlesUseCase = articlesUseCase;
    }

    public LiveData<List<Article>> loadArticles() {
        return articlesUseCase.getArticles();
    }

}
