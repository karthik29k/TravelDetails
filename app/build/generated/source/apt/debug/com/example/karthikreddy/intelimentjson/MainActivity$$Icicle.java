// Generated code from Icepick. Do not modify!
package com.example.karthikreddy.intelimentjson;
import android.os.Bundle;

import com.example.karthikreddy.intelimentjson.ui.MainActivity;

import icepick.Injector.Object;

public class MainActivity$$Icicle<T extends MainActivity> extends Object<T> {

  private final static Helper H = new Helper("com.example.karthikreddy.intelimentjson.ui.MainActivity$$Icicle.");

  public void restore(T target, Bundle state) {
    if (state == null) return;
    target.itemPosition = H.getInt(state, "itemPosition");
    super.restore(target, state);
  }

  public void save(T target, Bundle state) {
    super.save(target, state);
    H.putInt(state, "itemPosition", target.itemPosition);
  }
}