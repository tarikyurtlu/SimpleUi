package com.googlecode.simpleui.listtests;

import java.util.List;

import tools.ButterknifeHelper;
import util.Log;
import v2.simpleUi.util.ColorUtils;
import adapters.SimpleBaseAdapter;
import adapters.SimpleBaseAdapter.HasItsOwnView;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.InjectView;

import com.googlecode.simpleui.R;

public class TestListView implements HasItsOwnView {

	private static final String LOG_TAG = TestListView.class.getSimpleName();
	@InjectView(R.id.swype_list_item_front_text)
	TextView t;
	@InjectView(R.id.swype_list_item_back_button)
	Button b;

	private final String name;

	public TestListView(String name) {
		this.name = name;
	}

	@Override
	public boolean onItemLongClick(View itemView, int posInList) {
		System.out.println("onItemLongClick: " + name);
		return true;
	}

	@Override
	public void onItemClick(View itemView, int posInList) {
		System.out.println("onItemClick: " + name);
	}

	@Override
	public View getView(final Context context, View convertView,
			ViewGroup parent, SimpleBaseAdapter simpleBaseAdapter,
			List<? extends HasItsOwnView> containerList, int positionInList) {
		convertView = ButterknifeHelper.injectFieldsInListItem(context, this,
				convertView, R.layout.swipe_list_item);
		Log.d(LOG_TAG, "convertView=" + convertView);
		t.setText(name);
		t.setBackgroundColor(ColorUtils.randomColor());
		b.setText("Button for " + name);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Clicked on " + name, Toast.LENGTH_LONG)
						.show();
			}
		});
		b.setBackgroundColor(ColorUtils.randomColor());
		return convertView;
	}
}