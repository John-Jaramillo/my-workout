package edu.cnm.deepdive.myworkout.controller.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.myworkout.databinding.FragmentProfileBinding;
import edu.cnm.deepdive.myworkout.model.entity.User;

public class ProfileFragment extends Fragment {

  private ProfileViewModel profileViewModel;
  private FragmentProfileBinding binding;
  private User user;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentProfileBinding.inflate(inflater, container, false);
    binding.update.setOnClickListener((v) -> {
      // TODO Update user field contents with binding field contents and invoke profileViewModel.save
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    profileViewModel =
        new ViewModelProvider(this).get(ProfileViewModel.class);
    getLifecycle().addObserver(profileViewModel);
    profileViewModel.getUser().observe(getViewLifecycleOwner(), (user) -> {
      this.user = user;
      // TODO Populate the objects in binding with contents of user model object
    });
    profileViewModel.getThrowable().observe(getViewLifecycleOwner(), (throwable) ->
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show());
  }
}