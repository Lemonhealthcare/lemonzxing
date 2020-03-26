package com.journeyapps.barcodescanner;

/**
 * Created by SH Kang on 2020/03/26.
 * Copyright © 2020 LemonHealthcare. All rights reserved.
 *
 * 스캔결과를 전달하는 콜백 인터페이스.
 */
public interface ScanResultCallback {
    void onScanResultCallback(BarcodeResult rawResult);
}
