package bluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import com.example.mydemo.R;

import java.util.ArrayList;
import java.util.List;

import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;
import no.nordicsemi.android.support.v18.scanner.ScanCallback;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

public class AddDeviceActivity extends Activity {

    List<ScanResult> list_device = new ArrayList<>();


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
        ScanSettings settings = new ScanSettings.Builder()
                .setLegacy(false)
                .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
                .setReportDelay(1000)
                .setUseHardwareBatchingIfSupported(true)
                .build();
        List<ScanFilter> filters = new ArrayList<>();
//        filters.add(new ScanFilter.Builder().setServiceUuid(mUuid).build());
//        scanner.startScan(filters, settings, scanCallback);

        scanner.startScan(null, settings, scanCallback);
    }

    private ScanCallback scanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, @NonNull ScanResult result) {
            super.onScanResult(callbackType, result);
            //
            list_device.add(result);
        }

        @Override
        public void onBatchScanResults(@NonNull List<ScanResult> results) {
            super.onBatchScanResults(results);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }
    };
}