package lxt.project.myapplication.fragment.account.menu;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.dependency.AppProvider;
import lxt.project.myapplication.ui.views.fragment.account.menu.FragmentAccountMenuView;
import lxt.project.myapplication.ui.views.fragment.account.menu.FragmentAccountMenuViewCallback;
import lxt.project.myapplication.ui.views.fragment.account.menu.FragmentAccountMenuViewInterface;

public class FragmentAccountMenu extends BaseFragment<FragmentAccountMenuViewInterface, BaseParameters> implements FragmentAccountMenuViewCallback {

    private HomeActivity activity;

    @Override
    protected void initialize() {
        view.init(this);
        activity = (HomeActivity) getActivity();

        boolean userHasLogin = AppProvider.getPreferences().checkLoginStatus();

        if (!userHasLogin) {
            view.showLayoutLoginRequest();
        }
    }

    @Override
    public void changeToFragmentLogin() {
        if (activity != null)
            activity.changeToFragmentLogin();
    }

    @Override
    protected FragmentAccountMenuViewInterface getViewInstance() {
        return new FragmentAccountMenuView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void onClickChangeToFragmentProfileManager() {
        if (activity != null) {
            activity.changeToFragmentProfileManager();
        }
    }

    @Override
    public void onClickChangeToFragmentChangePassword() {
        if (activity != null) {
            activity.changeToFragmentPasswordManager();
        }
    }

    @Override
    public void onClickLogout() {
        if (activity != null)
            activity.doLogout();
    }

}
