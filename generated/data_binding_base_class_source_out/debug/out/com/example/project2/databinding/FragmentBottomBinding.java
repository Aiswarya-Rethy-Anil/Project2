// Generated by view binder compiler. Do not edit!
package com.example.project2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.project2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBottomBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView dateTView;

  @NonNull
  public final ImageView seasonImageView;

  @NonNull
  public final ImageView wheelImageView;

  private FragmentBottomBinding(@NonNull FrameLayout rootView, @NonNull TextView dateTView,
      @NonNull ImageView seasonImageView, @NonNull ImageView wheelImageView) {
    this.rootView = rootView;
    this.dateTView = dateTView;
    this.seasonImageView = seasonImageView;
    this.wheelImageView = wheelImageView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBottomBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBottomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_bottom, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBottomBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.date_tView;
      TextView dateTView = ViewBindings.findChildViewById(rootView, id);
      if (dateTView == null) {
        break missingId;
      }

      id = R.id.season_imageView;
      ImageView seasonImageView = ViewBindings.findChildViewById(rootView, id);
      if (seasonImageView == null) {
        break missingId;
      }

      id = R.id.wheel_imageView;
      ImageView wheelImageView = ViewBindings.findChildViewById(rootView, id);
      if (wheelImageView == null) {
        break missingId;
      }

      return new FragmentBottomBinding((FrameLayout) rootView, dateTView, seasonImageView,
          wheelImageView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
