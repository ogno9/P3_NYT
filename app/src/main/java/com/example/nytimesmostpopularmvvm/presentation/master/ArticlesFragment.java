package com.example.nytimesmostpopularmvvm.presentation.master;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nytimesmostpopularmvvm.R;
import com.example.nytimesmostpopularmvvm.data.entities.Article;
import com.example.nytimesmostpopularmvvm.interfaces.ItemClickListener;
import com.example.nytimesmostpopularmvvm.presentation.MainActivity;
import com.example.nytimesmostpopularmvvm.presentation.adapters.ArticlesAdapter;
import com.example.nytimesmostpopularmvvm.presentation.details.ArticlesDetailsFragment;
import com.example.nytimesmostpopularmvvm.presentation.viewmodel.ArticlesViewModel;
import com.example.nytimesmostpopularmvvm.presentation.viewmodel.ViewModelFactory;
import com.example.nytimesmostpopularmvvm.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class ArticlesFragment extends Fragment implements ItemClickListener<Article> {
    private ArticlesViewModel mViewModel;
    @BindView(R.id.articles_recycler)
    public RecyclerView articlesRecyclerView;

    @Inject
    public ArticlesAdapter adapter;

    @Inject
    public ViewModelFactory viewModelFactory;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.articles_fragment, container, false);
        ButterKnife.bind(this, view);

        initViews();
        setupToolbar();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(ArticlesViewModel.class);
    }

    private void initViews() {
        adapter.setItemClickListenr(this);
        articlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        articlesRecyclerView.setAdapter(adapter);
    }

    private void setupToolbar() {
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        mViewModel.loadArticles().observe(this, new Observer<List<Article>>() {

            @Override
            public void onChanged(@Nullable List<Article> articles) {
                adapter.setArticles(articles);
            }
        });
    }

    @Override
    public void onItemClick(int position, Article model) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.ARTICLE, model);
        ((MainActivity) getActivity()).replaceCurrentFragment(bundle, new ArticlesDetailsFragment());
    }
}
