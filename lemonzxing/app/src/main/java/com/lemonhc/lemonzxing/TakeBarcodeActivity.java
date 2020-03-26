package com.lemonhc.lemonzxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ScanResultCallback;
import com.journeyapps.barcodescanner.ViewfinderView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SH Kang on 2020/03/26.
 * Copyright © 2020 LemonHealthcare. All rights reserved.
 */
public class TakeBarcodeActivity extends Activity implements
        DecoratedBarcodeView.TorchListener,
        ScanResultCallback
{
    //버터나이프 사용시 간헐적으로 superView에서 초기화를 못하는 이슈가 있음.
//    @BindView(R.id.activity_take_barcode_preview)
    DecoratedBarcodeView barcodeScannerView;
    @BindView(R.id.activity_take_barcode_close_button)
    ImageView btnClose;
    @BindView(R.id.activity_take_barcode_button_manual_input)
    TextView btnManualInput;

    private ViewfinderView viewfinderView;
    private CaptureManager captureManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_scanner);

        ButterKnife.bind(this);

        barcodeScannerView = findViewById(R.id.custom_scanner_zxing_barcode_scanner);
        barcodeScannerView.setTorchListener(this);

        viewfinderView = findViewById(R.id.zxing_viewfinder_view);

        captureManager = new CaptureManager(this, barcodeScannerView);
        captureManager.initializeFromIntent(getIntent(), savedInstanceState);
        captureManager.decode();
    }
    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onTorchOn() {

    }

    @Override
    public void onTorchOff() {

    }

    @Override
    public void onScanResultCallback(BarcodeResult rawResult) {
        Log.d("TakeBarcodeActivity", "### result" + rawResult.toString());
    }
}
