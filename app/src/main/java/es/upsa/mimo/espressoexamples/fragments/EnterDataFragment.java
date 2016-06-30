package es.upsa.mimo.espressoexamples.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.upsa.mimo.espressoexamples.R;

public class EnterDataFragment extends Fragment {

    private EditText nameEditText;
    private EditText surnamesEditText;
    private TextView errorTextView;
    private Button goButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_data, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            nameEditText = (EditText) view.findViewById(R.id.name_edittext);
            surnamesEditText = (EditText) view.findViewById(R.id.surnames_edittext);
            errorTextView = (TextView) view.findViewById(R.id.error_text_data);
            goButton = (Button) view.findViewById(R.id.next_button);
            setUpGoButton();
    }

    private void setUpGoButton() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String surnames = surnamesEditText.getText().toString();
                if (name.length() > 0 && surnames.length() > 0) {
                    errorTextView.setVisibility(View.INVISIBLE);
                }
                else{
                    errorTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
