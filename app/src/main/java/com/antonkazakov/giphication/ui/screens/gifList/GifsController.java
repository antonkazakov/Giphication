package com.antonkazakov.giphication.ui.screens.gifList;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SearchViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.antonkazakov.giphication.GiphicationApp;
import com.antonkazakov.giphication.R;
import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.ui.screens.gifList.di.DaggerGifsComponent;
import com.antonkazakov.giphication.ui.screens.gifList.di.GifsComponent;
import com.antonkazakov.giphication.ui.screens.gifList.di.GifsModule;
import com.antonkazakov.giphication.ui.screens.main.MainContainerActivity;
import com.antonkazakov.giphication.ui.screens.singleGif.SingleGifController;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.jakewharton.rxbinding.widget.RxSearchView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GifsController extends Controller implements GifsView, GifsAdapter.GifItemClickListener {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    IGifsPresenter gifsPresenter;

    private GifsAdapter gifsAdapter;

    public GifsController() {
        GifsComponent gifsComponent = DaggerGifsComponent
                .builder()
                .appComponent(GiphicationApp.getAppComponent())
                .gifsModule(new GifsModule())
                .build();
        gifsComponent.inject(this);
        gifsAdapter = new GifsAdapter(this);
        gifsPresenter.setView(this);
        gifsPresenter.searchGifs("android");
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_gifs, container, false);
        ButterKnife.bind(this, view);
        ((MainContainerActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        initRecycler();
        return view;
    }

    private void initRecycler() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gifsAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem shareItem = menu.add("Search");
        MenuItemCompat.setShowAsAction(shareItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        View searchView = SearchViewCompat.newSearchView(getActivity());
        MenuItemCompat.setActionView(shareItem, searchView);
        RxSearchView.queryTextChanges((SearchView) searchView)
                .filter(charSequence -> charSequence.length() > 2)
                .debounce(500, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .subscribe(s -> gifsPresenter.searchGifs(s));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadData(List<GifEntity> gifEntities) {
        gifsAdapter.setData(gifEntities);
    }

    @Override
    public void showError(String errorText) {
        Toast.makeText(getActivity(), errorText, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAlert(String alertText) {

    }

    @Override
    public void onItemClicked(GifEntity entity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("entity", entity);
        getRouter().pushController(RouterTransaction.with(new SingleGifController(bundle))
                .pushChangeHandler(new FadeChangeHandler())
                .popChangeHandler(new FadeChangeHandler()));
    }

    @Override
    public void onItemLiked(GifEntity entity) {
        gifsPresenter.likeGif(entity);
    }

    @Override
    public void onItemDisliked(GifEntity entity) {
        gifsPresenter.dislikeGif(entity);
    }

}
