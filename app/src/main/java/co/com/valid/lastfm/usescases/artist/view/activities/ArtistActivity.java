package co.com.valid.lastfm.usescases.artist.view.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.valid.lastfm.R;
import co.com.valid.lastfm.base.BaseActivity;
import co.com.valid.lastfm.usescases.artist.interactor.IArtistInteractor;
import co.com.valid.lastfm.usescases.artist.model.Artist;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import co.com.valid.lastfm.usescases.artist.presenter.ArtistPresenter;

public class ArtistActivity extends BaseActivity implements IArtistView {

    @Inject
    ArtistPresenter<IArtistView, IArtistInteractor> mPresenter;

    @BindView(R.id.artists_hello_world)
    TextView mEmailEditText;

    @BindView(R.id.artists_button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);

    }

    @OnClick(R.id.artists_hello_world)
    void onServerLoginClick(View v) {
        mPresenter.getTopArtists(1,20);
    }

    @OnClick(R.id.artists_button)
    void artistButtonClick(View v) {
        mPresenter.getTopArtists(1,20);
    }



    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void showTopArtist(TopsArtistsResponse topArtists) {
        showMessage("---- "+topArtists.getTopartists().getArtist().size());
    }

    @Override
    public void showArtistDetail(Artist artist) {

    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
