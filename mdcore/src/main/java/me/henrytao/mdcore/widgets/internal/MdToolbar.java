/*
 * Copyright 2016 "Henry Tao <hi@henrytao.me>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.henrytao.mdcore.widgets.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import me.henrytao.mdcore.utils.Typography;

/**
 * Created by henrytao on 5/13/16.
 */
public class MdToolbar extends Toolbar {

  private boolean mInit;

  private Typeface mTypeface;

  public MdToolbar(Context context) {
    super(context);
    initFromAttributes(null, 0);
  }

  public MdToolbar(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    initFromAttributes(attrs, 0);
  }

  public MdToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initFromAttributes(attrs, defStyleAttr);
  }

  @Override
  public void setSubtitle(CharSequence subtitle) {
    super.setSubtitle(subtitle);
    syncTypeface();
  }

  @Override
  public void setTitle(CharSequence title) {
    super.setTitle(title);
    syncTypeface();
  }

  private void initFromAttributes(AttributeSet attrs, int defStyleAttr) {
    mTypeface = Typography.getTypeface(getContext(), attrs, defStyleAttr, 0);
  }

  private void syncTypeface() {
    int n = getChildCount();
    View child;
    for (int i = 0; i < n; i++) {
      child = getChildAt(i);
      if (child instanceof TextView && ((TextView) child).getTypeface() != mTypeface) {
        ((TextView) child).setTypeface(mTypeface);
      }
    }
  }
}
