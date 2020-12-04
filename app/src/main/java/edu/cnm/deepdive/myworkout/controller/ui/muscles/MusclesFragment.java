package edu.cnm.deepdive.myworkout.controller.ui.muscles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.myworkout.R;
import edu.cnm.deepdive.myworkout.databinding.FragmentMusclesBinding;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;

public class MusclesFragment extends Fragment implements OnItemSelectedListener {

  private FragmentMusclesBinding binding;
  private MusclesViewModel musclesViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentMusclesBinding.inflate(inflater, container, false);
    binding.back.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        setFront(false);
        binding.front.setChecked(false);
        binding.front.setEnabled(true);
        binding.back.setEnabled(false);
      }
    });
    binding.front.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        setFront(true);
        binding.back.setChecked(false);
        binding.back.setEnabled(true);
        binding.front.setEnabled(false);
      }
    });
    binding.musclesSpinner.setOnItemSelectedListener(this);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    musclesViewModel = new ViewModelProvider(this).get(MusclesViewModel.class);
    musclesViewModel.getMuscles().observe(getViewLifecycleOwner(), (muscles) -> {
      ArrayAdapter<Muscle> adapter =
          new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, muscles);
      binding.musclesSpinner.setAdapter(adapter);
    });
  }

  private void setFront(boolean front) {
    musclesViewModel.setFront(front);
    binding.musclesImage.setImageResource(
        front ? R.drawable.muscular_system_front : R.drawable.muscular_system_back);
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    Muscle muscle = (Muscle) parent.getItemAtPosition(position);
    String drawableName = muscle.getDrawable();
    int drawableId = getContext().getResources().getIdentifier(
        drawableName, "drawable", getContext().getPackageName());
    binding.highlightedMuscle.setImageResource(drawableId);
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {

  }
}
