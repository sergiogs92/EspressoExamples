package es.upsa.mimo.espressoexamples.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import es.upsa.mimo.espressoexamples.R;

public class DataPickerFragment extends Fragment {

    private TextView textDataPicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data_picker, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textDataPicker = (TextView) view.findViewById(R.id.data_picker_text);
        showDatePickerDialog();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = year + "-" + monthOfYear + "-" + dayOfMonth;
                textDataPicker.setText(date);
            }
        }, 2016, 3, 15);
        datePicker.setTitle("Date Picker");
        datePicker.show();
    }

}
