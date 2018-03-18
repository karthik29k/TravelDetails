// Generated code from Butter Knife. Do not modify!
package com.example.karthikreddy.intelimentjson.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.karthikreddy.intelimentjson.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165236;

  private View view2131165264;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.carResult = Utils.findRequiredViewAsType(source, R.id.carTravelTime, "field 'carResult'", TextView.class);
    target.trainResult = Utils.findRequiredViewAsType(source, R.id.trainTravelTime, "field 'trainResult'", TextView.class);
    view = Utils.findRequiredView(source, R.id.destination_spinner, "field 'spinner' and method 'spinnerOnItemSelected'");
    target.spinner = Utils.castView(view, R.id.destination_spinner, "field 'spinner'", Spinner.class);
    view2131165236 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.spinnerOnItemSelected(p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    view = Utils.findRequiredView(source, R.id.navigateBtn, "field 'navigate' and method 'setNavigate'");
    target.navigate = Utils.castView(view, R.id.navigateBtn, "field 'navigate'", Button.class);
    view2131165264 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setNavigate();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.carResult = null;
    target.trainResult = null;
    target.spinner = null;
    target.navigate = null;

    ((AdapterView<?>) view2131165236).setOnItemSelectedListener(null);
    view2131165236 = null;
    view2131165264.setOnClickListener(null);
    view2131165264 = null;
  }
}
