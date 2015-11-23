package com.xc.sample;

import java.io.File;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.xc.framework.https.HttpParam;
import com.xc.framework.https.interfaces.UploadCallBack;
import com.xc.framework.utils.BitmapUtil;
import com.xc.framework.utils.HttpUtil;
import com.xc.framework.utils.StringUtil;
import com.xc.sample.R.layout;

public class UploadDemoActivity extends BaseDemoActivity implements OnClickListener {
	Button btnUpload;
	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout.activity_upload_demo);
		initView();
	}

	private void initView() {
		btnUpload = (Button) findViewById(R.id.btn_upload_demo);
		btnUpload.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (btnUpload == v) {
//			String url = "http://192.168.0.254/zym/index.php?app=gmuappaca&mod=Index&act=uploadNativePic&sjbb=1&debug=1234";
			String url = "http://192.168.0.52:81/phpProject/index.php/Home/Upload/saveImage";
			String path = "storage/emulated/0/DCIM/Camera/20150915_152702.jpg";
			//
			HttpParam params = new HttpParam(url);
			params.addFileParam("img" , new File(path));
//			params.addFileParam("ceshi2" , new File(path));
			HttpUtil.uploadFile(this, params, uploadCallBack);
		}
	}

	UploadCallBack uploadCallBack = new UploadCallBack() {
		@Override
		public void onLoading(long total, long current) {
			Log.i("UploadActivity", "total:" + total + ",current:" + current);
		}

		@Override
		public void onResult(String result) {
			if (!StringUtil.isEmpty(result)) {
				System.out.println(result);
			}
		}
	};
}
