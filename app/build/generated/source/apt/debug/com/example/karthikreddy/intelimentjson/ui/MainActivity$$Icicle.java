// Generated code from Icepick. Do not modify!
package com.example.karthikreddy.intelimentjson.ui;
import android.os.Bundle;
import icepick.Injector.Helper;
import icepick.Injector.Object;

public class MainActivity$$Icicle<T extends MainActivity> extends Object<T> {

  private final static Helper H = new Helper("com.example.karthikreddy.intelimentjson.ui.MainActivity$$Icicle.");

  public void restore(T target, Bundle state) {
    if (state == null) return;
    target.itemPosition = H.getInt(state, "itemPosition");
    target.carTime = H.getString(state, "carTime");
    target.trainTime = H.getString(state, "trainTime");
    target.latitude = H.getString(state, "latitude");
    target.longitude = H.getString(state, "longitude");
    super.restore(target, state);
  }

  public void save(T target, Bundle state) {
    super.save(target, state);
    H.putInt(state, "itemPosition", target.itemPosition);
    H.putString(state, "carTime", target.carTime);
    H.putString(state, "trainTime", target.trainTime);
    H.putString(state, "latitude", target.latitude);
    H.putString(state, "longitude", target.longitude);
  }
}