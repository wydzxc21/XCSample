package com.xc.sample;

import android.app.Activity;
import android.util.Log;

import com.xc.framework.utils.ThreadUtil;

/**
 * @author ZhangXuanChen
 * @date 2015-10-15
 * @package com.xc.sample
 * @description activity基类demo
 */
public class BaseDemoActivity extends Activity {
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("BaseDemoActivity", "onPause");
		ThreadUtil.getInstance().stopAll();
	}
}
