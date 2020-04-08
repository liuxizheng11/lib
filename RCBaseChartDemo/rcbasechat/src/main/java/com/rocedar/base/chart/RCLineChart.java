package com.rocedar.base.chart;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.rocedar.base.chart.dto.XBaseEntity;
import com.rocedar.base.chart.dto.XLineBaseEntity;
import com.rocedar.base.chart.dto.XLineDataEntity;
import com.rocedar.base.chart.dto.YBaseEntity;
import com.rocedar.base.chart.util.MathUtil;

import java.util.List;

/**
 * 项目名称：基础库-图表
 * <p>
 * 作者：phj
 * 日期：2017/12/28 下午4:14
 * 版本：V1.0.00
 * 描述：
 * <p>
 * CopyRight©北京瑰柏科技有限公司
 */

public class RCLineChart extends RCBaseChart {

    public RCLineChart(Context context) {
        super(context);
    }

    public RCLineChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RCLineChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private XLineBaseEntity xLineEntity;

    /**
     * 设置折线图X轴实例
     *
     * @param xLineEntity
     */
    public RCLineChart setXEntity(XLineBaseEntity xLineEntity) {
        this.xLineEntity = xLineEntity;
        setXBaseColorEntity(xLineEntity);
        return this;
    }


    /**
     * 设置折线图Y轴实例（不设置为隐藏）
     *
     * @param yBaseEntity
     */
    public RCLineChart setYEntity(YBaseEntity yBaseEntity) {
        setYBaseEntity(yBaseEntity);
        return this;
    }

    private List<XLineDataEntity> xLineDataEntityList;


    private LineItemDecoration lineItemDecoration;

    /**
     * 设置折线图数据
     *
     * @param xLineDataEntityList 折线图实例列表
     */
    public void setChatData(List<XLineDataEntity> xLineDataEntityList, List<XBaseEntity> xBaseEntities) {
        if (this.xLineDataEntityList != null) {
            this.xLineDataEntityList.clear();
            this.xLineDataEntityList.addAll(xLineDataEntityList);
        } else {
            this.xLineDataEntityList = xLineDataEntityList;
            setChartItemDecoration(new LineItemDecoration(mContext, xLineEntity, this.xLineDataEntityList));
        }
        reMathData();
        invalidate(xBaseEntities);
    }


    /**
     * 向前添加折线图数据
     *
     * @param xLineDataEntityList 折线图实例列表
     */
    public void addChatDataToRight(List<XLineDataEntity> xLineDataEntityList, List<XBaseEntity> xBaseEntities) {
        for (int i = 0; i < xLineDataEntityList.size(); i++) {
            this.xLineDataEntityList.add(xLineDataEntityList.get(i));
        }
        reMathData();
        addDataRight(xBaseEntities);
    }

    /**
     * 向后添加折线图数据
     *
     * @param xLineDataEntityList 折线图实例列表
     */
    public void addChatDataToLeft(List<XLineDataEntity> xLineDataEntityList, List<XBaseEntity> xBaseEntities) {
        for (int i = xLineDataEntityList.size() - 1; i >= 0; i--) {
            this.xLineDataEntityList.add(0, xLineDataEntityList.get(i));
        }
        reMathData();
        addDataLeft(xBaseEntities);
    }

    /**
     * 重新计算最大最小值
     */
    private void reMathData() {
        List<Double> ylist = yBaseEntity != null ? yBaseEntity.getShowDataList() : null;
        double[] temp = new MathUtil().getMaxAndMin(ylist, xLineDataEntityList);
        setNumber(temp[0], temp[1]);
    }


}