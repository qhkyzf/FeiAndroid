package com.njnu.kai.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public abstract class BaseActivity extends Activity {
	protected TextView mTextView;
	protected Button mButton;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_button);
        mTextView = (TextView)findViewById(R.id.textview);
        mButton = (Button)findViewById(R.id.button);
        String className = this.getClass().getSimpleName();
        setTitle(className);
        mButton.setText(getButtonText());
        mTextView.setText("taskid=" + getTaskId() + "\n" + this);
        mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent startupIntent = getStartupIntent();
				startActivity(startupIntent);
			}
		});
    }
	
	abstract protected String getButtonText();
	
	abstract protected Intent getStartupIntent();
}
