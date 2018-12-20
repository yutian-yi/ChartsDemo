package puminkeji.pumin.com.chartsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //图表
        chart = (LineChart) findViewById(R.id.chart);
        final String[] quarters = new String[]{"2018.10.17", "10.18", "10.19", "10.20","10.21","10.22","10.23", "10.24", "10.25", "10.26","10.27","10.28"};

//自定义设置X轴的值为 => 日期
        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };

//设置说明
        chart.setDescription(null);
//设置图例关
        chart.getLegend().setEnabled(false);
//设置显示范围
        chart.setVisibleXRangeMaximum(2);
        chart.setVisibleYRangeMinimum(10f, YAxis.AxisDependency.LEFT);
//设置透明度
        chart.setAlpha(1.0f);
//设置背景色
        chart.setBackgroundColor(Color.WHITE);
//设置边框
        chart.setBorderColor(Color.rgb(0, 0, 0));
        chart.setGridBackgroundColor(R.color.colorPrimary);
//设置触摸(关闭影响下面3个属性)
        chart.setTouchEnabled(true);
//设置是否可以拖拽
        chart.setDragEnabled(true);
//设置是否可以缩放
        chart.setScaleEnabled(true);
//设置是否能扩大扩小
        chart.setPinchZoom(true);

//获取X轴
        XAxis xl = chart.getXAxis();
//启用X轴
        xl.setEnabled(true);
//设置X轴避免图表或屏幕的边缘的第一个和最后一个轴中的标签条目被裁剪
        xl.setAvoidFirstLastClipping(true);
//设置X轴底部显示
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
//设置竖网格
        xl.setDrawGridLines(false);
//设置X轴文字大小
        xl.setTextSize(10f);
//设置X轴单位间隔
        xl.setGranularity(1f);
//设置X轴值
        xl.setValueFormatter(formatter);
        xl.setAxisMaximum(quarters.length-1);

//获取Y轴(左)
        YAxis yl = chart.getAxisLeft();
//设置Y轴文字在外部显示
        yl.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//Y轴字体
        yl.setTextSize(10f);
//设置Y轴最大值
        yl.setAxisMaximum(20f);
//        yl.setAxisMinimum(-2f);
//设置Y轴起始值
        yl.setAxisMinimum(-2f);
//设置横网格
        yl.setDrawGridLines(false);
//获取Y轴(右)
        YAxis yl2 = chart.getAxisRight();
//禁用右侧Y轴
        yl2.setEnabled(false);

//数据
        ArrayList<Entry> entryList = new ArrayList<>();
        entryList.add(new Entry(0, 1));
        entryList.add(new Entry(1, 3));
        entryList.add(new Entry(2, 2));
        entryList.add(new Entry(3, 4));

        entryList.add(new Entry(4, 6));
        entryList.add(new Entry(5, 4));
        entryList.add(new Entry(6, 3));
        entryList.add(new Entry(7, 6));
        entryList.add(new Entry(8, 6));
        entryList.add(new Entry(9, 4));
        entryList.add(new Entry(10, 3));
        entryList.add(new Entry(11, 6));

        LineDataSet l1 = new LineDataSet(entryList, "红色");
        l1.setAxisDependency(YAxis.AxisDependency.LEFT);
//设置包括的范围区域填充颜色
        l1.setDrawFilled(false);

//设置线的宽度
        l1.setLineWidth(2f);
//设置曲线的颜色
        l1.setColor(Color.rgb(244, 117, 117));
//设置曲率,0.05f-1f  1为折线
        l1.setCubicIntensity(0.1f);

//设置有圆点
        l1.setDrawCircles(true);
//设置小圆点的大小
        l1.setCircleRadius(3f);
//设置圆圈颜色
        l1.setCircleColor(Color.rgb(244, 117, 117));
//填充圆圈内颜色
        l1.setCircleColorHole(Color.rgb(244, 117, 117));

//设置不显示数值
        l1.setDrawValues(false);

        List<ILineDataSet> lineDataSetArrayList = new ArrayList<>();
        lineDataSetArrayList.add(l1);

        LineData lineData = new LineData(lineDataSetArrayList);
        chart.setData(lineData);

//设置XY轴进入动画
        chart.animateXY(800, 800);
//设置最小的缩放
        chart.setScaleMinima(1f, 1f);

//刷新图表
//chart.invalidate();List<Model> newData = new ArrayList<>();
    }
}
