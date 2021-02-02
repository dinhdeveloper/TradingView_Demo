package lxt.project.myapplication.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import b.laixuantam.myaarlibrary.base.BaseFragmentActivity;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.OnKeyboardVisibilityListener;
import lxt.project.myapplication.helper.Consts;
import lxt.project.myapplication.helper.MySocket;
import lxt.project.myapplication.model.socket.model.BaseSocketResponse;
import lxt.project.myapplication.model.socket.model.ReloadJson;
import lxt.project.myapplication.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewCallback;
import lxt.project.myapplication.ui.views.action_bar.base_main_actionbar.BaseMainActionbarViewInterface;
import lxt.project.myapplication.ui.views.activity.base_main_activity.BaseMainActivityViewInterface;
import lxt.project.myapplication.ui.views.activity.chart_activity.ChartActivityView;
import lxt.project.myapplication.ui.views.activity.chart_activity.ChartActivityViewCallback;
import lxt.project.myapplication.ui.views.activity.chart_activity.ChartActivityViewInterface;
import lxt.project.myapplication.ui.views.activity.home_activity.HomeActivityViewCallback;

public class ChartActivity extends BaseFragmentActivity<ChartActivityViewInterface, BaseMainActionbarViewInterface, BaseParameters> implements BaseMainActionbarViewCallback, ChartActivityViewCallback, ActivityCompat.OnRequestPermissionsResultCallback, OnKeyboardVisibilityListener {
    @Override
    protected void initialize(Bundle savedInstanceState) {
        view.init(this, this);
        initSocketConnection();
    }

    @Override
    protected ChartActivityViewInterface getViewInstance() {
        return new ChartActivityView();
    }

    @Override
    protected BaseMainActionbarViewInterface getActionbarInstance() {
        return null;
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }


    @Override
    public void onVisibilityChanged(boolean visible) {

    }

    @Override
    public void onFilterToggle(boolean showFilter) {

    }

    @Override
    public void onFiltering(String keyword) {

    }

    @Override
    public void onClickButtonLeftActionbar() {

    }

    @Override
    public void onClickButtonRightActionbar() {

    }

    public void initSocketConnection(){
        MySocket.getInstance().init();

        MySocket.getInstance().on(Consts.SocketEvent.TOA_DO, ReloadJson.class, new MySocket.SocketCallback<ReloadJson>() {
                    @Override
                    public void onReceived(ReloadJson data) {
                        view.setDataChart(data);
                    }
                });

    }
}
