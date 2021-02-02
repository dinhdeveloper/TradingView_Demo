package lxt.project.myapplication.ui.views.fragment.list_base;

import lxt.project.myapplication.dialog.option.OptionModel;

public interface FragmentAdminManagerListBaseViewCallback {
    void onClickBackHeader();

    void refreshLoadingList();

    void onRequestLoadMoreList();

    void onRequestSearchWithFilter(String status, String key);

    void onItemListSelected(OptionModel item);

    void onClickAddItem();

    void onDeleteItemSelected(OptionModel item);
}
