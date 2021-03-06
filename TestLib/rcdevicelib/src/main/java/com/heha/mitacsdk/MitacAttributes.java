package com.heha.mitacsdk;

public class MitacAttributes
{
    public static int TimeIntervalSince1970 = 978307200;
    public static final String ACTION_GATT_CONNECTED = "com.mitac.bluetooth.le.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_DISCONNECTED = "com.mitac.bluetooth.le.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_SERVICES_DISCOVERED = "com.mitac.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED";
    public static final String ACTION_DATA_AVAILABLE = "com.mitac.bluetooth.le.ACTION_DATA_AVAILABLE";
    public static final String EXTRA_DATA = "com.mitac.bluetooth.le.EXTRA_DATA";
    public static final String ACTION_SCAN_RECEIVE = "com.mitac.bluetooth.le.ACTION_SCAN_RECEIVE";
    public static final String ACTION_EKG_DATA_AVAILABLE = "com.mitac.bluetooth.le.ACTION_EKG_DATA_AVAILABLE";
    public static final String ACTION_ACTIVITY_DATA_AVAILABLE = "com.mitac.bluetooth.le.ACTION_ACTIVITY_DATA_AVAILABLE";
    public static final String ACTION_SLEEP_DATA_AVAILABLE = "com.mitac.bluetooth.le.ACTION_SLEEP_DATA_AVAILABLE";
    public static final String ACTION_CONTROL_DATA_AVAILABLE = "com.mitac.bluetooth.le.ACTION_CONTROL_DATA_AVAILABLE";
    public static final String ACTION_DEVICEINFO_DATA_AVAILABLE = "com.mitac.bluetooth.le.ACTION_DEVICEINFO_DATA_AVAILABLE";
    public static final String ACTION_FIRMWARE_DATA_AVAILABLE = "com.mitac.bluetooth.le.ACTION_FIRMWARE_DATA_AVAILABLE";

    public static enum ETimeZone
    {


        UTC_MINUS_12_00("-1200"),
        UTC_MINUS_11_00("-1100"),
        UTC_MINUS_10_00("-1000"),
        UTC_MINUS_09_30("-0930"),
        UTC_MINUS_09_00("-0900"),
        UTC_MINUS_08_00("-0800"),
        UTC_MINUS_07_00("-0700"),
        UTC_MINUS_06_00("-0600"),
        UTC_MINUS_05_00("-0500"),
        UTC_MINUS_04_30("-0430"),
        UTC_MINUS_04_00("-0400"),
        UTC_MINUS_03_30("-0330"),
        UTC_MINUS_03_00("-0300"),
        UTC_MINUS_02_00("-0200"),
        UTC_MINUS_01_00("-0100"),
        UTC("+0000"),
        UTC_PLUS_01_00("+0100"),
        UTC_PLUS_02_00("+0200"),
        UTC_PLUS_03_00("+0300"),
        UTC_PLUS_03_30("+0330"),
        UTC_PLUS_04_00("+0400"),
        UTC_PLUS_04_30("+0430"),
        UTC_PLUS_05_00("+0500"),
        UTC_PLUS_05_30("+0530"),
        UTC_PLUS_05_45("+0545"),
        UTC_PLUS_6("+0600"),
        UTC_PLUS_630("+0630"),
        UTC_PLUS_7("+0700"),
        UTC_PLUS_8("+0800"),
        UTC_PLUS_830("+0830"),
        UTC_PLUS_9("+0900"),
        UTC_PLUS_930("+0930"),
        UTC_PLUS_10("+1000"),
        UTC_PLUS_1030("+1030"),
        UTC_PLUS_11("+1100"),
        UTC_PLUS_1130("+1130"),
        UTC_PLUS_12("+1200"),
        UTC_PLUS_1245("+1245"),
        UTC_PLUS_13("+1300"),
        UTC_PLUS_14("+1400"),
        TimeZone_UNKNOWN("");


        private final String name;

        public static ETimeZone getTimeZoneByIndex(final int index){

            for (ETimeZone zone : ETimeZone.values()) {
               if (zone.ordinal() == index){
                   return zone;
               }
            }
            return TimeZone_UNKNOWN;
        }

