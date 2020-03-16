package co.com.valid.lastfm.usescases.artist.view.activities;

import android.os.Bundle;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BaseActivity;
import co.com.valid.lastfm.usescases.artist.interactor.IArtistInteractor;
import co.com.valid.lastfm.usescases.artist.model.Artist;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import co.com.valid.lastfm.usescases.artist.presenter.ArtistPresenter;

public class ArtistActivity extends BaseActivity implements IArtistView {

    @Inject
    ArtistPresenter<IArtistView, IArtistInteractor> mPresenter;

    /* @BindView(R.id.et_email)
    EditText mEmailEditText;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }

    /*@OnClick(R.id.btn_server_login)
    void onServerLoginClick(View v) {
        mPresenter.onServerLoginClick(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }*/


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

    }

    @Override
    public void showArtistDetail(Artist artist) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
