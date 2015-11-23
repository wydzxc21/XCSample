package com.xc.sample;

import java.util.List;

import com.xc.framework.db.DBManager;
import com.xc.framework.utils.DBUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author ZhangXuanChen
 * @date 2015-9-22
 * @package com.xc.sample
 * @description 数据库demo
 */
public class DBDemoActivity extends BaseDemoActivity implements OnClickListener {
	TextView tvOutput;
	Button btnInsert, btnQuery, btnDelete, btnChange, btnDeleteTable, btnDeleteDB;

	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_db_demo);
		initView();
	}

	private void initView() {
		tvOutput = (TextView) findViewById(R.id.tv_db_demo_output);
		btnInsert = (Button) findViewById(R.id.btn_db_demo_insert);
		btnQuery = (Button) findViewById(R.id.btn_db_demo_query);
		btnDelete = (Button) findViewById(R.id.btn_db_demo_delete);
		btnChange = (Button) findViewById(R.id.btn_db_demo_change);
		btnDeleteTable = (Button) findViewById(R.id.btn_db_demo_delete_table);
		btnDeleteDB = (Button) findViewById(R.id.btn_db_demo_delete_db);
		//
		btnInsert.setOnClickListener(this);
		btnQuery.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		btnChange.setOnClickListener(this);
		btnDeleteTable.setOnClickListener(this);
		btnDeleteDB.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_db_demo_insert:// 插入
			DBBean db = new DBBean();
			db.setId("1");
			db.setName("小明");
			db.setAge("13");
			boolean insert = DBUtil.insert(this, db);
			tvOutput.setText("插入状态:" + insert);
			break;
		case R.id.btn_db_demo_query:// 查询
			// 查询所有
			// List<DBBean> queryAll = mDBManager.query(new DBBean());
			// 查询单个或多个
			DBBean dbQuery = new DBBean();
			// dbQuery.setName("小明");
			dbQuery.setAge("13");
			//
			List<DBBean> query = DBUtil.query(this, dbQuery);
			tvOutput.setText(query.toString());
			break;
		case R.id.btn_db_demo_delete:// 删除
			DBBean dbDelete = new DBBean();
			// dbQuery.setName("小明");
			dbDelete.setAge("13");
			//
			boolean delete = DBUtil.delete(this, dbDelete);
			tvOutput.setText("删除状态:" + delete);
			break;
		case R.id.btn_db_demo_change:// 修改
			// 修改所有
			// DBBean updateBean = new DBBean();
			// updateBean.setName("张三");
			// updateBean.setAge("16");
			// DBUtil.update(this,updateBean, new DBBean());
			// 修改单个或多个
			// 修改内容
			DBBean updateBean = new DBBean();
			updateBean.setName("张三");
			updateBean.setAge("16");
			// 修改条件
			DBBean conditionBean = new DBBean();
			conditionBean.setId("1");// 条件唯一
			// conditionBean.setName("小明");//或者组合条件,满足条件的都修改
			boolean update = DBUtil.update(this, updateBean, conditionBean);
			tvOutput.setText("修改状态:" + update);
			break;
		case R.id.btn_db_demo_delete_table:// 删除表
			boolean deleteTable = DBUtil.deleteTable(this, DBBean.class);
			tvOutput.setText("删除表状态:" + deleteTable);
			break;
		case R.id.btn_db_demo_delete_db:// 删除库
			boolean deleteDB = DBUtil.deleteDB(this);
			tvOutput.setText("删除库状态:" + deleteDB);
			break;
		}
	}
}
