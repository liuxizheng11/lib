package app.phj.com.testlib.device;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rocedar.base.RCHandler;
import com.rocedar.base.manger.RCBaseFragment;
import com.rocedar.deviceplatform.LogUnit;
import com.rocedar.deviceplatform.config.RCBluetoothDataType;
import com.rocedar.deviceplatform.config.RCBluetoothDoType;
import com.rocedar.deviceplatform.config.RCDeviceDeviceID;
import com.rocedar.deviceplatform.device.bluetooth.RCBlueTooth;
import com.rocedar.deviceplatform.device.bluetooth.impl.RCBluetoothYDImpl;
import com.rocedar.deviceplatform.device.bluetooth.listener.RCBluetoothGetDataListener;

import org.json.JSONArray;

import app.phj.com.testlib.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称：设备管理平台
 * <p>
 * 作者：phj
 * 日期：2017/2/14 下午12:32
 * 版本：V1.0
 * 描述：
 * <p>
 * CopyRight©北京瑰柏科技有限公司
 */

public class DeviceYDTestFragment extends RCBaseFragment implements RCBluetoothGetDataListener {


    @BindView(R.id.info1)
    TextView info1;
    @BindView(R.id.function_text)
    TextView functionText;
    @BindView(R.id.function_list_01)
    Button functionList01;
    @BindView(R.id.function_list_02)
    Button functionList02;
    @BindView(R.id.function_list_03)
    Button functionList03;
    @BindView(R.id.function_list_06)
    Button functionList06;

    private RCBlueTooth rcBlueTooth;


    private String mac;


    private int deviceId = RCDeviceDeviceID.YD;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device_test_yd, null);
        ButterKnife.bind(this, view);
        rcBlueTooth = RCBluetoothYDImpl.getInstance(mActivity);
        mac = getArguments().getString("mac");
        info1.setText("设备名称：" + LogUnit.getDeviceName(deviceId) + "(" + mac + ")");
        return view;
    }


    @OnClick({R.id.function_list_01, R.id.function_list_02, R.id.function_list_03, R.id.function_list_06})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.function_list_01:
                sendInstruct(RCBluetoothDataType.DATATYPE_STEP_TODAY);
                break;
            case R.id.function_list_02:
                sendInstruct(RCBluetoothDoType.DO_GET_REALTIME_STEP_START);
                break;
            case R.id.function_list_03:
                sendInstruct(RCBluetoothDoType.DO_GET_REALTIME_STEP_STOP);
                break;
            case R.id.function_list_06:
                rcBlueTooth.doDisconnect();
                break;
        }
    }

    private int doType;

    private void sendInstruct(int doType) {
        this.doType = doType;
        showLog(LogUnit.logStringSendZL(deviceId, doType));
        rcBlueTooth.sendInstruct(this, mac, doType);
    }


    private void showLog(final String info) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                functionText.setText(LogUnit.logString(info, LogUnit.getDeviceName(deviceId))
                        + "\n" + functionText.getText());
            }
        });
    }


    @Override
    public void getDataError(int status, String msg) {
        mRcHandler.sendMessage(RCHandler.GETDATA_OK);
        showLog(LogUnit.logStringGetDataError(deviceId, doType, status, msg));
    }

    @Override
    public void getDataStart() {
        mRcHandler.sendMessage(RCHandler.START);
    }

    @Override
    public void dataInfo(JSONArray array) {
        mRcHandler.sendMessage(RCHandler.GETDATA_OK);
        showLog(LogUnit.logStringGetDataOk(deviceId, doType, array.toString()));
    }


}
