package lxt.project.myapplication.ui.views.fragment.account.register;


import lxt.project.myapplication.model.UserRegisterModel;

public interface FragmentRegisterViewCallback {
    void onClickBackHeader();

    void onClickShowLoginForm();

    void onSignUp(UserRegisterModel userRegisterModel);

    void onRequestCheckPhoneRegister(UserRegisterModel userRegisterModel);

}
