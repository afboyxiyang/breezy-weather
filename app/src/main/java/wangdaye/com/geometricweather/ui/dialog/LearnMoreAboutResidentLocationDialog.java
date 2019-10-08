package wangdaye.com.geometricweather.ui.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import wangdaye.com.geometricweather.R;
import wangdaye.com.geometricweather.basic.GeoDialogFragment;

/**
 * Learn more about resident location dialog.
 * */
public class LearnMoreAboutResidentLocationDialog extends GeoDialogFragment {

    private CoordinatorLayout container;

    @NonNull
    @SuppressLint("InflateParams")
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(
                LayoutInflater.from(getActivity())
                        .inflate(R.layout.dialog_resident_location, null, false)
        );
        return builder.create();
    }

    @Override
    public View getSnackbarContainer() {
        return container;
    }
}
