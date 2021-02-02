package lxt.project.myapplication.event;


import b.laixuantam.myaarlibrary.helper.BusHelper;

public class ReloadMenuBottomEvent {

    public static void post() {
        BusHelper.post(new ReloadMenuBottomEvent());
    }
}
