package com.xc.sample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xc.framework.https.HttpParam;
import com.xc.framework.https.interfaces.RequestCallback;
import com.xc.framework.utils.HttpUtil;
import com.xc.framework.utils.StringUtil;

/**
 * @author ZhangXuanChen
 * @date 2015-9-21
 * @package com.xc.sample
 * @description http请求demo
 */
@SuppressLint("HandlerLeak")
public class HttpDemoActivity extends BaseDemoActivity implements OnClickListener {
	static final int HTTP_RESULT = 0x123;
	TextView tvResult;
	Button btnRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_demo);
		initView();
	}

	private void initView() {
		tvResult = (TextView) findViewById(R.id.tv_http_demo_result);
		btnRequest = (Button) findViewById(R.id.btn_http_demo_request);
		//
		btnRequest.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_http_demo_request:
			String url = "http://m.zhenyoumei.com.cn/ispushcode.php";
			HttpParam params = new HttpParam(url);
			params.addGetParam("key", "value");
			params.addPostParam("key", "value");
			HttpUtil.sendRequest(this, params, HTTP_RESULT, requestCallback);
			break;
		}
	}

	RequestCallback requestCallback = new RequestCallback() {
		@Override
		public void onResult(int what, String result) {
			switch (what) {
			case HTTP_RESULT:
				if (!StringUtil.isEmpty(result)) {
					tvResult.setText(result);
				}
				break;
			}
		}
	};
}
