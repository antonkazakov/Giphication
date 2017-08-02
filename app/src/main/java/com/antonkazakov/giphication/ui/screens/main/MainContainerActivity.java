package com.antonkazakov.giphication.ui.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.antonkazakov.giphication.R;
import com.antonkazakov.giphication.ui.screens.gifList.GifsController;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainContainerActivity extends AppCompatActivity {

    private Router router;

    @BindView(R.id.controller_container)
    ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cond);
        ButterKnife.bind(this);

        router = Conductor
                .attachRouter(this, container, savedInstanceState);
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction
                    .with(new GifsController()));
        }
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }
}
