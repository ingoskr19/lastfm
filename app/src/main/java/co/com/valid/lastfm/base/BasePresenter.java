package co.com.valid.lastfm.base;

import javax.inject.Inject;

public class BasePresenter<V extends IBaseView, I extends IBaseInteractor> implements IBasePresenter<V,I> {

    private static final String TAG = "BasePresenter";

    private V mBaseView;
    private I mInteractor;

    @Inject
    public BasePresenter(I mvpInteractor) {
        this.mInteractor = mvpInteractor;
    }

    @Override
    public V getView() {
        return mBaseView;
    }

    @Override
    public I getInteractor() {
        return mInteractor;
    }

    @Override
    public void onAttach(V mView) {
        mBaseView = mView;
    }

    @Override
    public void onDetach() {
        mBaseView = null;
    }

}
