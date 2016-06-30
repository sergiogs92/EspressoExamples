package es.upsa.mimo.espressoexamples.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.activities.SecondActivity;
import es.upsa.mimo.espressoexamples.activities.ViewPagerActivity;

public class MenuFragment extends Fragment {

    private String ARG_KEY = "key";
    private Button exampleRecyclerButton;
    private Button exampleDataButton;
    private Button exampleActivityButton;
    private Button exampleDialogButton;
    private Button exampleDataPickerButton;
    private Button exampleViewPagerButton;
    private Button exampleAdapterViewButton;
    private ViewGroup containerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        containerView = container;
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        exampleRecyclerButton = (Button) view.findViewById(R.id.recycler_example_button);
        exampleDataButton = (Button) view.findViewById(R.id.enter_example_button);
        exampleActivityButton = (Button) view.findViewById(R.id.change_example_activity);
        exampleDialogButton = (Button) view.findViewById(R.id.dialog_example_activity);
        exampleDataPickerButton = (Button) view.findViewById(R.id.data_picker_button);
        exampleViewPagerButton =  (Button) view.findViewById(R.id.view_pager_button);
        exampleAdapterViewButton = (Button) view.findViewById(R.id.adapter_view_list_button);
        setUpRecyclerButton();
        setUpEnterDataButton();
        setUpActivityButton();
        setUpDialogButton();
        setUpDataPickerButton();
        setUpViewPagerButton();
        setUpAdapterViewButton();
    }

    private void setUpActivityButton() {
        exampleActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), SecondActivity.class);
                intent.putExtra(ARG_KEY, "param A to B activity");
                startActivity(intent);
            }
        });
    }

    private void setUpEnterDataButton() {
        exampleDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpNewFragment(new DataFormFragment());
            }
        });
    }

    private void setUpRecyclerButton() {
        exampleRecyclerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpNewFragment(new TeamFragment());
            }
        });
    }

    private void setUpDialogButton() {
        exampleDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpNewFragment(new ShowDialogFragment());
            }
        });
    }

    private void setUpDataPickerButton() {
        exampleDataPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpNewFragment(new DataPickerFragment());
            }
        });
    }

    private void setUpViewPagerButton() {
        exampleViewPagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), ViewPagerActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setUpAdapterViewButton() {
        exampleAdapterViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpNewFragment(new AdapterViewFragment());
            }
        });
    }

    private void setUpNewFragment(Fragment fragment){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(containerView.getId(), fragment).commit();
    }
}
