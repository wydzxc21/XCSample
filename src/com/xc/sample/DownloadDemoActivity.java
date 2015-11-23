package com.xc.sample;

import java.io.File;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.xc.framework.https.HttpParam;
import com.xc.framework.https.interfaces.DownloadCallBack;
import com.xc.framework.utils.FileUtil;
import com.xc.framework.utils.HttpUtil;

/**
 * @author ZhangXuanChen
 * @date 2015-10-14
 * @package com.xc.sample
 * @description 下载文件demo
 */
public class DownloadDemoActivity extends BaseDemoActivity implements OnClickListener {
	static final int HTTP_RESULT = 0x123;
	Button btnDownload;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download_demo);
		initView();
	}

	private void initView() {
		btnDownload = (Button) findViewById(R.id.btn_download_demo);
		//
		btnDownload.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_download_demo:
			String url = "http://m.zhenyoumei.com.cn/zym_daye.apk";
			String filePath = FileUtil.getSDCardRootDir() + File.separator + "mulu2" + File.separator + "mulu3" + File.separator + "ceshi.apk";
			//
			HttpParam params = new HttpParam(url);
			// params.setSaveFilePath(filePath);//默认地址保存缓存目录
			HttpUtil.downloadFile(this, params, HTTP_RESULT, downloadCallBack);
			//
			break;
		}
	}

	DownloadCallBack downloadCallBack = new DownloadCallBack() {

		@Override
		public void onResult(File file) {
			Log.i("download", "下载完成" + file.getAbsolutePath());

		}

		@Override
		public void onLoading(long total, long current) {
			System.out.println("下载中:" + total + "," + current);
		}
	};
}
