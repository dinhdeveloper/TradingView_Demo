package lxt.project.myapplication.ui.views.fragment.notification;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.model.NotificationModel;

public interface FragmentNotificationViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentNotificationViewCallback callback);

    void setDataNotification(NotificationModel[] data);

    void setNoMoreLoading();

    void validateCheckSeenNotifySuccess();

    void hideRootView();

    void showRootView();
}
