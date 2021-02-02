package lxt.project.myapplication.ui.views.activity.chart_activity;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import lxt.project.myapplication.activity.ChartActivity;
import lxt.project.myapplication.model.socket.model.ReloadJson;

public interface ChartActivityViewInterface extends BaseViewInterface {

    void init(ChartActivity activity,ChartActivityViewCallback callback);

    void setDataChart(ReloadJson data);
}
