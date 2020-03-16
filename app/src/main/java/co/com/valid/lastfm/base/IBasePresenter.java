package co.com.valid.lastfm.base;

public interface IBasePresenter<V extends IBaseView, I extends IBaseInteractor> {

    V getView();

    I getInteractor();

    void onAttach(V mvpView);

    void onDetach();
}
