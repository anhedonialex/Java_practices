package com.example.p2_18;

public class MainPresenter implements MainContract.MainPresenter{
    private MainContract.MainView view;
    private MainRepository repository;
    public MainPresenter(MainContract.MainView view){
        this.view = view;
    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onClickGetInfoButton(String name, String group) {
        if(this.repository == null){
            this.repository = new MainRepository();
        }
        if(!name.isEmpty() && !group.isEmpty()){
            view.showLoading(); //запускаем крутиться Progressbar
            repository.loadStudentInfo(name, group, new OnStudentInfoLoaded()
            {
                @Override
                public void onSuccessLoad(String text, String avaUrl) {
                    view.hideLoading(); //остановка Progressbar
                    view.showStudentInfo(text,avaUrl); // показать инфо о студенте
                }
                @Override
                public void onFailed(String textError) {
                    view.showError(textError); // показать ошибку
                }
            });
        }else{
            view.showError(R.string.error_empty_fields); // показать ошибку
        }
    }

    @Override
    public void onViewDestroyed() {

    }
}
