package lxt.project.myapplication.ui.views.activity.chart_activity;


import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.broooapps.graphview.CurveGraphConfig;
import com.broooapps.graphview.CurveGraphView;
import com.broooapps.graphview.models.GraphData;
import com.broooapps.graphview.models.PointMap;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import lxt.project.myapplication.R;
import lxt.project.myapplication.activity.ChartActivity;
import lxt.project.myapplication.model.socket.model.ReloadJson;

public class ChartActivityView extends BaseView<ChartActivityView.UIContainer> implements ChartActivityViewInterface {
    ChartActivity activity;
    ChartActivityViewCallback callback;

    private final Handler mHandler = new Handler();
    private Runnable mTimer;
    private double graphLastXValue = 5d;
    private LineGraphSeries<DataPoint> mSeries;

    private double graphLastX = 0;

    @Override
    public void init(ChartActivity activity, ChartActivityViewCallback callback) {
        this.activity = activity;
        this.callback = callback;

//        ui.curveGraphView.configure(
//                new CurveGraphConfig.Builder(activity)
//                        .setAxisColor(R.color.white)                                             // Set number of values to be displayed in X ax
//                        .setVerticalGuideline(4)                                                // Set number of background guidelines to be shown.
//                        .setHorizontalGuideline(2)
//                        .setGuidelineColor(R.color.Black)                                         // Set color of the visible guidelines.
//                        .setNoDataMsg(" No Data ")                                              // Message when no data is provided to the view.
//                        .setxAxisScaleTextColor(R.color.white)                                  // Set X axis scale text color.
//                        .setyAxisScaleTextColor(R.color.Black)                                  // Set Y axis scale text color
//                        .setAnimationDuration(2000)                                             // Set Animation Duration
//                        .build()
//        );
//
//
//        PointMap pointMap = new PointMap();
//        pointMap.addPoint(1, 200);
//        pointMap.addPoint(3, 400);
//        pointMap.addPoint(4, 100);
//        pointMap.addPoint(5, 463);
//        pointMap.addPoint(6, 734);
//        pointMap.addPoint(7, 134);
//        pointMap.addPoint(8, 645);
//        pointMap.addPoint(9, 325);
//        pointMap.addPoint(10, 845);
//        pointMap.addPoint(11, 234);
//        pointMap.addPoint(12, 856);
//        pointMap.addPoint(13, 226);
//        pointMap.addPoint(14, 600);
//        pointMap.addPoint(15, 523);
//        pointMap.addPoint(16, 744);
//        pointMap.addPoint(17, 421);
//        pointMap.addPoint(18, 424);
//        pointMap.addPoint(19, 123);
//        pointMap.addPoint(20, 600);
//        pointMap.addPoint(21, 452);
//        pointMap.addPoint(22, 435);
//        pointMap.addPoint(23, 234);
//        pointMap.addPoint(24, 600);
//        pointMap.addPoint(25, 600);
//        pointMap.addPoint(26, 243);
//        pointMap.addPoint(27, 345);
//
//        final GraphData gd = GraphData.builder(activity)
//                .setPointMap(pointMap)
//                .setGraphStroke(R.color.white)
//                .animateLine(true)
//                .setPointColor(R.color.Black)
//                .setPointRadius(5)
//                .build();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ui.curveGraphView.setData(27, 1000, gd);
//            }
//        }, 250);

        initGraph(ui.curveGraphView);

        ui.btnGiam.setOnClickListener(v -> {
            ui.viewLine.setBackgroundColor(Color.parseColor("#FC1313"));
        });
        ui.btnTang.setOnClickListener(v -> {
            ui.viewLine.setBackgroundColor(Color.parseColor("#5AEF14"));
        });

    }

    @Override
    public void setDataChart(ReloadJson data) {
        Date currentTime = Calendar.getInstance().getTime();
        mTimer = new Runnable() {
            @Override
            public void run() {
                mSeries.appendData(new DataPoint(currentTime, Double.valueOf(data.getY())), true, 20);
                mHandler.postDelayed(this, 1000);
            }
        };
        mHandler.postDelayed(mTimer, 1000);
    }

    private void initGraph(GraphView graph) {
//        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setScalable(true);
        graph.getViewport().setDrawBorder(true);
        graph.getViewport().setBorderColor(Color.parseColor("#FFFFFF"));
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(4);
//
//        graph.getGridLabelRenderer().setLabelVerticalWidth(100);

        // first mSeries is a line
        mSeries = new LineGraphSeries<>();
        mSeries.setDrawDataPoints(true);
//        mSeries.setDrawBackground(true);
        mSeries.setBackgroundColor(Color.parseColor("#00000000"));
        mSeries.setDataPointsRadius(4f);
        mSeries.setAnimated(true);
        graph.addSeries(mSeries);
    }

    double mLastRandom = 2;
    Random mRand = new Random();

    private double getRandom() {
        return mLastRandom += mRand.nextDouble() * 0.5 - 0.25;
    }


    @Override
    public BaseUiContainer getUiContainer() {
        return new ChartActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.dinh_layout_activity_chart;
    }

    public class UIContainer extends BaseUiContainer {
        @UiElement(R.id.graph)
        public GraphView curveGraphView;

        @UiElement(R.id.viewLine)
        public View viewLine;

        @UiElement(R.id.btnGiam)
        public View btnGiam;

        @UiElement(R.id.btnTang)
        public View btnTang;


    }
}