        ETimeZone(final String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    public static enum ECommandStatus
    {
        ECS_GET_FWVERSION,  ECS_GET_SEVENDAYSACTIVITY,  ECS_GET_UUID,  ECS_GET_MODEL,  ECS_GET_MACADDR,  ECS_GET_BATTERYSTATUS,  ECS_GET_DATETIME,  ECS_GET_PROFILE,  ECS_GET_TARGET,  ECS_GET_SLEEPSTATUS,  ECS_GET_SLEEPDATA,  ECS_GET_UID,  ECS_GET_ALARM,  ECS_GET_TIMETOSLEEP,  ECS_SET_DEVICEINFO,  ECS_GET_FWMODE,  ECS_OTA_UPDATE,  ECS_GET_FWRAMSIZE,  ECS_GET_UNITFORMAT;
    }

    public static enum EGattStatus
    {
        EGS_CONNECTED,  EGS_DISCONNECTED,  EGS_DISCOVERED;
    }

    public static enum EHistoryTransferStatus
    {
        EHTS_NONE,  EHTS_ActivityInit,  EHTS_SleepInit,  EHTS_ActivityStart,  EHTS_SleepStart;
    }

    public static enum EOTAUpdateStatus
    {
        EOTA_NONE,  EOTA_INIT,  EOTA_START,  EOTA_TIMEOUT;
    }

    public static enum EFirmwareMode
    {
        EFWMode_UNKNOWN,  EFWMode_NORMAL,  EFWMode_OTA;
    }


    public static final byte MIC_SD_CP_OPCODE_RESPONSE = 1;
    public static final byte MIC_SD_CP_OPCODE_INIT_DATA_TRANSFER = 2;
    public static final byte MIC_SD_CP_OPCODE_TRANSFER_START = 3;
    public static final byte MIC_SD_CP_OPCODE_TRANSFER_NEXT = 4;
    public static final byte MIC_SD_CP_OPCODE_TRANSFER_END = 5;
    public static final byte MIC_SD_CP_OPCODE_ABORT_TRANSFER = 6;
    public static final byte MIC_SD_CP_OPCODE_SET_DATE = 7;
    public static final byte MIC_SD_CP_OPCODE_START_EKG_INFO = 8;
    public static final byte MIC_SD_CP_OPCODE_STOP_EKG_INFO = 9;
    public static final byte MIC_SD_CP_OPCODE_START_ACTIVITY_INFO = 17;
    public static final byte MIC_SD_CP_OPCODE_STOP_ACTIVITY_INFO = 18;
    public static final byte MIC_SD_CP_OPCODE_SEVENDAYS_ACTIVITY_START = 19;
    public static final byte MIC_SD_CP_OPCODE_SEVENDAYS_ACTIVITY_NEXT = 20;
    public static final byte MIC_SD_CP_OPCODE_SEVENDAYS_ACTIVITY_STOP = 21;
    public static final byte MIC_SD_CP_OPCODE_START_SLEEP_MODE = 22;
    public static final byte MIC_SD_CP_OPCODE_STOP_SLEEP_MODE = 23;
    public static final byte MIC_SD_CP_OPCODE_SLEEP_STATUS = 25;
    public static final byte MIC_SD_CP_OPCODE_INIT_FIRMWARE_UPDATE = 10;
    public static final byte MIC_SD_CP_OPCODE_INIT_FIRMWARE_TRANSFER = 11;
    public static final byte MIC_SD_CP_OPCODE_FIRMWARE_TRANSFER_START = 12;
    public static final byte MIC_SD_CP_OPCODE_FIRMWARE_PKT = 13;
    public static final byte MIC_SD_CP_OPCODE_FIRMWARE_TRANSFER_END = 14;
    public static final byte MIC_SD_CP_OPCODE_GET_DEVICE_INFO = 15;
    public static final byte MIC_SD_CP_OPCODE_SET_DEVICE_INFO = 16;
    public static final byte MIC_SD_CP_OPCODE_GET_PROFILE = 18;
    public static final byte MIC_SD_CP_OPCODE_GET_GOAL = 19;
    public static final byte MIC_SD_CP_OPCODE_GET_BATTERY_LEVEL = 23;
    public static final byte MIC_SD_CP_OPCODE_FACTORY_DEFAULT = 24;
    public static final byte MIC_SD_CP_OPCODE_GET_DATE = 25;
    public static final byte MIC_SD_CP_OPCODE_SET_FIRST_UID = 26;
    public static final byte MIC_SD_CP_OPCODE_SET_LAST_UID = 27;
    public static final byte MIC_SD_CP_OPCODE_GET_FIRST_UID = 28;
    public static final byte MIC_SD_CP_OPCODE_GET_LAST_UID = 29;
    public static final byte MIC_SD_CP_OPCODE_GET_SLEEP_ALARM = 30;
    public static final byte MIC_SD_CP_OPCODE_GET_TIME_TO_SLEEP = 31;
    public static final byte MIC_SD_CP_OPCODE_SET_DEVICE_INFO_START = 15;
    public static final byte MIC_SD_CP_OPCODE_SET_DEVICE_INFO_COMPLETE = 16;
    public static final byte MIC_GLORY_GET_DEVICEINFO_OPCODE_FW_VERSION = 1;
    public static final byte MIC_GLORY_GET_DEVICEINFO_OPCODE_UUID = 2;
    public static final byte MIC_GLORY_GET_DEVICEINFO_OPCODE_BT_MAC = 3;
    public static final byte MIC_GLORY_SET_DEVICEINFO_OPCODE_PROFILE = 4;
    public static final byte MIC_GLORY_SET_DEVICEINFO_OPCODE_GOAL = 5;
    public static final byte MIC_GLORY_SET_DEVICEINFO_OPCODE_ALARM = 10;
    public static final byte MIC_GLORY_SET_DEVICEINFO_OPCODE_TIMETOSLEEP = 11;
    public static final byte MIC_GLORY_GET_DEVICEINFO_OPCODE_FW_MODE = 37;
    public static final byte MIC_GLORY_SET_DEVICEINFO_OPCODE_UNIT_FORMAT = 29;
    public static final byte MIC_GLORY_GET_DEVICEINFO_OPCODE_UNIT_FORMAT = 30;
    public static final byte MIC_GLORY_GET_DEVICEINFO_OPCODE_FW_RAMSIZE = 26;
    public static final byte MIC_GLORY_BLUETOOTHLE_READY = 42;
    public static final String FIELD_STEP = "FIELD_STEP";
    public static final String FIELD_FLOOR = "FIELD_FLOOR";
    public static final String FIELD_DISTANCE = "FIELD_DISTANCE";
    public static final String FIELD_CALORIES = "FIELD_CALORIES";
    public static final String FIELD_EKG = "FIELD_EKG";
    public static final String FIELD_ISEND = "FIELD_ISEND";
    public static final String FIELD_VERSION = "FIELD_VERSION";
    public static final String FIELD_UUID = "FIELD_UUID";
    public static final String FIELD_MAC = "FIELD_MAC";
    public static final String FIELD_LOG = "FIELD_LOG";
    public static final String FIELD_DEVICE_NAME = "FIELD_DEVICE_NAME";
    public static final String FIELD_DEVICE_MAC = "FIELD_DEVICE_MAC";
    public static final String FIELD_DEVICE_TYPE = "FIELD_DEVICE_TYPE";
    public static final String FIELD_DEVICE_RSSI = "FIELD_DEVICE_RSSI";
    public static final String MITAC_DEVICE_NAME = "GLORY";
    public static final String MITAC_DEVICE_HEADER = "S000";
    public static final int MITAC_TIMEOUT_NORMAL = 2000;
    public static final int MITAC_TIMEOUT_LONG = 5000;

    public static class EEKG_TRAINING_LEVEL
    {
        public static final int EKG_TRAINING_LEVEL_1 = 0;
        public static final int EKG_TRAINING_LEVEL_2 = 1;
        public static final int EKG_TRAINING_LEVEL_3 = 2;
    }

    public static class EEKG_TYPE
    {


        public static final int EKG_RUNMETHOD_HR = 1;
        // public static final int EKG_RUNMETHOD_UNKNOWN = 1;
        public static final int EKG_RUNMETHOD_CPC = 2;

    }


}
