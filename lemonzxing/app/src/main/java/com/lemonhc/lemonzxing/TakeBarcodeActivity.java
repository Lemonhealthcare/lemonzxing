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
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SH Kang on 2020/03/26.
 * Copyright © 2020 LemonHealthcare. All rights reserved.
 */
public class TakeBarcodeActivity extends Activity implements DecoratedBarcodeView.TorchListener {

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


//        preview = findViewById(R.id.activity_take_barcode_preview);
        // 프리뷰 사용하는 화면은 부모클래스에 있다.
//        super.initTextureView(this.preview);
//        barcodeScannerView = initializeContent();

//        this.initBarcodeScanner(savedInstanceState);

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
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d("onActivityResult", "onActivityResult: .");
        if (resultCode == Activity.RESULT_OK) {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            String re = scanResult.getContents();
            String message = re;
            Log.d("onActivityResult", "onActivityResult: ." + re);
            Toast.makeText(this, re, Toast.LENGTH_LONG).show();
        }
    }


}
